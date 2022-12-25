package com.zarguan.infraction.commandSide.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.hajar.commun.commands.CreateInfractionCommand;
import org.hajar.commun.commands.DeleteInfractionCommand;
import org.hajar.commun.commands.UpdateInfractionCommand;
import org.hajar.commun.dtos.InfractionRequestDto;
import org.hajar.commun.dtos.InfractionUpdateRequestDto;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/command/infractions")
public class InfractionCommandController {
    private CommandGateway commandGateway ;
    private EventStore eventStore ;

    @PostMapping(path = "/create")
    public  CompletableFuture<String> createInfraction (@RequestBody InfractionRequestDto request){
        CompletableFuture<String> response = commandGateway.send(new CreateInfractionCommand(
                UUID.randomUUID().toString(),
                request.getDate(),
                request.getNumradar(),
                request.getVitessemax(),
                request.getMatricule(),
                request.getVitessevehicule(),
                request.getMontant()
        ));
         return response;
    }
    @PutMapping(path="/update")
    public CompletableFuture<String> updateInfraction(@RequestBody InfractionUpdateRequestDto request){
        CompletableFuture<String> response = commandGateway.send(new UpdateInfractionCommand(
                request.getId(),
                request.getDate(),
                request.getNumradar(),
                request.getVitessemax(),
                request.getMatricule(),
                request.getVitessevehicule(),
                request.getMontant()
        ));
        return  response;
    }
    @DeleteMapping("/{id}")
    public CompletableFuture<String> deleteInfraction(@PathVariable String id ){
        CompletableFuture<String> response =
                commandGateway.send(new DeleteInfractionCommand(id));
        return  response;
    }



    @GetMapping(path="/eventStore/{id}")
    public Stream eventStore (@PathVariable String id ){
        return  eventStore.readEvents(id).asStream();
    }

}
