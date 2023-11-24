package com.example.Barberia.controller;

import com.example.Barberia.interfaceService.IReservaBarberiaService;
import com.example.Barberia.model.ReservaBarberia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ControllerReservaBarberia {
    @Autowired
    private IReservaBarberiaService reservaBarberiaService;

    @GetMapping("/inicio")
    public String inicio(Model model){
        List<ReservaBarberia> reservaBarberia = reservaBarberiaService.listar();
        model.addAttribute("reservaBarberia", reservaBarberia);
        return "index";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<ReservaBarberia> reservas = reservaBarberiaService.listar();
        model.addAttribute("reservas", reservas);
        return "visualizacion-reservas";
    }

    @PostMapping("/save")
    public String save(@Validated ReservaBarberia r, @RequestParam("servicio") String servicio, Model model) {
        r.setServicio(servicio);
        reservaBarberiaService.save(r);
        model.addAttribute("mensaje", "Reserva realizada correctamente");
        model.addAttribute("reserva", new ReservaBarberia());  // Esta linea lo que hace es reiniciar el formulario
        return "redirect:/inicio";
    }
    @GetMapping("/reservar")
    public String reservarServicio(Model model) {
        model.addAttribute("reserva", new ReservaBarberia());
        return "reserva";
    }

    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id){
        reservaBarberiaService.delete(id);
        return "redirect:/listar";
    }

}
