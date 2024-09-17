package com.example.logisticAPP.controllers;

import com.example.logisticAPP.models.Client;
import com.example.logisticAPP.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("logisticApp/v1/clientes") //endpoint orientado al recurso
public class ClienteControlador {

    @Autowired
    ClientServices clienteServicio;

    @PostMapping
    public ResponseEntity<?> llamandoAlServicioParaGuardar(@RequestBody Client datosCliente ){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteServicio.registrar(datosCliente));
        } catch (Exception error){
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }

    @GetMapping
    public ResponseEntity<?> llamandoAlServicioParaBuscarTodas(){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(this.clienteServicio.buscarMercancias());

        } catch (Exception error) {
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }
}
