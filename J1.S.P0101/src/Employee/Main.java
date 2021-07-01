package Employee;

import java.util.Scanner;

/**
 *
 * @author Khuong Hung
 */
public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        int size;
        EmployeeManager employeeManager = new EmployeeManager();
        String employeeId;
        String employeeName;
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    boolean isExisted = false;
                    size = employeeManager.employeeList.size();
                    String ID = Validate.inputId();
                    for (int i = 0; i < size; i++) {
                        if (employeeManager.employeeList.get(i).getId().equals(ID)) {
                            isExisted = true;
                            System.out.printf("Employee ID : %s is already available !\n", ID);
                            break;
                        }
                    }
                    if (!isExisted) {
                        String firstName = Validate.inputFirstName();
                        String lastName = Validate.inputLastName();
                        String Phone = Validate.inputPhone();
                        String Email = Validate.inputEmail();
                        String Address = Validate.inputAddress();
                        String DOB = Validate.inputDOB();
                        String Sex = Validate.inputSex();
                        int Salary = Validate.inputSalary();
                        String Egency = Validate.inputEgency();
                        employeeManager.add(ID, firstName, lastName, Phone, Email, Address, DOB, Sex, Salary, Egency);
                    }
                    break;

                case "2":
                    boolean Existed = false;
                    String id2 = Validate.inputId();
                    size = employeeManager.employeeList.size();
                    for (int i = 0; i < size; i++) {
                        if (employeeManager.employeeList.get(i).getId().equals(id2)) {
                            Existed = true;
                            String id = Validate.inputId();
                            String firstName = Validate.inputFirstName();
                            String lastName = Validate.inputLastName();
                            String Phone = Validate.inputPhone();
                            String Email = Validate.inputEmail();
                            String Address = Validate.inputAddress();
                            String DOB = Validate.inputDOB();
                            String Sex = Validate.inputSex();
                            int Salary = Validate.inputSalary();
                            String Egency = Validate.inputEgency();
                            employeeManager.update(id, firstName, lastName, Phone, Email, Address, DOB, Sex, Salary, Egency);
                            break;
                        }
                    }
                    if (!Existed) {
                        System.out.printf("Id = %s not existed.\n", id2);
                    }
                    break;

                case "3":
                    employeeId = Validate.inputId();
                    employeeManager.remove(employeeId);
                    break;
                case "4":
                    employeeName = Validate.inputName();
                    employeeManager.search(employeeName);
                    break;
                case "5":
                    employeeManager.sortEmployeeById();
                    break;
                case "6":
                    employeeManager.show();
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
        System.out.println("==============================");
        System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");
        System.out.println("==============================");
        System.out.println("--------------menu----------");
        System.out.println("1. Add employees.");
        System.out.println("2. Update employees.");
        System.out.println("3. Remove employees.");
        System.out.println("4. Search employees. ");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Show data.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

}
