package com.example.inftactionqueryside.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Infraction {
    @Id
    private  String id;
    private Date date;
    private String numRadar;
    private double montant;
    private String  matricule;
    private double vitesseMax;
    private double vitessevehicule;
}
