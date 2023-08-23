package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.Candidate;
import com.netcracker.smartwfm.dao.Demand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfileMatcher {


    public DemandCandidateMatch calculateMatchingPercentage(Candidate candidate, Demand demand) {
        DemandCandidateMatch demandCandidateMatch = new DemandCandidateMatch();
        List<String> candidateSkills = candidate.getSkillSet();
        int candidateExperience = candidate.getYearsOfExperience();

        List<String> requiredSkills = demand.getDesiredSkillSet();
        int requiredExperience = demand.getDesiredYearsOfExperience();
        double skillMatchPercentage = (double) countMatchingSkills(candidateSkills, requiredSkills) / requiredSkills.size() * 100;
        double experienceMatchPercentage  = 0.0;
        if(candidateExperience > requiredExperience) {
            experienceMatchPercentage = 100;
        } else {
            experienceMatchPercentage = (double) candidateExperience / requiredExperience * 100;
        }
        double overallMatchingPercentage = (skillMatchPercentage + experienceMatchPercentage) / 2;
        demandCandidateMatch.setCandidateId(candidate.getId());
        demandCandidateMatch.setDemandId(demand.getId());
        demandCandidateMatch.setMatchPercentage(overallMatchingPercentage);
        return demandCandidateMatch;
    }

    public int countMatchingSkills(List<String> candidateSkills, List<String> desiredSkills) {
        int count = 0;
        for (String skill : desiredSkills) {
            if (candidateSkills.contains(skill)) {
                count++;
            }
        }
        return count;
    }
}
