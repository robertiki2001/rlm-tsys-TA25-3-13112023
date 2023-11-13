package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Caja;
import com.example.demo.services.CajaService;

@RestController
@RequestMapping("/api")
public class CajaController {

	@Autowired
	CajaService cajaService;

	@GetMapping("/cajas")
	public List<Caja> listarCajas() {
		return cajaService.listarCajas();
	}

	@GetMapping("/caja/{num_referencia}")
	public ResponseEntity<Caja> cajaXID(@PathVariable(name = "num_referencia") String num_referencia) {
		Optional<Caja> caja = cajaService.getCajaXID(num_referencia);
		if (caja.isPresent()) {
			return ResponseEntity.ok(caja.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/caja")
	public Caja guardarCaja(@RequestBody Caja caja) {
		return cajaService.guardarCaja(caja);
	}

	@PutMapping("/caja/{num_referencia}")
	public ResponseEntity<Caja> actualizarCaja(@PathVariable(name = "num_referencia") String num_referencia, @RequestBody Caja caja) {

	    Optional<Caja> caja_seleccionado = cajaService.getCajaXID(num_referencia);

	    if (caja_seleccionado.isPresent()) {
	        Caja caja_existente = caja_seleccionado.get();

	        if (caja.getContenido() != null) {
	            caja_existente.setContenido(caja.getContenido());
	        }
	        if (caja.getValor() != 0) {
	            caja_existente.setValor(caja.getValor());
	        }
	        if (caja.getAlmacen() != null) {
	            caja_existente.setAlmacen(caja.getAlmacen());
	        }
	        Caja caja_actualizado = cajaService.actualizarCaja(caja_existente);

	        return ResponseEntity.ok(caja_actualizado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	@DeleteMapping("/caja/{num_referencia}")
	public ResponseEntity<Void> eliminarCaja(@PathVariable(name = "num_referencia") String num_referencia) {
		Optional<Caja> caja = cajaService.getCajaXID(num_referencia);
		if (caja.isPresent()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
