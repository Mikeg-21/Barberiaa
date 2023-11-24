package com.example.Barberia.repository;

import com.example.Barberia.model.ReservaBarberia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReservaBarberia extends JpaRepository<ReservaBarberia, Integer>{
}