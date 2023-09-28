package com.uam.ServPsi.service;

import com.uam.ServPsi.mapper.AlumnoInDTOToAlumno;
import com.uam.ServPsi.persistence.repository.AlumnoRepository;
import com.uam.ServPsi.service.dto.AlumnoInDTO;
import org.springframework.stereotype.Service;
import com.uam.ServPsi.persistence.entity.Alumno;
//Aqui va la logica de negocio
@Service //Define la clase como un servivcio
public class AlumnoService {

    //Realizamos inyeccion de dependecia.
    //(Inyectar el objeto de una clase en otra.)
    private final AlumnoRepository alumnoRepository;
    private final AlumnoInDTOToAlumno mapper;//Inyectamos el mapper

    //Inyeccion de dependencia.
    public AlumnoService(AlumnoRepository alumnoRepository, AlumnoInDTOToAlumno mapper) {
        this.alumnoRepository = alumnoRepository;  //Inyeccion de AlumnoRepository
        this.mapper = mapper;//Inyeccion para Mapper
    }

    //Crear un alumno.
    public Alumno createAlumno(AlumnoInDTO alumnoInDTO){
       Alumno alumno = mapper.map(alumnoInDTO); //Mappeamos el objeto
        return this.alumnoRepository.save(alumno); //Guarda el Alumno Mappeado
    }
}
