package LichHen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import MySpa.DBConnect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class QuanLyKhachHang extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection connection;

    public QuanLyKhachHang() {
        setTitle("Quản lý khách hàng");
        setSize(899, 666);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        connection = DBConnect.getConnection();
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã KH", "Họ", "Tên", "Giới Tính", "Ngày Sinh", "Số ĐT", "Email", "Địa Chỉ", "Ngày Tạo"}
        );
        table = new JTable(tableModel);

        loadDataIntoTable();

        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 90, 895, 403);
        getContentPane().add(scrollPane);

        JLabel lblTitle = new JLabel("DANH SÁCH KHÁCH HÀNG");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(235, 10, 432, 70);
        getContentPane().add(lblTitle);

        JButton btnThem = new JButton("THÊM");
        btnThem.setBackground(Color.LIGHT_GRAY);
        btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnThem.setBounds(208, 532, 159, 37);
        getContentPane().add(btnThem);

        JButton btnCapNhat = new JButton("CẬP NHẬT");
        btnCapNhat.setBackground(Color.LIGHT_GRAY);
        btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnCapNhat.setBounds(546, 532, 159, 37);
        getContentPane().add(btnCapNhat);

        JButton btnLamMoi = new JButton("LÀM MỚI");
        btnLamMoi.setBackground(Color.LIGHT_GRAY);
        btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnLamMoi.setBounds(715, 532, 159, 37);
        getContentPane().add(btnLamMoi);

        JButton btnXoa = new JButton("XÓA");
        btnXoa.setBackground(Color.LIGHT_GRAY);
        btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnXoa.setBounds(377, 532, 159, 37);
        getContentPane().add(btnXoa);

        JButton btnTimKiem = new JButton("TÌM KIẾM");
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnTimKiem.setBackground(Color.LIGHT_GRAY);
        btnTimKiem.setBounds(39, 532, 159, 37);
        getContentPane().add(btnTimKiem);
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ThemKhachHangForm themKhachHangForm = new ThemKhachHangForm(connection);
                themKhachHangForm.setVisible(true);
                themKhachHangForm.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        if (themKhachHangForm != null) {
                            loadDataIntoTable();
                        }
                    }
                });
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(QuanLyKhachHang.this, "Vui lòng chọn một khách hàng để xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(QuanLyKhachHang.this, "Bạn có chắc chắn muốn xóa khách hàng này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int maKhachHang = (int) table.getValueAt(selectedRow, 0);
                    if (xoaKhachHang(maKhachHang)) {
                        JOptionPane.showMessageDialog(QuanLyKhachHang.this, "Xóa khách hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadDataIntoTable();
                    } else {
                        JOptionPane.showMessageDialog(QuanLyKhachHang.this, "Xóa khách hàng thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Theo tên", "Theo số điện thoại", "Theo mã khách hàng"};
                String selectedOption = (String) JOptionPane.showInputDialog(QuanLyKhachHang.this, "Chọn cách tìm kiếm", "Tìm kiếm", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (selectedOption != null) {
                    String keyword = JOptionPane.showInputDialog(QuanLyKhachHang.this, "Nhập từ khóa tìm kiếm", "Tìm kiếm", JOptionPane.QUESTION_MESSAGE);
                    if (keyword != null && !keyword.trim().isEmpty()) {
                        timKiemKhachHang(selectedOption, keyword.trim());
                    } else {
                        JOptionPane.showMessageDialog(QuanLyKhachHang.this, "Từ khóa không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        btnLamMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataIntoTable();
            }
        });
        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(QuanLyKhachHang.this, "Vui lòng chọn một khách hàng để cập nhật", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int maKhachHang = (int) table.getValueAt(selectedRow, 0);
                String ho = (String) table.getValueAt(selectedRow, 1);
                String ten = (String) table.getValueAt(selectedRow, 2);
                String gioiTinh = (String) table.getValueAt(selectedRow, 3);
                java.sql.Date date = (java.sql.Date) table.getValueAt(selectedRow, 4);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ngaySinh = dateFormat.format(date);
                String soDienThoai = (String) table.getValueAt(selectedRow, 5);
                String email = (String) table.getValueAt(selectedRow, 6);
                String diaChi = (String) table.getValueAt(selectedRow, 7);
                CapNhatKhachHangForm capNhatKhachHangForm = new CapNhatKhachHangForm(connection, maKhachHang, ho, ten, gioiTinh, ngaySinh, soDienThoai, email, diaChi);
                capNhatKhachHangForm.setVisible(true);
                capNhatKhachHangForm.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        loadDataIntoTable();
                    }
                });
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    private void loadDataIntoTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String query = "SELECT * FROM KhachHang";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Object[] rowData = {
                    resultSet.getInt("MaKhachHang"),
                    resultSet.getString("Ho"),
                    resultSet.getString("Ten"),
                    resultSet.getString("GioiTinh"),
                    resultSet.getDate("NgaySinh"),
                    resultSet.getString("SoDienThoai"),
                    resultSet.getString("Email"),
                    resultSet.getString("DiaChi"),
                    resultSet.getTimestamp("NgayTao")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu từ cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean xoaKhachHang(int maKhachHang) {
        try {
            String query = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maKhachHang);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void timKiemKhachHang(String option, String keyword) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String query = "";
        switch (option) {
            case "Theo tên":
                query = "SELECT * FROM KhachHang WHERE Ten LIKE ?";
                break;
            case "Theo số điện thoại":
                query = "SELECT * FROM KhachHang WHERE SoDienThoai LIKE ?";
                break;
            case "Theo mã khách hàng":
                query = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
                break;
            default:
                break;
        }

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            if (option.equals("Theo tên") || option.equals("Theo số điện thoại")) {
                statement.setString(1, "%" + keyword + "%");
            } else {
                statement.setInt(1, Integer.parseInt(keyword));
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] rowData = {
                    resultSet.getInt("MaKhachHang"),
                    resultSet.getString("Ho"),
                    resultSet.getString("Ten"),
                    resultSet.getString("GioiTinh"),
                    resultSet.getDate("NgaySinh"),
                    resultSet.getString("SoDienThoai"),
                    resultSet.getString("Email"),
                    resultSet.getString("DiaChi"),
                    resultSet.getTimestamp("NgayTao")
                };
                model.addRow(rowData);
            }
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(QuanLyKhachHang.this, "Lỗi khi tìm kiếm khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
