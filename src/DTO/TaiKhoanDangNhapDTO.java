package DTO;

public class TaiKhoanDangNhapDTO {

    private String tenDangNhap;
    private String matKhau;
    private String maNguoiDung;

    public TaiKhoanDangNhapDTO() {
    }

    public TaiKhoanDangNhapDTO(String tenDangNhap, String matKhau, int vaiTro, String maNguoiDung) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

}
