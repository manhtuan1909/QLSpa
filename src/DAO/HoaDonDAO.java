package DAO;

import DTO.HoaDonDTO;
import QuanLyHoaDon_ThanhToan.JFrame_QuanLyHoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class HoaDonDAO {

    private Connect_Db connectLink = new Connect_Db();
    private Connection connection = connectLink.connectDB();

    public List<HoaDonDTO> getAllHoaDon() {
        List<HoaDonDTO> hoaDonList = new ArrayList<>();
        String query = "SELECT * FROM HoaDon";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                HoaDonDTO hoaDon = new HoaDonDTO();
                hoaDon.setMaHoaDon(rs.getInt("MaHoaDon"));
                hoaDon.setMaKhachHang(rs.getInt("MaKhachHang"));
                hoaDon.setNgayLap(rs.getDate("NgayLap"));
                hoaDon.setTongTien(rs.getDouble("TongTien"));
                hoaDon.setTrangThai(rs.getString("TrangThai"));
                hoaDon.setGhiChu(rs.getString("GhiChu"));
                hoaDon.setNgayTao(rs.getTimestamp("NgayTao"));
                hoaDonList.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDonList;
    }

    public void updateHoaDon(HoaDonDTO hoaDon) {
        String query = "UPDATE HoaDon SET MaKhachHang = ?, NgayLap = ?, TongTien = ?, TrangThai = ?, GhiChu = ? WHERE MaHoaDon = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, hoaDon.getMaKhachHang());
            preparedStatement.setDate(2, new java.sql.Date(hoaDon.getNgayLap().getTime()));
            preparedStatement.setDouble(3, hoaDon.getTongTien());
            preparedStatement.setString(4, hoaDon.getTrangThai());
            preparedStatement.setString(5, hoaDon.getGhiChu());
            preparedStatement.setInt(6, hoaDon.getMaHoaDon());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Hóa đơn được cập nhật thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn để cập nhật!");
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
