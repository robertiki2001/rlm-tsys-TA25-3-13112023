package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajaDAO;
import com.example.demo.dto.Caja;

@Service
public class CajaService implements ICajaService{
	
	@Autowired
	ICajaDAO iCajaDAO;

		//Listar todos
		public List<Caja> listarCajas(){
			return iCajaDAO.findAll();
		};
		
		//Listar por id
		public Optional<Caja> getCajaXID(String num_referencia) {
		    return iCajaDAO.findById(num_referencia);
		}
		
		//Guardar
		public Caja guardarCaja(Caja caja) {
			return iCajaDAO.save(caja);
		};
		
		//Actualizar
		public Caja actualizarCaja(Caja caja) {
			return iCajaDAO.save(caja);
		};
		
		//Eliminar
		public void eliminarCaja(String num_referencia) {
			iCajaDAO.deleteById(num_referencia);
		}



}