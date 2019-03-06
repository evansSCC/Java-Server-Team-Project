
package db;

import java.sql.*;
import data.Course;
import data.Student;
import java.time.LocalDate;
import java.util.LinkedHashMap;

/**
 *
 * @author rg305912
 */
public class CoursesDB {

public static LinkedHashMap getCourseList(String option) throws Exception{
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedHashMap allCourses = new LinkedHashMap();
        String query = "SELECT * FROM courses " +
                        "WHERE ? = 'r' OR ? = 'e' ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, option);
            ps.setString(2, option);
            rs = ps.executeQuery();
            Course course = null;
            if (rs.next()){
                course = new Course();
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setType(rs.getString("type"));
                course.setCreditHours(rs.getFloat("creditHours"));
                course.setIntegrated(rs.getString("integrated"));
                course.setPcWeb(rs.getString("pcWeb"));
                allCourses.put(course.getCourseID(), course);
            }
            
           return allCourses;
        }
         catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
    }

public static LinkedHashMap searchPlansByStudentID (Student student) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedHashMap plansList = new LinkedHashMap();
        String query = "SELECT planID, Plandate FROM studentPlans " +
                "WHERE studentID = ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, student.getStudentID());
            rs = ps.executeQuery();
            if (rs.next()){
                plansList.put(rs.getString("Plandate"), rs.getInt("planID"));
            }
            return plansList;
        }catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
}

public static int addStudentPlan (Student student) throws Exception {
 ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
       
        String query = "INSERT INTO studentplans (studentID, fName, lName, PlanDate) " +
                "VALUES (?, ?, ?, NOW());" +
                
                "SELECT LAST_INSERT_ID() from StudentPlans " +
                        "WHERE studentID = ?; ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, student.getStudentID());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
}

public static int getPlanID(Student student) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT LAST_INSERT_ID() from StudentPlans " +
                        "WHERE studentID = ?; ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, student.getStudentID());
            rs = ps.executeQuery();
            int planID = rs.getInt(1);
            return planID;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
}

public static int addCourseToPlan(Course course, int PlanID) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO planData (ID, PlanID) " +
                        "VALUES (?, ?);";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, course.getID());
            ps.setInt(2, PlanID);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
}

public static Course getCourseById (int ID) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = new Course();
        
        String query = "SELECT * FROM courses WHERE id = ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                course.setID(ID);
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setCreditHours(rs.getFloat("creditHours"));
                course.setType(rs.getString("type"));
                course.setIntegrated(rs.getString("integrated"));
                course.setPcWeb(rs.getString("pcWeb"));  
            }
            return course;
        }
        catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
    }
    
    
}
