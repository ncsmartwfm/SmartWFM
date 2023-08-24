package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.Candidate;
import com.netcracker.smartwfm.dao.Demand;
import com.netcracker.smartwfm.exception.CandidateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateDaoService {

    @Autowired
    private ProfileMatcher profileMatcher;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private DemandRepository demandRepository;

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public List<Candidate> getAvailableCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(String Id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(Id);
        if (candidateOptional.isPresent()) {
            return candidateOptional.get();
        }
        throw new CandidateNotFoundException("Candidate with Id: " + Id + " does not exist");
    }

    public void deleteCandidateById(String Id) {
        Optional<Candidate> candidateOptional = candidateRepository.findById(Id);
        if (candidateOptional.isPresent()) {
            candidateRepository.deleteById(Id);
        }
        throw new CandidateNotFoundException("Candidate with Id " + Id + " does not exist");
    }

    public void updateCandidateWithDemandCandidateMatchByCandidateId(String candidateId) {
        List<Demand> demands = demandRepository.findAll();
        Optional<Candidate> candidateOptional = candidateRepository.findById(candidateId);
        if (candidateOptional.isPresent()) {
            for (Demand demand : demands) {
                profileMatcher.calculateMatchingPercentage(candidateOptional.get(), demand);
            }
        }
        throw new CandidateNotFoundException("Candidate with Id " + candidateId + " does not exist");

    }

    public void updateCandidateWithDemandCandidateMatchForAllCandidates() {
        List<Demand> demands = demandRepository.findAll();
        List<Candidate> candidates = candidateRepository.findAll();
        for(Candidate candidate : candidates) {
            for(Demand demand : demands) {
                profileMatcher.calculateMatchingPercentage(candidate, demand);
            }
        }
    }

}
