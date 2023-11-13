package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.Almacen;
import com.example.demo.services.AlmacenService;

@RestController
@RequestMapping("/api")
public class AlmacenController {

	@Autowired
	AlmacenService almacenService;

	@GetMapping("/almacenes")
	public List<Almacen> listarAlmacenes() {
		return almacenService.listarAlmacenes();
	}

	@GetMapping("/almacen/{id}")
	public Almacen almacenXID(@PathVariable(name = "id") Integer id) {
		return almacenService.almacenXID(id);
	}

	@PostMapping("/almacen")
	public Almacen guardarAlmacen(@RequestBody Almacen almacen) {
		return almacenService.guardarAlmacen(almacen);
	}

	@PutMapping("/almacen/{id}")
	public Almacen actualizarAlmacen(@PathVariable(name = "id") Integer id, @RequestBody Almacen almacen) {

		Almacen almacen_seleccionado = almacenService.almacenXID(id);
		Almacen almacen_actualizado = new Almacen();

		almacen_seleccionado.setLugar(almacen.getLugar());
		almacen_seleccionado.setCapacidad(almacen.getCapacidad());

		almacen_actualizado = almacenService.actualizarAlmacen(almacen_seleccionado);

		return almacen_actualizado;
	}

	@DeleteMapping("/almacen/{id}")
	public void eliminarAlmacen(@PathVariable Integer id) {
		almacenService.eliminarAlmacen(id);
	}

}
