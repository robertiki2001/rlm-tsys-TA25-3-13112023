package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Almacen;


public interface IAlmacenService {
	
		//Listar todos
		public List<Almacen> listarAlmacenes();
		
		//Listar por id
		public Almacen almacenXID(Integer id); 
		
		//Guardar
		public Almacen guardarAlmacen(Almacen almacen);
		
		//Actualizar
		public Almacen actualizarAlmacen(Almacen almacen);
		
		//Eliminar
		public void eliminarAlmacen(Integer id);

}