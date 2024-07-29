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

public class ThemKhachHangForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lblHo, lblTen, lblGioiTinh, lblNgaySinh, lblSoDienThoai, lblEmail, lblDiaChi;
    private JTextField txtHo, txtTen, txtSoDienThoai, txtEmail, txtDiaChi, txtNgaySinh;
    private JComboBox<String> cboGioiTinh;
    private JButton btnLuu;

    private Connection connection;

    public ThemKhachHangForm(Connection connection) {
        this.connection = connection;

        setTitle("Nhập thông tin khách hàng");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(8, 2, 10, 10));

        lblHo = new JLabel("Họ:");
        txtHo = new JTextField();

        lblTen = new JLabel("Tên:");
        txtTen = new JTextField();

        lblGioiTinh = new JLabel("Giới tính:");
        cboGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ", "Khác"});

        lblNgaySinh = new JLabel("Ngày sinh:");
        txtNgaySinh = new JTextField();

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        lblDiaChi = new JLabel("Địa chỉ:");
        txtDiaChi = new JTextField();

        lblSoDienThoai = new JLabel("Số điện thoại:");
        txtSoDienThoai = new JTextField();

        btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuThongTinKhachHang();
            }
        });

        getContentPane().add(lblHo);
        getContentPane().add(txtHo);
        getContentPane().add(lblTen);
        getContentPane().add(txtTen);
        getContentPane().add(lblGioiTinh);
        getContentPane().add(cboGioiTinh);
        getContentPane().add(lblNgaySinh);
        getContentPane().add(txtNgaySinh);
        getContentPane().add(lblEmail);
        getContentPane().add(txtEmail);
        getContentPane().add(lblDiaChi);
        getContentPane().add(txtDiaChi);
        getContentPane().add(lblSoDienThoai);
        getContentPane().add(txtSoDienThoai);
        getContentPane().add(new JLabel());
        getContentPane().add(btnLuu);
    }

    private void luuThongTinKhachHang() {
        try {
            String ho = txtHo.getText();
            String ten = txtTen.getText();
            String gioiTinh = cboGioiTinh.getSelectedItem().toString();
            String ngaySinh = txtNgaySinh.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String email = txtEmail.getText();
            String diaChi = txtDiaChi.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = dateFormat.parse(ngaySinh);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ. Vui lòng nhập lại theo định dạng năm-tháng-ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String query = "INSERT INTO KhachHang (Ho, Ten, GioiTinh, NgaySinh, SoDienThoai, Email, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ho);
            preparedStatement.setString(2, ten);
            preparedStatement.setString(3, gioiTinh);
            preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
            preparedStatement.setString(5, soDienThoai);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, diaChi);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu thông tin khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Connection connection = DBConnect.getConnection();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ThemKhachHangForm(connection).setVisible(true);
            }
        });
    }
}
