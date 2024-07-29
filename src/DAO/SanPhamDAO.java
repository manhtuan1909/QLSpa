package DAO;

import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    private Connect_Db connectLink = new Connect_Db();

    public List<SanPhamDTO> getAllSanPham() {
        List<SanPhamDTO> sanPhamList = new ArrayList<>();
        String query = "SELECT * FROM SanPham";

        try (Connection conn = connectLink.connectDB(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                SanPhamDTO sanPham = new SanPhamDTO();
                sanPham.setMaSanPham(rs.getInt("MaSanPham"));
                sanPham.setTenSanPham(rs.getString("NTenSanPham"));
                sanPham.setMoTa(rs.getString("MoTa"));
                sanPham.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanPham.setGiaBan(rs.getDouble("GiaBan"));
                sanPham.setNgayTao(rs.getTimestamp("NgayTao"));
                sanPhamList.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sanPhamList;
    }

    public boolean addSanPham(SanPhamDTO sanPham) {
        String query = "INSERT INTO SanPham (NTenSanPham, MoTa, SoLuongTon, GiaBan) VALUES (?, ?, ?, ?)";
        try (Connection conn = connectLink.connectDB(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sanPham.getTenSanPham());
            stmt.setString(2, sanPham.getMoTa());
            stmt.setInt(3, sanPham.getSoLuongTon());
            stmt.setDouble(4, sanPham.getGiaBan());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSanPham(int maSanPham) {
        String query = "DELETE FROM SanPham WHERE MaSanPham = ?";
        try (Connection conn = connectLink.connectDB(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, maSanPham);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSanPham(SanPhamDTO sanPham) {
        String query = "UPDATE SanPham SET NTenSanPham = ?, MoTa = ?, SoLuongTon = ?, GiaBan = ? WHERE MaSanPham = ?";
        try (Connection conn = connectLink.connectDB(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sanPham.getTenSanPham());
            stmt.setString(2, sanPham.getMoTa());
            stmt.setInt(3, sanPham.getSoLuongTon());
            stmt.setDouble(4, sanPham.getGiaBan());
            stmt.setInt(5, sanPham.getMaSanPham());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
