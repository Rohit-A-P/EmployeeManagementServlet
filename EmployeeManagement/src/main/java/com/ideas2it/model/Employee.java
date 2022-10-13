package com.ideas2it.model;

import java.sql.Date;

/**
 *
 * Employee class is used to get Employee details
 *  
 * @version 11.0 01-09-2022
 *
 * @author Rohit A P
 *
 */
public class Employee {
    
    private Integer id;
    private String name;
    private String bloodGroup;
    private Date dateOfBirth; 
    private String designation;
    private String gender;
    private Long phoneNumber;
    private String email;

    public Employee() {
    }
   
    public Employee(Integer id, String name, String bloodGroup, String designation,
                    Date dateOfBirth, String gender, Long phoneNumber, String email) {
        this.id = id;
        this.name = name; 
        this.bloodGroup = bloodGroup;
        this.dateOfBirth = dateOfBirth;
        this.designation = designation;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }  

    public Integer getId() {
        return id;
    }
   
    public String getName() {
        return name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getDesignation() {
        return designation;
    }
    public String getEmail() {
        return email;
    }
 
    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
 
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(Integer id) {
       this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
 
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
   
    public String toString() {
        return ("\nID                   : " + this.id + 
                "\nName                 : " + this.name +
                "\nBlood Group          : " + this.bloodGroup +
                "\nEMail                : " + this.email +
                "\nDate of Birth(Y-M-D) : " + this.dateOfBirth + 
                "\nGender               : " + this.gender +
                "\nPhone Number         : " + this.phoneNumber +
                "\nDesignation          : " + this.designation);
    }
}    
