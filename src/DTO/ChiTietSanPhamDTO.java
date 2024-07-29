package DTO;

public class ChiTietSanPhamDTO {

    private int maChiTietSanPham;
    private int maHoaDon;
    private int maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public ChiTietSanPhamDTO() {
    }

    public ChiTietSanPhamDTO(int maHoaDon, int maSanPham, int soLuong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getMaChiTietSanPham() {
        return maChiTietSanPham;
    }

    public void setMaChiTietSanPham(int maChiTietSanPham) {
        this.maChiTietSanPham = maChiTietSanPham;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return soLuong * donGia;
    }
}
