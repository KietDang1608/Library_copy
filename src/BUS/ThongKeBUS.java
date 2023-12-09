package BUS;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

import DTO.CT_PhanQuyen;
import DTO.CT_PhieuMuon;
import DTO.CT_PhieuNhap;
import DTO.PhieuMuon;
import DTO.PhieuNhap;
import DTO.PhieuPhat;
import DTO.Sach;
import DTO.ThanhVien;
import CheckInfo.CheckTool;
public class ThongKeBUS
{
    PhieuMuonBUS bu=new PhieuMuonBUS();

    public static String[] tkSach(String year, int MaxBookOfMonth[],int BookOfMonth[])
    {
        PhieuMuonBUS busPm=new PhieuMuonBUS();
        CT_PhieuMuonBUS busCtpm=new CT_PhieuMuonBUS();

        ArrayList<CT_PhieuMuon> lstCtpm=new ArrayList<>();
        ArrayList<CT_PhieuMuon> lstCtpmMonth=new ArrayList<>();
        ArrayList<PhieuMuon> lstPmYear=new ArrayList<>();
        ArrayList<PhieuMuon> lstPmMonth=new ArrayList<>();

        //danh sách các phiếu mượn thuộc cùng 1 năm(year truyền vào)
        for(PhieuMuon Pm:busPm.getLst())
        {
            if(Pm.getNgayMuon().substring(0, 4).equals(year))
            {
                lstPmYear.add(Pm);
            }
        }

        //danh sách chi tiết phiếu mượn của các phiếu mượn trên
        for(PhieuMuon Pm:lstPmYear)
        {
            for(CT_PhieuMuon ct:busCtpm.getLst())
            {
                if(ct.getMaPhieu()==Pm.getMaPhieu())
                {
                    lstCtpm.add(ct);
                }
            }
        }
        //  for(CT_PhieuMuon ct:lstCtpm)
        // System.out.println(ct.toString());

        // int b=MaxBookOfYear(lstCtpm);
        //danh sách các phiếu mượn thuộc cùng 1 tháng
        String[] MaxOfEachMonth=new String[12];
        for(int i=1;i<13;i++)
        {
            //hàm tìm danh sách các phiếu trong từng tháng, đồng thời xuất ra max
            MaxOfEachMonth[(i-1)] =MaxBookOfMonth(lstPmYear, i,MaxBookOfMonth,BookOfMonth);
            System.out.println("thang "+i+" "+MaxOfEachMonth[i-1]);
        }
        return MaxOfEachMonth;
    }

    //hàm tính số lượng sách được mượn nhiều nhất trong danh sách CHI TIẾT PHIẾU MƯỢN truyền vào
    public static String MaxBookOfYear(ArrayList<CT_PhieuMuon> lstCTPM,int MaxBookOfMonth[],int month)
    {
        CT_PhieuMuonBUS busCtpm=new CT_PhieuMuonBUS();
        SachBUS busSa=new SachBUS();
        ArrayList<CT_PhieuMuon> lstCtpm=new ArrayList<>();
        // ArrayList<Sach> lstSa=new ArrayList<>();

        int num=0;
        int flat;
        int a []= new int[100];
        int currentID=lstCTPM.get(0).getMaSach();
        a[num++]=currentID;
        //vòng lặp tìm các mã sách có trong chi tiết phiếu mượn
        for(CT_PhieuMuon ct:lstCTPM)
        {
            flat=0;
            for(int i=0;i<num;i++)
            {
                if(ct.getMaSach()==a[i])
                {
                    flat=1;
                    break;
                }
            }
            if(flat==0)
            {
                currentID=ct.getMaSach();
                a[num++]=currentID;
                //ra được mảng a chứa các mã sách
            }
        }

        //tìm số sách được mượn nhiều nhất(tìm theo mã sách)
        int count=0;
        int max=0;
        String temp="";
        String tensachMax="";
        for(int i=0;i<num;i++)
        {
            count=0;
            for(CT_PhieuMuon ct:lstCTPM)
            {
                if(ct.getMaSach()==a[i])
                {
                    for(Sach sa:busSa.getLst() )
                    {
                        if(sa.getMaSach()==ct.getMaSach())temp=sa.getTenSach();
                    }
                    count++;
                }
                // System.out.println(count);
            }
            if(count>max)
            {
                tensachMax=temp;
                max=count;
            }
        }

        MaxBookOfMonth[month-1]=max;

        return tensachMax;
    }

