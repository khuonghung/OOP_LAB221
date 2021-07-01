/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.util.Comparator;
/**
 *
 * @author Khuong Hung
 */
public class SortEmployeeById implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getId().compareTo(employee2.getId());
    }
}
