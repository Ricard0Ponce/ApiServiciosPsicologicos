package com.uam.ServPsi.service;

import com.uam.ServPsi.mapper.AlumnoInDTOToAlumno;
import com.uam.ServPsi.persistence.repository.AlumnoRepository;
import com.uam.ServPsi.service.dto.AlumnoInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uam.ServPsi.persistence.entity.Alumno;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

//Aqui va la logica de negocio
@Service //Define la clase como un servivcio
public class AlumnoService {

    //Realizamos inyeccion de dependecia.
    //(Inyectar el objeto de una clase en otra.)
    @Autowired
    private final AlumnoRepository alumnoRepository;
    @Autowired
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

    //Regresa la lista de todos los alumnos
    public List<Alumno> findAll(){
        return this.alumnoRepository.findAll();
    }

    //Regresa una lista de alumnos que tienen el atricuta isconCita=true
    public List<Alumno> findByCita() {
        //Toma toda la lista de la BD
        List<Alumno> listaInicial = new ArrayList<>(this.alumnoRepository.findAll());

        // Utiliza Streams para filtrar la lista de alumnos con isConCita=true
        List<Alumno> listaFinal = listaInicial.stream()
                .filter(Alumno::isConCita)
                .collect(Collectors.toList());
        //Regresa la lista de alumnos isconcita=true
        return listaFinal;
    }

    //Encuentra un alumno por matricula
    public Alumno findByMatricula(Long matricula) {
        Optional <Alumno> alumno = alumnoRepository.findById(matricula);
        return alumno.get();
    }




}
