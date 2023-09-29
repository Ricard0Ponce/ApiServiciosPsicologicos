package com.uam.ServPsi.controller;

import com.uam.ServPsi.persistence.entity.Psiquiatra;
import com.uam.ServPsi.service.PsiquiatraService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Reconoce que es un controlador
@RequestMapping("/V1") //Versionamiento del API
@Slf4j
public class PsiquiatraController {

    //Inyeccion de dependencias
    @Autowired
    private final PsiquiatraService psiquiatraService;

    public PsiquiatraController(PsiquiatraService psiquiatraService) {
        this.psiquiatraService = psiquiatraService;
    }

    @ApiOperation(
            value = "Crear Psiquiatra",
            notes = "Permite crear un nuevo Psiquiatra."
    ) // Documentacion del api
    @PostMapping(path = "/psiquiatras", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?> createPsiquiatra(@RequestBody Psiquiatra psiquiatra) {
        Psiquiatra psiquiatraF = psiquiatraService.createPsiquiatra(psiquiatra);
        if(psiquiatraF != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(psiquiatraF);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @ApiOperation(
            value = "Loggea Psiquiatra",
            notes = "Permite Loggear un Psiquiatra."
    ) // Documentacion del api
    @GetMapping(path = "/psiquiatra/{matricula},{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?> logginPsiquiatra( @PathVariable("matricula") Long matricula,
                                                @PathVariable ("password") String password) {
        boolean result=false;
        if(matricula != null && password!= null) {
            result = psiquiatraService.logginPsiquiatra(matricula,password);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
