/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TpBank;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Khuong Hung
 */
public class Main {
     public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        int choice;
        while (true) {
            System.out.println("=========Login Tien Phong Bank’s Ebank===========");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");

            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    manager.setLocate(vietnamese);
                    manager.inputAccount();
                    manager.inputPassword();
                    manager.inputCapcha();
                    break;
                case 2:
                    manager.setLocate(english);
                    manager.inputAccount();
                    manager.inputPassword();
                    manager.inputCapcha();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
