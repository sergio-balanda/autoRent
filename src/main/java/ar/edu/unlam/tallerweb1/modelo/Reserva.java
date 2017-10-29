package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.Date;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	private Date fechaInicio;
	private Date fechaFin;
	private Double costoOrigen;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkVehiculo") 
	private Vehiculo fkVehiculo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkSucursalR")
	private Sucursal fkSucursalR;
	
	public Reserva() {
		super();
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Reserva(Integer idReserva, Date fechaInicio, Date fechaFin, Double costoOrigen, Vehiculo fkVehiculo,
			Sucursal fkSucursal) {
		super();
		this.idReserva = idReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoOrigen = costoOrigen;
		this.fkVehiculo = fkVehiculo;
		this.fkSucursalR = fkSucursal;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Vehiculo getFkVehiculo() {
		return fkVehiculo;
	}

	public void setFkVehiculo(Vehiculo fkVehiculo) {
		this.fkVehiculo = fkVehiculo;
	}

	public Sucursal getFkSucursalR() {
		return fkSucursalR;
	}

	public void setFkSucursal(Sucursal fkSucursalR) {
		this.fkSucursalR = fkSucursalR;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getCostoOrigen() {
		return costoOrigen;
	}

	public void setCostoOrigen(Double costoOrigen) {
		this.costoOrigen = costoOrigen;
	}

	
}