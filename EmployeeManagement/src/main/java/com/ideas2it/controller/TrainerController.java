package com.ideas2it.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.ideas2it.model.Trainer;
import com.ideas2it.service.EmployeeService;

/**
 * Servlet implementation class TrainerController
 */
public class TrainerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService = new EmployeeService();

    /**
     * 
     * it is used to get request and response
     * 
     * @param request, response
     * @return void
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 
     * it is used to send response
     * 
     * @param request, response
     * @return void
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("flag");

        switch (action) {
        case "insertTrainer":
            insertTrainer(request, response);
            break;
        case "ViewAllTrainer":
            viewAllTrainer(request, response);
            break;
        case "deleteTrainer":
            deleteTrainer(request, response);
            break;
        }
    }

    /**
     * 
     * add trainer details to trainer object
     * 
     * @param request, response
     * @return void
     */
    public void insertTrainer(HttpServletRequest request, HttpServletResponse response) {

        int id = 0;

        String name = request.getParameter("name");
        String bloodGroup = request.getParameter("bloodGroup");

        String date = request.getParameter("dateOfBirth");
        date = employeeService.reverseDate(date);
        Date dateOfBirth = Date.valueOf(date);

        String designation = request.getParameter("designation");

        String gender = request.getParameter("gender");

        String number = request.getParameter("phoneNumber");
        long phoneNumber = Long.parseLong(number);

        String email = request.getParameter("email");

        String trainerId = "0";

        String year = request.getParameter("trainingSince");
        int trainingSince = Integer.parseInt(year);

        Trainer trainer = new Trainer(id, name, bloodGroup, designation,
                dateOfBirth, gender, phoneNumber, email, trainerId, trainingSince);

        id = employeeService.insertTrainer(trainer);
    }

    /**
     * 
     * shows all trainers
     * 
     * @param request, response
     * @return void
     */
    public void viewAllTrainer(HttpServletRequest request, HttpServletResponse response) {
        List<Trainer> trainers = employeeService.viewAllTrainer();
        request.setAttribute("trainers", trainers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTrainers.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 
     * delete trainer
     * 
     * @param request, response
     * @return void
     */
    public void deleteTrainer(HttpServletRequest request, HttpServletResponse response) {
        String identifiacation = request.getParameter("id");
        int id = Integer.parseInt(identifiacation);
        employeeService.deleteTraineeById(id);
    }

}