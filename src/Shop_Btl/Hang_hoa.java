package Shop_Btl;

import java.util.Scanner;



abstract class Hang_hoa {
	
	private String ma_hang, band, ten_san_pham, dia_chi, ngay_san_xuat;
		
	
	
	public Hang_hoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Hang_hoa(String ma_hang, String band, String ten_san_pham, String dia_chi, String ngay_san_xuat) {
		super();
		this.ma_hang = ma_hang;
		this.band = band;
		this.ten_san_pham = ten_san_pham;
		this.dia_chi = dia_chi;
		this.ngay_san_xuat = ngay_san_xuat;
	}
	public String getMa_hang() {
		return ma_hang;
	}
	public void setMa_hang(String ma_hang) {
		this.ma_hang = ma_hang;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getTen_san_pham() {
		return ten_san_pham;
	}
	public void setTen_san_pham(String ten_san_pham) {
		this.ten_san_pham = ten_san_pham;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getNgay_san_xuat() {
		return ngay_san_xuat;
	}
	public void setNgay_san_xuat(String ngay_san_xuat) {
		this.ngay_san_xuat = ngay_san_xuat;
	}
	
	public void Nhap() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("+ Nhập mã hàng: ");
		ma_hang=scanner.nextLine();
		System.out.println("+ Nhập tên sản phẩm: ");
		ten_san_pham=scanner.nextLine();
		System.out.println("+ Nhập hãng: ");
		band=scanner.nextLine();
		System.out.println("+ Nhập ngày sản xuất: ");
		ngay_san_xuat=scanner.nextLine();
		System.out.println("+Nhập địa chỉ: ");
		dia_chi=scanner.nextLine();
	}
	
	public void Xuat() {
		System.out.println("* Mã hàng: "+ ma_hang);
		System.out.println("- Tên sản phẩm: "+ten_san_pham);
		System.out.println("- Hãng: "+ band);
		System.out.println("- Ngày sản xuất: "+ngay_san_xuat);
		System.out.println("- Địa chỉ: "+dia_chi);
		
		//System.out.println("Mã hàng: "+ma_hang+"\t Tên sản phẩm: "+ten_san_pham+"\t Hãng: "+band+"\t Ngày sản xuất: "+ngay_san_xuat+"\t Địa chỉ: "+dia_chi);
	}
	protected abstract int Thanh_tien();
}
