/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpBank;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Khuong Hung
 */
public class Manager {

    Scanner scanner = new Scanner(System.in);
    ResourceBundle bundle;

    public void setLocate(Locale locale) {
        if (locale.getLanguage().equalsIgnoreCase("vi")) {
            bundle = ResourceBundle.getBundle("TpBank.Language.language_vi_VN");
        }
        if (locale.getLanguage().equalsIgnoreCase("en")) {
            bundle = ResourceBundle.getBundle("TpBank.Language.language_en_US");
        }
    }

    public void inputAccount() {
        String account;
        while (true) {
            try {
                System.out.print(bundle.getString("account"));
                account = scanner.nextLine();
                if (checkAccountNumber(account).equalsIgnoreCase("valid input")) {
                    break;
                }
                if (checkAccountNumber(account).equalsIgnoreCase("invalid input")) {
                    System.out.println(bundle.getString("check.account"));
                }
            } catch (Exception e) {
                System.out.println(bundle.getString("check.account"));
            }
        }
    }

    public void inputPassword() {
        String password;
        while (true) {
            try {
                System.out.print(bundle.getString("password"));
                password = scanner.nextLine();
                if (checkPassword(password).equals("valid input")) {
                    break;
                }
                if (checkPassword(password).equals("invalid input")) {
                    System.out.println(bundle.getString("wrong.password1"));
                }
                if (checkPassword(password).equals("invalid check")) {
                    System.out.println(bundle.getString("wrong.password2"));
                }
            } catch (Exception e) {
                System.out.println(bundle.getString("wrong.password2"));
            }
        }
    }

    public void inputCapcha() {
        while (true) {
            try {
                String capcha = "";
                System.out.print(bundle.getString("capcha"));
                String generateCaptcha = generateCaptcha().toString();
                System.out.print(bundle.getString("input.capcha"));
                capcha = scanner.nextLine().replaceAll("\\s+", "").trim();
                
                    if (checkCapcha(capcha, generateCaptcha).equals("valid input")) {
                        System.out.println(bundle.getString("right.capcha"));
                        break;
                    } else {
                        System.out.println(bundle.getString("wrong.capcha"));
                    }

            } catch (Exception e) {
            }
        }
    }

    public String checkAccountNumber(String account) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(account);
        if (m.find()) {
            return "valid input";
        } else {
            return "invalid input";
        }
    }

    public String checkPassword(String password) {
        int check1 = 0;
        int check2 = 0;
        if (password.length() >= 8) {
            while (true) {
                for (int i = 0; i < password.length(); i++) {
                    char x = password.charAt(i);
                    if (Character.isLetter(x)) {
                        check1 = 1;
                    }
                    if (Character.isDigit(x)) {
                        check2 = 1;
                    }
                }
                break;
            }
            if (check1 == 1 && check2 == 1) {
                return "valid input";
            } else {
                return "invalid input";
            }
        }
        return "invalid check";
    }

    public StringBuffer generateCaptcha() {
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final int N = alphabet.length();
        Random r = new Random();
        StringBuffer capcha = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            char c = alphabet.charAt(r.nextInt(N));
            capcha.append(c);
            alphabet = alphabet.replaceAll(c + "", "");
        }
        System.out.println(capcha);
        return capcha;
    }

    public String checkCapcha(String capcha, String generateCaptcha) {
        if (capcha.length() == 0) {
            return "invalid input";
        }
        if (generateCaptcha.contains(capcha)) {
            return "valid input";
        }
        return "invalid input";
    }
}
