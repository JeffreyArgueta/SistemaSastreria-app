package com.uso.gestor;

import java.awt.*;

import javax.swing.*;

import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.uso.App;

public class FormManager {
  private App app;
  private static FormManager instance;

  public static FormManager getInstance() {
    if (instance == null) {
      instance = new FormManager();
    }

    return instance;
  }

  private FormManager() {

  }

  public void initApp(App app) {
    this.app = app;
  }

  public void showForm(JComponent form) {
    EventQueue.invokeLater(() -> {
      FlatAnimatedLafChange.showSnapshot();
      app.setContentPane(form);
      app.revalidate();
      app.repaint();
      FlatAnimatedLafChange.hideSnapshotWithAnimation();
    });
  }
}
