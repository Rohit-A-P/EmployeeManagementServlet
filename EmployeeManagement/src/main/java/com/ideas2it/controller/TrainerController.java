package com.ideas2it.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ideas2it.model.Trainer;
import com.ideas2it.service.EmployeeService;

/**
 * Servlet implementation class TrainerController
 */
public class TrainerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmployeeService employeeService = new EmployeeService();
    private Logger logger = LogManager.getLogger(TrainerController.class);  

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
        case "viewTrainers":
            viewTrainers(request, response);
            break;
        case "updateTrainer":
            updateTrainer(request, response);
            break;            
        case "deleteTrainer":
            deleteTrainer(request, response);
            break;
        case "getTrainerById":
            getTrainerById(request, response);
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
        Date dateOfBirth = Date.valueOf(date);

        String designation = request.getParameter("desgination");

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
        viewTrainers(request, response);
    }

    /**
     * 
     * shows all trainers
     * 
     * @param request, response
     * @return void
     */
    public void viewTrainers(HttpServletRequest request, HttpServletResponse response) {
        List<Trainer> trainers = employeeService.viewAllTrainer();
        request.setAttribute("trainerList", trainers);
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
     * update trainer 
     * 
     * @param request, response
     * @return void
     */
    public void updateTrainer(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String bloodGroup = request.getParameter("bloodGroup");

        String date = request.getParameter("dateOfBirth");
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

       employeeService.updateTrainerById(trainer);
       
       try {
           response.sendRedirect("http://localhost:8080/EmployeeManagement/TrainerController?flag=viewTrainers");
       } catch (IOException e) {
           e.printStackTrace();
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
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isIdExist = employeeService.deleteTrainerById(id);
        try {
            response.sendRedirect("http://localhost:8080/EmployeeManagement/TrainerController?flag=viewTrainers");
        } catch (IOException e) {
            e.printStackTrace();
        }  
   }

    /**
     * 
     * get trainer by id
     * 
     * @param request, response
     * @return void
     */
    public void getTrainerById(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Trainer trainer = employeeService.getTrainerById(id);
        request.setAttribute("trainer", trainer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateTrainer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } 
    }
}