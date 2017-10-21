package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehiculo {
	@Id
	private Long id;
	private Integer cantidadDePersonas;
	private Integer cantidadEquipaje;
	private String patente;
	
	public Vehiculo(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidadDePersonas() {
		return cantidadDePersonas;
	}

	public void setCantidadDePersonas(Integer cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}

	public Integer getCantidadEquipaje() {
		return cantidadEquipaje;
	}

	public void setCantidadEquipaje(Integer cantidadEquipaje) {
		this.cantidadEquipaje = cantidadEquipaje;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
}
