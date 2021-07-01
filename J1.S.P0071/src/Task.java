

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khuong Hung
 */
public class Task {
    private int ID;
    private String requirementName;
    private String Assignee;
    private String Reviewer;
    private String taskTypeID;
    private String Date;
    private double planFrom;
    private double planTo;

    public Task() {
    }

    public Task(int ID, String requirementName, String Assignee, String Reviewer, String taskTypeID, String Date, double planFrom, double planTo) {
        this.ID = ID;
        this.requirementName = requirementName;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
        this.taskTypeID = taskTypeID;
        this.Date = Date;
        this.planFrom = planFrom;
        this.planTo = planTo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }
    
    


    
    
    
}

 