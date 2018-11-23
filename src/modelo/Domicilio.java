package modelo;

public class Domicilio {
	private short numeroCasa;
	private String calle;
	private String colonia;
	private String codigoPostal;
	private String ciudad;
	private String estado;

	public Domicilio() {
		this((short)0, null, null, null, null, null);
	}

	public Domicilio(short numeroCasa, String calle, String colonia, String codigoPostal, String ciudad, String estado) {
		this.numeroCasa = numeroCasa;
		this.calle = calle;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.estado = estado;
	}


	public short getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(short numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return calle + " N. " + numeroCasa + " Col. " + colonia + " " + ciudad + " " + estado + " CP:  " + codigoPostal;	
	}

}
