package LichHen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CapNhatKhachHangForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lblHo, lblTen, lblGioiTinh, lblNgaySinh, lblSoDienThoai, lblEmail, lblDiaChi;
    private JTextField txtHo, txtTen, txtSoDienThoai, txtEmail, txtDiaChi, txtNgaySinh;
    private JComboBox<String> cboGioiTinh;
    private JButton btnLuu;

    private Connection connection;

    public CapNhatKhachHangForm(Connection connection, int maKhachHang, String ho, String ten, String gioiTinh, String ngaySinh, String soDienThoai, String email, String diaChi) {
        this.connection = connection;

        setTitle("Cập nhật thông tin khách hàng");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(8, 2, 10, 10));

        lblHo = new JLabel("Họ:");
        txtHo = new JTextField(ho);

        lblTen = new JLabel("Tên:");
        txtTen = new JTextField(ten);

        lblGioiTinh = new JLabel("Giới tính:");
        cboGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ", "Khác"});
        cboGioiTinh.setSelectedItem(gioiTinh);

        lblNgaySinh = new JLabel("Ngày sinh:");
        txtNgaySinh = new JTextField(ngaySinh);

        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(email);

        lblDiaChi = new JLabel("Địa chỉ:");
        txtDiaChi = new JTextField(diaChi);

        lblSoDienThoai = new JLabel("Số điện thoại:");
        txtSoDienThoai = new JTextField(soDienThoai);

        btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuThongTinKhachHang(maKhachHang);
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

    private void luuThongTinKhachHang(int maKhachHang) {
        try {
            String ho = txtHo.getText();
            String ten = txtTen.getText();
            String gioiTinh = cboGioiTinh.getSelectedItem().toString();
            String ngaySinhString = txtNgaySinh.getText();
            String soDienThoai = txtSoDienThoai.getText();
            String email = txtEmail.getText();
            String diaChi = txtDiaChi.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaySinh = dateFormat.parse(ngaySinhString);
            
            String query = "UPDATE KhachHang SET Ho = ?, Ten = ?, GioiTinh = ?, NgaySinh = ?, SoDienThoai = ?, Email = ?, DiaChi = ? WHERE MaKhachHang = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ho);
            preparedStatement.setString(2, ten);
            preparedStatement.setString(3, gioiTinh);
            preparedStatement.setDate(4, new java.sql.Date(ngaySinh.getTime()));
            preparedStatement.setString(5, soDienThoai);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, diaChi);
            preparedStatement.setInt(8, maKhachHang);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thành công");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin khách hàng thất bại");
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
