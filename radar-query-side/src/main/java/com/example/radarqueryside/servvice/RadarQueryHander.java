package com.example.radarqueryside.servvice;


import com.example.radarqueryside.entities.Radar;
import com.example.radarqueryside.repository.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.hajar.commun.query.GetAllRadar;
import org.hajar.commun.query.GetRadarById;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarQueryHander {
    RadarRepository radarRepository;

    @QueryHandler
    public List<Radar> on (GetAllRadar query){
        return radarRepository.findAll();
    }
    @QueryHandler
    public Radar on (GetRadarById query){
        return radarRepository.findById(query.getId())
                .orElseThrow(()-> new RuntimeException("cannot find Radar"));
    }


}
