/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Students;
import java.util.Comparator;

/**
 *
 * @author Khuong Hung
 */
public class SortStudentByName implements Comparator<Students> {

    @Override
    public int compare(Students students1, Students students2) {
        return students1.getStudentName().compareTo(students2.getStudentName());
    }
}
