package com.example.inftactionqueryside.controllers;

import com.example.inftactionqueryside.entites.Infraction;
import com.example.inftactionqueryside.repository.InfractionRepository;

import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.hajar.commun.query.GetAllInfraction;
import org.hajar.commun.query.GetInfractionById;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/query/infractions")
public class InfractionQueryController {
    QueryGateway queryGateway;
    InfractionRepository infractionRepository;

  @GetMapping
    public CompletableFuture <List<Infraction>> getInfractions(){

       return  queryGateway.query(new GetAllInfraction(),ResponseTypes.multipleInstancesOf(Infraction.class) );
  }
    @GetMapping(path = "/{id}")
    public  CompletableFuture<Infraction> getInfractionById(@PathVariable String id){
      return queryGateway.query(new GetInfractionById(id), ResponseTypes.instanceOf(Infraction.class));
    }
    @DeleteMapping(path ="/deleteAll")
    public  String deleteinfractions(){
         infractionRepository.deleteAll();
         return "success";
    }
    @ExceptionHandler
    public ResponseEntity<String>  error(Exception ex){
      ResponseEntity<String> error =new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       return error;
  }

}
