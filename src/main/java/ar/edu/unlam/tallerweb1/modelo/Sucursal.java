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
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSucursal;
	private String ciudad;
	private String provincia;
	private String domicilio;
	@OneToMany(mappedBy="fkSucursalR",cascade=CascadeType.ALL) 
	private List<Reserva> reserva = new ArrayList<>();
	@OneToMany(mappedBy="fkSucursalV",cascade=CascadeType.ALL) 
	private List<Vehiculo> vehiculo = new ArrayList<>();
	
	
	public Sucursal() {
		super();
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

}