package Manager;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String choose;
        boolean exit = false;
        int size;
        boolean isExisted;
        Manager manager = new Manager();
        String studentsName;
        String studentID;
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    String YN, ID;
                    String regex = "^[nN]$";
                    isExisted = false;
                    size = manager.studentList.size();
                    while (true){
                        for(int i = 1; i <= 2 ; i++) {
                            ID = Validate.inputId();
                            for (int j = 0; j < size; j++) {
                                if (manager.studentList.get(j).getID().equals(ID)) {
                                    isExisted = true;
                                    System.out.printf(" ID : %s is already available !\n", ID);
                                    break;
                                }
                            }
                            if (!isExisted) {
                                String studentName = Validate.inputstudentName();
                                String semester = Validate.inputSemester();
                                String courseName = Validate.inputCourseName();
                                if(ID != null && studentName != null && semester != null && courseName != null) {
                                manager.Create(ID, studentName, semester, courseName);
                                }else {
                                    System.out.println("you cannot add this list ! , do it again");
                                }
                            }
                        }
                        System.out.println("Do u want continues ? (y/n)");
                        YN = scanner.nextLine();
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(YN);
                        if(matcher.find()) {
                            break;
                        }
                    }
                    break;
                case "2":
                    manager.SortStudentByName();
                    studentsName = Validate.inputstudentName();
                    manager.Search(studentsName);
                    break;
                case "3":
                    isExisted = false;
                    size = manager.studentList.size();
                    String option;
                    studentID = Validate.inputId();
                    for (int i = 0; i < size; i++) {
                        if (manager.studentList.get(i).getID().equals(studentID)) {
                            isExisted = true;
                            System.out.print("Do you want to update (U) or delete (D) student : ");
                            option = scanner.nextLine();
                            if(option.equalsIgnoreCase("u")) {
                                String Name = Validate.inputstudentName();
                                String Semester = Validate.inputSemester();
                                String CourseName = Validate.inputCourseName();
                                manager.Update(studentID, Name,Semester,CourseName);
                                break;
                            }else if(option.equalsIgnoreCase("d")){
                                manager.Remove(studentID);
                                break;
                            } else {
                                System.out.println("Invalid chooose !");
                            }
                        }
                    }
                    if (!isExisted) {
                        System.out.printf("Id = %s not existed.\n", studentID);
                    }
                    break;
                case "4":
                    manager.Report();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
    }
    public static void showMenu() {
        System.out.println();
        System.out.println("--------------menu----------");
        System.out.println("1. Add.");
        System.out.println("2. Find/Sort.");
        System.out.println("3. Update/Remove.");
        System.out.println("4. Report.");
        System.out.println("0. exit.");
        System.out.print("Please choose: ");
    }
}
