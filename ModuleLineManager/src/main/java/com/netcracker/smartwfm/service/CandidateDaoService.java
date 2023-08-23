package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.Candidate;
import com.netcracker.smartwfm.exception.CandidateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateDaoService {

    @Autowired
    private ProfileMatcher profileMatcher;
    // for testing purpose lets create a static arraylist of available resource
    @Autowired
    private CandidateRepository candidateRepository;
    public static List<Candidate> listOfCandidate = new ArrayList<>();

    static {
        Candidate av1 = new Candidate("SAHA0216", "Sam", "Harper", "CPQ",
                Arrays.asList("Java", "SpringBoot", "CPQ"), 4,
                2, "ALHA0314",
                "Alex Hales", "England", "Trent");
        Candidate av2 = new Candidate("FAFA0216", "Sam", "Harper", "CPQ",
                Arrays.asList("Java", "SpringBoot", "CPQ"), 4,
                2, "ALHA0314",
                "Alex Hales", "England", "Trent");
        Candidate av3 = new Candidate("DESI0512", "Sam", "Harper", "CPQ",
                Arrays.asList("Java", "SpringBoot", "CPQ"), 4,
                2, "ROGA0438",
                "Alex Hales", "England", "Trent");
        listOfCandidate.add(av1);
        listOfCandidate.add(av2);
        listOfCandidate.add(av3);
    }

    // TODO find all the available resources
    public List<Candidate> getListOfAvailableCandidates() {
        return listOfCandidate;
    }

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
        //listOfCandidate.add(candidate);
    }

    public Candidate getCandidateById(String Id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(Id);
        if(candidateOptional.isPresent())
        {
            return candidateOptional.get();
        }/*
        return listOfCandidate.stream()
                .filter(e -> e.getId().equals(Id))
                .findFirst()
                .orElse(null);*/
        throw new CandidateNotFoundException("Candidate with Id: "+Id+" does not exist");
    }

    public List<Candidate> getListOfCandidateByYearsOfExperience(int yearOfExperience) {
        return listOfCandidate.stream().filter(e->e.getYearsOfExperience()>= yearOfExperience)
                .collect(Collectors.toList());
    }

    public List<Candidate> getListOfCandidateByParticularSkill(String skill) {
        return listOfCandidate.stream().filter(e->e.getSkillSet().contains(skill))
                .collect(Collectors.toList());
    }

    public void deleteCandidateById(String Id) {
        Candidate candidate = listOfCandidate.stream().filter(e -> e.getId().equals(Id)).findFirst().orElse(null);
        if(candidate == null) {
            throw new CandidateNotFoundException("Candidate with Id:"+Id+" does not exist");
        }
        listOfCandidate.remove(candidate);
    }

    /*public void updateCandidateWithProfileMatch(String Id) {
        Candidate candidate = getCandidateById(Id);
        profileMatcher.getMatchPercentageForAvailableDemands(candidate, OpenDemandDaoService.listOfDemands);
    }*/

    // TODO to save the resource in the DB

    // TODO to delete the resource from the DB
}
