package com.example.radarqueryside.servvice;

import com.example.radarqueryside.entities.Radar;
import com.example.radarqueryside.repository.RadarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;

import org.sid.coreapi.commands.CreatedRadarEvent;
import org.sid.coreapi.commands.DeletedRadarEvent;
import org.sid.coreapi.commands.UpdatedRadarEvent;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RadarEventHandler
{
    RadarRepository radarRepository;
    @EventHandler  //
    public  void on (CreatedRadarEvent event){
        log.info("======================");
        log.info("CreatedRadar Event received");
        Radar radar=new Radar();
        radar.setId(event.getId());
        radar.setVitessemax(event.getVitessemax());
        radar.setLongtitude(event.getLongtitude());
        radar.setLatitude(event.getLatitude());
        radarRepository.save(radar);
    }

    @EventHandler //
    public void on (UpdatedRadarEvent event){
        log.info("======================");
        log.info("UpdatedRadarEvent received ");
      Radar radar=radarRepository.findById(event.getId()).get();
        radar.setId(event.getId());
        radar.setVitessemax(event.getVitessemax());
        radar.setLongtitude(event.getLongtitude());
        radar.setLatitude(event.getLatitude());
        radarRepository.save(radar);
    }
    @EventHandler
    public void on (DeletedRadarEvent event){
        log.info("======================");
        log.info("DeletedRadarEvent received ");
        Radar radar=radarRepository.findById(event.getId()).get();
        radarRepository.delete(radar);
    }

}
