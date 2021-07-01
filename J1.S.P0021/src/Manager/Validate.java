/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.StudentsReport;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Khuong Hung
 */
public class Validate {
 public static Scanner scanner = new Scanner(System.in);
    static String convert(String s) {
        s = s.toLowerCase();
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


    public static String inputId() {
        String regex = "^[0-9a-zA-Z\\s+]+$";
        String Id;
        while (true) {
            System.out.print("Enter id: ");
            Id = scanner.nextLine().trim();
            if(!Id.isEmpty()) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(Id);
                if (matcher.find()) {
                    Id = convert(Id);
                    break;
                } else {
                    System.out.println("Invalid id input !");
                }
            }else{
                Id = null;
                break;
            }
        }
        return Id;
    }

    static String inputstudentName(){
        String Name;
        String regex = "^[a-zA-Z\\s+]+$";
        while (true){
            System.out.print("Enter name : ");
            Name = scanner.nextLine().replaceAll("//s+", "").trim();
            if(!Name.isEmpty()) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(Name);
                if (matcher.find()) {
                    Name = convert(Name);
                    break;
                } else {
                    System.out.println("Invalid input !");
                }
            }else{
                Name = null;
                break;
            }
        }
        return Name;
    }

    static String inputSemester(){
        String Semester;
        String regex = "^[1-9]+$";
        while (true) {
                System.out.print("Enter semester : ");
                Semester = scanner.nextLine().trim();
            if(!Semester.isEmpty()) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(Semester);
                if (matcher.find()) {
                    Semester = convert(Semester);
                    break;
                } else {
                    System.out.println("Invalid input !");
                }
            }else{
                Semester = null;
                break;
            }
        }
        return Semester;
    }

    static String inputCourseName(){
        String CourseName;
        String regex = "^[a-zA-Z.1-9/\\s+]+$";
        while (true){
            System.out.print("Enter course : ");
            CourseName = scanner.nextLine().trim();
            if(!CourseName.isEmpty()) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(CourseName);
                if (matcher.find()) {
                    CourseName = convert(CourseName);
                    break;
                } else {
                    System.out.println("Invalid input !");
                }
            }else{
                CourseName = null;
                break;
            }
        }
        return CourseName;
    }

    public static boolean checkReportExist(ArrayList<StudentsReport> studentsList2,String studentsName,String courseName, int totalCourse) {
        for (int i = 0; i < studentsList2.size(); i ++) {
            if (studentsName.equalsIgnoreCase(studentsList2.get(i).getStudentsName())
                    && courseName.equalsIgnoreCase(studentsList2.get(i).getCourseName())
                    && totalCourse == studentsList2.get(i).getTotalCourse()) {
                return false;
            }
        }
        return true;
    }
}
