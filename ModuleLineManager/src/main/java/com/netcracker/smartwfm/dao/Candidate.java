package com.netcracker.smartwfm.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Candidate {
    @Id
    private String Id;
    private String firstName;
    private String lastName;
    private String domain;
    private List<String> skillSet;
    private Integer yearsOfExperience;
    private Integer yearOfExperienceInCurrentDomain;
    private String lineManagerId;
    private String demandIdWithLMRecommendation;
    private String country;
    private String city;


    public Candidate() {
    }

    public Candidate(String id, String firstName, String lastName, String domain,
                     List<String> skillSet, Integer yearOfExperience,
                     Integer yearOfExperienceInCurrentDomain, String lineManagerId,
                     String lineManagerName, String country, String city) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.domain = domain;
        this.skillSet = skillSet;
        this.yearsOfExperience = yearOfExperience;
        this.yearOfExperienceInCurrentDomain = yearOfExperienceInCurrentDomain;
        this.lineManagerId = lineManagerId;
        this.lineManagerName = lineManagerName;
        this.country = country;
        this.city = city;
    }

    private String lineManagerName;

    public String getLineManagerId() {
        return lineManagerId;
    }

    public void setLineManagerId(String lineManagerId) {
        this.lineManagerId = lineManagerId;
    }

    public String getLineManagerName() {
        return lineManagerName;
    }

    public void setLineManagerName(String lineManagerName) {
        this.lineManagerName = lineManagerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<String> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(List<String> skillSet) {
        this.skillSet = skillSet;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getYearOfExperienceInCurrentDomain() {
        return yearOfExperienceInCurrentDomain;
    }

    public void setYearOfExperienceInCurrentDomain(Integer yearOfExperienceInCurrentDomain) {
        this.yearOfExperienceInCurrentDomain = yearOfExperienceInCurrentDomain;
    }

    public String getDemandIdWithLMRecommendation() {
        return demandIdWithLMRecommendation;
    }

    public void setDemandIdWithLMRecommendation(String demandIdWithLMRecommendation) {
        this.demandIdWithLMRecommendation = demandIdWithLMRecommendation;
    }

    /*public List<DemandCandidateMatch> getListOfDemandCandidateMatch() {
        return listOfDemandCandidateMatch;
    }

    public void setListOfDemandCandidateMatch(List<DemandCandidateMatch> listOfDemandCandidateMatch) {
        this.listOfDemandCandidateMatch = listOfDemandCandidateMatch;
    }*/
}
