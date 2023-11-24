package com.example.Barberia.interfaceService;

import com.example.Barberia.model.ReservaBarberia;

import java.util.List;
import java.util.Optional;

public interface IReservaBarberiaService {

    public List<ReservaBarberia> listar();

    public Optional<ReservaBarberia> listId(int id);
    public int save (ReservaBarberia r);
    public void delete(int id);

}
