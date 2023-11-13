package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAlmacenDAO;
import com.example.demo.dto.Almacen;

@Service
public class AlmacenService implements IAlmacenService{
	
	@Autowired
	IAlmacenDAO iAlmacenDAO;

		//Listar todos
		public List<Almacen> listarAlmacenes(){
			return iAlmacenDAO.findAll();
		};
		
		//Listar por id
		public Almacen almacenXID(Integer id) {
			return iAlmacenDAO.findById(id).get();
		}; 
		
		//Guardar
		public Almacen guardarAlmacen(Almacen almacen) {
			return iAlmacenDAO.save(almacen);
		};
		
		//Actualizar
		public Almacen actualizarAlmacen(Almacen almacen) {
			return iAlmacenDAO.save(almacen);
		};
		
		//Eliminar
		public void eliminarAlmacen(Integer id) {
			iAlmacenDAO.deleteById(id);
		}		

}