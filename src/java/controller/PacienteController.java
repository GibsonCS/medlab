/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PacienteDAO;
//import jakarta.servlet.RequestDispatcher;
//import java.io.IOException;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import model.Paciente;
import com.google.gson.Gson;

/**
 *
 * @author Gibson
 */
@WebServlet(name = "PacienteController", urlPatterns = {"/pacientes"})
public class PacienteController extends HttpServlet {
    
    private PacienteDAO pacienteDAO;

    @Override
    public void init() {
        this.pacienteDAO = new PacienteDAO();
    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
       List<Paciente> pacientes = this.pacienteDAO.findAll();
      
       Gson gson = new Gson();
       
       String json = gson.toJson(pacientes);
              
       request.setAttribute("pacientes", json);
        
       String path = "/pacientes.jsp";
        
       RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        
        dispatcher.forward(request, response);
    }

 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    try {
        getUsers(request, response);
    } catch (SQLException ex) {
        throw new ServletException("Erro ao buscar pacientes", ex);
    }
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
}
