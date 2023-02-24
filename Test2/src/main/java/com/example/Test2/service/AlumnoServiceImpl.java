package com.example.Test2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.Test2.modelo.Alumno;
import com.example.Test2.repository.AlumnoRepository;




@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, Long> implements AlumnoService {
	
	
	@Autowired
    AlumnoRepository alumnoRepository;
    
    @Override
    public CrudRepository<Alumno, Long> getDao() {
        return alumnoRepository;
    }

}
