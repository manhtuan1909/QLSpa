package DTO;

public class ChiTietDichVuDTO {

    private int maChiTietDichVu;
    private int maHoaDon;
    private int maDichVu;
    private int soLuong;
    private double donGia;
    private double thanhTien;

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public ChiTietDichVuDTO() {
    }

    public ChiTietDichVuDTO(int maHoaDon, int maDichVu, int soLuong, double donGia) {
        this.maHoaDon = maHoaDon;
        this.maDichVu = maDichVu;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaChiTietDichVu() {
        return maChiTietDichVu;
    }

    public void setMaChiTietDichVu(int maChiTietDichVu) {
        this.maChiTietDichVu = maChiTietDichVu;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
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
}
