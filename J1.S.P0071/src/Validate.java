
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Khuong Hung
 */
public class Validate {

    TaskManager taskManager = new TaskManager();
    public static Scanner scanner = new Scanner(System.in);

    static String convert(String s) {
        s = s.toLowerCase();
        String[] ss;
        int i;
        String s2 = "";
        ss = s.split(" ");
        for (i = 0; i < ss.length; i++) {
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

    static int inputID() {
        int ID;
        while (true) {
            try {
                System.out.print("Enter ID : ");
                ID = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid input !");
            }
        }
        return ID;
    }

    static String inputRequirementName() {
        String Name;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true) {
            System.out.print("Requirement Name : ");
            Name = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Name);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid input name !");
            }
        }
        Name = convert(Name);
        return Name;
    }

    static String inputTypeID() {
        String typeID;
        String regex = "^[1-4]$";
        while (true) {
            System.out.print("Task type : ");
            typeID = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(typeID);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid input id !");
            }
        }
        if (typeID.equals("1")) {
            return "Code";
        } else if (typeID.equals("2")) {
            return "Test";
        } else if (typeID.equals("3")) {
            return "Designer";
        } else if (typeID.equals("4")) {
            return "Review";
        }
        return typeID;
    }

    static String inputDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print("Date (dd/MM/yyyy) : ");
                date = sdf.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date,please input again! ");
            }
        }
        return sdf.format(date);
    }

    static double inputPlanFrom() {
        double from = 0;
        while (true) {
            try {
                System.out.print("input from: ");
                from = Double.parseDouble(scanner.nextLine());
                if (from >= 8 && from < 17.5) {
                    if (from % 0.5 == 0) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.err.println("invalid amount, please input again");
            }
        }
        return from;
    }

    static double inputPlanTo(double from) {
        double to = 0;
        while (true) {
            try {
                System.out.print("input to: ");
                to = Double.parseDouble(scanner.nextLine());
                if (to >= 8 && to <= 17.5) {
                    if (to % 0.5 == 0) {
                        if (to > from) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.err.println("invalid amount, please input again");
            }
        }
        return to;
    }

    static double Time(double from, double to) {
        double time;
        time = to - from;
        return time;
    }

    static String inputAssignee() {
        String Assignee;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true) {
            System.out.print("Assignee : ");
            Assignee = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Assignee);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid input Assignee !");
            }
        }

        Assignee = convert(Assignee);
        return Assignee;

    }

    static String intputReviewer() {
        String Reviewer;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true) {
            System.out.print("Reviewer : ");
            Reviewer = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Reviewer);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Invalid input Reviewer !");
            }
        }

        Reviewer = convert(Reviewer);
        return Reviewer;
    }
}
