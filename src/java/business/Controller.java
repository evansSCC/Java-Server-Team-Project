/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.Course;
import data.Student;
import db.CoursesDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author es555691
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String url = "/worksheet.jsp";

        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "default":
                url = "/studentInfo.jsp";
                break;
            case "initialize_user":
                String firstName = request.getParameter("first_name");
                String lastName = request.getParameter("last_name");
                String studentID = request.getParameter("student_id");
                int parsedID = 0;
                boolean pcWeb = false;
                boolean integrated = false;
                String focus = request.getParameter("focus");
                boolean valid = true;
                Student student;
                LinkedHashMap<String, Course> courses = new LinkedHashMap<String, Course>();
                HashMap<String, String> errors = new HashMap<String, String>();

                //validate that a focus was selected
                if (focus != null && focus.equals("pcWeb")) {
                    pcWeb = true;
                } else if (focus != null && focus.equals("integrated")) {
                    integrated = true;
                } else {
                    valid = false;
                    errors.put("focus", "Please select a focus to continue.");
                }
                //validate names
                if (firstName.equals("") || firstName.isEmpty()) {
                    valid = false;
                    errors.put("first_name", "Please enter a first name to continue.");
                }
                if (lastName.equals("") || lastName.isEmpty()) {
                    valid = false;
                    errors.put("last_name", "Please enter a last name to continue.");
                }
                //validate studentID
                if (studentID.equals("") || studentID.isEmpty()) {
                    valid = false;
                    errors.put("student_id", "Please enter a student ID to continue.");
                } else if (valid) {
                    try {
                        parsedID = Integer.parseInt(studentID);
                        student = new Student(firstName, lastName, parsedID, pcWeb, integrated);
                        session.setAttribute("student", student);
                        session.setAttribute("name", firstName + " " + lastName);
                        session.setAttribute("studentID", studentID);
                        if (pcWeb == true) {
                            try {
                                courses = CoursesDB.getCourseList("pcWeb");
                                request.setAttribute("courses", courses);
                                session.setAttribute("courses", courses);
                            } catch (Exception ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if (integrated == true) {
                            try {
                                courses = CoursesDB.getCourseList("integrated");
                                request.setAttribute("courses", courses);
                                session.setAttribute("courses", courses);
                            } catch (Exception ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        url = "/worksheet.jsp";
                    } catch (NumberFormatException e) {
                        valid = false;
                        errors.put("student_id", "Please enter a valid integer for studentID");
                    }
                }
                if (!valid) {
                    url = "/studentInfo.jsp";
                    request.setAttribute("errors", errors);
                }
                break;
            case "process_worksheet":
                student = (Student) session.getAttribute("student");
                LinkedHashMap<String, Course> coursesNeeded = new LinkedHashMap<String, Course>();
                LinkedHashMap<String, Course> coursesTaken = new LinkedHashMap<String, Course>();
                String[] values = (String[]) request.getParameterValues("completed");
                //LinkedHashMap<String, Course> coursesTaken = new LinkedHashMap<String, Course>();
                LinkedHashMap<String, Course> allCourses = (LinkedHashMap) session.getAttribute("courses");

                //creates list of courses not taken
                for (String c : values) {
                    if (allCourses.containsKey(c)) {
                        allCourses.remove(c);
                    }
                    try {
                        coursesTaken.put(c, CoursesDB.getCourseByCourseId(c));
                    } catch (Exception e) {

                    }
                }

                //semester
                if (!coursesTaken.containsKey("INFO1121") || !coursesTaken.containsKey("INFO1131") || !coursesTaken.containsKey("INFO1211")) {
                    try {
                        coursesNeeded.put("BSADIOIO", CoursesDB.getCourseByCourseId("BSADIOIO"));
                    } catch (Exception e) {

                    }
                }
                if (!coursesTaken.containsKey("INFO1221") || !coursesTaken.containsKey("INFO1428")) {
                    try {
                        coursesNeeded.put("INFO1428", CoursesDB.getCourseByCourseId("INFO1428"));
                    } catch (Exception e) {

                    }
                }
                if (!coursesTaken.containsKey("INFO1314") || !coursesTaken.containsKey("INFO1414")) {
                    try {
                        coursesNeeded.put("INFO1414", CoursesDB.getCourseByCourseId("INFO1414"));
                    } catch (Exception e) {

                    }
                }
                if (!coursesTaken.containsKey("INFO1334") || !coursesTaken.containsKey("INFO1434")) {
                    try {
                        coursesNeeded.put("INFO1434", CoursesDB.getCourseByCourseId("INFO1434"));
                    } catch (Exception e) {

                    }
                }

                if (!coursesTaken.containsKey("INFO2544") || !coursesTaken.containsKey("INFO2644")) {
                    try {
                        coursesNeeded.put("INFO2644", CoursesDB.getCourseByCourseId("INFO2644"));
                    } catch (Exception e) {

                    }
                }

                if (!coursesTaken.containsKey("INFO2558") || !coursesTaken.containsKey("INFO2638")) {
                    try {
                        coursesNeeded.put("INFO2638", CoursesDB.getCourseByCourseId("INFO2638"));
                    } catch (Exception e) {

                    }
                }

                if (!coursesTaken.containsKey("INFO2544") || !coursesTaken.containsKey("INFO2644")) {
                    try {
                        coursesNeeded.put("INFO2644", CoursesDB.getCourseByCourseId("INFO2644"));
                    } catch (Exception e) {

                    }
                }
                url = "/output.jsp";

                session.setAttribute("coursesQuarter", allCourses);
                session.setAttribute("coursesSemester", coursesNeeded);
                session.setAttribute("coursesCompleted", coursesTaken);
        }

        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

//Admin Database sort/comment methods - insert where appropriate
//List of plans
//String sortOption = request.getParameter("sortOption");
//String sortOrder = request.getParameter("sortOrder");
//LinkedHashMap<String, Plan> plansList = getPlanList(sortOption, sortOrder);
//request.setAttribute("planList", plansList);
//Get Comments By Plan ID
//int planID = request.getParameter("planID");
//LinkedHashMap<String, String> comments = getPlanComments(planID);
//request.setAttribute("comments", comments);
