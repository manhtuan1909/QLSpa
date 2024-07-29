package DAO;

import DTO.ChiTietDichVuDTO;
import QuanLyHoaDon_ThanhToan.JFrame_QuanLyHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ChiTietDichVuDAO {

    private Connect_Db connectLink = new Connect_Db();
    private Connection connection = connectLink.connectDB();

    public List<ChiTietDichVuDTO> getAllChiTietDichVu() {
        List<ChiTietDichVuDTO> chiTietDichVuList = new ArrayList<>();
        String query = "SELECT * FROM ChiTietDichVu";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChiTietDichVuDTO chiTietDichVu = new ChiTietDichVuDTO();
                chiTietDichVu.setMaChiTietDichVu(rs.getInt("MaChiTietDichVu"));
                chiTietDichVu.setMaHoaDon(rs.getInt("MaHoaDon"));
                chiTietDichVu.setMaDichVu(rs.getInt("MaDichVu"));
                chiTietDichVu.setSoLuong(rs.getInt("SoLuong"));
                chiTietDichVu.setDonGia(rs.getDouble("DonGia"));
                chiTietDichVu.setThanhTien(rs.getDouble("ThanhTien"));
                chiTietDichVuList.add(chiTietDichVu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chiTietDichVuList;
    }

    public void deleteChiTietDichVu(int maHoaDon, int maDichVu) {
        String query = "DELETE FROM ChiTietDichVu WHERE MaHoaDon = ? AND MaDichVu = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maHoaDon);
            preparedStatement.setInt(2, maDichVu);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateChiTietDichVu(int maHoaDon, ChiTietDichVuDTO chiTietDichVu) {
        String query = "UPDATE ChiTietDichVu SET SoLuong = ?, DonGia = ? WHERE MaHoaDon = ? AND MaDichVu = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, chiTietDichVu.getSoLuong());
            preparedStatement.setDouble(2, chiTietDichVu.getDonGia());
            preparedStatement.setInt(3, maHoaDon);
            preparedStatement.setInt(4, chiTietDichVu.getMaDichVu());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
