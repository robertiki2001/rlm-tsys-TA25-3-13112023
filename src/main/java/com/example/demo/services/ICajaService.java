package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Caja;


public interface ICajaService {
	
		//Listar todos
		public List<Caja> listarCajas();
		
		//Listar por id
		public Optional<Caja> getCajaXID(String num_referencia); 
		
		//Guardar
		public Caja guardarCaja(Caja caja);
		
		//Actualizar
		public Caja actualizarCaja(Caja caja);
		
		//Eliminar
		public void eliminarCaja(String num_referencia);

}