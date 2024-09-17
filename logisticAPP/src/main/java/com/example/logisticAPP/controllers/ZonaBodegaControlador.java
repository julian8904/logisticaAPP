package com.example.logisticAPP.controllers;


import com.example.logisticAPP.models.StoreZone;
import com.example.logisticAPP.services.StoreZoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("logisticApp/v1/zonaBodega")
public class ZonaBodegaControlador {

    @Autowired
    StoreZoneServices zonaBodegaServicio;

    @PostMapping
    //Se crea un método para llamar a cada uno de los servicios disponibles
    public ResponseEntity<?> llamandoAlServicioParaGuardar(@RequestBody StoreZone datosZonaBodega) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.zonaBodegaServicio.registrar(datosZonaBodega));

        } catch (Exception error) {
            //El hashMap nos permite responder con un mensaje de error
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }

    @GetMapping
    public ResponseEntity<?> llamandoAlServicioParaBuscarTodas(){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(this.zonaBodegaServicio.buscarMercancias());

        } catch (Exception error) {
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }
}
