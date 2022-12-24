package com.example.radarcommandside.aggregate;


import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.hajar.commun.commands.CreateRadarCommand;
import org.hajar.commun.commands.DeleteRadarCommand;
import org.hajar.commun.commands.UpdateRadarCommand;

@Aggregate
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private  String id;
    private double vitesseMax;
    private String longtitude;
    private String latitude;
    public RadarAggregate() {
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command) {

        log.info("====================");
        AggregateLifecycle.apply(new CreatedRadarEvent(
                command.getId(),
                command.getVitessemax(),
                command.getLongtitude(),
                command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on (CreatedRadarEvent event){
      log.info("====================");
      log.info("CreatedRadarEvent reseved ");
      id=event.getId();
      vitesseMax= event.getVitessemax();
      longtitude= event.getLongtitude();
      latitude= event.getLatitude();
    }
    @CommandHandler
    public void on (UpdateRadarCommand command){
        AggregateLifecycle.apply(new UpdatedRadarEvent(
                command.getId(),
                command.getVitessemax(),
                command.getLongtitude(),
                command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on (UpdatedRadarEvent event){
        log.info("====================");
        log.info("UpdatedRadarEvent received  ");
        id=event.getId();
        vitesseMax= event.getVitessemax();
        longtitude= event.getLongtitude();
        latitude= event.getLatitude();

    }
  // ==============delete ==================
  @CommandHandler
  public void on (DeleteRadarCommand command){
      log.info("====================");
      log.info("DeleteRadarCommand received  ");
      AggregateLifecycle.apply(new DeletedRadarEvent(
              command.getId()
      ));
  }

}
