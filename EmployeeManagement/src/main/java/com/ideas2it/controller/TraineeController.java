package com.ideas2it.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas2it.model.Skill;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.EmployeeService;

/**
 * Servlet implementation class TraineeController
 */
public class TraineeController extends HttpServlet {
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
     * it is used to send request and response
     * 
     * @param request, response
     * @return void
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("flag");

        switch (action) {
        case "insertTrainee":
            insertTrainee(request, response);
            break;
        case "viewTrainees":
            viewAllTrainee(request, response);
            break;
        case "updateTrainee":
            updateTraineeById(request, response);
            break;
        case "deleteTrainee":
            deleteTrainee(request, response);
            break;
        }
    }

    /**
     * 
     * add trainee details to trainee object
     * 
     * @param request, response
     * @return void
     */
    public void insertTrainee(HttpServletRequest request, HttpServletResponse response) {

        int id = 0;

        String name = request.getParameter("name");
        String bloodGroup = request.getParameter("bloodGroup");

        String date = request.getParameter("dateOfBirth");
        Date dateOfBirth = Date.valueOf(date);

        String designation = request.getParameter("designation");

        String gender = request.getParameter("gender");

        String number = request.getParameter("phoneNumber");
        long phoneNumber = Long.parseLong(number);

        String email = request.getParameter("email");

        String traineeId = "0";

        date = request.getParameter("dateOfJoining");
        Date dateOfJoining = Date.valueOf(date);

        Set<Skill> skills = new HashSet<Skill>();

        Skill skill = new Skill();

        skill.setTraineeId(traineeId);

        skill.setSkillName(request.getParameter("skillName1"));

        String expirenece = request.getParameter("skillExperience1");
        skill.setSkillExperience(Float.valueOf(expirenece));

        skill.setSkillVersion(request.getParameter("skillVersion1"));

        skill.setSkillCertification(request.getParameter("skillCertification1"));

        skills.add(skill);

        skill.setTraineeId(traineeId);

        skill.setSkillName(request.getParameter("skillName2"));

        expirenece = request.getParameter("skillExperience2");
        skill.setSkillExperience(Float.valueOf(expirenece));

        skill.setSkillVersion(request.getParameter("skillVersion2"));

        skill.setSkillCertification(request.getParameter("skillCertification2"));

        skills.add(skill);

        Trainee trainee = new Trainee(id, name, bloodGroup, designation, dateOfBirth,
                gender, phoneNumber, email, traineeId, dateOfJoining, skills);

        id = employeeService.insertTrainee(trainee);
        
        viewAllTrainee(request, response);
    }

    /**
     * 
     * shows all trainee
     * 
     * @param request, response
     * @return void
     */
    public void viewAllTrainee(HttpServletRequest request, HttpServletResponse response) {
        List<Trainee> trainees = employeeService.viewAllTrainee();
        request.setAttribute("traineeList", trainees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTrainees.jsp");
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
     * update trainee by id
     * 
     * @param request, response
     * @return void
     */
    public void updateTraineeById(HttpServletRequest request, HttpServletResponse response) {

        String stringId = request.getParameter("id");
        int id = Integer.parseInt(stringId);

        String name = request.getParameter("name");
        String bloodGroup = request.getParameter("bloodGroup");

        String date = request.getParameter("dateOfBirth");
        Date dateOfBirth = Date.valueOf(date);

        String designation = request.getParameter("designation");

        String gender = request.getParameter("gender");

        String number = request.getParameter("phoneNumber");
        long phoneNumber = Long.parseLong(number);

        String email = request.getParameter("email");

        String traineeId = "0";

        date = request.getParameter("dateOfJoining");
        Date dateOfJoining = Date.valueOf(date);

        Set<Skill> skills = new HashSet<Skill>();

        Skill skill = new Skill();

        skill.setTraineeId(traineeId);

        skill.setSkillName(request.getParameter("skillName1"));

        String expirenece = request.getParameter("skillExperience1");
        skill.setSkillExperience(Float.valueOf(expirenece));

        skill.setSkillVersion(request.getParameter("skillVersion1"));

        skill.setSkillCertification(request.getParameter("skillCertification1"));

        skills.add(skill);

        skill.setTraineeId(traineeId);

        skill.setSkillName(request.getParameter("skillName2"));

        expirenece = request.getParameter("skillExperience2");
        skill.setSkillExperience(Float.valueOf(expirenece));

        skill.setSkillVersion(request.getParameter("skillVersion2"));

        skill.setSkillCertification(request.getParameter("skillCertification2"));

        skills.add(skill);

        Trainee trainee = new Trainee(id, name, bloodGroup, designation, dateOfBirth,
                gender, phoneNumber, email, traineeId, dateOfJoining, skills);
        
        employeeService.updateTraineeById(trainee);
        
        try {
            response.sendRedirect("http://localhost:8080/EmployeeManagement/SaveTrainee?flag=viewTrainees");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }

    /**
     * 
     * delete trainee
     * 
     * @param request, response
     * @return void
     */
    public void deleteTrainee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isIdExist = employeeService.deleteTraineeById(id);
        try {
            response.sendRedirect("http://localhost:8080/EmployeeManagement/SaveTrainee?flag=viewTrainees");
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
    
    /**
     * 
     * get trainee by id
     * 
     * @param request, response
     * @return void
     */
    public void getTraineeById(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        Trainee trainee = employeeService.getTraineeById(id);
        request.setAttribute("trainee", trainee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateTrainee.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } 
    }
}