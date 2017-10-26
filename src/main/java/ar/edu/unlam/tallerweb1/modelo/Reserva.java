package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReserva;
	private Date fechaInicio;
	private Date fechaFin;
	private Double costoOrigen;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkVehiculoR")
	private Vehiculo vehiculo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkSucursalR")
	private Sucursal sucursal;
	
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

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getCostoOrigen() {
		return costoOrigen;
	}

	public void setCostoOrigen(Double costoOrigen) {
		this.costoOrigen = costoOrigen;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}