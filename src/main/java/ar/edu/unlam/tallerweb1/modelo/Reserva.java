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
	private float costoOrigen;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkVehiculoR") 
	private Vehiculo fkVehiculoR;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkSucursalR")
	private Sucursal fkSucursalR;
	
	public Reserva(){}
	
	public Reserva(Integer idReserva, Date fechaInicio, Date fechaFin, float costoOrigen, Vehiculo fkVehiculoR,
			Sucursal fkSucursalR) {
		super();
		this.idReserva = idReserva;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoOrigen = costoOrigen;
		this.fkVehiculoR = fkVehiculoR;
		this.fkSucursalR = fkSucursalR;
	}
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
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
	public float getCostoOrigen() {
		return costoOrigen;
	}
	public void setCostoOrigen(float costoOrigen) {
		this.costoOrigen = costoOrigen;
	}
	public Vehiculo getFkVehiculoR() {
		return fkVehiculoR;
	}
	public void setFkVehiculoR(Vehiculo fkVehiculoR) {
		this.fkVehiculoR = fkVehiculoR;
	}
	public Sucursal getFkSucursalR() {
		return fkSucursalR;
	}
	public void setFkSucursalR(Sucursal fkSucursalR) {
		this.fkSucursalR = fkSucursalR;
	}
	
}