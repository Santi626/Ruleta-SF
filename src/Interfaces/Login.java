/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BaseDatos.DataBase;
import Clases.ErrorException;
import Clases.GestorMail;
import Clases.GestorUsuarios;
import Clases.Mesa;
import Clases.Usuario;
import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private Socket cliente;
    private int puerto = 9999;
    private String ip = "127.0.0.1";

    public Login() {
        try {
            initComponents();

            DataBase.setConexion("", "ruletasf", "ruletasf", "jdbc:oracle:thin:@localhost:1521:XE");
        } catch (ErrorException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema con la conexión.");
            btEntrar.setEnabled(false);
            btEntrarComoInvitado.setEnabled(false);
            labelCrearCuenta.setVisible(false);
            labelOlvidarContrasena.setVisible(false);
        }
        //Arma la mesa de la ruleta
        Mesa.armarMesa();
        //Mesa.imprimirRuleta();

        this.setLocationRelativeTo(null);
        this.setTitle("Ruleta SF - Iniciar Sesión");
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/login.png")).getImage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFechaNacimiento = new javax.swing.JPanel();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        panelCorreo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btEntrarComoInvitado = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cbMostrarPassword = new javax.swing.JCheckBox();
        btCerrar = new javax.swing.JButton();
        btEntrar = new javax.swing.JButton();
        labelOlvidarContrasena = new javax.swing.JLabel();
        labelCrearCuenta = new javax.swing.JLabel();

        panelFechaNacimiento.setToolTipText("");

        dcFechaNacimiento.setDateFormatString("yyyy-MM-dd");

        jLabel4.setText("*Fecha de Nacimiento: ");

        javax.swing.GroupLayout panelFechaNacimientoLayout = new javax.swing.GroupLayout(panelFechaNacimiento);
        panelFechaNacimiento.setLayout(panelFechaNacimientoLayout);
        panelFechaNacimientoLayout.setHorizontalGroup(
            panelFechaNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaNacimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFechaNacimientoLayout.setVerticalGroup(
            panelFechaNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaNacimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFechaNacimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("*Correo: ");

        tfCorreo.setToolTipText("Escriba el correo del usuario");

        javax.swing.GroupLayout panelCorreoLayout = new javax.swing.GroupLayout(panelCorreo);
        panelCorreo.setLayout(panelCorreoLayout);
        panelCorreoLayout.setHorizontalGroup(
            panelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCorreoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCorreoLayout.setVerticalGroup(
            panelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCorreoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCorreoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Iniciar Sesión");

        btEntrarComoInvitado.setText("Entrar Como Invitado");
        btEntrarComoInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarComoInvitadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuario: ");

        tfUsuario.setToolTipText("Nombre de usuario");
        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });

        tfPassword.setToolTipText("Escriba su contraseña");
        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        jLabel3.setText("Contraseña: ");

        cbMostrarPassword.setBackground(new java.awt.Color(102, 255, 102));
        cbMostrarPassword.setText("Mostrar Contraseña");
        cbMostrarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarPasswordActionPerformed(evt);
            }
        });

        btCerrar.setText("CERRAR");
        btCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCerrarMouseExited(evt);
            }
        });
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btEntrar.setText("Entrar");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        labelOlvidarContrasena.setForeground(new java.awt.Color(0, 153, 153));
        labelOlvidarContrasena.setText("¿Olvidó su contraseña?");
        labelOlvidarContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelOlvidarContrasenaMouseClicked(evt);
            }
        });

        labelCrearCuenta.setForeground(new java.awt.Color(0, 153, 153));
        labelCrearCuenta.setText("Crear Cuenta");
        labelCrearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCrearCuentaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(btEntrarComoInvitado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btCerrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelCrearCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfPassword)
                                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelOlvidarContrasena)
                                        .addComponent(cbMostrarPassword)))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btEntrarComoInvitado))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(cbMostrarPassword)
                .addGap(33, 33, 33)
                .addComponent(labelOlvidarContrasena)
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrar)
                    .addComponent(btEntrar)
                    .addComponent(labelCrearCuenta))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
        aceptar();
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void cbMostrarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarPasswordActionPerformed
        // TODO add your handling code here:
        if (cbMostrarPassword.isSelected()) {
            tfPassword.setEchoChar((char) 0);
        } else {
            tfPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cbMostrarPasswordActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCerrarMouseEntered
        // TODO add your handling code here:
        btCerrar.setBackground(Color.RED);
    }//GEN-LAST:event_btCerrarMouseEntered

    private void btCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCerrarMouseExited
        // TODO add your handling code here:
        btCerrar.setBackground(new Color(238, 238, 238));
    }//GEN-LAST:event_btCerrarMouseExited

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
        aceptar();
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        // TODO add your handling code here:
        aceptar();
    }//GEN-LAST:event_btEntrarActionPerformed

    private void btEntrarComoInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarComoInvitadoActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Aceptar"};
        int seleccion = JOptionPane.showOptionDialog(this, panelFechaNacimiento, "Introduzca su fecha de nacimiento",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (seleccion != -1) {
            if (dcFechaNacimiento.getDate() != null
                    && calculateAge(dcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()) >= 18) {
                entrarComoInvitado();
            } else {
                JOptionPane.showMessageDialog(this, "Debes ser mayor de 18 años para acceder a esta aplicación.");
            }
        }
        dcFechaNacimiento.setDate(null);
    }//GEN-LAST:event_btEntrarComoInvitadoActionPerformed

    private void labelCrearCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearCuentaMouseClicked
        // TODO add your handling code here:
        tfPassword.setText("");
        NuevoUsuario nu = new NuevoUsuario(this);
        nu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_labelCrearCuentaMouseClicked

    private void labelOlvidarContrasenaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelOlvidarContrasenaMouseClicked
        // TODO add your handling code here:
        //Manda correo al usuario
        Usuario u = existeUsuario(tfUsuario.getText());
        
        if (u != null && u.getCorreo() != null) {
            Object[] options = {"Aceptar"};
            int seleccion = JOptionPane.showOptionDialog(this, panelCorreo, "Introduzca el correo electronico de este usuario",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (seleccion != -1) {
                if (tfCorreo.getText().equals(u.getCorreo())) {
                    try {
                        GestorMail.enviarMail(tfCorreo.getText(), u);
                        JOptionPane.showMessageDialog(this, "Se ha enviado la contraseña a su mail");
                    } catch (MessagingException ex) {
                        JOptionPane.showMessageDialog(this, "Ha habido un problema enviando el correo");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El correo introducido no es correcto");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No existe este usuario o no se puede enviar un correo a su email");
        }

        tfCorreo.setText("");
    }//GEN-LAST:event_labelOlvidarContrasenaMouseClicked

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        //Calcular edad de usuario
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public void actualizarFechaUltimaConexion(int id) {
        //Actualiza la fecha de ultima conexion del usuario
        try {
            PreparedStatement ps = null;

            ps = DataBase.getConexion().prepareStatement("update usuario "
                    + "set FECHAULTIMACONEXION = SYSDATE "
                    + "where IDUSUARIO = ?");
            ps.setInt(1, id);

            //Ejecuta
            DataBase.ejecutaUpdateSeguro(ps);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Problemas actualizando la fecha de conexión");
        }
    }

    public Usuario existeUsuario(String nombre) {
        try {
            //Comprueba que el usuario esté en BBDD
            PreparedStatement ps = null;
            ResultSet rs = null;

            ps = DataBase.getConexion().prepareStatement("select * from usuario "
                    + "where nombre = ?");
            ps.setString(1, nombre);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("NOMBRE"), rs.getString("CORREO"), rs.getString("CONTRASENA"));
            }
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return null;
    }

    public boolean comprobarDatos(String nombre, String password) {
        try {
            //Comprueba que el usuario esté en BBDD
            PreparedStatement ps = null;
            ResultSet rs = null;

            ps = DataBase.getConexion().prepareStatement("select * from usuario "
                    + "where nombre = ? and contrasena = ?");
            ps.setString(1, nombre);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                GestorUsuarios.setUsuarioActivo(new Usuario(rs.getInt("IDUSUARIO"), rs.getString("NOMBRE"), new Date(), rs.getInt("FICHAS")));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return false;
    }

    public void aceptar() {
        //Entra con usuario a la aplicación
        //Construye la contraseña
        String password = "";
        for (int i = 0; i < tfPassword.getPassword().length; i++) {
            password += tfPassword.getPassword()[i];
        }

        tfPassword.setText("");
//            //Crea la conexion con el servidor
//            cliente = new Socket(ip, puerto);
        //Comprueba que los datos son correctos
        if (comprobarDatos(tfUsuario.getText(), password)) {
            //Conexion correcta
            //Entra como usuario

            //Update de ultimo dia de conexión
            actualizarFechaUltimaConexion(GestorUsuarios.getUsuarioActivo().getId());
            Menu m = new Menu(this);
            m.setVisible(true);
            this.setVisible(false);
        } else {
            //Conexion fallida
            JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos");
        }
    }

    public void entrarComoInvitado() {
//        try {
//            //Crea la conexion con el servidor
//            cliente = new Socket(ip, puerto);
            //Entra con un usuario de prueba
            GestorUsuarios.setUsuarioActivo(null);

            Menu m = new Menu(this);
            m.setVisible(true);
            this.setVisible(false);
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//        }
    }

    public void setParametros(String nombre, String password) {
        //Escribe parametros en los TF
        tfUsuario.setText(nombre);
        tfPassword.setText(password);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btEntrar;
    private javax.swing.JButton btEntrarComoInvitado;
    private javax.swing.JCheckBox cbMostrarPassword;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCrearCuenta;
    private javax.swing.JLabel labelOlvidarContrasena;
    private javax.swing.JPanel panelCorreo;
    private javax.swing.JPanel panelFechaNacimiento;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
