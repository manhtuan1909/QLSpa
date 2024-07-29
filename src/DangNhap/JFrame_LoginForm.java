package DangNhap;

import DAO.TaiKhoanDangNhapDAO;
import javax.swing.JOptionPane;
import DTO.*;

public class JFrame_LoginForm extends javax.swing.JFrame {

    public TaiKhoanDangNhapDTO nd = new TaiKhoanDangNhapDTO();
    public TaiKhoanDangNhapDAO taiKhoanDAO = new TaiKhoanDangNhapDAO();
    private String username, password;

    public JFrame_LoginForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbDN = new javax.swing.JLabel();
        lbTenDN = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        tf_TenDN = new javax.swing.JTextField();
        btnDN = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        tf_MatKhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));

        lbDN.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbDN.setForeground(new java.awt.Color(255, 102, 102));
        lbDN.setText("ĐĂNG NHẬP");

        lbTenDN.setForeground(new java.awt.Color(255, 102, 102));
        lbTenDN.setText("Tên đăng nhập ");

        lbMatKhau.setForeground(new java.awt.Color(255, 102, 102));
        lbMatKhau.setText("Mật khẩu");

        btnDN.setBackground(new java.awt.Color(255, 102, 102));
        btnDN.setText("Đăng nhập");
        btnDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDNActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 102, 102));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenDN)
                            .addComponent(lbMatKhau))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_TenDN)
                            .addComponent(tf_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnDN)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDN)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDN)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenDN)
                    .addComponent(tf_TenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatKhau)
                    .addComponent(tf_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDN)
                    .addComponent(btnThoat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean areFieldsEmpty(String username, String password) {
        return username.isEmpty() || password.isEmpty();
    }

    public void getData() {
        username = tf_TenDN.getText().trim();
        password = new String(tf_MatKhau.getPassword());
        nd = taiKhoanDAO.getTaiKhoanByCredentials(username, password);

        if (areFieldsEmpty(username, password)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            if (username.isEmpty()) {
                tf_TenDN.requestFocus();
            } else if (password.isEmpty()) {
                tf_MatKhau.requestFocus();
            }
            return;
        }

        if (nd != null) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            Main.JFrame_Main mainForm = new Main.JFrame_Main(nd);
            mainForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Tài khoản và mật khẩu không tồn tại!", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDNActionPerformed
        getData();

    }//GEN-LAST:event_btnDNActionPerformed


    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn kết thúc không", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_LoginForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDN;
    private javax.swing.JButton btnThoat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDN;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbTenDN;
    private javax.swing.JPasswordField tf_MatKhau;
    private javax.swing.JTextField tf_TenDN;
    // End of variables declaration//GEN-END:variables
}
