package com.uso.vistas;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;

import net.miginfocom.swing.MigLayout;

public class Login extends JPanel {
  public Login() {
    init();
  }

  private void init() {
    setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));

    txtUsername = new JTextField();
    txtPassword = new JPasswordField();
    chRememberMe = new JCheckBox("Recuérdame");
    btnLogin = new JButton("Iniciar Sesión");

    JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "fill,250:280"));

    panel.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "arc:20;" +
            "[light]background:darken(@background,3%);" +
            "[dark]background:lighten(@background,3%)");

    txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa tu usuario o correo");
    txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingresa tu contraseña");

    txtPassword.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "showRevealButton:true");

    btnLogin.putClientProperty(
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

    btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

    btnLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoginActionPerfomed(evt);
      }
    });

    JLabel lblTitle = new JLabel(generateRandomTitle(), SwingConstants.CENTER);
    JLabel lblDescription = new JLabel(generateRandomDescription(), SwingConstants.CENTER);

    lblTitle.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "font:bold +10");

    lblDescription.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "[light]foreground:lighten(@foreground,30%);" +
            "[dark]foreground:darken(@foreground,30%)");

    panel.add(lblTitle);
    panel.add(lblDescription);
    panel.add(new JLabel("Usuario"), "gapy 8");
    panel.add(txtUsername);
    panel.add(new JLabel("Contraseña"), "gapy 8");
    panel.add(txtPassword);
    panel.add(chRememberMe, "grow 0");
    panel.add(btnLogin, "gapy 10");
    panel.add(createSignupLabel(), "gapy 10");

    add(panel);
  }

  private Component createSignupLabel() {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

    panel.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "background:null");

    btnRegister = new JButton("<html><a href=\"#\">Registrarse</a></html>");

    btnRegister.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "border:3,3,3,3");

    btnRegister.setContentAreaFilled(false);
    btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

    btnRegister.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnRegisterActionPerfomed(evt);
      }
    });

    JLabel lblNotAccount = new JLabel("¿No tienes una cuenta?");

    lblNotAccount.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "[light]foreground:lighten(@foreground,30%);" +
            "[dark]foreground:darken(@foreground,30%)");

    panel.add(lblNotAccount);
    panel.add(btnRegister);

    return panel;
  }

  private String generateRandomTitle() {
    Random random = new Random();

    String[] titles = {
        "¡Bienvenido!",
        "¿Listo para comenzar?",
        "Accede a tu cuenta",
        "¡Hola de nuevo!",
        "¡Qué gusto verte!",
        "Listos para ayudar"
    };

    String randomTitle = titles[random.nextInt(titles.length)];
    return randomTitle;
  }

  private String generateRandomDescription() {
    Random random = new Random();

    String[] descriptions = {
        "Accede para gestionar tus servicios",
        "Revisa tus órdenes y trabajos activos",
        "Ingresa tus credenciales para continuar",
        "Controla tus órdenes y avances desde aquí",
        "Organiza tus tareas y pedidos fácilmente",
        "Tu taller, siempre al alcance",
    };

    String randomDescription = descriptions[random.nextInt(descriptions.length)];
    return randomDescription;
  }

  private void btnLoginActionPerfomed(java.awt.event.ActionEvent evt) {
    System.out.println("Iniciando sesión");
    // TODO: login
  }

  private void btnRegisterActionPerfomed(java.awt.event.ActionEvent evt) {
    System.out.println("Formulario de registro");
    // TODO: sign-up form
  }

  private JTextField txtUsername;
  private JPasswordField txtPassword;
  private JCheckBox chRememberMe;
  private JButton btnLogin;
  private JButton btnRegister;
}
