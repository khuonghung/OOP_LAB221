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
    ArrayList<Students> ListUpdate = new ArrayList<>();

    public void Create(String ID, String studentName, int semester, String courseName) {
        Students students = new Students(ID, studentName, semester, courseName);
        studentList.add(students);
    }

    public void Search(String Name) {
        boolean isExisted = false;
        int count = 0;
        int size = studentList.size();
        int i;
        for (i = 0; i < size; i++) {
            if (studentList.get(i).getStudentName().contains(Name)) {
                isExisted = true;
                if (count == 0) {
                    System.out.println("Information : ");
                    System.out.printf("%-25s%-15s%-15s\n", "Student name",
                            "semester", "Course Name");
                    count++;
                }
                System.out.printf("%-25s  %-15s   %-15s\n", studentList.get(i).getStudentName(),
                        studentList.get(i).getSemester(), studentList.get(i).getCourseName());
            }
        }
        if (!isExisted) {
            System.out.printf("Name : %s not existed.\n", Name);
        }
    }
    
    public void Sort() {
        Collections.sort(studentList, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        } );
    }

    public void Update(String ID, String Name1 , int Semester1, String CourseName1, String Name, int Semester, String CourseName) {
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getID().equals(ID)&& studentList.get(i).getStudentName().equalsIgnoreCase(Name1)
                    && studentList.get(i).getCourseName().equalsIgnoreCase(CourseName1) && studentList.get(i).getSemester() == Semester1) {
                if (Name != null) {
                    studentList.get(i).setStudentName(Name);
                }
                if (Semester != 0) {
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

    public void Remove(String ID, String Name, String CourseName, int Semester) {
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            if (studentList.get(i).getID().equals(ID) && studentList.get(i).getStudentName().equals(Name) &&
                    studentList.get(i).getCourseName().equals(CourseName) && studentList.get(i).getSemester() == Semester) {
                studentList.remove(studentList.get(i));
                break;
            }
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
        studentsList2.removeAll(studentsList2);
    }

    public void DisplayReport() {
        System.out.printf("%-25s%-13s%-15s\n", "Student name",
                "Course name", "Total course");
        for (int z = 0; z < studentsList2.size(); z++) {
            System.out.printf("%-25s  %-15s%-20d\n", studentsList2.get(z).getStudentsName(),
                    studentsList2.get(z).getCourseName(), studentsList2.get(z).getTotalCourse());
        }
    }

    public void Display() {
        System.out.printf("%-10s%-25s%-15s%-15s\n", "ID", "Student name",
                "semester", "Course Name");
        for (Students students : studentList) {
            System.out.printf("%-10s  %-25s  %-15s   %-15s\n", students.getID(), students.getStudentName(),
                    students.getSemester(), students.getCourseName());
        }
    }

    public void SearchUpdate(String ID) {

        boolean isExisted = false;
        int size = studentList.size();
        int i,stt;;
        for (i = 0; i < size; i++) {
            if (studentList.get(i).getID().contains(ID)) {
                isExisted = true;
                if (ListUpdate.isEmpty()) {
                    stt = 1;
                } else {
                    int lastIndex = ListUpdate.size() - 1;
                    int lastId = ListUpdate.get(lastIndex).getStt();
                    stt = lastId + 1;
                }
                Students students = new Students(stt,studentList.get(i).getID(), studentList.get(i).getStudentName(),
                        studentList.get(i).getSemester(), studentList.get(i).getCourseName());
                ListUpdate.add(students);
            }
        }
        if (!isExisted) {
            System.out.printf("ID : %s not existed.\n", ID);
        }
        for(Students students : ListUpdate){
            System.out.printf("%-4d : %-10s  %-25s  %-15s   %-15s\n", students.getStt(),students.getID(), students.getStudentName(),
                    students.getSemester(), students.getCourseName());
        }
    }

    public void CleanListUpdate(){
            ListUpdate.removeAll(ListUpdate);
    }
    
}
