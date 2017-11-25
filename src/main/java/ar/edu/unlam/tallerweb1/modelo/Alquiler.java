package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Alquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlquiler;
	@OneToOne
	@JoinColumn(name="fkReserva")
	private Reserva fkReserva;
	@OneToMany(mappedBy="fkAlquiler")
	private List<AlquilerAccesorio> alquilerAccesorio = new ArrayList<>();
	private String estado;
	private Double precioFinal;
	
	public Alquiler(){
		super();
	}

	public Alquiler(Integer idAlquiler, Reserva fkReserva, List<AlquilerAccesorio> alquiler) {
		super();
		this.idAlquiler = idAlquiler;
		this.fkReserva = fkReserva;
		this.alquilerAccesorio = alquilerAccesorio;
	}

	public List<AlquilerAccesorio> getAlquilerAccesorio() {
		return alquilerAccesorio;
	}

	public void setAlquilerAccesorio(List<AlquilerAccesorio> alquilerAccesorio) {
		this.alquilerAccesorio = alquilerAccesorio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Reserva getFkReserva() {
		return fkReserva;
	}

	public void setFkReserva(Reserva fkReserva) {
		this.fkReserva = fkReserva;
	}



}
