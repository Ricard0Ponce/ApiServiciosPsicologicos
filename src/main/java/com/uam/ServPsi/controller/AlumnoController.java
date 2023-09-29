package com.uam.ServPsi.controller;

import com.uam.ServPsi.persistence.entity.Alumno;
import com.uam.ServPsi.service.AlumnoService;
import com.uam.ServPsi.service.dto.AlumnoInDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController //Reconoce que es un controlador
@RequestMapping("/V1") //Versionamiento del API
@Slf4j
public class AlumnoController {

    //NOTA: La capa de controller solo se comunica con la capa de service
    //NOTA 2: Siempre que tengamos un controlador va en plural. Alumno-Alumnos
    @Autowired
    private final AlumnoService alumnoService;
    //Se agrega la inyeccion de dependencias
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    //Metodo que permite crear un alumno desde Swagger
    @ApiOperation(
            value = "Crear alumno",
            notes = "Permite crear un nuevo alumno."
    ) // Documentacion del api
    @PostMapping(path = "/alumnos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) //Notacion que permite crear elementos
    //Nota: Aun no tiene validaciones
    public ResponseEntity <?> createAlumno(@RequestBody AlumnoInDTO alumnoInDTO) {
        Alumno alumno = alumnoService.createAlumno(alumnoInDTO);//Creamos al alumno
        if (alumno != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @ApiOperation(
            value = "Regresa la lista de alumnos",
            notes = "Permite obtener una lista con todos los alumnos."
    ) // Documentacion del api
    @GetMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?> findAll(){
        Iterable <Alumno> lista = alumnoService.findAll(); //Diferencia entre findAll y retriveAll??
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }


    //Pasar esto al nuevo formato
    @ApiOperation(
            value = "Regresa la lista de alumnos con cita",
            notes = "Permite obtener una lista con todos los alumnos con citas regstradas."
    ) // Documentacion del api
   @GetMapping(path = "/alumnos/cita", produces = MediaType.APPLICATION_JSON_VALUE) // Define el mapeo GET /alumnos/con-cita
    public ResponseEntity <?> findAlumnosByCita() {
        List <Alumno> alumnos = alumnoService.findByCita();
        return ResponseEntity.status(HttpStatus.OK).body(alumnos);
    }

    @ApiOperation(
            value = "Regresa a un alumno dada su matricula",
            notes = "Regresa un alumno dada su matricula con sus datos"
    ) // Documentacion del api
    @GetMapping(path = "/alumnos/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <?> findAlumnoByMatricula(@PathVariable("matricula") Long matricula) {
        Alumno alumno;
        if(matricula != null){
            alumno = alumnoService.findByMatricula(matricula);
            return ResponseEntity.status(HttpStatus.OK).body(alumno);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

} //Termina clase AlumnoController
