package com.netcracker.smartwfm.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Demand {
    @Id
    private String Id;
    private String projectName;
    private List<String> desiredSkillSet;
    private Integer desiredYearsOfExperience;
    private String domain;
    private String location;
    private String desiredLocation;

    // TODO add the email list of interview panel


    public Demand() {
        // forJAXB serialization purpose
    }

    public Demand(String id, String projectName, List<String> desiredSkillSet,
                  Integer desiredYearsOfExperience, String domain, String location,
                  String desiredLocation) {
        Id = id;
        this.projectName = projectName;
        this.desiredSkillSet = desiredSkillSet;
        this.desiredYearsOfExperience = desiredYearsOfExperience;
        this.domain = domain;
        this.location = location;
        this.desiredLocation = desiredLocation;
    }

    public String getDesiredLocation() {
        return desiredLocation;
    }

    public void setDesiredLocation(String desiredLocation) {
        this.desiredLocation = desiredLocation;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getDesiredSkillSet() {
        return desiredSkillSet;
    }

    public void setDesiredSkillSet(List<String> desiredSkillSet) {
        this.desiredSkillSet = desiredSkillSet;
    }

    public Integer getDesiredYearsOfExperience() {
        return desiredYearsOfExperience;
    }

    public void setDesiredYearsOfExperience(Integer desiredYearsOfExperience) {
        this.desiredYearsOfExperience = desiredYearsOfExperience;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
