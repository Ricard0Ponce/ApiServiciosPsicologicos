package com.uam.ServPsi.persistence.repository;

import com.uam.ServPsi.persistence.entity.Alumno;
import com.uam.ServPsi.persistence.entity.Psiquiatra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsiquiatraRepository extends JpaRepository<Psiquiatra, Long> {
}
