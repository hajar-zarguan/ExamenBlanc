package com.example.inftactionqueryside.services;


import com.example.inftactionqueryside.entites.Infraction;
import com.example.inftactionqueryside.repository.InfractionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.hajar.commun.query.GetAllInfraction;
import org.hajar.commun.query.GetAllRadar;
import org.hajar.commun.query.GetRadarById;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionQueryHander {
    InfractionRepository infractionRepository;

    @QueryHandler
    public List<Infraction> on (GetAllInfraction query){
        return infractionRepository.findAll();
    }
    @QueryHandler
    public Infraction on (GetRadarById query){
        return infractionRepository.findById(query.getId())
                .orElseThrow(()-> new RuntimeException("cannot find Infraction"));
    }


}
