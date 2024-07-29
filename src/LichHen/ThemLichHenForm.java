package LichHen;

import javax.swing.*;

import MySpa.DBConnect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThemLichHenForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblMaKhachHang, lblMaDichVu, lblMaNhanVien, lblNgayHen, lblGioDen, lblGhiChu;
    private JTextField txtMaKhachHang, txtMaDichVu, txtMaNhanVien, txtNgayHen, txtGioDen, txtGhiChu;
    private JButton btnLuu;

    private Connection connection;

    public ThemLichHenForm(Connection connection) {
        this.connection = connection;

        setTitle("Thêm lịch hẹn");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(7, 2, 10, 10));

        lblMaKhachHang = new JLabel("Mã khách hàng:");
        txtMaKhachHang = new JTextField();

        lblMaDichVu = new JLabel("Mã dịch vụ:");
        txtMaDichVu = new JTextField();

        lblMaNhanVien = new JLabel("Mã nhân viên:");
        txtMaNhanVien = new JTextField();

        lblNgayHen = new JLabel("Ngày hẹn:");
        txtNgayHen = new JTextField();

        lblGioDen = new JLabel("Giờ đến:");
        txtGioDen = new JTextField();

        lblGhiChu = new JLabel("Ghi chú:");
        txtGhiChu = new JTextField();

        btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuThongTinLichHen();
            }
        });

        getContentPane().add(lblMaKhachHang);
        getContentPane().add(txtMaKhachHang);
        getContentPane().add(lblMaDichVu);
        getContentPane().add(txtMaDichVu);
        getContentPane().add(lblMaNhanVien);
        getContentPane().add(txtMaNhanVien);
        getContentPane().add(lblNgayHen);
        getContentPane().add(txtNgayHen);
        getContentPane().add(lblGioDen);
        getContentPane().add(txtGioDen);
        getContentPane().add(lblGhiChu);
        getContentPane().add(txtGhiChu);
        getContentPane().add(new JLabel());
        getContentPane().add(btnLuu);
    }

    private void luuThongTinLichHen() {
        try {
            int maKhachHang = Integer.parseInt(txtMaKhachHang.getText());
            int maDichVu = Integer.parseInt(txtMaDichVu.getText());
            int maNhanVien = Integer.parseInt(txtMaNhanVien.getText());
            String ngayHen = txtNgayHen.getText();
            String gioDen = txtGioDen.getText();
            String ghiChu = txtGhiChu.getText();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(ngayHen);

            String query = "INSERT INTO LichHen (MaKhachHang, MaDichVu, MaNhanVien, NgayHen, GioDen, GhiChu) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maKhachHang);
            preparedStatement.setInt(2, maDichVu);
            preparedStatement.setInt(3, maNhanVien);
            preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
            preparedStatement.setString(5, gioDen);
            preparedStatement.setString(6, ghiChu);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Thêm lịch hẹn thành công");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm lịch hẹn thất bại");
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu thông tin lịch hẹn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Connection connection = DBConnect.getConnection();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThemLichHenForm(connection).setVisible(true);
            }
        });
    }
}
