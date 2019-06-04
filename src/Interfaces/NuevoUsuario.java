/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import BaseDatos.DataBase;
import java.awt.Color;
import javax.swing.ImageIcon;
import Clases.ErrorException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class NuevoUsuario extends javax.swing.JFrame {

    /**
     * Creates new form NuevoUsuario
     */
    private Login l;

    public NuevoUsuario(Login l) {
        initComponents();

        this.l = l;

        this.setLocationRelativeTo(null);
        this.setTitle("Ruleta SF - Registrarse");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cbMostrarPassword = new javax.swing.JCheckBox();
        btCancelar = new javax.swing.JButton();
        btCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfPassword1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        tfCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Nuevo Usuario");

        jLabel2.setText("*Usuario: ");
        jLabel2.setToolTipText("OBLIGATORIO");

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

        jLabel3.setText("*Contraseña: ");
        jLabel3.setToolTipText("OBLIGATORIO");

        cbMostrarPassword.setBackground(new java.awt.Color(102, 255, 102));
        cbMostrarPassword.setText("Mostrar Contraseña");
        cbMostrarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarPasswordActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCancelarMouseExited(evt);
            }
        });
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btCrear.setText("Crear");
        btCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearActionPerformed(evt);
            }
        });

        jLabel4.setText("*Confirmar\nContraseña");
        jLabel4.setToolTipText("OBLIGATORIO");

        tfPassword1.setToolTipText("Confirme su contraseña");
        tfPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPassword1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Correo: ");

        tfCorreo.setToolTipText("Correo electrónico");

        jLabel6.setText("*Fecha de Nacimiento: ");
        jLabel6.setToolTipText("OBLIGATORIO");

        jdFechaNacimiento.setBackground(new java.awt.Color(102, 255, 102));
        jdFechaNacimiento.setToolTipText("Fecha de nacimiento");
        jdFechaNacimiento.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btCancelar)
                        .addGap(163, 163, 163)
                        .addComponent(btCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(32, 32, 32)
                            .addComponent(tfPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(32, 32, 32)
                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbMostrarPassword)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfUsuario)
                                .addComponent(tfCorreo)
                                .addComponent(jdFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(cbMostrarPassword)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btCrear))
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
        creaUsuario();
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
        creaUsuario();
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void cbMostrarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarPasswordActionPerformed
        // TODO add your handling code here:
        if (cbMostrarPassword.isSelected()) {
            tfPassword.setEchoChar((char) 0);
            tfPassword1.setEchoChar((char) 0);
        } else {
            tfPassword.setEchoChar('*');
            tfPassword1.setEchoChar('*');
        }
    }//GEN-LAST:event_cbMostrarPasswordActionPerformed

    private void btCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseEntered
        // TODO add your handling code here:
        btCancelar.setBackground(Color.RED);
    }//GEN-LAST:event_btCancelarMouseEntered

    private void btCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseExited
        // TODO add your handling code here:
        btCancelar.setBackground(new Color(238, 238, 238));
    }//GEN-LAST:event_btCancelarMouseExited

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearActionPerformed
        // TODO add your handling code here:
        creaUsuario();
    }//GEN-LAST:event_btCrearActionPerformed

    private void tfPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassword1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        //Calcular edad de usuario
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public boolean existeNombre(String nombre) {
        //Comprueba si el nombre ya existe en la Base de Datos
        try {
            //Comprueba que el usuario esté en BBDD
            PreparedStatement ps = null;
            ResultSet rs = null;

            ps = DataBase.getConexion().prepareStatement("select NOMBRE from usuario "
                    + "where nombre = ?");
            ps.setString(1, nombre);

            rs = ps.executeQuery();

            return rs.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return false;
    }

    public void valida() throws ErrorException {
        //Valida los campos
        String password = "";
        String password2 = "";
        for (int i = 0; i < tfPassword.getPassword().length; i++) {
            password += tfPassword.getPassword()[i];
        }
        for (int i = 0; i < tfPassword1.getPassword().length; i++) {
            password2 += tfPassword1.getPassword()[i];
        }

        //Compara todos los campos
        Date hoy = new Date();
        if (tfUsuario.getText().length() == 0) {
            tfUsuario.requestFocus();
            throw new ErrorException("El nombre de usuario no puede estar vacio");
        } else if (existeNombre(tfUsuario.getText())) {
            tfUsuario.setText("");
            tfUsuario.requestFocus();
            throw new ErrorException("El nombre de usuario ya existe");
        } else if (tfCorreo.getText().length() != 0 && !tfCorreo.getText().matches(".+@.+\\..+")) {
            tfCorreo.setText("");
            tfCorreo.requestFocus();
            throw new ErrorException("El formato de correo no es correcto");
        } else if (jdFechaNacimiento.getDate() == null) {
            throw new ErrorException("La fecha de nacimiento no puede estar vacia");
        } else if (calculateAge(jdFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()) < 18) {
            jdFechaNacimiento.setDate(null);
            throw new ErrorException("Debes ser mayor de 18 años para acceder a esta aplicación.");
        } else if (password.length() < 6) {
            tfPassword.setText("");
            tfPassword1.setText("");
            tfPassword.requestFocus();
            throw new ErrorException("La contraseña es demasiado debil.\nDebe contener al menos 6 caracteres");
        } else if (!password.equals(password2)) {
            tfPassword.setText("");
            tfPassword1.setText("");
            tfPassword.requestFocus();
            throw new ErrorException("Las contraseñas no coinciden");
        }
    }

    public void creaUsuario() {
        //Crea el usuario en bbdd validando los campos
        try {
            valida();
            //Una vez comprobado que esta correcto, se da de alta en BBDD
            String password = "";
            for (int i = 0; i < tfPassword.getPassword().length; i++) {
                password += tfPassword.getPassword()[i];
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            PreparedStatement ps = null;

            ps = DataBase.getConexion().prepareStatement("INSERT INTO usuario "
                    + "(NOMBRE, FECHANACIMIENTO, CORREO, FECHACREACION, FICHAS, CONTRASENA)  "
                    + "values(?, ?, ?, SYSDATE, 1000, ?)");
            ps.setString(1, tfUsuario.getText());
            ps.setString(2, sdf.format(jdFechaNacimiento.getDate()));
            if (tfCorreo.getText().length() == 0) {
                ps.setString(3, null);
            } else {
                ps.setString(3, tfCorreo.getText());
            }
            ps.setString(4, password);

            //Ejecuta
            DataBase.ejecutaUpdateSeguro(ps);

            //Mensaje de éxito
            JOptionPane.showMessageDialog(this, "Se ha creado el usuario con éxito!", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            //Cierra la pestaña y carga los parametros en el login
            l.setParametros(tfUsuario.getText(), password);
            l.setVisible(true);
            this.dispose();
        } catch (ErrorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ha habido un problema guardando el usuario en Base de Datos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCrear;
    private javax.swing.JCheckBox cbMostrarPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdFechaNacimiento;
    private javax.swing.JTextField tfCorreo;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JPasswordField tfPassword1;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
