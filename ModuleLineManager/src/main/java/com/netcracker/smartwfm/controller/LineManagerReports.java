package com.netcracker.smartwfm.controller;

import com.netcracker.smartwfm.dao.Candidate;
import com.netcracker.smartwfm.dao.Demand;
import com.netcracker.smartwfm.exception.CandidateNotFoundException;
import com.netcracker.smartwfm.service.CandidateDaoService;
import com.netcracker.smartwfm.service.OpenDemandDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LineManagerReports {
    @Autowired
    private OpenDemandDaoService openDemandDaoService;
    @Autowired
    private CandidateDaoService candidateDaoService;

    @GetMapping("/demands")
    public List<Demand> getOpenDemands() {
        return openDemandDaoService.getAllDemands();
    }

    @GetMapping("/candidates")
    public List<Candidate> getAvailableResources() {
        return candidateDaoService.getListOfAvailableCandidates();
    }

    @GetMapping("/candidates/{Id}")
    public Candidate getCandidateBydId(@PathVariable String Id) {
        Candidate candidate = candidateDaoService.getCandidateById(Id);
        if(candidate == null) {
            throw new CandidateNotFoundException("Candidate with Id: "+Id+" is not found");
        }
        return candidate;
    }

    @PostMapping("/demands")
    public void createDemand(@Validated @RequestBody Demand demand) {
        openDemandDaoService.save(demand);
    }

    @PostMapping("/candidates")
    public ResponseEntity<Candidate> createCandidate(@Validated @RequestBody Candidate candidate) {
        candidateDaoService.save(candidate);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/demands/{Id}")
    public void deleteDemandById(@PathVariable String Id) {
        openDemandDaoService.deleteDemandById(Id);
    }

    @DeleteMapping("/candidates/{Id}")
    public void deleteCandidateById(@PathVariable String Id) {
        candidateDaoService.deleteCandidateById(Id);
    }

    /*@GetMapping("/candidates/match/{Id}")
    public Candidate getMatchedDemandWithCandidateId(@PathVariable String Id) {
        candidateDaoService.updateCandidateWithProfileMatch(Id);
        Candidate candidateBydId = getCandidateBydId(Id);
        return candidateBydId;
    }

    @GetMapping("/candidates/match")
    public List<Candidate> getMatchedDemandForAllCandidates() {
        for(Candidate candidate : CandidateDaoService.listOfCandidate) {
            candidateDaoService.updateCandidateWithProfileMatch(candidate.getId());
        }
        return CandidateDaoService.listOfCandidate;
    }*/
}
