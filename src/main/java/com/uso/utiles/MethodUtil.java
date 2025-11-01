package com.uso.utiles;

public class MethodUtil {
  public static int checkPasswordStrength(String password) {
    int score = 0;

    if (password.length() >= 8) {
      score++;
    }

    boolean hasUpperCase = !password.equals(password.toLowerCase());

    if (hasUpperCase) {
      score++;
    }

    boolean hasLowerCase = !password.equals(password.toUpperCase());

    if (hasLowerCase) {
      score++;
    }

    boolean hasDigit = password.matches(".*\\d.*");

    if (hasDigit) {
      score++;
    }

    boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

    if (hasSpecialChar) {
      score++;
    }

    if (score < 3) {
      return 1;
    } else if (score < 5) {
      return 2;
    } else {
      return 3;
    }
  }
}
