package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;
	private String patente;
	private String marca;
	private String modelo;
	private String nombre;
	private Integer capacidadPasajeros;
	private Integer capacidadValijas;
	private Integer kilometraje;

	public Vehiculo() {
		super();
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	public void setCapacidadPasajeros(Integer capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}

	public Integer getCapacidadValijas() {
		return capacidadValijas;
	}

	public void setCapacidadValijas(Integer capacidadValijas) {
		this.capacidadValijas = capacidadValijas;
	}

	public Integer getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(Integer kilometraje) {
		this.kilometraje = kilometraje;
	}

}
