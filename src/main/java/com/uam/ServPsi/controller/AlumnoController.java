package com.uam.ServPsi.controller;

import com.uam.ServPsi.persistence.entity.Alumno;
import com.uam.ServPsi.service.AlumnoService;
import com.uam.ServPsi.service.dto.AlumnoInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Reconoce que es un controlador
@RequestMapping("/alumnos") //Define el camino del controlador, se define en ()
public class AlumnoController {

    //NOTA: La capa de controller solo se comunica con la capa de service
    //NOTA 2: Siempre que tengamos un controlador va en plural. Alumno-Alumnos
    private final AlumnoService alumnoService;
    //Se agrega la inyeccion de dependencias
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    //Metodo que permite crear un alumno desde Swagger
    @PostMapping //Notacion que permite crear elementos
    public Alumno createAlumno(@RequestBody AlumnoInDTO alumnoInDTO){
        return this.alumnoService.createAlumno(alumnoInDTO);//


    }
}
