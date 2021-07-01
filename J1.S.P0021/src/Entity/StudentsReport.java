/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Khuong Hung
 */
public class StudentsReport {

    private String studentsName;
    private String courseName;
    private int totalCourse;

    public StudentsReport() {
    }

    public StudentsReport(String studentsName, String courseName, int totalCourse) {
        this.studentsName = studentsName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
}
