package Shop_Btl;

import java.util.Scanner;

abstract class Giay_dep extends Hang_hoa{

	private int so_luong;
	private int don_gia;
	private int size;
	
	public Giay_dep() {
		// TODO Auto-generated constructor stub
	}

	

	public Giay_dep(int so_luong, int don_gia, int size) {
		super();
		this.so_luong = so_luong;
		this.don_gia = don_gia;
		this.size = size;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public int getDon_gia() {
		return don_gia;
	}

	public void setDon_gia(int don_gia) {
		this.don_gia = don_gia;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

	public void Nhap() {
		super.Nhap();
		Scanner scanner=new Scanner(System.in);
		System.out.println("+ Nhập số lượng: ");
		so_luong=scanner.nextInt();
		System.out.println("+ Nhập đơn giá: ");
		don_gia=scanner.nextInt();
		System.out.println("+ Nhập size: ");
		size=scanner.nextInt();
	}
	
	public void Xuat() {
		super.Xuat();
		System.out.println("- Số lượng: "+so_luong);
		System.out.println("- Đơn giá: "+don_gia);
		System.out.println("- Size: "+size);
	
	}
	
	public int Thanh_tien() {
		int m = 1;
		m = don_gia*so_luong;
		return m;
	}

	public String getFileLine() {
		// TODO Auto-generated method stub
		return getMa_hang() +"\n "+getTen_san_pham()+"\n"+getBand()+"\n "+getNgay_san_xuat()+"\n"+getDia_chi()+"\n"+so_luong+"\n"+don_gia;
	}
}