    //hàm lọc ra các CHI TIẾT PHIẾU MƯỢN trong 1 tháng
    public static String MaxBookOfMonth(ArrayList<PhieuMuon> lstPmYear,int month,int MaxBookOfMonth[],int BookOfMonth[])
    {
        CT_PhieuMuonBUS busCtpm=new CT_PhieuMuonBUS();
        ArrayList<PhieuMuon> lstPmMonth=new ArrayList<>();
        ArrayList<CT_PhieuMuon> lstCtpmMonth=new ArrayList<>();
        int flag=0;
        String result="";
        //danh sách các PHIẾU MƯỢN trong 1 tháng(tháng là month truyền vào)
        for(PhieuMuon Pm:lstPmYear)
        {
            if(Integer.parseInt(Pm.getNgayMuon().substring(5, 7))==month)
            {
                // System.out.println(Pm.toString());
                lstPmMonth.add(Pm);
                flag=1;
            }
        }
        //lọc ra các CHI TIẾT PHIẾU MƯỢN thuộc danh sách phiếu mượn trên
        if(flag==1)
        {
            for(PhieuMuon Pm:lstPmMonth)
            {
                for(CT_PhieuMuon ct:busCtpm.getLst())
                {
                    if(ct.getMaPhieu()==Pm.getMaPhieu())
                    {
                        // System.out.println("here "+ct.toString());
                        lstCtpmMonth.add(ct);
                    }
                }
            }
            //gọi hàm tính số lượng sách tối đa trong tháng
            result=MaxBookOfYear(lstCtpmMonth,MaxBookOfMonth,month);
            BookOfMonth[month-1]=lstCtpmMonth.size();
        }
        return result;
    }

    public static double[] tkPhat(String year)
    {
        //lấy mã sách bên phiếu phạt ->ct_phieu_nhap ->đơn giá
        //lấy mã quy định bên phiếu phạt -> % tiền phạt bên quy_dinh
        //tiền phạt= đơn giá* %tiền phạt
        PhieuPhatBUS busPp=new PhieuPhatBUS();
        ArrayList<PhieuPhat> lstPpYear=new ArrayList<>();

        //danh sách các phiếu phạt thuộc cùng 1 năm(year truyền vào)
        for(PhieuPhat Pp:busPp.getLst())
        {
            if(Pp.getNgayPhat().substring(0, 4).equals(year))
            {
                lstPpYear.add(Pp);
            }
        }

        double[] MaxOfEachMonth=new double[12];
        for(int i=1;i<13;i++)
        {
            //hàm tìm danh sách các phiếu trong từng tháng, đồng thời xuất ra max
            MaxOfEachMonth[(i-1)] =PhatOfMonth(lstPpYear, i);
            System.out.println("thang: "+i+" tien: "+MaxOfEachMonth[i-1]);
        }
        return MaxOfEachMonth;
    }

    //tính tiền phạt theo hằng tháng
    public static double PhatOfMonth(ArrayList<PhieuPhat> lstPpYear,int month)
    {
        ArrayList<PhieuPhat> lstPpMonth=new ArrayList<>();
        // int flag=0;
        double result=0;
        //danh sách các PHIẾU PHẠT trong 1 tháng(tháng là month truyền vào)
        for(PhieuPhat Pp:lstPpYear)
        {
            if(Integer.parseInt(Pp.getNgayPhat().substring(5, 7))==month)
            {
                // System.out.println(Pm.toString());
                lstPpMonth.add(Pp);
                // flag=1;
            }
        }

        //tính tiền phạt trong tháng
        for(PhieuPhat Pp:lstPpMonth)
        {
            double tien=(double) 0;
            if(Pp.getMaQuyDinh()==1)
            {
                tien=FindDonGia(Pp.getMaSach())*0.1*FindPhieuMuon(Pp.getMaPhieuMuon());
                result+=tien;
            }
            if(Pp.getMaQuyDinh()==2)
            {
                tien=FindDonGia(Pp.getMaSach())*2;
                result+=tien;
            }
            if(Pp.getMaQuyDinh()==3)
            {
                tien=FindDonGia(Pp.getMaSach());
                result+=tien;
            }
        }
        return result;
    }

