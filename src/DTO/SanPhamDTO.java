package DTO;

public class SanPhamDTO {

    private int maSanPham;
    private String tenSanPham;
    private String moTa;
    private int soLuongTon;
    private double giaBan;
    private java.sql.Timestamp ngayTao;

    // Constructors
    public SanPhamDTO() {
    }

    public SanPhamDTO(int maSanPham, String tenSanPham, String moTa, int soLuongTon, double giaBan) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
    }

    public SanPhamDTO(String tenSanPham, String moTa, int soLuongTon, double giaBan) {
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
    }

    // Getters and Setters
    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public java.sql.Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(java.sql.Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}
