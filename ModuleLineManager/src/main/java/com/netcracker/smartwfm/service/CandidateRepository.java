package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, String> {
    Candidate findByCandidateId(String candidateId);
}
