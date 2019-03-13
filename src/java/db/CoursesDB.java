package db;

import java.sql.*;
import data.Course;
import data.Plan;
import data.Student;
import java.time.LocalDate;
import java.util.ArrayList;
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
                    + "WHERE (pcWeb = 'R' OR pcWeb = 'E') " 
                    + "AND type = 'Q';";
        } else if (option.equals("integrated")) {
            query = "SELECT * FROM courses "
                    + "WHERE (integrated = 'R' OR integrated = 'E') "
                    + "AND type = 'Q';";
        }
        try {
            ps = connection.prepareStatement(query);
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

//Database Admin Methods

//Get Sorted List of Plans

public static LinkedHashMap<String, Plan> getPlanList (String sortOption, String sortOrder) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedHashMap<String, Plan> plansList = new LinkedHashMap();
       
        String query = "SELECT * FROM studentplans ORDER BY ? ?;";
        
        try {
            Student s = new Student();
            Plan p = new Plan();
            ps = connection.prepareStatement(query);
            ps.setString(1, sortOption);
            ps.setString(2, sortOrder);
            rs = ps.executeQuery();
            if (rs.next()){
                String planDate = rs.getDate("planDate").toString();
                s.setFirstName(rs.getString("fName"));
                s.setLastName(rs.getString("lName"));
                s.setStudentID(rs.getInt("StudentID"));
                if(rs.getString("focus").equals("pcweb")){
                    s.setPcWeb(true);
                }
                else if(rs.getString("focus").equals("integrated")){
                    s.setIntegrated(true);
                }
//                else if(rs.getString("focus").equals("networking")){
//                    s.setNetworking(true);
//                }
//                else if(rs.getString("focus").equals("support")){
//                    s.setSupport(true);
//                }
                p.setPlanID(rs.getInt("planID"));
                p.setStudent(s);
                plansList.put(planDate, p);
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

//See All Comments By Plan
public static LinkedHashMap<String, String> getPlanComments (int planID) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedHashMap<String, String> comments = new LinkedHashMap();
       
        String query = "SELECT users.fName, users.lName, plancomments.Comment " +
                "FROM users "
                + "JOIN planComments ON users.adminID=planComments.adminID WHERE planComments.planID = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, planID);
            rs = ps.executeQuery();
            if (rs.next()){
                String comment = rs.getString("comment");
                String adminName = rs.getString("fName") + " " + rs.getString("lName");
                comments.put(adminName, comment);
            }
             return comments;   
        }catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(pool != null){pool.freeConnection(connection);}
        }
        
}

    
    public static Course getCourseByCourseId (String courseID) throws Exception {
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = new Course();
        
        String query = "SELECT * FROM courses WHERE courseID = ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, courseID);
            rs = ps.executeQuery();
            if (rs.next()) {
                course.setCourseID(courseID);
                course.setCourseName(rs.getString("courseName"));
                course.setCreditHours(rs.getFloat("creditHours"));
                course.setType(rs.getString("type"));
                course.setID(rs.getInt("ID"));
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
