package SanPham;

import DAO.*;
import DTO.*;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SanPhamFrame extends javax.swing.JFrame {

    public TaiKhoanDangNhapDTO tkdn;
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultTableModel dfm;
    private ImageIcon icon, iconScaled;
    private Image img, imgScaled;
    private List<SanPhamDTO> sanPhamList;
    private int currentIndex = 0;

    public SanPhamFrame() {
        initComponents();
        initTable();
    }

    public SanPhamFrame(TaiKhoanDangNhapDTO tkdn) {
        this.tkdn = tkdn;
        initComponents();
        kiemTraVaiTro();

        initTable();
    }

    private void kiemTraVaiTro() {
        String mnd = tkdn.getMaNguoiDung();
        if (mnd.equals("3")) {
            refreshBtn.setVisible(false);
            addBtn.setVisible(false);
            updateBtn.setVisible(false);
            deleteBtn.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_Hinh = new javax.swing.JLabel();
        Ten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MoTa = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        SoLuongTon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Gia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tbModel = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_Hinh.setBackground(new java.awt.Color(204, 255, 255));
        lb_Hinh.setMaximumSize(new java.awt.Dimension(220, 270));
        lb_Hinh.setMinimumSize(new java.awt.Dimension(220, 270));
        lb_Hinh.setPreferredSize(new java.awt.Dimension(220, 270));

        Ten.setBackground(new java.awt.Color(204, 204, 255));
        Ten.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Ten.setForeground(new java.awt.Color(0, 0, 0));
        Ten.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Ten.setToolTipText("");

        MoTa.setBackground(new java.awt.Color(204, 204, 255));
        MoTa.setColumns(20);
        MoTa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        MoTa.setForeground(new java.awt.Color(0, 0, 0));
        MoTa.setLineWrap(true);
        MoTa.setRows(10);
        MoTa.setTabSize(5);
        jScrollPane1.setViewportView(MoTa);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Số lượng tồn:");

        SoLuongTon.setBackground(new java.awt.Color(204, 204, 255));
        SoLuongTon.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        SoLuongTon.setForeground(new java.awt.Color(0, 0, 0));
        SoLuongTon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Giá:");

        Gia.setBackground(new java.awt.Color(204, 204, 255));
        Gia.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        Gia.setForeground(new java.awt.Color(0, 0, 0));
        Gia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Thành phần:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Tên sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_Hinh, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lb_Hinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        tbSanPham.setBackground(new java.awt.Color(204, 204, 204));
        tbSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbSanPham.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbSanPham.setRowHeight(28);
        tbSanPham.setShowGrid(true);
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        tbModel.setViewportView(tbSanPham);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Danh sách sản phẩm");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        refreshBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        refreshBtn.setText("Làm mới");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addBtn.setText("Thêm mới");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        deleteBtn.setText("Xóa");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        updateBtn.setText("Cập nhật");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tbModel)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 213, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(tbModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayRecord(int index) {
        SanPhamDTO sanPham = sanPhamList.get(index);
        Ten.setText(sanPham.getTenSanPham());
        MoTa.setText(sanPham.getMoTa());
        SoLuongTon.setText(String.valueOf(sanPham.getSoLuongTon()));
        Gia.setText(formatGia(sanPham.getGiaBan(), decimalFormat));
    }

    public void clearText() {
        Ten.setText("");
        SoLuongTon.setText("");
        MoTa.setText("");
        Gia.setText("");
    }

    public void clearTable(JTable tb) {
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        getData();
    }

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        if (currentIndex > 0) {
            currentIndex--;
            tbSanPham.setRowSelectionInterval(currentIndex, currentIndex);
            displayRecord(currentIndex);
        }
    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        if (currentIndex < sanPhamList.size() - 1) {
            currentIndex++;
            tbSanPham.setRowSelectionInterval(currentIndex, currentIndex);
            displayRecord(currentIndex);
        }
    }//GEN-LAST:event_NextActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int selectedRow = tbSanPham.getSelectedRow();
        if (selectedRow != -1) {
            int index = selectedRow;
            currentIndex = index;
            displayRecord(currentIndex);
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private boolean validateData() {
        String tenSanPham = Ten.getText();
        String moTa = MoTa.getText();
        String thoiLuongText = SoLuongTon.getText().replaceAll("[^\\d]", "");
        String giaText = Gia.getText().replaceAll("[^\\d.]", "");

        if (tenSanPham.isEmpty() || moTa.isEmpty() || thoiLuongText.isEmpty() || giaText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return false;
        }

        try {
            int thoiLuong = Integer.parseInt(thoiLuongText);
            if (thoiLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng tồn phải là một số nguyên dương.");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là một số nguyên dương.");
            return false;
        }

        try {
            double gia = Double.parseDouble(giaText);
            if (gia <= 0) {
                JOptionPane.showMessageDialog(this, "Giá phải là một số dương.");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giá phải là một số dương.");
            return false;
        }

        return true;
    }

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        clearText();
        clearTable(tbSanPham);
        getData();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if (validateData()) {
            String tenSanPham = Ten.getText();
            String moTa = MoTa.getText();

            String thoiLuongText = SoLuongTon.getText().replaceAll("[^\\d]", "");
            int thoiLuong = Integer.parseInt(thoiLuongText);

            String giaText = Gia.getText().replaceAll("[^\\d]", "");
            double gia = Double.parseDouble(giaText);

            SanPhamDTO sanPham = new SanPhamDTO(tenSanPham, moTa, thoiLuong, gia);
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            boolean success = sanPhamDAO.addSanPham(sanPham);

            if (success) {
                clearText();
                sanPhamList.add(sanPham);
                dfm.addRow(new Object[]{
                    sanPham.getTenSanPham(),
                    sanPham.getMoTa(),
                    sanPham.getSoLuongTon(),
                    formatGia(sanPham.getGiaBan(), decimalFormat)
                }
                );
                JOptionPane.showMessageDialog(this, "Thêm mới sản phẩm thành công !");
                clearTable(tbSanPham);
                getData();

            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm mới sản phẩm !");
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedRow = tbSanPham.getSelectedRow();
        if (selectedRow != -1) {
            if (validateData()) {
                int masp = (int) tbSanPham.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    SanPhamDAO sanPhamDAO = new SanPhamDAO();
                    boolean success = sanPhamDAO.deleteSanPham(masp);
                    if (success) {
                        JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công !");
                        clearText();
                        sanPhamList.remove(selectedRow);
                        dfm.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm !");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa !");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int selectedRow = tbSanPham.getSelectedRow();
        if (selectedRow != -1 && validateData()) {
            int maSanPham = (int) tbSanPham.getValueAt(selectedRow, 0);
            String tenSanPham = Ten.getText();
            String moTa = MoTa.getText();
            String soLuongTonText = SoLuongTon.getText().replaceAll("[^\\d]", "");
            int soLuongTon = Integer.parseInt(soLuongTonText);

            String giaText = Gia.getText().replaceAll("[^\\d]", "");
            double gia = Double.parseDouble(giaText);

            SanPhamDTO sanPham = new SanPhamDTO(maSanPham, tenSanPham, moTa, soLuongTon, gia);
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            boolean success = sanPhamDAO.updateSanPham(sanPham);
            if (success) {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công !");
                clearText();
                sanPhamList.set(selectedRow, sanPham);
                dfm.setValueAt(sanPham.getTenSanPham(), selectedRow, 1);
                dfm.setValueAt(sanPham.getMoTa(), selectedRow, 2);
                dfm.setValueAt(sanPham.getSoLuongTon(), selectedRow, 3);
                dfm.setValueAt(formatGia(sanPham.getGiaBan(), decimalFormat), selectedRow, 4);
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật sản phẩm !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để cập nhật !");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    //=========================================================================================
    private String formatGia(double gia, DecimalFormat decimalFormat) {
        return decimalFormat.format(gia) + " đ";
    }

    private void initTable() {
        dfm = new DefaultTableModel();
        dfm.setColumnIdentifiers(new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Mô Tả", "Số Lượng Tồn", "Giá Bán", "Ngày Tạo"});
        tbSanPham.setModel(dfm);
        getData();

        for (int i = 0; i < tbSanPham.getColumnCount(); i++) {
            TableColumn column = tbSanPham.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }

        scaleImage(updateBtn, "src/img_icon/updated.png", 35, 35);
        scaleImage(refreshBtn, "src/img_icon/filter.png", 35, 35);
        scaleImage(deleteBtn, "src/img_icon/trash.png", 35, 35);
        scaleImage(addBtn, "src/img_icon/add.png", 35, 35);
        scaleImage(Next, "src/img_icon/next-button.png", 35, 35);
        scaleImage(Back, "src/img_icon/back-button.png", 35, 35);
    }

    private void getData() {
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamList = sanPhamDAO.getAllSanPham();
        for (SanPhamDTO d : sanPhamList) {
            dfm.addRow(new Object[]{
                d.getMaSanPham(),
                d.getTenSanPham(),
                d.getMoTa(),
                d.getSoLuongTon(),
                formatGia(d.getGiaBan(), decimalFormat),
                dateFormat.format(d.getNgayTao())
            });
        }
    }

    public void scaleImage(JButton button, String fileImage, int width, int height) {
        ImageIcon icon = new ImageIcon(fileImage);
        Image img = icon.getImage();
        Image imgScaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon iconScaled = new ImageIcon(imgScaled);
        button.setIcon(iconScaled);
    }

    public void scaleImage(JLabel label, String fileImage, int width, int height) {
        icon = new ImageIcon(fileImage);
        img = icon.getImage();
        imgScaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        iconScaled = new ImageIcon(imgScaled);
        label.setIcon(iconScaled);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Gia;
    private javax.swing.JTextArea MoTa;
    private javax.swing.JButton Next;
    private javax.swing.JTextField SoLuongTon;
    private javax.swing.JTextField Ten;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Hinh;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JScrollPane tbModel;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
