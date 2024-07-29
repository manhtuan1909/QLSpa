package DAO;

import DTO.TaiKhoanDangNhapDTO;
import DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiKhoanDangNhapDAO {

    private Connect_Db connectDb;

    public TaiKhoanDangNhapDAO() {
        connectDb = new Connect_Db();
    }

    public TaiKhoanDangNhapDTO getTaiKhoanByCredentials(String username, String password) {
        TaiKhoanDangNhapDTO taiKhoan = null;
        try (Connection connection = connectDb.connectDB()) {
            String query = "SELECT * FROM TaiKhoanDangNhap WHERE TenDangNhap = ? AND MatKhau = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                taiKhoan = new TaiKhoanDangNhapDTO();
                taiKhoan.setTenDangNhap(resultSet.getString("TenDangNhap"));
                taiKhoan.setMatKhau(resultSet.getString("MatKhau"));
                taiKhoan.setMaNguoiDung(resultSet.getString("MaNguoiDung"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taiKhoan;
    }
}
