package com.ideas2it.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.ideas2it.customexception.DatabaseNotFound;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.gender.Gender;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;

/**
 *
 * EmployeeService class have business logics
 * 
 * @version 1.0 01-09-2022
 *
 * @author Rohit A P
 * 
 */
public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();
    private Logger logger = LogManager.getLogger(EmployeeService.class);  

    /**
     * 
     * pass Trainer Details insertTrainer method
     * 
     * @param trainer
     * @return void
     */
    public int insertTrainer(Trainer trainer) {

        int id = 0; 
        try {
            id = employeeDao.insertTrainer(trainer);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }    
        return id;
    }

    /**
     * 
     * pass Trainer Details insertTrainerDetails method
     * 
     * @param trainee
     * @return void
     */
    public int insertTrainee(Trainee trainee) {

        int id = 0;
        try {
            id = employeeDao.insertTrainee(trainee);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return id;
        
    }

    /**
     *
     * viewAllTrainer method print every profile in Trainer
     *
     * @param
     * @return trainers
     */
    public List<Trainer> viewAllTrainer() {

        List<Trainer> trainers = new ArrayList<Trainer>();

        try {
            trainers = employeeDao.viewAllTrainer();
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return trainers;
    }

    /**
     * 
     * viewAllTrainee method print every profile in Trainee
     * 
     * @param
     * @return trainees
     */
    public List<Trainee> viewAllTrainee() {

        List<Trainee> trainees = new ArrayList<Trainee>();

        try {
            trainees = employeeDao.viewAllTrainee();
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return trainees;
    }

    /**
     * 
     * viewtraineeDetail method print every profile in Trainee
     * 
     * @param
     * @return employeeDao.retrivetraineeDetail()
     */
    public List<Trainee> SearchTraineeByName(String name) {

        List<Trainee> trainees = new ArrayList<Trainee>();

        try {
            trainees = employeeDao.SearchTraineeByName(name);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return trainees;
    }

    /**
     *
     * deleteTrainer method gets Trainer ID as input and search Id Database,
     * identifies that Id and delete Id details
     *
     * @param id
     * @return void
     */
    public boolean deleteTrainerById(int id) {

        boolean isIdExist = false;
        try {
            isIdExist = employeeDao.deleteTrainerById(id);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return isIdExist;
    }

    /**
     *
     * deleteTrainee method gets Trainee ID as input and search Id in Database,
     * identifies that Id and delete Id details
     *
     * @param id
     * @return isIdExist
     */
    public boolean deleteTraineeById(int id) {

        boolean isIdExist = false;
        try {
            isIdExist = employeeDao.deleteTraineeById(id);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return isIdExist;
    }

    /**
     *
     * update Trainer
     *
     *
     * @param trainer
     * @return void
     */
    public void updateTrainerById(Trainer trainer) {

        try {
            employeeDao.updateTrainerById(trainer);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
    }

    /**
     *
     * update trainee
     *
     *
     * @param trainee
     * @return void
     */
    public void updateTraineeById(Trainee trainee) {

        try {
            employeeDao.updateTraineeById(trainee);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
    }

    /**
     * 
     * Get Trainer detail by Id
     * 
     * @param id
     * @return trainer
     */
    public Trainer getTrainerById(int id) {

        Trainer trainer = null;
        try {
            trainer = employeeDao.getTrainerById(id);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return trainer;
    }

    /**
     * 
     * Get Trainer detail by Id
     * 
     * @param id
     * @return trainee
     */
    public Trainee getTraineeById(int id) {

        Trainee trainee = null;
        try {
            trainee = employeeDao.getTraineeById(id);
        } catch (DatabaseNotFound exception) {
            logger.warn(exception.getMessage());
        }
        return trainee;
    }

    /**
     * 
     * used to select gender
     * 
     * @param option
     * @return String
     */
    public String selectGender(int option) {

        String gender = "";

        switch (option) {
        case 1:
            return gender = Gender.MALE.toString();
        case 2:
            return gender = Gender.FEMALE.toString();
        case 3:
            return gender = Gender.OTHERS.toString();
        default:
            System.out.println("Invalid option");
            break;
        }
        return gender;
    }

    /**
     * 
     * Calculate age
     * 
     * @param
     * @return age
     */
    public int calculateAge(Date date) {

        String dateString = date.toString();
        LocalDate dob = LocalDate.parse(dateString);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dob, currentDate).getYears();
        return age;
    }
    
    /**
     * 
     * reverse date
     * 
     * @param date
     * @return reverseDate
     */
    public String reverseDate(String date) {

        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String reverseDate = null;
        try {
            reverseDate = format2.format(format1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reverseDate;
        
    }
    
    /**
     * 
     * Validate name
     * 
     * @param id
     * @return status
     */
    public boolean isValidName(String name) {

        boolean status = Pattern.matches("^[A-Za-z]\\w{4,29}$", name);
        return status;
    }

    /**
     * 
     * Validate phone number
     * 
     * @param phoneNumber
     * @return status
     */
    public boolean isValidPhoneNumber(Long phoneNumber) {

        boolean status = Pattern.matches("^[7-9][0-9]{9}", phoneNumber.toString());
        return status;
    }

    /**
     * 
     * Validate date
     * 
     * @param date
     * @return status
     */
    public boolean isValidDate(String date) {

        String format = "([1-2][0-9]{3})-([0][1-9]|[1][0-2])-([0][1-9]|[1][0-9]|[2][0-9]|[3][0-1])";
        boolean status = Pattern.matches(format, date);
        if(status == true) {
            Date isValidDate = Date.valueOf(date);
            int age = calculateAge(isValidDate);
            status = isValidAge(age);
        }
        return status;
    }

    /**
     * 
     * Validate email
     * 
     * @param eMail
     * @return status
     */
    public boolean isValidEmail(String eMail) {

        boolean status = Pattern.matches("^(.+)@(\\S+)$", eMail);
        return status;
    }

    /**
     * 
     * Validate age
     * 
     * @param age
     * @return status
     */
    public boolean isValidAge(int age) {

        boolean status = false;
        if (age > 18) {
            status = true;
        } else if(age > 55) {
            status = false;
        }
        return status;
    }
}