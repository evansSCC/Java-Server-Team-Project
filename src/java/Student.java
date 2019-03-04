
import data.Course;
import java.util.ArrayList;

public class Student {
    private ArrayList<Course> courses =  new ArrayList<Course>();
    //this will link to the pcWeb and integrated field. if true get courses for focus.
    private boolean pcWeb = false, integrated = false;
    private String firstName, lastName;
    private int studentID;
}
