package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkSucursalV")
	private Sucursal fkSucursalV;
	@OneToOne(mappedBy="fkVehiculo")
	private Reserva reserva = new Reserva();
	
	/*	
 	private Integer fkCategoriaV;
	*/

	public Vehiculo() {
		super();
	}

	

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	

	public Vehiculo(Integer idVehiculo, String patente, String marca, String nombre, String imagen,
			Integer capacidadPasajeros, Integer capacidadValijas, Integer kilometraje, Sucursal fkSucursal,
			Reserva reserva) {
		super();
		this.idVehiculo = idVehiculo;
		this.patente = patente;
		this.marca = marca;
		this.nombre = nombre;
		this.imagen = imagen;
		this.capacidadPasajeros = capacidadPasajeros;
		this.capacidadValijas = capacidadValijas;
		this.kilometraje = kilometraje;
		this.fkSucursalV = fkSucursal;
		this.reserva = reserva;
	}



	public Sucursal getFkSucursal() {
		return fkSucursalV;
	}



	public void setFkSucursal(Sucursal fkSucursalV) {
		this.fkSucursalV = fkSucursalV;
	}



	public Reserva getReserva() {
		return reserva;
	}



	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
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