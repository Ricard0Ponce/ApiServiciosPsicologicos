package com.uam.ServPsi.service.dto;

import lombok.Data;

//Creamos un DTO, este dto tiene todos los datos excepto si tiene o no cita.
@Data
public class AlumnoInDTO {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String email;
    private String genero;
    private String telefono;
    private String password;

}
