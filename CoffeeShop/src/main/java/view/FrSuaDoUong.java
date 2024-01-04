/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
// import file
import entity.DoUong;
import controller.DoUongController;
import controller.MainController;
// other librabry
import java.awt.Toolkit;
import static java.lang.Double.parseDouble;
import javax.swing.JOptionPane;


/**
 *
 * @author nguyentu
 */
public class FrSuaDoUong extends javax.swing.JFrame {
    // properties
     public FrDoUong frDoUong; 
     public DoUong doUong;
     public DoUongController doUongController;
     public FrSuaDoUong frSuaDoUong;
     // public DoUongController doUongController;
     public MainController mainController;
    /**
     * 
     * Creates new form FrSuaDoUong
     */
     
     // main constructor
    public FrSuaDoUong() {
        setTitle("Sửa thông tin đồ uống");
        initComponents();
    }
     // setter and getter
     public void setDoUong(DoUong doUong){
         this.doUong = doUong;
     }
     
    public void getDoUong(DoUong doUong){
        this.doUong = doUong;
    }
    // setter of main controller
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenDoUong = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        btnXoaThongTinCu = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtNhapDoUong = new javax.swing.JTextField();
        btnTroVe = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        lbLoi = new javax.swing.JLabel();

        jTextField2.setText("jTextField1");

        jTextField5.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SỬA THÔNG TIN ĐỒ UỐNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Nhập tên đồ uống");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Tên đồ uống");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Giá bán");

        btnXoaThongTinCu.setBackground(new java.awt.Color(102, 153, 255));
        btnXoaThongTinCu.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnXoaThongTinCu.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaThongTinCu.setText("Xoá thông tin cũ");
        btnXoaThongTinCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaThongTinCuActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(102, 153, 255));
        btnLuu.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(102, 153, 255));
        btnCancel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXoaThongTinCu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan)
                            .addComponent(txtTenDoUong))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaThongTinCu)
                    .addComponent(btnLuu)
                    .addComponent(btnCancel))
                .addGap(25, 25, 25))
        );

        btnTroVe.setBackground(new java.awt.Color(102, 153, 255));
        btnTroVe.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTroVe.setForeground(new java.awt.Color(255, 255, 255));
        btnTroVe.setText("< Trở về");
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(102, 153, 255));
        btnOk.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lbLoi.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbLoi.setForeground(new java.awt.Color(255, 0, 0));
        lbLoi.setText("*Nhập thông tin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTroVe)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNhapDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnOk))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbLoi)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(btnTroVe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNhapDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOk)
                        .addGap(18, 18, 18)
                        .addComponent(lbLoi))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        FrDoUong frDoUong = new FrDoUong();
        frDoUong.setMainController(mainController);
        frDoUong.runMain();
        setVisible(false);
        dispose(); 
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        txtGiaBan.setText("");
        txtTenDoUong.setText("");
        lbLoi.setText("");
        String name = (new String(txtNhapDoUong.getText()));
        doUongController = new DoUongController();
        if(doUongController.find(name)){
            frSuaDoUong = new FrSuaDoUong();
            frSuaDoUong.setDoUong(doUongController.getDoUong());
            String tenDoUong = frSuaDoUong.doUong.getTenDoUong();
            Double price = frSuaDoUong.doUong.getPrice();
            txtTenDoUong.setText(tenDoUong);
            txtGiaBan.setText(String.valueOf(price));
        }
        else{
            lbLoi.setText("*Không tìm thấy ID");
        }
        
        // doUongController = new doUongController(frSuaDoUong);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        FrDoUong frDoUong = new FrDoUong();
        frDoUong.setMainController(mainController);
        frDoUong.runMain();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        doUongController = new DoUongController();
        String inputName = txtNhapDoUong.getText();
        String name = txtTenDoUong.getText();
        String temp = txtGiaBan.getText();
        if(!check_empty()){
            Double gia = parseDouble(temp);
            doUong = new DoUong(name,gia);
            doUongController.update(doUong, inputName);
            txtGiaBan.setText("");
            txtNhapDoUong.setText("");
            txtTenDoUong.setText("");
            lbLoi.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this, "Không được để trống", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaThongTinCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaThongTinCuActionPerformed
        txtGiaBan.setText("");
        txtNhapDoUong.setText("");
        txtTenDoUong.setText("");
    }//GEN-LAST:event_btnXoaThongTinCuActionPerformed
    public boolean check_empty(){
        Boolean check = false;
        String name = txtTenDoUong.getText();
        String temp = txtGiaBan.getText();
        if(name.isEmpty() || temp.isEmpty()){
            return true;
        }
        return check;
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrSuaDoUong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrSuaDoUong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrSuaDoUong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrSuaDoUong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrSuaDoUong().setVisible(true);
            }
        });
    }
        public void runMain(){       
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (screenWidth - getWidth()) / 2;
        int y = (screenHeight -getHeight()) / 2;
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
        setVisible(true);
        setLocation(x, y);
        setResizable(false);
        }
});
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoaThongTinCu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbLoi;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtNhapDoUong;
    private javax.swing.JTextField txtTenDoUong;
    // End of variables declaration//GEN-END:variables
}
