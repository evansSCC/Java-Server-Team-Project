/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        String action = request.getParameter("action");
        String url = "/worksheet.jsp";
        
        if(action == null)
        {
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
                HashMap<String, String> errors = new HashMap();
                
                //validate that a focus was selected
                if(focus != null && focus.equals("pcWeb")){
                    pcWeb = true;
                } else if(focus != null  && focus.equals("integrated")) {
                    integrated = true;
                } else {
                    valid = false;
                    errors.put("focus", "Please select a focus to continue.");
                }
                //validate names
                if(firstName.equals("") || firstName.isEmpty()){
                    valid = false;
                    errors.put("first_name", "Please enter a first name to continue.");
                }if(lastName.equals("") || lastName.isEmpty()){
                    valid = false;
                    errors.put("last_name", "Please enter a last name to continue.");
                }
                //validate studentID
                if(studentID.equals("") || studentID.isEmpty()){
                    valid = false;
                    errors.put("student_id", "Please enter a student ID to continue.");
                } else if(valid){
                    try{
                        parsedID = Integer.parseInt(studentID);
                        student = new Student(firstName, lastName, parsedID, pcWeb, integrated);
                        url = "/worksheet.jsp";
                    } catch(NumberFormatException e) {
                        valid = false;
                        errors.put("student_id", "Please enter a valid integer for studentID");
                    }
                }
                
                if(!valid){
                    request.setAttribute("errors", errors);
                }
                
                
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
