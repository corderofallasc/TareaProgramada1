/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import cliente.Cliente;
import java.util.Arrays;
import javax.swing.JOptionPane;
import sql.Conexion;

/**
 *
 * @author Caro
 */
public class Registrar extends javax.swing.JFrame {
    Cliente cliente;
    Conexion conexion;
    String user;
    String password;
    
    public Registrar() {
        initComponents();
        setLocationRelativeTo(null);
        conexion=new Conexion();
        user="";
        password="";
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jlContrasena = new javax.swing.JPanel();
        jUser = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jbRegistrar = new javax.swing.JButton();
        jlUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlContrasena.setBackground(new java.awt.Color(153, 255, 153));
        jlContrasena.setForeground(new java.awt.Color(255, 255, 255));
        jlContrasena.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserActionPerformed(evt);
            }
        });

        jbRegistrar.setText("Registrar");
        jbRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarActionPerformed(evt);
            }
        });

        jlUsuario.setText("Usuario: ");

        jLabel2.setText("Contrase??a: ");

        jbIniciar.setText("Iniciar Sesi??n");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jlContrasenaLayout = new javax.swing.GroupLayout(jlContrasena);
        jlContrasena.setLayout(jlContrasenaLayout);
        jlContrasenaLayout.setHorizontalGroup(
            jlContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlContrasenaLayout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(jlContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jlContrasenaLayout.createSequentialGroup()
                        .addComponent(jlUsuario)
                        .addGap(31, 31, 31)
                        .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlContrasenaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlContrasenaLayout.createSequentialGroup()
                        .addComponent(jbRegistrar)
                        .addGap(31, 31, 31)
                        .addComponent(jbIniciar)))
                .addGap(46, 46, 46))
        );
        jlContrasenaLayout.setVerticalGroup(
            jlContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlContrasenaLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jlContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUsuario))
                .addGap(31, 31, 31)
                .addGroup(jlContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jlContrasenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegistrar)
                    .addComponent(jbIniciar))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUserActionPerformed

    private void jbRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarActionPerformed
        user=jUser.getText();
        password=String.valueOf(jPassword.getPassword());
        if (user.length() == 0 || password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
        } else {
            int flag = conexion.Registrar(user, password);
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Registrado con ??xito");
                jPassword.setText("");
                jUser.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al registrar, no registrado");
            }
        }
    }//GEN-LAST:event_jbRegistrarActionPerformed

    private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed
        user=jUser.getText();
        password=String.valueOf(jPassword.getPassword());
        if (user.length() == 0 || password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
        } else {
            int flag = conexion.IniciarSesion(user, password);
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
                jPassword.setText("");
                jUser.setText("");
                this.dispose();
                cliente=new Cliente(user);
                cliente.run();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un problema al iniciar sesi??n");
            }
        }
    }//GEN-LAST:event_jbIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jUser;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JLabel jlUsuario;
    // End of variables declaration//GEN-END:variables
}