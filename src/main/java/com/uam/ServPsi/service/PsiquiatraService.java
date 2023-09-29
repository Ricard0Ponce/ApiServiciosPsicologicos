package com.uam.ServPsi.service;

import com.uam.ServPsi.persistence.entity.Alumno;
import com.uam.ServPsi.persistence.entity.Psiquiatra;
import com.uam.ServPsi.persistence.repository.PsiquiatraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PsiquiatraService {
    //Se realiza la Inyeccion de dependencias
    @Autowired
    private final PsiquiatraRepository psiquiatraRepository;

    public PsiquiatraService(PsiquiatraRepository psiquiatraRepository) {
        this.psiquiatraRepository = psiquiatraRepository;
    }

    //Creamos los metodos, aqui van las reglas de negocio
    //Creamos un Psiquiatra
    //Faltan condicionales
    public Psiquiatra createPsiquiatra(Psiquiatra psiquiatra) {
        return this.psiquiatraRepository.save(psiquiatra); //Agregamos un psiquiatra
    }

    public boolean logginPsiquiatra(Long matricula, String password) {
        List<Psiquiatra> lista = new ArrayList<>(this.psiquiatraRepository.findAll());
        int x=0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumTrabajador().equals(matricula) && lista.get(i).getPassword().equals(password)) {
               x=1;
            } else {
                x=0;
            }
        }
        if(x==1){
            return true;
        } else{
            return false;
        }
    }
}

