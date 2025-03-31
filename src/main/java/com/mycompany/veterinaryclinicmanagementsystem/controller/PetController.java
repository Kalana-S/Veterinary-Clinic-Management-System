package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.PetDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Pet;
import com.mycompany.veterinaryclinicmanagementsystem.service.PetService;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/pets")
public class PetController extends HttpServlet {
    private PetService petService;

    @Override
    public void init() throws ServletException {
        Connection connection = DatabaseConnection.getConnection();
        petService = new PetService(new PetDAO(connection));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ownerId = Integer.parseInt(request.getParameter("ownerId"));
        try {
            List<Pet> pets = petService.getPetsByOwner(ownerId);
            request.setAttribute("pets", pets);
            request.getRequestDispatcher("pets.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String type = request.getParameter("type");
        int ownerId = Integer.parseInt(request.getParameter("ownerId"));

        Pet pet = new Pet(0, name, age, type, ownerId);
        try {
            petService.registerPet(pet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("pets?ownerId=" + ownerId);
    }
}