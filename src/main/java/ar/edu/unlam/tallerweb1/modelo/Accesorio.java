package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accesorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccesorio;
	private String nombre;
	private Double costoDia;

	public Accesorio() {

	}

	public Integer getIdAccesorio() {
		return idAccesorio;
	}

	public void setIdAccesorio(Integer idAccesorio) {
		this.idAccesorio = idAccesorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCostoDia() {
		return costoDia;
	}

	public void setCostoDia(Double costoDia) {
		this.costoDia = costoDia;
	}

}
