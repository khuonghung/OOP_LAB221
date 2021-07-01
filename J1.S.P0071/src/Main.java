/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Khuong Hung
 */

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose;
        boolean exit = false;
        TaskManager taskManager = new TaskManager();
        int tastID;
        int ID;

        taskManager.showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("========= Add Task =========");
                    String requirementName = Validate.inputRequirementName();
                    String assignee = Validate.inputAssignee();
                    String reviewer = Validate.intputReviewer();
                    String taskTypeID = Validate.inputTypeID();
                    String date = Validate.inputDate();
                    double planFrom = Validate.inputPlanFrom();
                    double planTo = Validate.inputPlanTo(planFrom);
                    taskManager.add(requirementName, assignee, reviewer, taskTypeID, date, planFrom, planTo);
                    break;
                case "2":
                    System.out.println("========= Delete Task =========");
                    tastID = Validate.inputID();
                    taskManager.remove(tastID);
                    break;
                case "3":
                    taskManager.Display();
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
            taskManager.showMenu();
        }
    }

}
