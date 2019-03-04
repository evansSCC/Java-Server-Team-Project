/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author es555691
 */
public class Course {

    private String courseID = "", courseName = "";
    char pcWeb = 'a', integrated='a', type='a';
    int ID = 0;
    float creditHours = 0;

    public Course(){};
    
    public Course(String courseID, String courseName, char pcWeb, char integrated, char type, int ID, float creditHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.pcWeb = pcWeb;
        this.integrated = integrated;
        this.type = type;
        this.ID = ID;
        this.creditHours = creditHours;
    }
    
    
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public char getPcWeb() {
        return pcWeb;
    }

    public void setPcWeb(char pcWeb) {
        this.pcWeb = pcWeb;
    }

    public char getIntegrated() {
        return integrated;
    }

    public void setIntegrated(char integrated) {
        this.integrated = integrated;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
