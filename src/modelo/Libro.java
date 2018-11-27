package modelo;

public class Libro extends Object implements Comparable<Libro> {

	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private String edicion;
	private boolean estaPrestado;
	private String noControlAlumno;

	public Libro() {

	}

	public Libro(String isbn, String titulo, String autor, String editorial, String edicion) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public void setnoControlAlumno(String n) {
		this.noControlAlumno = n;
	}

	public String getNoControlAlumno() {
		return noControlAlumno;
	}

	public void prestarLibro(String noControlA) {
		this.noControlAlumno = noControlA;
		this.estaPrestado = true;
	}

	public boolean estaPrestado() {
		return estaPrestado;
	}

	public void setEstaPrestado(boolean estaPrestado) {
		this.estaPrestado = estaPrestado;
	}

	public void devolver() {
		this.estaPrestado = false;
		this.noControlAlumno = "No Prestado";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	@Override
	public String toString() {
		return "\nISBN: " + isbn + "\n TITULO: " + titulo + "\n AUTOR: " + autor + "\n EDITORIAL: " + editorial
				+ "\n EDICION: " + edicion + "\n Esta Prestado: " + (estaPrestado ? "SI" : "NO") + "\n";
	}

	@Override
	public int compareTo(Libro o) {
		return isbn.compareTo(o.getIsbn());
	}

}
