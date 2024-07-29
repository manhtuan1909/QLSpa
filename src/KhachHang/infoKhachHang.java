package KhachHang;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import DTO.*;
import DAO.*;

public class infoKhachHang extends JFrame {

    public infoKhachHang() {
        setTitle("Thông tin khách hàng");
        setSize(300, 200);
        setLayout(new FlowLayout());

        JButton btnShowInfo = new JButton("Hiển thị thông tin khách hàng");
        add(btnShowInfo);

        btnShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Nhập mã khách hàng:");
                if (input != null && !input.trim().isEmpty()) {
                    try {
                        int maKhachHang = Integer.parseInt(input.trim());
                        KhachHangDAO khachHangDAO = new KhachHangDAO();
                        KhachHangDTO khachHang = khachHangDAO.getKhachHangById(maKhachHang);

                        if (khachHang != null) {
                            JOptionPane.showMessageDialog(null,
                                    "Mã khách hàng: " + khachHang.getMaKhachHang() + "\n"
                                    + "Họ: " + khachHang.getHo() + "\n"
                                    + "Tên: " + khachHang.getTen() + "\n"
                                    + "Giới tính: " + khachHang.getGioiTinh() + "\n"
                                    + "Ngày sinh: " + (khachHang.getNgaySinh() != null ? khachHang.getNgaySinh().toString() : "") + "\n"
                                    + "Số điện thoại: " + khachHang.getSoDienThoai() + "\n"
                                    + "Email: " + khachHang.getEmail() + "\n"
                                    + "Địa chỉ: " + khachHang.getDiaChi() + "\n"
                                    + "Ngày tạo: " + (khachHang.getNgayTao() != null ? khachHang.getNgayTao().toString() : ""),
                                    "Thông tin khách hàng", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng với mã: " + maKhachHang);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ");
                    }
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
