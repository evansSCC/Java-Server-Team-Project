package business;


import business.Course;
import java.util.ArrayList;

public class Student {
    private ArrayList<Course> courses =  new ArrayList<Course>();
    //this will link to the pcWeb and integrated field. if true get courses for focus.
    private boolean pcWeb = false, integrated = false;
    private String firstName, lastName;
    private int studentID;

    public Student() {
    }

    public Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
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
