package com.example.demo.dto;

import jakarta.persistence.*;

@Entity
@Table(name="cajas")
public class Caja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String num_referencia;
	private String contenido;
	private int valor;
	
	@ManyToOne
    @JoinColumn(name="id_almacen")
	private Almacen almacen;
	
	public Caja() {
		
	}

	public Caja(String num_referencia, String contenido, int valor, Almacen almacen) {
		this.num_referencia = num_referencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	public String getNum_referencia() {
		return num_referencia;
	}

	public void setNum_referencia(String num_referencia) {
		this.num_referencia = num_referencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
}