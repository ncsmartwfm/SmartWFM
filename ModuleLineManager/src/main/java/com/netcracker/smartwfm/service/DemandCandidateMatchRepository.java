package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.DemandCandidateMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandCandidateMatchRepository extends JpaRepository<DemandCandidateMatch, String> {

    public List<DemandCandidateMatch> findDemandCandidateMatchByCandidateId(String candidateId);
    public List<DemandCandidateMatch> findDemandCandidateMatchByDemandId(String demandId);
}
