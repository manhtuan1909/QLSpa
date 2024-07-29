package Main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import DTO.*;
import javax.swing.JPanel;

public class JFrame_Main extends javax.swing.JFrame {

    public TaiKhoanDangNhapDTO tkdn;
    private SanPham.SanPhamFrame sp;
    private QuanLyHoaDon_ThanhToan.JFrame_QuanLyHoaDon hd;
    private LichHen.QuanLyLichHen lh;
    private LichHen.QuanLyKhachHang kh;
    private DichVu.DichVuFrame dv;

    public JFrame_Main(TaiKhoanDangNhapDTO tkdn) {
        this.tkdn = tkdn;
        initRole();
        initComponents();

        kiemTraVaiTro();
        initIcon();
        addAllTabs();
    }

    public JFrame_Main() {
        initComponents();
        initIcon();
        addAllTabs();
    }

    private void kiemTraVaiTro() {
        String mnd = tkdn.getMaNguoiDung();
        if (mnd.equals("1") || mnd.equals("2")) {
        }
    }

    public void initRole() {
        sp = new SanPham.SanPhamFrame(tkdn);
        hd = new QuanLyHoaDon_ThanhToan.JFrame_QuanLyHoaDon();
        lh = new LichHen.QuanLyLichHen();
        kh = new LichHen.QuanLyKhachHang();
        dv = new DichVu.DichVuFrame(tkdn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        ExitMenu = new javax.swing.JMenu();
        ExitItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sugong_Spa");

        jMenuBar1.setPreferredSize(new java.awt.Dimension(70, 80));

        ExitMenu.setText("Đăng Xuất");
        ExitMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExitMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ExitItem.setText("Thoát");
        ExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitItemActionPerformed(evt);
            }
        });
        ExitMenu.add(ExitItem);

        jMenuBar1.add(ExitMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1534, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitItemActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            this.dispose();
            DangNhap.JFrame_LoginForm login = new DangNhap.JFrame_LoginForm();
            login.setVisible(true);
        }
    }//GEN-LAST:event_ExitItemActionPerformed

    private void addAllTabs() {
        JPanel qlspPanel = (JPanel) sp.getContentPane();
        JPanel qldvPanel = (JPanel) dv.getContentPane();
        JPanel hdPanel = (JPanel) hd.getContentPane();
        JPanel lhPanel = (JPanel) lh.getContentPane();
        JPanel khPanel = (JPanel) kh.getContentPane();
        jTabbedPane1.addTab("Quản lí sản phẩm", qlspPanel);
        jTabbedPane1.addTab("Quản lí dịch vụ", qldvPanel);
        jTabbedPane1.addTab("Quản lí hóa đơn", hdPanel);
        jTabbedPane1.addTab("Quản lí khách hàng", khPanel);
        jTabbedPane1.addTab("Quản lí lịch hẹn", lhPanel);
        jTabbedPane1.setSelectedIndex(0);
    }

    public void initIcon() {
        scaleImageMenu(ExitMenu, "src/img_icon/Exit.png", 45, 45, JMenu.LEFT, JMenu.CENTER, JMenu.BOTTOM);
    }

    public void scaleImageMenu(JMenu menu, String fileImage, int width, int height, int horizontalAlignment, int horizontalTextPosition, int verticalAlignment) {
        ImageIcon icon = new ImageIcon(fileImage);
        Image img = icon.getImage();
        Image imgScaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon iconScaled = new ImageIcon(imgScaled);
        menu.setIcon(iconScaled);
        menu.setHorizontalAlignment(horizontalAlignment);
        menu.setHorizontalTextPosition(horizontalTextPosition);
        menu.setVerticalTextPosition(verticalAlignment);
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
            java.util.logging.Logger.getLogger(JFrame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
