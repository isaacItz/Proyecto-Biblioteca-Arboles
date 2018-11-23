package modelo;

import java.time.LocalDate;

public class Devolucion implements Comparable<Devolucion> {
	private String isbn;
	private boolean devuelto = false;
	private LocalDate fechaDevuelto;
	private String titulo;

	public Devolucion(String isbn, String titulo, boolean devuelto, LocalDate fechaDevuelto) {
		super();
		this.isbn = isbn;
		this.devuelto = devuelto;
		this.fechaDevuelto = fechaDevuelto;
		this.titulo = titulo;

	}

	public Devolucion() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	public LocalDate getFechaDevuelto() {
		return fechaDevuelto;
	}

	public void setFechaDevuelto(LocalDate fechaDevuelto) {
		this.fechaDevuelto = fechaDevuelto;
	}

	@Override
	public int compareTo(Devolucion o) {
		return 0;
	}

	@Override
	public String toString() {
		return "ISBN: " + isbn + " Titulo: " + titulo + " Devuelto: " + devuelto + " Fecha de Devolucion:"
				+ fechaDevuelto + "\n";
	}

}
