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

    public static LinkedHashMap<String, Course> getCourseList(String option) throws Exception {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedHashMap<String, Course> allCourses = new LinkedHashMap<String, Course>();
        String query = "";
        if (option.equals("pcWeb")) {
            query = "SELECT * FROM courses "
                    + "WHERE pcWeb = 'R' OR pcWeb = 'E'";
        } else if (option.equals("integrated")) {
            query = "SELECT * FROM courses "
                    + "WHERE integrated = 'R' OR integrated = 'E'";
        }
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, option);
            ps.setString(2, option);
            rs = ps.executeQuery();
            Course course = null;
            while (rs.next()) {
                course = new Course();
                course.setID(rs.getInt("ID"));
                course.setCourseID(rs.getString("courseID"));
                course.setCourseName(rs.getString("courseName"));
                course.setType(rs.getString("type"));
                course.setCreditHours(rs.getFloat("creditHours"));
                course.setIntegrated(rs.getString("integrated"));
                course.setPcWeb(rs.getString("pcWeb"));
                allCourses.put(rs.getString("courseID"), course);
            }

            return allCourses;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if (pool != null) {
                pool.freeConnection(connection);
            }
        }
    }

    public static LinkedHashMap searchPlansByStudentID(Student student) throws Exception {
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
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if (pool != null) {
                pool.freeConnection(connection);
            }
        }
    }

    public static int addStudentPlan(Student student) throws Exception {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        ResultSet rs = null;
        PreparedStatement psinsert = null;
        PreparedStatement psquery = null;
        int planID = 10;
       
        String insert = "INSERT INTO studentplans (studentID, fName, lName, PlanDate) " +
                "VALUES (?, ?, ?, NOW());";
                
        String query = "SELECT LAST_INSERT_ID() from StudentPlans;";
        
        try {
            psinsert = connection.prepareStatement(insert);
            psinsert.setInt(1, student.getStudentID());
            psinsert.setString(2, student.getFirstName());
            psinsert.setString(3, student.getLastName());
            psinsert.executeUpdate();
            psquery = connection.prepareStatement(query);
            rs = psquery.executeQuery();
            if(rs.next()){
                planID = rs.getInt("LAST_INSERT_ID()");
            }
            return planID;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(psinsert);
            DBUtil.closePreparedStatement(psquery);
            if (pool != null) {
                pool.freeConnection(connection);
            }
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
            if (pool != null) {
                pool.freeConnection(connection);
            }
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
