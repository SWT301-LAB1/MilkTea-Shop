/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDBContext;
import dal.ProductDBContext;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/category"})
public class CategoryController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             int categoryId = Integer.parseInt(request.getParameter("categoryId"));

            List<Product> listProducts = new ProductDBContext().getProductsByCategoryId(categoryId);
            List<Category> listCategories = new CategoryDBContext().getAllCategories();
            request.setAttribute("listCategories", listCategories);
            request.setAttribute("listProducts", listProducts);
            request.setAttribute("tag", categoryId);
            request.getRequestDispatcher("home.jsp").forward(request, response);
         

        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
