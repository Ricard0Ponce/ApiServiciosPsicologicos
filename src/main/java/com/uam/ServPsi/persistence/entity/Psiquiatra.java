package com.uam.ServPsi.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //La clase se crea en una entidad
@Table(name="Psiquiatra") //Asigna nombre a la tabla.
@Data //Crea Getters/Setter de la clase con Lombook
public class Psiquiatra {
    @Id
    @GeneratedValue  //Asigna valores al elemento creado con Hibernate
    private Long id;
    private Long numTrabajador;
    private String password;
}
