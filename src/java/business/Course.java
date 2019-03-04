/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author es555691
 */
public class Course {

    private String courseID = "", courseName = "";
    private String pcWeb = "";
    private String integrated = "";
    private String type = "";
    int ID = 0;
    float creditHours = 0;

    public Course(){};
    
    public Course(String courseID, String courseName, String pcWeb, String integrated, String type, int ID, float creditHours) {
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

    public String getPcWeb() {
        return pcWeb;
    }

    public void setPcWeb(String pcWeb) {
        this.pcWeb = pcWeb;
    }

    public String getIntegrated() {
        return integrated;
    }

    public void setIntegrated(String integrated) {
        this.integrated = integrated;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(float creditHours) {
        this.creditHours = creditHours;
    }
    
    
    
}
