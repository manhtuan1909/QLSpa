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

public class QuanLyLichHen extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private Connection connection;

    public QuanLyLichHen() {
        setTitle("Quản lý lịch hẹn");
        setSize(899, 666);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        connection = DBConnect.getConnection();
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Mã Lịch Hẹn", "Mã Khách Hàng", "Mã Dịch Vụ", "Mã Nhân Viên", "Ngày Hẹn", "Giờ Đến", "Trạng Thái", "Ghi Chú"}
        );
        table = new JTable(tableModel);

        loadDataIntoTable();

        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 90, 895, 403);
        getContentPane().add(scrollPane);

        JLabel lblTitle = new JLabel("DANH SÁCH LỊCH HẸN");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitle.setBounds(270, 10, 432, 70);
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
                ThemLichHenForm themLichHenForm = new ThemLichHenForm(connection);
                themLichHenForm.setVisible(true);
                themLichHenForm.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        if (themLichHenForm != null) {
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
                    JOptionPane.showMessageDialog(QuanLyLichHen.this, "Vui lòng chọn một lịch hẹn để xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(QuanLyLichHen.this, "Bạn có chắc chắn muốn xóa lịch hẹn này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    int maLichHen = (int) table.getValueAt(selectedRow, 0);
                    if (xoaLichHen(maLichHen)) {
                        JOptionPane.showMessageDialog(QuanLyLichHen.this, "Xóa lịch hẹn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadDataIntoTable();
                    } else {
                        JOptionPane.showMessageDialog(QuanLyLichHen.this, "Xóa lịch hẹn thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Theo mã lịch hẹn", "Theo mã khách hàng", "Theo mã dịch vụ", "Theo mã nhân viên"};
                String selectedOption = (String) JOptionPane.showInputDialog(QuanLyLichHen.this, "Chọn cách tìm kiếm", "Tìm kiếm", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if (selectedOption != null) {
                    String keyword = JOptionPane.showInputDialog(QuanLyLichHen.this, "Nhập từ khóa tìm kiếm", "Tìm kiếm", JOptionPane.QUESTION_MESSAGE);
                    if (keyword != null && !keyword.trim().isEmpty()) {
                        timKiemLichHen(selectedOption, keyword.trim());
                    } else {
                        JOptionPane.showMessageDialog(QuanLyLichHen.this, "Từ khóa không được để trống", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(QuanLyLichHen.this, "Vui lòng chọn một lịch hẹn để cập nhật", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int maLichHen = (int) table.getValueAt(selectedRow, 0);
                int maKhachHang = (int) table.getValueAt(selectedRow, 1);
                int maDichVu = (int) table.getValueAt(selectedRow, 2);
                int maNhanVien = (int) table.getValueAt(selectedRow, 3);
                java.sql.Date date = (java.sql.Date) table.getValueAt(selectedRow, 4);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String ngayHen = dateFormat.format(date);
                String gioDen = (String) table.getValueAt(selectedRow, 5);
                String trangThai = (String) table.getValueAt(selectedRow, 6);
                String ghiChu = (String) table.getValueAt(selectedRow, 7);
                CapNhatLichHenForm capNhatLichHenForm = new CapNhatLichHenForm(connection, maLichHen, maKhachHang, maDichVu, maNhanVien, ngayHen, gioDen, trangThai, ghiChu);
                capNhatLichHenForm.setVisible(true);
                capNhatLichHenForm.addWindowListener(new java.awt.event.WindowAdapter() {
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
                new QuanLyLichHen().setVisible(true);
            }
        });
    }

    private void loadDataIntoTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String query = "SELECT L.MaLichHen, L.MaKhachHang, L.MaDichVu, L.MaNhanVien, L.NgayHen, L.GioDen, L.TrangThai, L.GhiChu " +
                "FROM LichHen L " +
                "INNER JOIN KhachHang K ON L.MaKhachHang = K.MaKhachHang " +
                "INNER JOIN DichVu D ON L.MaDichVu = D.MaDichVu " +
                "INNER JOIN NhanVien NV ON L.MaNhanVien = NV.MaNhanVien";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getInt("MaLichHen"),
                        resultSet.getInt("MaKhachHang"),
                        resultSet.getInt("MaDichVu"),
                        resultSet.getInt("MaNhanVien"),
                        resultSet.getString("NgayHen"),
                        resultSet.getString("GioDen"),
                        resultSet.getString("TrangThai"),
                        resultSet.getString("GhiChu")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lấy dữ liệu từ cơ sở dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean xoaLichHen(int maLichHen) {
        try {
            String query = "DELETE FROM LichHen WHERE MaLichHen = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maLichHen);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void timKiemLichHen(String option, String keyword) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        String query = "";
        switch (option) {
            case "Theo mã lịch hẹn":
                query = "SELECT * FROM LichHen WHERE MaLichHen = " + keyword;
                break;
            case "Theo mã khách hàng":
                query = "SELECT * FROM LichHen WHERE MaKhachHang = " + keyword;
                break;
            case "Theo mã dịch vụ":
                query = "SELECT * FROM LichHen WHERE MaDichVu = " + keyword;
                break;
            case "Theo mã nhân viên":
                query = "SELECT * FROM LichHen WHERE MaNhanVien = " + keyword;
                break;
            default:
                break;
        }

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Object[] rowData = {
                        resultSet.getInt("MaLichHen"),
                        resultSet.getInt("MaKhachHang"),
                        resultSet.getInt("MaDichVu"),
                        resultSet.getInt("MaNhanVien"),
                        resultSet.getString("NgayHen"),
                        resultSet.getString("GioDen"),
                        resultSet.getString("TrangThai"),
                        resultSet.getString("GhiChu")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tìm kiếm lịch hẹn", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
