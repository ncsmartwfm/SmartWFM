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
    @Autowired
    private CandidateRepository candidateRepository;

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public List<Candidate> getAvailableCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(String Id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(Id);
        if(candidateOptional.isPresent())
        {
            return candidateOptional.get();
        }
        throw new CandidateNotFoundException("Candidate with Id: "+Id+" does not exist");
    }

    /*public List<Candidate> getListOfCandidateByYearsOfExperience(int yearOfExperience) {
        return listOfCandidate.stream().filter(e->e.getYearsOfExperience()>= yearOfExperience)
                .collect(Collectors.toList());
    }

    public List<Candidate> getListOfCandidateByParticularSkill(String skill) {
        return listOfCandidate.stream().filter(e->e.getSkillSet().contains(skill))
                .collect(Collectors.toList());
    }*/

    // TODO need to add validations if the Candidate exists or not
    public void deleteCandidateById(String Id) {
        candidateRepository.deleteById(Id);
    }

}
