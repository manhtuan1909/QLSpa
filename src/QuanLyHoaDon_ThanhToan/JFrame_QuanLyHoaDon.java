package QuanLyHoaDon_ThanhToan;

import DTO.*;
import DAO.*;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class JFrame_QuanLyHoaDon extends javax.swing.JFrame {

    private DefaultTableModel modelChiTiet;
    private DefaultTableModel dfm;
    private Connect_Db Db = new Connect_Db();
    private Connection connect;

    private HoaDonDAO hd = new HoaDonDAO();
    private ChiTietSanPhamDAO ctsp = new ChiTietSanPhamDAO();
    private ChiTietDichVuDAO ctdv = new ChiTietDichVuDAO();

    public JFrame_QuanLyHoaDon() {
        connect = Db.connectDB();
        initComponents();
        initComboBox();
        initTable();
        init_ChiTietDon();
    }

    private void initTable() {
        dfm = new DefaultTableModel();
        dfm.setColumnIdentifiers(new String[]{"Mã hóa đơn", "Mã khách hàng", "Ngày lập", "Thành tiền", "Trạng thái", "Ghi chú"});
        tb_HoaDon.setModel(dfm);
        getData();

        TableColumn columnMaHoaDon = tb_HoaDon.getColumnModel().getColumn(0);
        columnMaHoaDon.setPreferredWidth(70);

        TableColumn columnMaKhachHang = tb_HoaDon.getColumnModel().getColumn(1);
        columnMaKhachHang.setPreferredWidth(70);

        TableColumn columnNgayLap = tb_HoaDon.getColumnModel().getColumn(2);
        columnNgayLap.setPreferredWidth(70);

        TableColumn columnThanhTien = tb_HoaDon.getColumnModel().getColumn(3);
        columnThanhTien.setPreferredWidth(80);

        TableColumn columnTrangThai = tb_HoaDon.getColumnModel().getColumn(4);
        columnTrangThai.setPreferredWidth(120);

        TableColumn columnGhiChu = tb_HoaDon.getColumnModel().getColumn(5);
        columnGhiChu.setPreferredWidth(100);
    }

    private void refresh() {

        tf_DonGia.setText("");
        tf_SoLuong.setText("");
        tf_MaChiTietDon.setText("");
        tf_MHD.setText("");
        tf_MKH.setText("");
        tf_NPT.setText("");
        tf_TT.setText("");
        cbTrangThaiDon.setSelectedItem(null);
        cbLoai.setSelectedItem(null);
        tf_GhiChu.setText("");

        DefaultTableModel model1 = (DefaultTableModel) tb_HoaDon.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tableChiTietDon.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
        getData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tbModel = new javax.swing.JScrollPane();
        tb_HoaDon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_MHD = new javax.swing.JTextField();
        tf_TT = new javax.swing.JTextField();
        btn_Update = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        tf_NPT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tf_MKH = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        tf_DonGia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_MaChiTietDon = new javax.swing.JTextField();
        tf_SoLuong = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        XoaMon = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        show_infoKhach = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbLoai = new javax.swing.JComboBox<>();
        cbTrangThaiDon = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_GhiChu = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiTietDon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1263, 755));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(1263, 755));
        jPanel2.setMinimumSize(new java.awt.Dimension(1263, 755));
        jPanel2.setPreferredSize(new java.awt.Dimension(1263, 755));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tbModel.setBackground(new java.awt.Color(204, 204, 204));

        tb_HoaDon.setBackground(new java.awt.Color(255, 255, 255));
        tb_HoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tb_HoaDon.setForeground(new java.awt.Color(0, 0, 0));
        tb_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tb_HoaDon.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tb_HoaDon.setRowHeight(28);
        tb_HoaDon.setShowGrid(true);
        tb_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_HoaDonMouseClicked(evt);
            }
        });
        tbModel.setViewportView(tb_HoaDon);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Mã hóa đơn");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ngày lập");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Thành tiền");

        tf_MHD.setBackground(new java.awt.Color(255, 255, 255));
        tf_MHD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_MHD.setEnabled(false);

        tf_TT.setBackground(new java.awt.Color(255, 255, 255));
        tf_TT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_TT.setEnabled(false);

        btn_Update.setBackground(new java.awt.Color(255, 51, 102));
        btn_Update.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Update.setForeground(new java.awt.Color(255, 255, 255));
        btn_Update.setText("Cập nhật");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_Delete.setBackground(new java.awt.Color(204, 51, 255));
        btn_Delete.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Delete.setText("Xóa hóa đơn");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        tf_NPT.setBackground(new java.awt.Color(255, 255, 255));
        tf_NPT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tf_NPT.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Ghi chú");

        tf_MKH.setBackground(new java.awt.Color(255, 255, 255));
        tf_MKH.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_MKH.setEnabled(false);

        jSeparator1.setForeground(new java.awt.Color(255, 153, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Đơn giá");

        tf_DonGia.setBackground(new java.awt.Color(255, 255, 255));
        tf_DonGia.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Mã dịch vụ/ sản phẩm");

        tf_MaChiTietDon.setBackground(new java.awt.Color(255, 255, 255));
        tf_MaChiTietDon.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tf_MaChiTietDon.setEnabled(false);

        tf_SoLuong.setBackground(new java.awt.Color(255, 255, 255));
        tf_SoLuong.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Số lượng");

        XoaMon.setBackground(new java.awt.Color(153, 153, 0));
        XoaMon.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        XoaMon.setText("Xóa dịch vụ/ sản phẩm");
        XoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaMonActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(255, 153, 255));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Mã khách hàng");

        show_infoKhach.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        show_infoKhach.setText("Hiển thị thông tin khách hàng");
        show_infoKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_infoKhachActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Loại");

        cbLoai.setEditable(true);
        cbLoai.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cbLoai.setForeground(new java.awt.Color(0, 0, 0));
        cbLoai.setEnabled(false);

        cbTrangThaiDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbTrangThaiDon.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Trạng thái đơn");

        tf_GhiChu.setColumns(20);
        tf_GhiChu.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        tf_GhiChu.setForeground(new java.awt.Color(0, 0, 0));
        tf_GhiChu.setLineWrap(true);
        tf_GhiChu.setRows(5);
        jScrollPane2.setViewportView(tf_GhiChu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_TT)
                            .addComponent(cbTrangThaiDon, 0, 236, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_MHD, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_NPT, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_MaChiTietDon, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(XoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_MKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(show_infoKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_MaChiTietDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tf_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_Delete)
                                    .addComponent(XoaMon))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_MKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(show_infoKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_MHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_NPT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_TT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTrangThaiDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Danh sách hóa đơn");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tableChiTietDon.setAutoCreateRowSorter(true);
        tableChiTietDon.setBackground(new java.awt.Color(255, 255, 255));
        tableChiTietDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tableChiTietDon.setForeground(new java.awt.Color(0, 0, 0));
        tableChiTietDon.setAlignmentX(0.0F);
        tableChiTietDon.setAlignmentY(0.0F);
        tableChiTietDon.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableChiTietDon.setAutoscrolls(false);
        tableChiTietDon.setRowHeight(25);
        tableChiTietDon.setRowSelectionAllowed(false);
        tableChiTietDon.setShowGrid(true);
        tableChiTietDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChiTietDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableChiTietDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(665, 665, 665))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tbModel, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(tbModel, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1534, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        String deleteChiTietDichVuQuery = "DELETE FROM ChiTietDichVu WHERE MaHoaDon = ?";
        String deleteChiTietSanPhamQuery = "DELETE FROM ChiTietSanPham WHERE MaHoaDon = ?";
        String deleteHoaDonQuery = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
        int maHoaDon = Integer.parseInt(tf_MHD.getText().toString());
        int option = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc chắn muốn xóa !" + "\n"
                + "Việc này sẽ xóa các thông tin liên quan tới hóa đơn: " + maHoaDon + "\n",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement psDeleteChiTietDichVu = connect.prepareStatement(deleteChiTietDichVuQuery);
                psDeleteChiTietDichVu.setInt(1, maHoaDon);
                psDeleteChiTietDichVu.executeUpdate();
                psDeleteChiTietDichVu.close();

                PreparedStatement psDeleteChiTietSanPham = connect.prepareStatement(deleteChiTietSanPhamQuery);
                psDeleteChiTietSanPham.setInt(1, maHoaDon);
                psDeleteChiTietSanPham.executeUpdate();
                psDeleteChiTietSanPham.close();

                PreparedStatement psDeleteHoaDon = connect.prepareStatement(deleteHoaDonQuery);
                psDeleteHoaDon.setInt(1, maHoaDon);
                int rowsAffected = psDeleteHoaDon.executeUpdate();
                psDeleteHoaDon.close();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Hóa đơn và các chi tiết liên quan đã được xóa thành công!");
                    refresh();
                } else {
                    connect.rollback();
                    JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn để xóa!");
                }

            } catch (SQLException ex) {
                try {
                    connect.rollback();
                } catch (SQLException rollbackEx) {
                    Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, rollbackEx);
                }
                Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed

        int maHoaDon = Integer.parseInt(tf_MHD.getText());
        int maKhachHang = Integer.parseInt(tf_MKH.getText());
        java.util.Date ngayLap = java.sql.Date.valueOf(tf_NPT.getText());
        double tongTien = Double.parseDouble(tf_TT.getText());
        String trangThai = cbTrangThaiDon.getSelectedItem().toString();
        String ghiChu = tf_GhiChu.getText();

        HoaDonDTO hoaDon = new HoaDonDTO(maHoaDon, maKhachHang, ngayLap, tongTien, trangThai, ghiChu);
        hd.updateHoaDon(hoaDon);

        int selectedRow = tableChiTietDon.getSelectedRow();
        if (selectedRow != -1) {
            int maChiTiet = Integer.parseInt(tf_MaChiTietDon.getText().toString());
            int soLuong = Integer.parseInt(tf_SoLuong.getText().toString());
            double donGia = Double.parseDouble(tf_DonGia.getText().toString());
            String loai = tableChiTietDon.getValueAt(selectedRow, 5).toString();
            if (loai.equals("Dịch vụ")) {
                ChiTietDichVuDTO chiTietDichVu = new ChiTietDichVuDTO(maHoaDon, maChiTiet, soLuong, donGia);
                ctdv.updateChiTietDichVu(maHoaDon, chiTietDichVu);
            } else if (loai.equals("Sản phẩm")) {
                ChiTietSanPhamDTO chiTietSanPham = new ChiTietSanPhamDTO(maHoaDon, maChiTiet, soLuong, donGia);
                ctsp.updateChiTietSanPham(maHoaDon, chiTietSanPham);
            }
            JOptionPane.showMessageDialog(null, "Cập nhật hoá đơn và chi tiết đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            refresh();
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một chi tiết đơn để cập nhật.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        refresh();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void tb_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_HoaDonMouseClicked
        int selectedRow = tb_HoaDon.getSelectedRow();

        if (selectedRow >= 0 && selectedRow < tb_HoaDon.getRowCount()) {
            tf_MHD.setText(tb_HoaDon.getValueAt(selectedRow, 0).toString());
            tf_MKH.setText(tb_HoaDon.getValueAt(selectedRow, 1).toString());
            tf_NPT.setText(tb_HoaDon.getValueAt(selectedRow, 2).toString());
            tf_TT.setText(tb_HoaDon.getValueAt(selectedRow, 3).toString());

            String trangThai = tb_HoaDon.getValueAt(selectedRow, 4).toString();
            for (int i = 0; i < cbTrangThaiDon.getItemCount(); i++) {
                if (cbTrangThaiDon.getItemAt(i).toString().equals(trangThai)) {
                    cbTrangThaiDon.setSelectedIndex(i);
                    break;
                }
            }

            tf_GhiChu.setText(tb_HoaDon.getValueAt(selectedRow, 5).toString());

            int maHoaDon = Integer.parseInt(tb_HoaDon.getValueAt(selectedRow, 0).toString());
            selectedHoaDon(maHoaDon);
        } else {
            System.out.println("Lỗi");
        }
    }//GEN-LAST:event_tb_HoaDonMouseClicked

    private void tableChiTietDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChiTietDonMouseClicked
        int selectedRow = tableChiTietDon.getSelectedRow();

        if (selectedRow >= 0 && selectedRow < tableChiTietDon.getRowCount()) {
            tf_MaChiTietDon.setText(tableChiTietDon.getValueAt(selectedRow, 0).toString());
            tf_SoLuong.setText(tableChiTietDon.getValueAt(selectedRow, 2).toString());
            tf_DonGia.setText(tableChiTietDon.getValueAt(selectedRow, 3).toString());
            String trangThai = tableChiTietDon.getValueAt(selectedRow, 5).toString();
            for (int i = 0; i < cbLoai.getItemCount(); i++) {
                if (cbLoai.getItemAt(i).toString().equals(trangThai)) {
                    cbLoai.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            System.out.println("Lỗi");
        }
    }//GEN-LAST:event_tableChiTietDonMouseClicked

    private void show_infoKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_infoKhachActionPerformed
        String input = tf_MKH.getText();
        if (input != null && !input.trim().isEmpty()) {
            try {
                int maKhachHang = Integer.parseInt(input.trim());
                KhachHangDAO khachHangDAO = new KhachHangDAO();
                KhachHangDTO khachHang = khachHangDAO.getKhachHangById(maKhachHang);

                if (khachHang != null) {
                    JOptionPane.showMessageDialog(this,
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
                    JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng với mã: " + maKhachHang);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng lấy thông tin mã khách hàng trước !");
        }
    }//GEN-LAST:event_show_infoKhachActionPerformed

    private void XoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaMonActionPerformed
        int maHoaDon = Integer.parseInt(tf_MHD.getText());

        int selectedRow = tableChiTietDon.getSelectedRow();
        if (selectedRow != -1) {
            int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Xác nhận", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                int maChiTiet = Integer.parseInt(tableChiTietDon.getValueAt(selectedRow, 0).toString());
                String loai = tableChiTietDon.getValueAt(selectedRow, 5).toString();

                if (loai.equals("Dịch vụ")) {
                    ctdv.deleteChiTietDichVu(maHoaDon, maChiTiet);
                } else if (loai.equals("Sản phẩm")) {
                    ctsp.deleteChiTietSanPham(maHoaDon, maChiTiet);
                } else {
                    JOptionPane.showMessageDialog(null, "Không có lựa chọn hợp lệ để xóa!");
                }
                refresh();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một chi tiết đơn để xóa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_XoaMonActionPerformed

//=====================================================================================================
    private void getData() {
        List<HoaDonDTO> hoaDonList = hd.getAllHoaDon();
        for (HoaDonDTO hoaDon : hoaDonList) {
            dfm.addRow(new Object[]{
                hoaDon.getMaHoaDon(),
                hoaDon.getMaKhachHang(),
                hoaDon.getNgayLap(),
                hoaDon.getTongTien(),
                hoaDon.getTrangThai(),
                hoaDon.getGhiChu()
            });
        }
    }

    private void populateChiTietHoaDon(int maHoaDon) {
        modelChiTiet.setRowCount(0);

        try {
            String queryDichVu = "SELECT ChiTietDichVu.MaDichVu, DichVu.TenDichVu, ChiTietDichVu.SoLuong, ChiTietDichVu.DonGia, ChiTietDichVu.ThanhTien "
                    + "FROM ChiTietDichVu "
                    + "INNER JOIN DichVu ON ChiTietDichVu.MaDichVu = DichVu.MaDichVu "
                    + "WHERE ChiTietDichVu.MaHoaDon = ?";
            PreparedStatement preparedStatementDichVu = connect.prepareStatement(queryDichVu);
            preparedStatementDichVu.setInt(1, maHoaDon);
            ResultSet resultSetDichVu = preparedStatementDichVu.executeQuery();

            while (resultSetDichVu.next()) {
                int maDichVu = resultSetDichVu.getInt("MaDichVu");
                String tenDichVu = resultSetDichVu.getString("TenDichVu");
                int soLuong = resultSetDichVu.getInt("SoLuong");
                double donGia = resultSetDichVu.getDouble("DonGia");
                double thanhTien = resultSetDichVu.getDouble("ThanhTien");
                String loai = "Dịch vụ";
                modelChiTiet.addRow(new Object[]{maDichVu, tenDichVu, soLuong, donGia, thanhTien, loai});
            }

            resultSetDichVu.close();
            preparedStatementDichVu.close();

            String querySanPham = "SELECT ChiTietSanPham.MaSanPham, SanPham.NTenSanPham, ChiTietSanPham.SoLuong, ChiTietSanPham.DonGia, ChiTietSanPham.ThanhTien "
                    + "FROM ChiTietSanPham "
                    + "INNER JOIN SanPham ON ChiTietSanPham.MaSanPham = SanPham.MaSanPham "
                    + "WHERE ChiTietSanPham.MaHoaDon = ?";
            PreparedStatement preparedStatementSanPham = connect.prepareStatement(querySanPham);
            preparedStatementSanPham.setInt(1, maHoaDon);
            ResultSet resultSetSanPham = preparedStatementSanPham.executeQuery();

            while (resultSetSanPham.next()) {
                int maSanPham = resultSetSanPham.getInt("MaSanPham");
                String tenSanPham = resultSetSanPham.getString("NTenSanPham");
                int soLuong = resultSetSanPham.getInt("SoLuong");
                double donGia = resultSetSanPham.getDouble("DonGia");
                double thanhTien = resultSetSanPham.getDouble("ThanhTien");
                String loai = "Sản phẩm";
                modelChiTiet.addRow(new Object[]{maSanPham, tenSanPham, soLuong, donGia, thanhTien, loai});
            }

            resultSetSanPham.close();
            preparedStatementSanPham.close();

        } catch (SQLException ex) {
            Logger.getLogger(JFrame_QuanLyHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init_ChiTietDon() {
        modelChiTiet = (DefaultTableModel) tableChiTietDon.getModel();
        String[] colName = new String[]{"Mã dịch vụ/ Sản phẩm", "Tên dịch vụ/ Sản phẩm", "Số lượng", "Đơn giá", "Thành tiền", "Loại"};
        modelChiTiet.setColumnIdentifiers(colName);

        Font font = new Font("Arial", Font.PLAIN, 13);
        tableChiTietDon.setFont(font);

        TableColumn columnMaDichVuSanPham = tableChiTietDon.getColumnModel().getColumn(0);
        columnMaDichVuSanPham.setPreferredWidth(157);

        TableColumn columnTenDichVuSanPham = tableChiTietDon.getColumnModel().getColumn(1);
        columnTenDichVuSanPham.setPreferredWidth(170);

        TableColumn columnSoLuong = tableChiTietDon.getColumnModel().getColumn(2);
        columnSoLuong.setPreferredWidth(70);

        TableColumn columnDonGia = tableChiTietDon.getColumnModel().getColumn(3);
        columnDonGia.setPreferredWidth(95);

        TableColumn columnThanhTien = tableChiTietDon.getColumnModel().getColumn(4);
        columnThanhTien.setPreferredWidth(95);

        TableColumn columnLoai = tableChiTietDon.getColumnModel().getColumn(5);
        columnLoai.setPreferredWidth(80);
    }

    private void selectedHoaDon(int maHoaDon) {
        populateChiTietHoaDon(maHoaDon);
    }

    public void initComboBox() {
        cbLoai.addItem("Sản phẩm");
        cbLoai.addItem("Dịch vụ");

        cbTrangThaiDon.addItem("Đã thanh toán");
        cbTrangThaiDon.addItem("Chưa thanh toán");

        cbLoai.setSelectedItem(null);
        cbTrangThaiDon.setSelectedItem(null);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame_QuanLyHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_QuanLyHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_QuanLyHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_QuanLyHoaDon.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_QuanLyHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton XoaMon;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_Update;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbTrangThaiDon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton show_infoKhach;
    private javax.swing.JTable tableChiTietDon;
    private javax.swing.JScrollPane tbModel;
    private javax.swing.JTable tb_HoaDon;
    private javax.swing.JTextField tf_DonGia;
    private javax.swing.JTextArea tf_GhiChu;
    private javax.swing.JTextField tf_MHD;
    private javax.swing.JTextField tf_MKH;
    private javax.swing.JTextField tf_MaChiTietDon;
    private javax.swing.JTextField tf_NPT;
    private javax.swing.JTextField tf_SoLuong;
    private javax.swing.JTextField tf_TT;
    // End of variables declaration//GEN-END:variables

}
