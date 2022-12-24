package com.example.radarcommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.hajar.commun.commands.CreateRadarCommand;
import org.hajar.commun.commands.DeleteRadarCommand;
import org.hajar.commun.commands.UpdateRadarCommand;
import org.hajar.commun.dtos.RadarRequestDto;
import org.hajar.commun.dtos.RadarUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/command/radars")
public class RadarCommandController {
    private CommandGateway commandGateway ;
    private EventStore eventStore ;

    @PostMapping(path = "/create")
    public  CompletableFuture<String> createRadar (@RequestBody RadarRequestDto request){
        CompletableFuture<String> response = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitessemax(),
                request.getLongtitude(),
                request.getLatitude()
        ));
         return response;
    }
    @PutMapping(path="/update")
    public CompletableFuture<String> updateRadar(@RequestBody RadarUpdateRequestDto request){
        CompletableFuture<String> response = commandGateway.send(new UpdateRadarCommand(
                request.getId(),
                request.getVitessemax(),
                request.getLongtitude(),
                request.getLatitude()
        ));
        return  response;
    }
    @DeleteMapping("/{id}")
    public CompletableFuture<String> deleteRadar(@PathVariable String id ){
        CompletableFuture<String> response =
                commandGateway.send(new DeleteRadarCommand(id));
        return  response;
    }



    @GetMapping(path="/eventStore/{id}")
    public Stream eventStore (@PathVariable String id ){
        return  eventStore.readEvents(id).asStream();
    }

}
