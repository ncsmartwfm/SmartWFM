package com.netcracker.smartwfm.service;

import com.netcracker.smartwfm.dao.Demand;
import com.netcracker.smartwfm.exception.DemandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpenDemandDaoService {
    @Autowired
    private DemandRepository demandRepository;
    public List<Demand> getAllDemands() {
        return demandRepository.findAll();
    }

    public void save(Demand demand) {
        demandRepository.save(demand);
    }

    public Demand getDemandById(String Id) {
        Optional<Demand> demandOptional = demandRepository.findById(Id);
        if(demandOptional.isPresent()) {
            return demandOptional.get();
        }
        throw new DemandNotFoundException("Demand with Id "+Id+" does not exist");
    }

    public void deleteDemandById(String Id) {
        Optional<Demand> demandOptional = demandRepository.findById(Id);
        if(demandOptional.isPresent()) {
            demandRepository.delete(demandOptional.get());
        }
        throw new DemandNotFoundException("Demand for the Id "+Id+" does not exist");

    }
}
