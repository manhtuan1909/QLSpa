package DAO;

import DTO.ChiTietSanPhamDTO;
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

public class ChiTietSanPhamDAO {

    private Connect_Db connectLink = new Connect_Db();
    private Connection connection = connectLink.connectDB();

    public List<ChiTietSanPhamDTO> getAllChiTietSanPham() {
        List<ChiTietSanPhamDTO> chiTietSanPhamList = new ArrayList<>();
        String query = "SELECT * FROM ChiTietSanPham";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ChiTietSanPhamDTO chiTietSanPham = new ChiTietSanPhamDTO();
                chiTietSanPham.setMaChiTietSanPham(rs.getInt("MaChiTietSanPham"));
                chiTietSanPham.setMaHoaDon(rs.getInt("MaHoaDon"));
                chiTietSanPham.setMaSanPham(rs.getInt("MaSanPham"));
                chiTietSanPham.setSoLuong(rs.getInt("SoLuong"));
                chiTietSanPham.setDonGia(rs.getDouble("DonGia"));
                chiTietSanPham.setThanhTien(rs.getDouble("ThanhTien"));
                chiTietSanPhamList.add(chiTietSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chiTietSanPhamList;
    }

    public void deleteChiTietSanPham(int maHoaDon, int maSanPham) {
        String query = "DELETE FROM ChiTietSanPham WHERE MaHoaDon = ? AND MaSanPham = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maHoaDon);
            preparedStatement.setInt(2, maSanPham);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateChiTietSanPham(int maHoaDon, ChiTietSanPhamDTO chiTietSanPham) {
        String query = "UPDATE ChiTietSanPham SET SoLuong = ?, DonGia = ? WHERE MaHoaDon = ? AND MaSanPham = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, chiTietSanPham.getSoLuong());
            preparedStatement.setDouble(2, chiTietSanPham.getDonGia());
            preparedStatement.setInt(3, maHoaDon);
            preparedStatement.setInt(4, chiTietSanPham.getMaSanPham());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
