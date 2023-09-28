package com.uam.ServPsi.mapper;

import com.uam.ServPsi.persistence.entity.Alumno;
import com.uam.ServPsi.service.dto.AlumnoInDTO;
import org.springframework.stereotype.Component;

@Component
public class AlumnoInDTOToAlumno implements IMapper<AlumnoInDTO, Alumno>{
    @Override
    public Alumno map(AlumnoInDTO in) {
        Alumno alumno =  new Alumno();
        alumno.setNombre(in.getNombre());
        alumno.setApellidoP(in.getApellidoP());
        alumno.setApellidoM(in.getApellidoM());
        alumno.setEmail(in.getEmail());
        alumno.setGenero(in.getGenero());
        alumno.setTelefono(in.getTelefono());
        alumno.setConCita(false);//Cada que crea un elemento define cita como false
        return alumno;
    }
}
