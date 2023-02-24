package com.example.Test2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Test2.modelo.Alumno;

public interface AlumnoRepository extends MongoRepository<Alumno, Long>{

}
