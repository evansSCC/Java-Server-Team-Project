/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.LinkedHashMap;

/**
 *
 * @author rg305912
 */
public class Plan {
    
    int planID;
    Student student;
    LinkedHashMap<String, Course> neededCourses;

    public Plan() {
    }

    public Plan(int planID, Student student, LinkedHashMap<String, Course> neededCourses) {
        this.planID = planID;
        this.student = student;
        this.neededCourses = neededCourses;
    }


    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public LinkedHashMap<String, Course> getNeededCourses() {
        return neededCourses;
    }

    public void setNeededCourses(LinkedHashMap<String, Course> neededCourses) {
        this.neededCourses = neededCourses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
}
