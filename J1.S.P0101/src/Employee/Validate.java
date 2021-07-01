/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Khuong Hung
 */
public class Validate {

    public static Scanner scanner = new Scanner(System.in);

    static String convert(String s) {
        s = s.toLowerCase(); // viet thuong tat ca xau
        String[] ss;
        String s2 = "";
        ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            String s1 = "";
            if (ss[i].length() != 0) {
                s1 += Character.toUpperCase(ss[i].charAt(0));
                if (ss[i].length() > 1) {
                    s1 += ss[i].substring(1);
                }
                s2 += s1;
                if (i < ss.length) {
                    s2 += " ";
                }
            }
        }
        if (s2.charAt(s2.length() - 1) == ' ') {
            s2 += "\b";
        }
        return s2;
    }

    static String inputName() {
        String Name;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true) {
            System.out.print("Enter employee name : ");
            Name = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Name);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid name input !");
            }
        }
        Name = convert(Name);
        return Name;
    }

    static String inputId() {
        String Id;
        String regex = "^[0-9\\s+]+$";
        while (true) {
            System.out.print("Enter employee id: ");
            Id = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Id);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid id input !");
            }
        }
        Id = convert(Id);
        return Id;
    }

    static String inputFirstName() {
        String firstName;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true) {
            System.out.print("Enter employee Firstname : ");
            firstName = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(firstName);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid name input !");
            }
        }
        firstName = convert(firstName);
        return firstName;
    }

    static String inputLastName() {
        String lastName;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true) {
            System.out.print("Enter employee Lastname : ");
            lastName = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(lastName);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid name input !");
            }
        }
        lastName = convert(lastName);
        return lastName;
    }

    static String inputPhone() {
        String Phone;
        String regex = "^0[123456789]{1}\\d{8,9}$";
        while (true) {
            System.out.print("Enter employee Phone: ");
            Phone = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Phone);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid phone number !");
            }
        }
        return Phone;
    }

    static String inputEmail() {
        String Email;
        String regex = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        while (true) {
            System.out.print("Enter employee email (email@address.com): ");
            Email = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Email);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid email input !");
            }
        }
        return Email;
    }

    static String inputAddress() {
        String Address;
        String regex = "^[a-zA-Z0-9\\s+]+$";
        while (true) {
            System.out.print("Enter employee address : ");
            Address = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Address);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid email input !");
            }
        }
        Address = convert(Address);
        return Address;
    }

   static String inputDOB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print("Input date of birth (dd/MM/yyyy) : ");
                date = sdf.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid date,please input again! ");
            }
        }
        return sdf.format(date);
    }

    static String inputSex() {
        String Sex;
        while (true) {
            System.out.print("Enter employee Sex : ");
            Sex = scanner.nextLine();

            if (Sex.toLowerCase().equals("nam") || Sex.toLowerCase().equals("male")) {
                break;
            } else if (Sex.toLowerCase().equals("nu") || Sex.toLowerCase().equals("female")) {
                break;
            } else {
                System.out.println("Invalid phone sex !");
            }
        }
        Sex = convert(Sex);
        return Sex;
    }

    static int inputSalary() {
        int Salary;
        while (true) {
            try {
                System.out.print("Enter employee salary : ");
                Salary = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid phone salary");
            }
        }
        return Salary;
    }

    static String inputEgency() {
        String Egency;
        String regex = "^[a-zA-Z0-9\\s+]+$";
        while (true) {
            System.out.print("Enter employee egency : ");
            Egency = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Egency);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid email input !");
            }
        }
        Egency = convert(Egency);
        return Egency;
    }
}
