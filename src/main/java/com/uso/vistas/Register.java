package com.uso.vistas;

import javax.swing.*;

import com.formdev.flatlaf.FlatClientProperties;

import net.miginfocom.swing.MigLayout;

public class Register extends JPanel {
  public Register() {
    init();
  }

  private void init() {
    setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));

    JPanel panel = new JPanel();

    panel.putClientProperty(
        FlatClientProperties.STYLE, "" +
            "arc:20;" +
            "[light]background:darken(@background,6%);" +
            "[dark]background:lighten(@background,4%)");

    add(panel);
  }
}
