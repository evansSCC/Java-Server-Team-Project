package data;


import data.Course;
import java.util.LinkedHashMap;

public class Student {
    private LinkedHashMap<String, Course> courses =  new LinkedHashMap<String, Course>();
    //this will link to the pcWeb and integrated field. if true get courses for focus.
    private boolean pcWeb = false, integrated = false;
    private String firstName, lastName;
    private int studentID;

    public Student(){};
    
    public Student(String firstName, String lastName, int studentID, boolean pcWeb, boolean integrated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.pcWeb = pcWeb;
        this.integrated = integrated;
    }

    public LinkedHashMap<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(LinkedHashMap<String, Course> courses) {
        this.courses = courses;
    }

    public boolean isPcWeb() {
        return pcWeb;
    }

    public void setPcWeb(boolean pcWeb) {
        this.pcWeb = pcWeb;
    }

    public boolean isIntegrated() {
        return integrated;
    }

    public void setIntegrated(boolean integrated) {
        this.integrated = integrated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    
}
