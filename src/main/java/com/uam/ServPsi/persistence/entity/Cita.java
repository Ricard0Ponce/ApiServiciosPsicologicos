package com.uam.ServPsi.persistence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "Cita")
@Data
public class Cita {
    @Id
    @GeneratedValue
    private Long id;
    private Long matricula;
    private Long numTrabajador; //ID del Psiquiatra
    private Date fecha;
    private Time hora;
    private String motivoCita;
    private boolean discapacidad;
    private boolean comunidadIndigena;
    private boolean migrate;
}
