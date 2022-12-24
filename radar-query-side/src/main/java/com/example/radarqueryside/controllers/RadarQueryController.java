package com.example.radarqueryside.controllers;

import com.example.radarqueryside.entities.Radar;
import com.example.radarqueryside.repository.RadarRepository;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;

import org.hajar.commun.query.GetAllRadar;
import org.hajar.commun.query.GetRadarById;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/query/radars")
public class RadarQueryController {
    QueryGateway queryGateway;
    RadarRepository radarRepository;

  @GetMapping
    public CompletableFuture <List<Radar>> getRadars(){

       return  queryGateway.query(new GetAllRadar(),ResponseTypes.multipleInstancesOf(Radar.class) );
  }
    @GetMapping(path = "/{id}")
    public  CompletableFuture<Radar> getRadarById(@PathVariable String id){
      return queryGateway.query(new GetRadarById(id), ResponseTypes.instanceOf(Radar.class));
    }
    @DeleteMapping(path ="/deleteAll")
    public  String deleteRadars(){
         radarRepository.deleteAll();
         return "success";
    }
    @ExceptionHandler
    public ResponseEntity<String>  error(Exception ex){
      ResponseEntity<String> error =new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       return error;
  }

}
