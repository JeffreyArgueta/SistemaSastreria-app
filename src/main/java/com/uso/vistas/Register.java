package com.uso.vistas;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;
import com.uso.componentes.PasswordStrengthStatus;
import com.uso.gestor.FormManager;

import net.miginfocom.swing.MigLayout;

public class Register extends JPanel {
  public Register() {
    init();
  }

  private void init() {
    setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));

    txtFirstName = new JTextField();
    txtLastName = new JTextField();
    txtUsername = new JTextField();
    txtEmail = new JTextField();
    txtPassword = new JPasswordField();
    txtConfirmPassword = new JPasswordField();
    btnRegister = new JButton("Registrarse");
    passwordStrengthStatus = new PasswordStrengthStatus();

    JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 35 45", "fill,360"));

    panel.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "arc:20;" +
            "[light]background:darken(@background,4%);" +
            "[dark]background:lighten(@background,4%)");

    txtFirstName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nombre/s");
    txtLastName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Apellido/s");
    txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Identificarte en el sistema como...");
    txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "correo.ejemplo@dominio.com");
    txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa una contraseña segura");
    txtConfirmPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Vuelve a ingresar tu contraseña");

    txtPassword.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "showRevealButton:true");

    txtConfirmPassword.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "showRevealButton:true");

    btnRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegisterActionPerfomed(evt);
      }
    });

    btnRegister.putClientProperty(
        FlatClientProperties.STYLE, "" +
        // "[light]background:darken(@background,10%);" +
        // "[dark]background:lighten(@background,10%);" +
            "[light]background:#8839EF;" +
            "[dark]background:#CBA6F7;" +
            "[light]foreground:#FFFFFF;" +
            "[dark]foreground:#000000;" +
            "borderWidth:0;" +
            "focusWidth:0;" +
            "innerFocusWidth:0");

    btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

    JLabel lblTitle = new JLabel("¡Bienvenido al mundo de la sastrería!", SwingConstants.CENTER);
    JLabel lblDescription = new JLabel(generateRandomDescription(), SwingConstants.CENTER);

    lblTitle.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "font:bold +10");

    lblDescription.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "[light]foreground:lighten(@foreground,30%);" +
            "[dark]foreground:darken(@foreground,30%)");


    passwordStrengthStatus.initPasswordField(txtPassword);

    panel.add(lblTitle);
    panel.add(lblDescription);
    panel.add(new JLabel("Nombre Completo"), "gapy 10");
    panel.add(txtFirstName, "split 2");
    panel.add(txtLastName);
    panel.add(new JSeparator(), "gapy 5 5");
    panel.add(new JLabel("Usuario"));
    panel.add(txtUsername);
    panel.add(new JLabel("Correo electrónico"), "gapy 8");
    panel.add(txtEmail);
    panel.add(new JLabel("Contraseña"), "gapy 8");
    panel.add(txtPassword);
    panel.add(passwordStrengthStatus, "gapy 0");
    panel.add(new JLabel("Confirmar contraseña"), "gapy 0");
    panel.add(txtConfirmPassword);
    panel.add(btnRegister, "gapy 20");
    panel.add(createLoginLabel(), "gapy 10");

    add(panel);
  }

  private Component createLoginLabel() {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

    panel.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "background:null");

    JLabel lblHaveAccount = new JLabel("¿Ya tienes una cuenta?");

    lblHaveAccount.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "[light]foreground:lighten(@foreground,30%);" +
            "[dark]foreground:darken(@foreground,30%)");

    btnLogin = new JButton("<html><a href=\"#\">Inicia sesión</a></html>");

    btnLogin.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "border:3,3,3,3");

    btnLogin.setContentAreaFilled(false);
    btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

    btnLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoginActionPerfomed(evt);
      }
    });

    panel.add(lblHaveAccount);
    panel.add(btnLogin);

    return panel;
  }

  private String generateRandomDescription() {
    Random random = new Random();

    String[] descriptions = {
        "Cada hilo cuenta, crea tu perfil",
        "Accede a herramientas de precisión",
        "Un nuevo comienzo, hecho a mano",
        "Un sistema hecho para creadores",
        "Regístrate y marca tu estilo",
        "Tu cuenta, hecha a la medida",
    };

    String randomDescription = descriptions[random.nextInt(descriptions.length)];
    return randomDescription;
  }

  private void btnRegisterActionPerfomed(java.awt.event.ActionEvent evt) {
    System.out.println("Registrando cuenta");
    // TODO: register
  }

  private void btnLoginActionPerfomed(java.awt.event.ActionEvent evt) {
    FormManager.getInstance().showForm(new Login());
  }

  private JTextField txtFirstName;
  private JTextField txtLastName;
  private JTextField txtUsername;
  private JTextField txtEmail;
  private JPasswordField txtPassword;
  private JPasswordField txtConfirmPassword;
  private JButton btnRegister;
  private JButton btnLogin;
  private PasswordStrengthStatus passwordStrengthStatus;
}
