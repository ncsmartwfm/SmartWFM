package com.netcracker.linemanager.service;

import com.netcracker.linemanager.dao.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, String> {
    Candidate findByCandidateId(String candidateId);
}
