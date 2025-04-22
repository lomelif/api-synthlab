package com.synthlab.synthlab_api.Controllers;

import org.springframework.web.bind.annotation.*;

import com.synthlab.synthlab_api.Entities.Leccion;
import com.synthlab.synthlab_api.Entities.LeccionContenido;
import com.synthlab.synthlab_api.Services.LeccionService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lecciones")
public class LeccionController {
    private final LeccionService leccionService;

    public LeccionController(LeccionService leccionService) {
        this.leccionService = leccionService;
    }

    @GetMapping("/{id}")
    public Leccion getLeccion(@PathVariable Long id) {
        return leccionService.getLeccion(id);
    }

    @GetMapping
    public List<Leccion> getTitulos() {
        return leccionService.getTitulos();
    }

    @GetMapping("/contenidos")
    public List<LeccionContenido> getContenidos() {
        return leccionService.getContenidos();
    }
}
