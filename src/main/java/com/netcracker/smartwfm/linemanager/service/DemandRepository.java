package com.netcracker.linemanager.service;

import com.netcracker.linemanager.dao.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, String> {
    Demand findByDemandId(String demandId);
}
