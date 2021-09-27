package Shop_Btl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main_hang_hoa {

	private static final String Hang_hoa = null;
	static ArrayList<Quan_ao> quan_aoList=new ArrayList<>();
	static ArrayList<Giay_dep> giay_depList=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	
	
	public void LoiNhapDuLieu() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main_hang_hoa h=new main_hang_hoa();
		int chon;
		System.out.println("+ Nhập mặt hàng cần thêm");
		do {
			
			Menu_main();
			chon=Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 0: {
				System.out.println("Đã thoát chương trinh");
				break;
			}
			
			case 1:{
				Menu_Quan_Ao();
				break;
			}
			
			case 2:{
				Menu_Giay_Dep();
				break;
			}
			default:
				System.out.println("NHập lại");
				break;
			}
		}while(chon!=0);
		System.out.println("\n\n");
	}

	
	private static void Menu_main() {
		// TODO Auto-generated method stub
		System.out.println("0.Thoát\n1.Quần áo\n2.Giày dép\nChọn");
		
	}

	
	//Quần áo
	public static  void Menu_Quan_Ao() {
			int chon;
			do {
				Menu();
				chon=Integer.parseInt(sc.nextLine());//chuyển về dạng chuỗi
				switch (chon) {
				case 0:{
					break;
				}
				case 1: {
					Them_quan_ao();
					System.out.println("<==Danh sách quần áo==> ");
					Hienthi();
					break;
				}
				
				case 2:{
					Sua_quan_ao();
					System.out.println("<==Danh sách quần áo sau khi sửa==>");
					Hienthi();
					break;
				}
				
				case 3:{
					Xoa_quan_ao();
					System.out.println("<==Danh sách quần áo sau khi xóa==>");
					Hienthi();
					break;
				}
				case 4:{
					SapxepByGia();
					System.out.println("<==Danh sách quần áo sau khi sắp xếp theo đơn giá==>");
					Hienthi();
					break;
				}
				case 5:{
					SapxepByTen();
					System.out.println("<==Danh sách quần áo sau khi sắp xếp theo tên A-Z==>");
					Hienthi();
					break;
				}
				case 6:{
					Hienthi();
					break;
				}
				case 7:{
					TimKiemByMa();
				}
				case 8:{
					Luufile();
					System.out.println("<==Đã lưu danh sách dưới dạng Giaydep.txt==>");
					break;
				}
				default:
					System.out.println("Nhập lại!");
				}
			}while(chon!=0);
			System.out.println("\n\n");
			
		}
	
	private static void Menu() {
			System.out.println("\n1.Thêm quần áo\n2.Sửa quần áo theo mã\n3.Xóa quần áo\n4.Sắp xếp quần áo theo giá\n5.Sắp xếp quần áo theo tên\n6.Hiển thị danh sách quần áo\n7.Tìm kiếm theo mã\n8.Lưu file quần áo.txt\n0.Thoát\nChọn: ");
		
	}
		private static void TimKiemByMa() {
		// TODO Auto-generated method stub
			System.out.println("+Nhập mã mặt quần áo cần tìm: ");
			String id=sc.nextLine();
			for(Quan_ao quan_ao: quan_aoList) 
			{
				if(quan_ao.getMa_hang().equals(id))
				{
					quan_ao.Xuat();;
					break;
				}
			}			
	}

		private static void Luufile() {
			// TODO Auto-generated method stub
			FileOutputStream fos=null;//tạo mới đói tượng
			try {
				fos=new FileOutputStream("quần áo.txt");//tạo file sinh viên.txt
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Quan_ao quan_ao: quan_aoList) {//duyệt tất cả phần tử mảng
				String line = quan_ao.getFileLine();//lấy từng dòng trong mang
				byte[] b;
				try {
				b = line.getBytes("utf8");//kiểu dịch ra tiếng việt
					fos.write(b);//Viết vào file
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}
			}
		}
	

	private static void Hienthi() {
		// TODO Auto-generated method stub
		for(Quan_ao quan_ao: quan_aoList) {//duyệt qua tât cả đối tượng trong list
			quan_ao.Xuat();
			System.out.println("\n\n");
		}
	}

	private static void SapxepByTen() {
		// TODO Auto-generated method stub
		Collections.sort(quan_aoList,new Comparator<Quan_ao>() {//tạo đối tượng so sánh mảng
			@Override
			public int compare(Quan_ao obj1, Quan_ao obj2) {//so snah hai đối tượng 
				// TODO Auto-generated method stub
				//sắp xếp từ A-Z
				return obj1.getTen_san_pham().compareToIgnoreCase(obj2.getTen_san_pham());//so sánh hai họ tên sinh viên
			}
		});
	}

	private static void SapxepByGia() {
		// TODO Auto-generated method stub
		Collections.sort(quan_aoList,new Comparator<Quan_ao>() 
		{

			@Override
			public int compare(Quan_ao o1, Quan_ao o2) 
			{
				// TODO Auto-generated method stub
				if(o1.getDon_gia()<o2.getDon_gia())
				{
					return -1;
				}
				return 1;
			}
			
		});
		
	}

	private static void Xoa_quan_ao() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập mã mặt quần áo cần xóa: ");
		String id=sc.nextLine();
		for(Quan_ao quan_ao: quan_aoList) 
		{
			if(quan_ao.getMa_hang().equals(id))
			{
				quan_aoList.remove(quan_ao);
				break;
			}
		}	
	}

	private static void Sua_quan_ao() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập mã quần áo cần sửa");
		String id=sc.nextLine();
		for(Quan_ao quan_ao: quan_aoList) 
		{
			if(quan_ao.getMa_hang().equals(id)) 
			{//Nhập chuỗi
			quan_ao.Nhap();
			System.out.println("\n");
			break;
			}
		}
	}

	private static void Them_quan_ao() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập số quần áo thêm: ");
		int n=Integer.parseInt(sc.nextLine());//Nhập chuỗi
		for(int i=0;i<n;i++) 
		{
			Quan_ao quan_ao=new Quan_ao() {};
			System.out.println("<==Thông tin quần áo "+(i+1)+"==>");
			quan_ao.Nhap();
			quan_aoList.add(quan_ao);
			System.out.println("\n");
		}
	}

	
	//Giày Dép
	public static void Menu_Giay_Dep() {
		int chon;
		do {
			Menu2();
			chon=Integer.parseInt(sc.nextLine());//chuyển về dạng chuỗi
			switch (chon) {
			
			case 0:{
				break;
			}
			case 1: {
				Them_giay_dep();
				System.out.println("<==Danh sách dày dép==>");
				Hienthi_Giay_dep();
				break;
			}
			
			case 2:{
				Sua_giay_dep();
				System.out.println("<==Danh sách giày dép sau khi sửa==>");
				Hienthi_Giay_dep();
				break;
			}
			
			case 3:{
				Xoa_giay_dep();
				System.out.println("<==Danh sách giày dép sau khi xóa==>");
				Hienthi_Giay_dep();
				break;
			}
			case 4:{
				SapxepByGia2();
				System.out.println("<==Danh sách giày dép sau khi sắp xếp theo đơn giá==>");
				Hienthi_Giay_dep();
				break;
			}
			case 5:{
				SapxepByTen2();
				System.out.println("<==Danh sách giày dép sau khi sắp xếp theo tên A-Z");
				Hienthi_Giay_dep();
				break;
			}
			case 6:{
				Hienthi_Giay_dep();
				break;
			}
			case 7:{
				TimKiemByMa2();
			}
			case 8:{
				Luufile_Giay_dep();
				System.out.println("<==Đã lưu danh sách dưới dạng Giaydep.txt==>");
				break;
			}
			
			default:{
				System.out.println("Nhập lại");
				break;
			}
		}
	}while(chon!=0);
		System.out.println("\n\n");
	}



	private static void Menu2() {
		// TODO Auto-generated method stub
		System.out.println("\n1.Thêm giày dép\n2.Sửa giày dép theo mã\n3.Xóa giày dép\n4.Sắp xếp giày dép theo giá\n5.Sắp xếp giày dép theo tên\n6.Hiển thị\n7.Tìm kiếm theo mã\n8.Lưu file giày dép.txt\n0.Thoát\nChọn: ");
	}


	private static void Luufile_Giay_dep() {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;//tạo mới đói tượng
		try {
			fos=new FileOutputStream("giày dép.txt");//tạo file sinh viên.txt
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Giay_dep giay_dep: giay_depList) {//duyệt tất cả phần tử mảng
			String line = giay_dep.getFileLine();//lấy từng dòng trong mang
			byte[] b;
			try {
			b = line.getBytes("utf8");//kiểu dịch ra tiếng việt
				fos.write(b);//Viết vào file
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}
	}


	private static void Hienthi_Giay_dep() {
		// TODO Auto-generated method stub
		for(Giay_dep giay_dep: giay_depList) {//duyệt qua tât cả đối tượng trong list
			giay_dep.Xuat();
			System.out.println("\n\n");
		}
	}


	private static void TimKiemByMa2() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập mã giày dép cần tìm: ");
		String id=sc.nextLine();
		for(Giay_dep giay_dep: giay_depList) 
		{
			if(giay_dep.getMa_hang().equals(id))
			{
				giay_dep.Xuat();;
				System.out.println("\n\n");
				break;
			}
		}		
	}
	
	private static void SapxepByGia2() {
		// TODO Auto-generated method stub
		Collections.sort(giay_depList,new Comparator<Giay_dep>() 
		{

			@Override
			public int compare(Giay_dep o1, Giay_dep o2) 
			{
				// TODO Auto-generated method stub
				if(o1.getDon_gia()<o2.getDon_gia())
				{
					return -1;
				}
				return 1;
			}
			
		});
	}

	private static void SapxepByTen2() {
		// TODO Auto-generated method stub
		Collections.sort(giay_depList,new Comparator<Giay_dep>() {//tạo đối tượng so sánh mảng
			@Override
			public int compare(Giay_dep obj1, Giay_dep obj2) {//so snah hai đối tượng 
				// TODO Auto-generated method stub
				//sắp xếp từ A-Z
				return obj1.getTen_san_pham().compareToIgnoreCase(obj2.getTen_san_pham());//so sánh hai họ tên sinh viên
			}
		});
	}


	private static void Xoa_giay_dep() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập mã mặt hàng giày dép cần xóa: ");
		String id=sc.nextLine();
		for(Giay_dep giay_dep: giay_depList) 
		{
			if(giay_dep.getMa_hang().equals(id))
			{
				giay_depList.remove(giay_dep);
				break;
			}
		}	
	}


	private static void Sua_giay_dep() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập mã giày dép cần sửa");
		String id=sc.nextLine();
		for(Giay_dep giay_dep: giay_depList) 
		{
			if(giay_dep.getMa_hang().equals(id)) 
			{//Nhập chuỗi
			giay_dep.Nhap();
			System.out.println("\n");
			break;
			}
		}
	}


	private static void Them_giay_dep() {
		// TODO Auto-generated method stub
		System.out.println("+Nhập số giày dép thêm: ");
		int n=Integer.parseInt(sc.nextLine());//Nhập chuỗi
		for(int i=0;i<n;i++) 
		{
			Giay_dep giay_dep=new Giay_dep() {};
			System.out.println("<==Thông tin giày dép "+(i+1)+"==>");
			giay_dep.Nhap();
			giay_depList.add(giay_dep);
			System.out.println("\n");
		}
	}
}
