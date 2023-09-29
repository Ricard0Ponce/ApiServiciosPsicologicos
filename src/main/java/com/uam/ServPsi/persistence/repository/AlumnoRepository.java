package com.uam.ServPsi.persistence.repository;

import com.uam.ServPsi.persistence.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

//Extiende de la entidad de JPA llamada JPARepository
//Recibe 2 parametros, el tipo de dato y el id
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
