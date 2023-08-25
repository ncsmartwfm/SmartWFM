package com.netcracker.linemanager.service;

import com.netcracker.linemanager.dao.DemandCandidateMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandCandidateMatchRepository extends JpaRepository<DemandCandidateMatch, String> {

    public List<DemandCandidateMatch> findByCandidateId(String candidateId);
    public List<DemandCandidateMatch> findByDemandId(String demandId);
}
