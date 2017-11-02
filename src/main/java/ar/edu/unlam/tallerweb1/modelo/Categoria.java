package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	private String nombre;
	private float costoHora;
	@OneToMany(mappedBy="fkCategoriaV",cascade=CascadeType.ALL) 
	private List<Vehiculo> vehiculo = new ArrayList<>();
	
	public Categoria() {
		super();
	}
	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(float costoHora) {
		this.costoHora = costoHora;
	}
	
	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
