package com.uso;

import javax.swing.*;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.uso.vistas.Login;

import java.awt.*;

public class App extends JFrame {
  public App() {
    init();
  }

  private void init() {
    setIconImage(icono);
    setTitle("Sistema Sastrería - Login");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(new Dimension(1200, 700));
    setLocationRelativeTo(null);
    setContentPane(new Login());
  }

  public static void main(String[] args) {
    FlatInterFont.install();
    FlatLaf.registerCustomDefaultsSource("themes");

    UIManager.put("defaultFont", new Font(FlatInterFont.FAMILY, Font.PLAIN, 13));
    FlatMacDarkLaf.setup();
    // FlatMacLightLaf.setup();

    EventQueue.invokeLater(() -> new App().setVisible(true));
  }

  private Image icono = new ImageIcon(getClass().getResource("/icons/app.png")).getImage();
}
