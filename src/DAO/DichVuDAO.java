package DAO;

import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DichVuDAO {

    private Connect_Db connectLink = new Connect_Db();
    private Connection connection = connectLink.connectDB();

    public List<DichVuDTO> getAllDichVu() {
        List<DichVuDTO> dichVuList = new ArrayList<>();
        String query = "SELECT * FROM DichVu";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DichVuDTO dichVu = new DichVuDTO();
                dichVu.setMaDichVu(rs.getInt("MaDichVu"));
                dichVu.setTenDichVu(rs.getString("TenDichVu"));
                dichVu.setMoTa(rs.getString("MoTa"));
                dichVu.setThoiLuong(rs.getInt("ThoiLuong"));
                dichVu.setGia(rs.getDouble("Gia"));
                dichVu.setNgayTao(rs.getTimestamp("NgayTao"));
                dichVuList.add(dichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dichVuList;
    }

    public boolean addDichVu(DichVuDTO dichVu) {
        String query = "INSERT INTO DichVu (TenDichVu, MoTa, ThoiLuong, Gia) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, dichVu.getTenDichVu());
            ps.setString(2, dichVu.getMoTa());
            ps.setInt(3, dichVu.getThoiLuong());
            ps.setDouble(4, dichVu.getGia());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateDichVu(DichVuDTO dichVu) {
        String query = "UPDATE DichVu SET TenDichVu = ?, MoTa = ?, ThoiLuong = ?, Gia = ? WHERE MaDichVu = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, dichVu.getTenDichVu());
            ps.setString(2, dichVu.getMoTa());
            ps.setInt(3, dichVu.getThoiLuong());
            ps.setDouble(4, dichVu.getGia());
            ps.setInt(5, dichVu.getMaDichVu());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteDichVu(int maDichVu) {
        String query = "DELETE FROM DichVu WHERE MaDichVu = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, maDichVu);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
