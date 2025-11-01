package com.uso.componentes;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import com.uso.utiles.MethodUtil;

import net.miginfocom.swing.MigLayout;

public class PasswordStrengthStatus extends JPanel {
  public PasswordStrengthStatus() {
    init();
  }

  private void init() {
    setLayout(new MigLayout("fill,insets 0", "3[100,fill,grow0][]", "[fill,grow0]"));

    label = new JLabel("none");
    label.setVisible(false);

    putClientProperty(FlatClientProperties.STYLE, "" +
        "background:null");

    add(new LabelStatus());
    add(label);
  }

  private Color getStrengthColor(int type) {

    if (type == 1) {
      return Color.decode(FlatLaf.isLafDark() ? "#F38BA8" : "#D20F39");
    } else if (type == 2) {
      return Color.decode(FlatLaf.isLafDark() ? "#F9E2AF" : "#DF8E1D");
    } else {
      return Color.decode(FlatLaf.isLafDark() ? "#A6E3A1" : "#40A02B");
    }
  }

  private void checkPassword(String password) {
    this.type = password.isEmpty() ? 0 : MethodUtil.checkPasswordStrength(password);

    if (type == 0) {
      label.setText("none");
      label.setVisible(false);
    } else {
      label.setVisible(true);

      if (type == 1) {
        label.setText("Muy débil");
      } else if (type == 2) {
        label.setText("Medio");
      } else {
        label.setText("Fuerte");
      }

      label.setForeground(getStrengthColor(type));
    }

    repaint();
  }

  public void initPasswordField(JPasswordField txtPassword) {
    if (documentListener == null) {
      documentListener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
          checkPassword(String.valueOf(txtPassword.getPassword()));
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
          checkPassword(String.valueOf(txtPassword.getPassword()));
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
          checkPassword(String.valueOf(txtPassword.getPassword()));
        }
      };
    }

    if (passwordField != null) {
      passwordField.getDocument().removeDocumentListener(documentListener);
    }

    txtPassword.getDocument().addDocumentListener(documentListener);
    passwordField = txtPassword;
  }

  private class LabelStatus extends JLabel {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      int width = getWidth();
      int height = getHeight();
      int size = (int) (height * 0.3f);

      Graphics2D g2 = (Graphics2D) g.create();
      FlatUIUtils.setRenderingHints(g2);

      int gap = UIScale.scale(5);
      int w = (width - gap * 2) / 3;
      int y = (height - size) / 2;
      Color disableColor = Color.decode(FlatLaf.isLafDark() ? "#404040" : "#CECECE");

      if (type >= 1) {
        g2.setColor(getStrengthColor(1));
      } else {
        g2.setColor(disableColor);
      }

      FlatUIUtils.paintComponentBackground(g2, 0, y, w, size, 0, 999);

      if (type >= 2) {
        g2.setColor(getStrengthColor(2));
      } else {
        g2.setColor(disableColor);
      }

      FlatUIUtils.paintComponentBackground(g2, w + gap, y, w, size, 0, 999);

      if (type >= 3) {
        g2.setColor(getStrengthColor(3));
      } else {
        g2.setColor(disableColor);
      }

      FlatUIUtils.paintComponentBackground(g2, (w + gap) * 2, y, w, size, 0, 999);

      g2.dispose();
    }
  }

  private JPasswordField passwordField;
  private DocumentListener documentListener;
  private JLabel label;
  private int type;
}
