/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author NCC
 */
@WebServlet(name = "DeleteCategory", urlPatterns = {"/DeleteCategory"})
public class DeleteCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("acc") != null) {
             String cId = request.getParameter("cId");
            CategoryDBContext categoryDBContext = new CategoryDBContext();
            try {
                categoryDBContext.deleteCategory(Integer.parseInt(cId));
            } catch (Exception e) {
            }
            response.sendRedirect("managerCategory");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // This method is not needed because the deletion of categories is handled in the doGet method.
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
