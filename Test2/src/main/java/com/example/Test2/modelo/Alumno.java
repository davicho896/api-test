package com.example.Test2.modelo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Document(collection="Alumno")
@Data
public class Alumno {
	
	private long Id;
	private String nombre;
	private String apellido;
	private String direccion;
	


}
