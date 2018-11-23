package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo implements Comparable<Prestamo> {
	private String numeroDeControl;
	private String ISBN;
	private LocalDate fechaDePrestamo;
	private LocalDate fechaDeEntrega;

	public Prestamo(String numeroDeControl, String iSBN, LocalDate fechaDePrestamo, LocalDate fechaDeEntrega) {
		super();
		this.numeroDeControl = numeroDeControl;
		ISBN = iSBN;
		this.fechaDePrestamo = fechaDePrestamo;
		this.fechaDeEntrega = fechaDeEntrega;
	}

	public Prestamo() {

	}

	public String getNumeroDeControl() {
		return numeroDeControl;
	}

	public void setNumeroDeControl(String numeroDeControl) {
		this.numeroDeControl = numeroDeControl;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public LocalDate getFechaDePrestamo() {
		return fechaDePrestamo;
	}

	public void setFechaDePrestamo(LocalDate fechaDePrestamo) {
		this.fechaDePrestamo = fechaDePrestamo;
	}

	public LocalDate getFechaDeEntrega() {
		return fechaDeEntrega;
	}

	public void setFechaDeEntrega(LocalDate fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}

	@Override
	public String toString() {
		return "Numero De Control: " + numeroDeControl + " ISBN: " + ISBN + " Fecha De Prestamo: " + fechaDePrestamo
				+ ", Fecha De Entrega: " + fechaDeEntrega + "\n";
	}

	@Override
	public int compareTo(Prestamo o) {
		return ISBN.compareTo(o.ISBN);
	}

}
