package DTO;

public class DichVuDTO {

    private int maDichVu;
    private String tenDichVu;
    private String moTa;
    private int thoiLuong;
    private double gia;
    private java.sql.Timestamp ngayTao;

    public DichVuDTO() {
    }

    public DichVuDTO(int maDichVu, String tenDichVu, String moTa, int thoiLuong, double gia) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.moTa = moTa;
        this.thoiLuong = thoiLuong;
        this.gia = gia;
    }

    public DichVuDTO(String tenDichVu, String moTa, int thoiLuong, double gia) {
        this.tenDichVu = tenDichVu;
        this.moTa = moTa;
        this.thoiLuong = thoiLuong;
        this.gia = gia;
    }

    // Getters and Setters
    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public java.sql.Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(java.sql.Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }
}
