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
import java.util.LinkedHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rg305912
 */
public class DBTest extends HttpServlet {

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
            String message = "";
            String url="/test.jsp";
            int id = 0;
            Student test = new Student("John", "Doe", 123456, true, false);
            Course course = new Course("INFO1131", "Microsoft Excel", "R", "R", "Q", 2, 1.5, "INFO1131");
            
            try{
                LinkedHashMap getAll = CoursesDB.getCourseList("pcWeb");
                message += "GetAll Success <br>";
        } catch (Exception e) {
            message += "GetAll Error <br>";
        }
            try {
              id = CoursesDB.addStudentPlan(test);
               
               message +="addStudentPlan success. Last ID: " + id + " <br>";
            } catch (Exception e){
                message += "addStudentPlan error <br>";
            }
            
            try {
                LinkedHashMap studentCoures = CoursesDB.searchPlansByStudentID(test);
                message += "searchbyId success <br>";
            } catch (Exception e) {
                message += "searchByID error <br>";
            }
                  
            
            try { 
                CoursesDB.addCourseToPlan(course, id);
                message +="AddCourseToPlan success <br>"; 
            } catch (Exception e) {
                message +="AddCourseToPlan error <br>";
            }
            request.setAttribute("message", message);
            ServletContext sc = getServletContext();
            
            sc.getRequestDispatcher(url).forward(request, response);
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
