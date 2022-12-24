package com.example.inftactionqueryside.services;

import com.example.inftactionqueryside.entites.Infraction;
import com.example.inftactionqueryside.repository.InfractionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class InfractionEventHandler
{
    InfractionRepository infractionRepository;
    @EventHandler  //
    public  void on (CreatedInfractionEvent event){
        log.info("======================");
        log.info("CreatedInfractionEvent  received");
        Infraction infraction=new Infraction();
        infraction.setId(event.getId());
        infraction.setDate(event.getDate());
        infraction.setMatricule(event.getMatricule());
        infraction.setMontant(event.getMontant());
        infraction.setNumRadar(event.getNumradar());
        infraction.setVitesseMax(event.getVitessemax());
        infraction.setVitessevehicule(event.getVitessevehicule());
        infractionRepository.save(infraction);
    }

    @EventHandler //
    public void on (UpdatedInfractionEvent event){
        log.info("======================");
        log.info("UpdatedRadarEvent received ");
      Infraction infraction=infractionRepository.findById(event.getId()).get();
      infraction.setId(event.getId());
        infraction.setDate(event.getDate());
        infraction.setMatricule(event.getMatricule());
        infraction.setMontant(event.getMontant());
        infraction.setNumRadar(event.getNumradar());
        infraction.setVitesseMax(event.getVitessemax());
        infraction.setVitessevehicule(event.getVitessevehicule());
        infractionRepository.save(infraction);
    }
    @EventHandler
    public void on (DeletedInfractionEvent event){
        log.info("======================");
        log.info("DeletedInfractionEvent received ");
        Infraction infraction=infractionRepository.findById(event.getId()).get();
        infractionRepository.delete(infraction);
    }

}
