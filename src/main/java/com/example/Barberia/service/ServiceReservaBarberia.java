package com.example.Barberia.service;

import com.example.Barberia.interfaceService.IReservaBarberiaService;
import com.example.Barberia.model.ReservaBarberia;
import com.example.Barberia.repository.RepositoryReservaBarberia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ServiceReservaBarberia implements IReservaBarberiaService {

    @Autowired
    private RepositoryReservaBarberia repositoryReservaBarberia;

    @Override
    public List<ReservaBarberia> listar(){
        return (List<ReservaBarberia>) repositoryReservaBarberia.findAll();
    }

    @Override
    public Optional<ReservaBarberia> listId(int id){
        return repositoryReservaBarberia.findById(id);
    }

    @Override
    public int save(ReservaBarberia r){
        int res=0;
        ReservaBarberia reservaBarberia = repositoryReservaBarberia.save(r);
        if(!reservaBarberia.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id){
        repositoryReservaBarberia.deleteById(id);
    }
}
