/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Khuong Hung
 */
public class TaskManager {

    ArrayList<Task> taskList = new ArrayList<>();

    public int add(String requirementName, String assignee,
            String reviewer, String taskTypeID, String date,
            double planFrom, double planTo) {
        int ID;
        if (taskList.isEmpty()) {
            ID = 1;
        } else {
            int lastIndex = taskList.size() - 1;
            int lastId = taskList.get(lastIndex).getID();
            ID = lastId + 1;
        }
        Task task = new Task(ID, requirementName, assignee, reviewer, taskTypeID, date, planFrom, planTo);
        System.out.println("Information of task has been added!");
        taskList.add(task);
        return ID;
    }

    public void remove(int ID) {
        int i;
        Task task = null;
        int size = taskList.size();
        for (i = 0; i < size; i++) {
            if (taskList.get(i).getID() == ID) {
                task = taskList.get(i);
                break;
            }
        }
        if (task != null) {
            taskList.remove(task);
            System.out.println("Information has been deleted!");
        } else {
            System.out.printf("id = %s not existed.\n", ID);
        }
    }

    public void Display() {
        System.out.println("----------------------------------------- Task ---------------------------------------\n");
        System.out.printf("%-5s%-20s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : taskList) {
            System.out.printf("%-5d%-20s  %-15s%-15s%-15.1f%-15s %-15s\n",
                    task.getID(), task.getRequirementName(), task.getTaskTypeID(),
                    task.getDate(), Validate.Time(task.getPlanFrom(), task.getPlanTo()),
                    task.getAssignee(), task.getReviewer());
        }
    }

    public void showMenu() {
        System.out.println();
        System.out.println("========Task Program=======");
        System.out.println("1. Add.");
        System.out.println("2. Delete.");
        System.out.println("3. Display");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

}
