package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandRepository extends JpaRepository<Demand, String> {

    
}
