package com.ideas2it.model;

import java.sql.Date;
import java.util.Set;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Skill;

/**
 *
 * Trainee class is used to get Trainee details
 * 
 * @version 11.0 01-09-2022
 *
 * @Author Rohit A P
 *
 */
public class Trainee extends Employee {

    private String traineeId;
    private Date dateOfJoining;
    private Set<Skill> skills;

    public Trainee() {
    }

    public Trainee(Integer id, String name, String bloodGroup, String designation,
            Date dateOfBirth, String gender, Long phoneNumber, String email, String traineeId,
            Date dateOfJoining, Set<Skill> skills) {

        super(id, name, bloodGroup, designation, dateOfBirth, gender, phoneNumber, email);
        this.traineeId = traineeId;
        this.dateOfJoining = dateOfJoining;
        this.skills = skills;
    }

    public String getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(String traineeId) {
        this.traineeId = traineeId;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public String toString() {
        return (super.toString() + "\nDate Of Joining      : " + this.dateOfJoining);
    }
}