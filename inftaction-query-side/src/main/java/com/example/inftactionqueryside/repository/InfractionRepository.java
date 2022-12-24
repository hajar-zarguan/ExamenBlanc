package com.example.inftactionqueryside.repository;

import com.example.inftactionqueryside.entites.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction,String> {
}
