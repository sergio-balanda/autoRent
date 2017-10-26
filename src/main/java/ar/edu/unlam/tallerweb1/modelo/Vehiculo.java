package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehiculo;
	private String patente;
	private String marca;
	private String nombre;
	private String imagen;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return imagen;
	}

	public void setFoto(String imagen) {
		this.imagen = imagen;
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