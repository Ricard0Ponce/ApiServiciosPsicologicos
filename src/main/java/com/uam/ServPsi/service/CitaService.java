package com.uam.ServPsi.service;

import com.uam.ServPsi.persistence.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    //Inyeccion de dependencia
    @Autowired
    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    //Creamos los metodos, aqui van las reglas de negocio
    //Creamos un Psiquiatra
    //Faltan condicionales

}