    //tìm đơn giá theo mã sách
    public static int FindDonGia(int ma_sach)
    {
        CT_PhieuNhapBUS busCTPN=new CT_PhieuNhapBUS();
        int fee=0;
        for(CT_PhieuNhap ct:busCTPN.getLst())
        {
            if(ct.getMaSach()==ma_sach)
            {
                fee=ct.getDonGia();
            }
        }
        return fee;
    }

    //tìm phiếu mượn theo mã phiếu mượn trong phiếu phạt
    //và tính khoảng cách giữa ngày hạn và ngày trả
    public static int FindPhieuMuon(int ma_phieu_muon)
    {
        CheckTool tool=new CheckTool();
        PhieuMuonBUS busPm=new PhieuMuonBUS();
        int NgayTre=0;
        for(PhieuMuon Pm:busPm.getLst())
        {
            if(Pm.getMaPhieu()==ma_phieu_muon)
            {
                LocalDate NgayTra=null,NgayHan=null;
                if(Pm.getNgayTra()!=null)
                {
                    NgayTra=tool.getLocalDate(Integer.parseInt(Pm.getNgayTra().substring(0, 4))
                            , Integer.parseInt(Pm.getNgayTra().substring(5,7))
                            , Integer.parseInt(Pm.getNgayTra().substring(8, 10)));
                    NgayHan=tool.getLocalDate(Integer.parseInt(Pm.getNgayHan().substring(0, 4))
                            , Integer.parseInt(Pm.getNgayHan().substring(5,7))
                            , Integer.parseInt(Pm.getNgayHan().substring(8, 10)));
                    if(tool.compareDate(NgayHan, NgayTra)==1 || tool.compareDate(NgayHan, NgayTra)==0)
                    {
                        NgayTre=1;
                    }
                    else if(tool.compareDate(NgayHan, NgayTra)==-1)
                    {
                        NgayTre=NgayTra.getDayOfMonth()-NgayHan.getDayOfMonth();
                    }
                }
                else NgayTre=0;


            }
        }
        return NgayTre;
    }

    public static int[] tkThe(String year)
    {
        //lấy mã sách bên phiếu phạt ->ct_phieu_nhap ->đơn giá
        //lấy mã quy định bên phiếu phạt -> % tiền phạt bên quy_dinh
        //tiền phạt= đơn giá* %tiền phạt
        ThanhVienBUS busTv=new ThanhVienBUS();
        ArrayList<ThanhVien> lstTvYear=new ArrayList<>();

        //danh sách các phiếu phạt thuộc cùng 1 năm(year truyền vào)
        for(ThanhVien Tv:busTv.getLst())
        {
            if(Tv.getNgayTao().substring(0, 4).equals(year))
            {
                lstTvYear.add(Tv);
            }
        }

        int[] MaxOfEachMonth=new int[12];
        for(int i=1;i<13;i++)
        {
            //hàm tìm danh sách các phiếu trong từng tháng, đồng thời xuất ra max
            MaxOfEachMonth[(i-1)] =TheOfMonth(lstTvYear, i);
            System.out.println("thang: "+i+" tien: "+MaxOfEachMonth[i-1]);
        }
        return MaxOfEachMonth;
    }

    public static int TheOfMonth(ArrayList<ThanhVien> lstTvYear,int month)
    {
        ArrayList<ThanhVien> lstTvMonth=new ArrayList<>();
        // int flag=0;
        int result=0;
        //danh sách các THẺ trong 1 tháng(tháng là month truyền vào)
        for(ThanhVien Tv:lstTvYear)
        {
            if(Integer.parseInt(Tv.getNgayTao().substring(5, 7))==month)
            {
                lstTvMonth.add(Tv);
                result++;
                // flag=1;
            }
        }
        return result;
    }


}
