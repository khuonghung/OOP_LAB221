/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Students;
import Entity.StudentsReport;
import java.util.*;

/**
 *
 * @author Khuong Hung
 */
public class Manager {

    ArrayList<Students> studentList = new ArrayList<>();
    ArrayList<StudentsReport> studentsList2 = new ArrayList<>();

    public void Create(String ID, String studentName, String semester, String courseName) {
        Students students = new Students(ID, studentName, semester, courseName);
        studentList.add(students);
    }

    public void Search(String Name) {
        boolean isExisted = false;
        int count = 0;
        int size = studentList.size();
        int i;
        for (i = 0; i < size; i++) {
            if (count == 0) {
                System.out.println("Information : ");
                System.out.printf("%-10s%-25s%-15s%-15s\n", "ID", "Student name",
                        "semester", "Course Name");
                count++;
            }
            while (studentList.get(i).getStudentName().contains(Name)) {
                isExisted = true;
                System.out.printf("%-10s  %-25s  %-15s   %-15s\n", studentList.get(i).getID(), studentList.get(i).getStudentName(),
                         studentList.get(i).getSemester(), studentList.get(i).getCourseName());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Name : %s not existed.\n", Name);
        }
    }

    public void SortStudentByName() {
        Collections.sort(studentList, new SortStudentByName());
        System.out.println("Information has been update !");
    }

    public void Update(String ID, String Name, String Semester, String CourseName) {
        int size = studentList.size();
        int size2 = studentsList2.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getID().equals(ID)) {
                if (Name != null) {
                    studentList.get(i).setStudentName(Name);
                }
                if (Semester != null) {
                    studentList.get(i).setSemester(Semester);
                }
                if (CourseName != null) {
                    studentList.get(i).setCourseName(CourseName);
                }
                break;
            }
        }
        System.out.println("Information has been update!");
    }

    public void Remove(String ID) {
        int size = studentList.size();
        int size2 = studentsList2.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getID().equals(ID)) {
                studentList.remove(studentList.get(i));
                break;
            }
        }
        for (int j = 0; j < size2; j++) {
            studentsList2.remove(studentsList2.get(j));
        }
        System.out.println("Information has been deleted!");
    }

    public void Report() {
        int size = studentList.size();
        String studentsName;
        String courseName;
        int totalCourse;
        for (int i = 0; i < size; i++) {
            totalCourse = 0;
            studentsName = studentList.get(i).getStudentName();
            courseName = studentList.get(i).getCourseName();
            for (int j = 0; j < size; j++) {
                if (studentsName.equalsIgnoreCase(studentList.get(j).getStudentName()) && courseName.equalsIgnoreCase(studentList.get(j).getCourseName())) {
                    totalCourse++;
                }
            }
            if (Validate.checkReportExist(studentsList2, studentsName, courseName, totalCourse)) {
                StudentsReport studentsReport = new StudentsReport(studentsName, courseName, totalCourse);
                studentsList2.add(studentsReport);
            }
        }
        DisplayReport();
        for (int z = 0; z < studentsList2.size(); z++) {
            studentsList2.remove(studentsList2.get(z));
        }
    }

    public void DisplayReport() {
        System.out.printf("%-25s%-13s%-15s\n", "Student name",
                "Course name", "Total course");
        for (int z = 0; z < studentsList2.size(); z++) {
            System.out.printf("%-25s  %-15s%-20d\n", studentsList2.get(z).getStudentsName(),
                     studentsList2.get(z).getCourseName(), studentsList2.get(z).getTotalCourse());
        }
    }
}
