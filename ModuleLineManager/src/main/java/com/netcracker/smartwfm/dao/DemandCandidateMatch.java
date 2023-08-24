package com.netcracker.smartwfm.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
public class DemandCandidateMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    @JsonProperty("demandId")
    private String demandId;
    @JsonProperty("candidateId")
    private String candidateId;
    @JsonProperty("match")
    private double matchPercentage;

    public DemandCandidateMatch() {
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(double matchPercentage) {
        this.matchPercentage = matchPercentage;
    }
}