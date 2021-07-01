package Employee;

import java.util.*;

/**
 *
 * @author Khuong Hung
 */
public class EmployeeManager {

    ArrayList<Employee> employeeList = new ArrayList<>();

    public void add(String Id,String firstName, String lastName,String Phone,String Email,String Address,String DOB,String Sex,int Salary,String Egency) {
            Employee employee = new Employee(Id, firstName, lastName, Phone, Email, Address, DOB, Sex,
                    Salary, Egency);
            System.out.println("Information of employee has been added!");
            employeeList.add(employee);
    }

    public void search(String Name) {
        boolean isExisted = false;
        int i;
        String fullname;
        int size = employeeList.size();
        for (i = 0; i < size; i++) {
            if (employeeList.get(i).getFirstName().contains(Name) || employeeList.get(i).getLastName().contains(Name)) {
                System.out.println("Information of employee : ");
                System.out.println(" ID       |          Name        |   Sex   |       Phone      "
                        + "|               Email              |              Address             "
                        + "|      DOB      |   Salary   |  Egency ");
            }
            break;
        }
        for (i = 0; i < size; i++) {
            while (employeeList.get(i).getFirstName().contains(Name) || employeeList.get(i).getLastName().contains(Name)) {
                isExisted = true;
                System.out.printf("%3s%23s %s%13s%18s%35s%28s%25s%14d%10s\n", employeeList.get(i).getId(), employeeList.get(i).getFirstName(),
                        employeeList.get(i).getLastName(), employeeList.get(i).getSex(), employeeList.get(i).getPhone(), employeeList.get(i).getEmail(), employeeList.get(i).getAddress(),
                        employeeList.get(i).getDOB(), employeeList.get(i).getSalary(), employeeList.get(i).getEgency());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Name : %s not existed.\n", Name);
        }
    }

    public void remove(String Id) {
        Employee employee = null;
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId().equals(Id)) {
                employee = employeeList.get(i);
                break;
            }
        }
        if (employee != null) {
            employeeList.remove(employee);
            System.out.println("Information has been deleted!");

        } else {
            System.out.printf("id = %s not existed.\n", Id);
        }
    }

    public void sortEmployeeById() {
        Collections.sort(employeeList, new SortEmployeeById());
        System.out.println("Information of employee has been update !");
    }

    public void show() {
        System.out.println(" ID       |          Name        |   Sex   |       Phone      "
                + "|               Email              |              Address             "
                + "|      DOB      |   Salary   |  Egency ");
        for (Employee employee : employeeList) {
            System.out.printf("%3s%23s %s%13s%18s%35s%28s%25s%14d%10s\n", employee.getId(), employee.getFirstName(),
                    employee.getLastName(), employee.getSex(), employee.getPhone(), employee.getEmail(), employee.getAddress(),
                    employee.getDOB(), employee.getSalary(), employee.getEgency());
        }

    }

    public void update(String id, String firstName, String lastName, String phone, String email, String address, String DOB, String sex, int salary, String egency) {
        boolean isExisted = false;
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId().equals(id)) {
                isExisted = true;
                employeeList.get(i).setFirstName(id);
                employeeList.get(i).setLastName(firstName);
                employeeList.get(i).setId(lastName);
                employeeList.get(i).setPhone(phone);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setAddress(address);
                employeeList.get(i).setDOB(DOB);
                employeeList.get(i).setSex(sex);
                employeeList.get(i).setSalary(salary);
                employeeList.get(i).setEgency(egency);
                break;
            }
        }
    }

}
