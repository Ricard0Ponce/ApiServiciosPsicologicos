package com.uam.ServPsi.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //La clase se crea en una entidad
@Table(name="Alumno") //Asigna nombre a la tabla.
@Data //Crea Getters/Setter de la clase con Lombooks
public class Alumno {
    @Id //Asigna la variable como id
    @GeneratedValue  //Asigna valores al elemento creado con Hibernate
    private Long id;
    private Long matricula;  //String o Long?
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
    private String genero;
    private String telefono;
    private String password;
    private boolean conCita;
    //Falta Cita
}
