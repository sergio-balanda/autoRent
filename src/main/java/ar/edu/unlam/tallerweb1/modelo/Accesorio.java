package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Accesorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccesorio;
	private String nombre;
	private Double costoDia;
	@OneToMany(mappedBy="fkAccesorio")
	private List<AlquilerAccesorio> accesorio = new ArrayList<>();
	
	public Accesorio(){
		super();
	}

	public Accesorio(Integer idAccesorio, String nombre, Double costoDia, List<AlquilerAccesorio> accesorio) {
		super();
		this.idAccesorio = idAccesorio;
		this.nombre = nombre;
		this.costoDia = costoDia;
		this.accesorio = accesorio;
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

	public List<AlquilerAccesorio> getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(List<AlquilerAccesorio> accesorio) {
		this.accesorio = accesorio;
	}
	
}
