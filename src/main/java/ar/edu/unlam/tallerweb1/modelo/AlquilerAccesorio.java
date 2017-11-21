package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlquilerAccesorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlquilerAccesorio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fkAlquiler")
	private Alquiler fkAlquiler;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fkAccesorio")
	private Accesorio fkAccesorio;
	
	public AlquilerAccesorio(){
		super();
	}

	public AlquilerAccesorio(Integer idAlquilerAccesorio, Alquiler fkAlquiler, Accesorio fkAccesorio) {
		super();
		this.idAlquilerAccesorio = idAlquilerAccesorio;
		this.fkAlquiler = fkAlquiler;
		this.fkAccesorio = fkAccesorio;
	}

	public Integer getIdAlquilerAccesorio() {
		return idAlquilerAccesorio;
	}

	public void setIdAlquilerAccesorio(Integer idAlquilerAccesorio) {
		this.idAlquilerAccesorio = idAlquilerAccesorio;
	}

	public Alquiler getFkAlquiler() {
		return fkAlquiler;
	}

	public void setFkAlquiler(Alquiler fkAlquiler) {
		this.fkAlquiler = fkAlquiler;
	}

	public Accesorio getFkAccesorio() {
		return fkAccesorio;
	}

	public void setFkAccesorio(Accesorio fkAccesorio) {
		this.fkAccesorio = fkAccesorio;
	}

}
