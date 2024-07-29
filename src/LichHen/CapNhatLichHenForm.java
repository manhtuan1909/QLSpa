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

public class CapNhatLichHenForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lblMaLichHen, lblMaKhachHang, lblMaDichVu, lblMaNhanVien, lblNgayHen, lblGioDen, lblTrangThai, lblGhiChu;
    private JTextField txtMaKhachHang, txtMaDichVu, txtMaNhanVien, txtNgayHen, txtGioDen, txtGhiChu;
    private JComboBox<String> cboTrangThai;
    private JButton btnLuu;

    private Connection connection;

    public CapNhatLichHenForm(Connection connection, int maLichHen, int maKhachHang, int maDichVu, int maNhanVien, String ngayHen, String gioDen, String trangThai, String ghiChu) {
        this.connection = connection;

        setTitle("Cập nhật lịch hẹn");
        setSize(427, 338);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        lblMaLichHen = new JLabel("Mã lịch hẹn:");
        lblMaLichHen.setBounds(0, 1, 74, 25);
        lblMaLichHen.setHorizontalAlignment(SwingConstants.LEFT);
        lblMaLichHen.setVerticalAlignment(SwingConstants.CENTER);
        lblMaLichHen.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(lblMaLichHen);

        JTextField txtMaLichHen = new JTextField(Integer.toString(maLichHen));
        txtMaLichHen.setEditable(false);
        txtMaLichHen.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtMaLichHen.setBounds(107, 1, 125, 25);
        getContentPane().add(txtMaLichHen);

        lblMaKhachHang = new JLabel("Mã khách hàng:");
        lblMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMaKhachHang.setBounds(0, 251, 96, 25);
        txtMaKhachHang = new JTextField(String.valueOf(maKhachHang));
        txtMaKhachHang.setBounds(107, 252, 125, 25);

        lblMaDichVu = new JLabel("Mã dịch vụ:");
        lblMaDichVu.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMaDichVu.setBounds(0, 212, 91, 25);
        txtMaDichVu = new JTextField(String.valueOf(maDichVu));
        txtMaDichVu.setBounds(107, 213, 125, 25);

        lblMaNhanVien = new JLabel("Mã nhân viên:");
        lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMaNhanVien.setBounds(0, 36, 91, 25);
        txtMaNhanVien = new JTextField(String.valueOf(txtMaNhanVien));
        txtMaNhanVien.setBounds(107, 36, 125, 25);

        lblNgayHen = new JLabel("Ngày hẹn:");
        lblNgayHen.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNgayHen.setBounds(0, 71, 82, 25);
        txtNgayHen = new JTextField(ngayHen);
        txtNgayHen.setBounds(107, 71, 125, 25);

        lblGioDen = new JLabel("Giờ đến:");
        lblGioDen.setHorizontalAlignment(SwingConstants.LEFT);
        lblGioDen.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblGioDen.setBounds(0, 106, 125, 25);
        txtGioDen = new JTextField(gioDen);
        txtGioDen.setBounds(107, 106, 125, 25);

        lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTrangThai.setBounds(0, 141, 125, 25);
        cboTrangThai = new JComboBox<>(new String[]{"Đã đặt lịch", "Đã hủy", "Đã hoàn thành"});
        cboTrangThai.setBounds(107, 142, 125, 25);
        cboTrangThai.setSelectedItem(trangThai);

        lblGhiChu = new JLabel("Ghi chú:");
        lblGhiChu.setHorizontalAlignment(SwingConstants.LEFT);
        lblGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblGhiChu.setBounds(0, 175, 74, 25);
        txtGhiChu = new JTextField(ghiChu);
        txtGhiChu.setHorizontalAlignment(SwingConstants.LEFT);
        txtGhiChu.setBounds(107, 176, 125, 25);

        btnLuu = new JButton("Lưu");
        btnLuu.setBounds(258, 275, 125, 25);
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luuThongTinLichHen(maLichHen);
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
        getContentPane().add(lblTrangThai);
        getContentPane().add(cboTrangThai);
        getContentPane().add(lblGhiChu);
        getContentPane().add(txtGhiChu);
        JLabel label = new JLabel();
        label.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label.setBounds(135, 176, 125, 25);
        getContentPane().add(label);
        getContentPane().add(btnLuu);
    }

    private void luuThongTinLichHen(int maLichHen) {
        try {
        	int maKhachHang =Integer.parseInt(txtMaKhachHang.getText());
            int maDichVu = Integer.parseInt(txtMaDichVu.getText());
            int maNhanVien = Integer.parseInt(txtMaNhanVien.getText());
            String ngayHenString = txtNgayHen.getText();
            String gioDen = txtGioDen.getText();
            String trangThai = cboTrangThai.getSelectedItem().toString();
            String ghiChu = txtGhiChu.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date ngayHen = dateFormat.parse(ngayHenString);
            String query = "UPDATE LichHen SET MaKhachHang =?,MaDichVu = ?, MaNhanVien = ?, NgayHen = ?, GioDen = ?, TrangThai = ?, GhiChu = ? WHERE MaLichHen = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maKhachHang);
            preparedStatement.setInt(2, maDichVu);
            preparedStatement.setInt(3, maNhanVien);
            preparedStatement.setDate(4, new java.sql.Date(ngayHen.getTime())); 
            preparedStatement.setString(5, gioDen);
            preparedStatement.setString(6, trangThai);
            preparedStatement.setString(7, ghiChu);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật lịch hẹn thành công");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật lịch hẹn thất bại");
            }
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật thông tin lịch hẹn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }


}
