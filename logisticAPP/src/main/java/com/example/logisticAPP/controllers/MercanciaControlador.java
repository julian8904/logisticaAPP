package com.example.logisticAPP.controllers;


import com.example.logisticAPP.models.Commodity;
import com.example.logisticAPP.services.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("logisticApp/v1/mercancias") //endpoint orientado al recurso
public class MercanciaControlador {

    //inyectar una dependencia al servicio
    @Autowired
    CommodityService mercanciaServicio;

    @PostMapping
    //Se crea un método para llamar a cada uno de los servicios disponibles
     public ResponseEntity<?> llamandoAlServicioParaGuardar(@RequestBody Commodity datosMercancia){
         try {
             return ResponseEntity.status(HttpStatus.CREATED).body(this.mercanciaServicio.registrar(datosMercancia));

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

            return ResponseEntity.status(HttpStatus.OK).body(this.mercanciaServicio.buscarMercanciaas());

        } catch (Exception error) {
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
     }
}
