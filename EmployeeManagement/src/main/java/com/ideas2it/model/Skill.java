package com.ideas2it.model;

/*
*
* model of skill pojo
*  
* @version 11.0 09-09-2022
*
* @Author Rohit A P
*
*/
public class Skill {

   private Integer skillId;
   private String traineeId;
   private String skillName;
   private Float skillExperience;
   private String skillVersion;
   private String skillCertification;

   public Skill() {
   }

   public Skill(Integer skillId, String traineeId, String skillName, Float skillExperience,
                 String skillVersion, String skillCertification) {

       this.skillId = skillId;
       this.traineeId = traineeId;
       this.skillName = skillName;
       this.skillExperience = skillExperience;
       this.skillVersion = skillVersion;
       this.skillCertification = skillCertification;
   }

   public Integer getSkillId() {
       return skillId;   
   }

   public String getTraineeId() {
       return traineeId;   
   }

   public String getSkillName() {
       return skillName;
   }

   public String getSkillVersion() {
       return skillVersion;
   }  

   public Float getSkillExperience() {
       return skillExperience;
   }

   public String getSkillCertification() {
       return skillCertification;
   } 

   public void setSkillId(Integer skillId) {
       this.skillId = skillId; 
   }    

   public void setTraineeId(String traineeId) {
       this.traineeId = traineeId; 
   }  

   public void setSkillName(String skillName) {
       this.skillName = skillName;
   }

   public void setSkillVersion(String skillVersion) {
       this.skillVersion = skillVersion;
   } 

   public void setSkillExperience(Float skillExperience) {
       this.skillExperience = skillExperience;
   }   

   public void setSkillCertification(String skillCertification) {
       this.skillCertification = skillCertification;
   }         

   public String toString() {
       return ( "\nSKILL NAME          : " + this.skillName 
              + "\nSKILL VERSION       : " + this.skillVersion 
              + "\nSKILL Experience    : " + this.skillExperience 
              + "\nSKILL CERTIFICATION : " + this.skillCertification);
   }
}