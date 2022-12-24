package com.example.infractioncommandside.aggregate;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.hajar.commun.commands.CreateInfractionCommand;
import org.hajar.commun.commands.DeleteInfractionCommand;
import org.hajar.commun.commands.UpdateInfractionCommand;

import java.util.Date;

@Aggregate
@Slf4j
public class InfractionAggregate {
    @AggregateIdentifier
    private  String id;
    private Date date;
    private String numRadar;
    private double montant;
    private String  matricule;
    private double vitesseMax;
    private double vitessevehicule;
    public InfractionAggregate() {
    }

    @CommandHandler
    public InfractionAggregate(CreateInfractionCommand command) {

        log.info("====================");
        AggregateLifecycle.apply(new CreatedInfractionEvent(
                command.getId(),
                command.getDate(),
                command.getNumradar(),
                command.getMontant(),
                command.getMatricule(),
                command.getVitessemax(),
                command.getVitessevehicule()
                ));
    }
    @EventSourcingHandler
    public void on (CreatedInfractionEvent event){
      log.info("====================");
      log.info("CreatedInfractionEvent reseved ");
      id=event.getId();
      vitesseMax= event.getVitessemax();
      date= event.getDate();
      numRadar= event.getNumradar();
      vitessevehicule=event.getVitessevehicule();
      matricule=event.getMatricule();
      montant=event.getMontant();
    }
    @CommandHandler
    public void on (UpdateInfractionCommand command){
        AggregateLifecycle.apply(new UpdatedInfractionEvent(
                command.getId(),
                command.getDate(),
                command.getNumradar(),
                command.getVitessemax(),
                command.getMatricule(),
                command.getVitessevehicule(),
                command.getMontant()
                ));
    }
    @EventSourcingHandler
    public void on (UpdatedInfractionEvent event){
        log.info("UpdatedInfractionEvent received  ");
        id=event.getId();
        vitesseMax= event.getVitessemax();
        date= event.getDate();
        numRadar= event.getNumradar();
        vitessevehicule=event.getVitessevehicule();
        matricule=event.getMatricule();
        montant=event.getMontant();

    }
  // ==============delete ==================
  @CommandHandler
  public void on (DeleteInfractionCommand command){
      log.info("DeleteInfractionCommand received ");
      AggregateLifecycle.apply(new DeletedInfractionEvent(
              command.getId()
      ));
  }

}
