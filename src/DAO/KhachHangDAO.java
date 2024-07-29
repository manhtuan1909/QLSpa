package DAO;

import DTO.KhachHangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KhachHangDAO {

    private Connect_Db connectLink = new Connect_Db();
    private Connection connection = connectLink.connectDB();

    public KhachHangDTO getKhachHangById(int maKhachHang) {
        KhachHangDTO khachHang = null;
        String query = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, maKhachHang);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                khachHang = new KhachHangDTO();
                khachHang.setMaKhachHang(rs.getInt("MaKhachHang"));
                khachHang.setHo(rs.getString("Ho"));
                khachHang.setTen(rs.getString("Ten"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));
                khachHang.setNgaySinh(rs.getDate("NgaySinh"));
                khachHang.setSoDienThoai(rs.getString("SoDienThoai"));
                khachHang.setEmail(rs.getString("Email"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setNgayTao(rs.getTimestamp("NgayTao"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return khachHang;
    }
}
