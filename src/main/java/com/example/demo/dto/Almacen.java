package com.example.demo.dto;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "almacenes")
public class Almacen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lugar;
	private int capacidad;
	
	@OneToMany
    @JoinColumn(name="id")
	private List<Caja> caja;
	
	  public Almacen() {
	    }
	  
	    public Almacen(int id, String lugar, int capacidad) {
	    	this.id = id;
	        this.lugar = lugar;	   
	        this.capacidad = capacidad;	   
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getLugar() {
			return lugar;
		}

		public void setLugar(String lugar) {
			this.lugar = lugar;
		}

		public int getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

}