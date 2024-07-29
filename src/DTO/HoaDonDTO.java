package DTO;

import java.util.Date;

public class HoaDonDTO {

    private int maHoaDon;
    private int maKhachHang;
    private Date ngayLap;
    private double tongTien;
    private String trangThai;
    private String ghiChu;
    private java.sql.Timestamp ngayTao;

    public HoaDonDTO() {
    }

    public HoaDonDTO(int maHoaDon, int maKhachHang, java.util.Date ngayLap, double tongTien, String trangThai, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public java.sql.Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(java.sql.Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}
