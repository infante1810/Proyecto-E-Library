/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author nahum
 */
public class Login_final extends javax.swing.JFrame {

    /**
     * Creates new form Login_final
     */
    public Login_final() {
        initComponents();
        addPlaceholderStyle(folioPassword);
        addPlaceholderStyle(folio1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        body = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Text1 = new javax.swing.JLabel();
        Image = new javax.swing.JLabel();
        Text2 = new javax.swing.JLabel();
        folio1 = new javax.swing.JTextField();
        button = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        folioPassword = new javax.swing.JPasswordField();

        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(750, 430));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 430));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("Bienvenid@");
        jPanel1.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        Text1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text1.setText("      CONTRASEÑA");
        jPanel1.add(Text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageUI/prestamo.gif"))); // NOI18N
        jPanel1.add(Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 390, 350));

        Text2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Text2.setText("      USUARIO");
        jPanel1.add(Text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        folio1.setForeground(new java.awt.Color(102, 102, 102));
        folio1.setText("Ingrese usuario");
        folio1.setBorder(null);
        folio1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                folio1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                folio1FocusLost(evt);
            }
        });
        folio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                folio1MousePressed(evt);
            }
        });
        folio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folio1ActionPerformed(evt);
            }
        });
        jPanel1.add(folio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 200, 30));

        button.setBackground(new java.awt.Color(16, 152, 173));
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMousePressed(evt);
            }
        });
        button.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESAR");
        button.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel1.add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 260, 50));

        folioPassword.setForeground(new java.awt.Color(102, 102, 102));
        folioPassword.setText("Password");
        folioPassword.setBorder(null);
        folioPassword.setEchoChar('\u0000');
        folioPassword.setPreferredSize(new java.awt.Dimension(81, 16));
        folioPassword.setSelectionEnd(15);
        folioPassword.setSelectionStart(15);
        folioPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                folioPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                folioPasswordFocusLost(evt);
            }
        });
        jPanel1.add(folioPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void folio1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_folio1MousePressed
        if(folio1.getText().equals("Ingrese usuario"))
        folio1.setText("");
        //if(folio.getText().equals("") || folio.getText() == null || folio.getText().equals(" "))
        //folio.setText("Ingrese contraseña");
    }//GEN-LAST:event_folio1MousePressed

    private void folio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_folio1ActionPerformed

    private void buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseEntered

    }//GEN-LAST:event_buttonMouseEntered

    private void buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMouseExited

    }//GEN-LAST:event_buttonMouseExited

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMousePressed
            if(folioPassword.getText().equals("admin")&& folio1.getText().equals("admin")){
                 
                  this.setVisible(false);
                  new Dashboard().setVisible(true);
                  
            }
    }//GEN-LAST:event_buttonMousePressed

    private void folioPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_folioPasswordFocusGained
        if(folioPassword.getText().equals("Password")){
            folioPassword.setText(null);
            folioPassword.requestFocus();
            folioPassword.setEchoChar('*');
            removePlaceholderStyle(folioPassword);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_folioPasswordFocusGained

    private void folioPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_folioPasswordFocusLost
        if(folioPassword.getText().length()==0){
            addPlaceholderStyle(folioPassword);
            folioPassword.setText("Password");
            folioPassword.setEchoChar('\u0000');            
        }
// TODO add your handling code here:
    }//GEN-LAST:event_folioPasswordFocusLost

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.requestFocusInWindow();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void folio1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_folio1FocusGained
        if(folio1.getText().equals("Ingrese usuario"));
        folio1.setText(null);
        folio1.requestFocus();
        removePlaceholderStyle(folio1);
// TODO add your handling code here:
    }//GEN-LAST:event_folio1FocusGained

    private void folio1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_folio1FocusLost
        if(folio1.getText().length()==0){
            addPlaceholderStyle(folio1);
            folio1.setText("Ingrese usuario");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_folio1FocusLost

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
            java.util.logging.Logger.getLogger(Login_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                Login_final log1 = new Login_final();
                log1.setVisible(true);
            }
        });
    }
    
    private void addPlaceholderStyle(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }
    
    private void removePlaceholderStyle(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JLabel Text1;
    private javax.swing.JLabel Text2;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel body;
    private javax.swing.JPanel button;
    private javax.swing.JTextField folio1;
    private javax.swing.JPasswordField folioPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
   
}
