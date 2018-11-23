package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prestamos {
	private Arbol<Prestamo> listaPrestamos;
	Estante estante;
	Grupo grupo;
	private String salida;
	private int contadorL;

	public Prestamos(Estante estante, Grupo grupo) {
		contadorL = 0;
		this.grupo = grupo;
		this.estante = estante;
		this.listaPrestamos = new Arbol<>();
		salida = "";
	}

	public void agregarPrestamo(Prestamo prestamo) {
		listaPrestamos.insertar(prestamo);
		estante.consultar(prestamo.getISBN()).setEstaPrestado(true);
	}

	public void eliminar(Prestamo prestamo) {
		listaPrestamos.eliminar(listaPrestamos.buscar(prestamo));
	}

	public boolean hayPrestamos() {
		return listaPrestamos.estaVacio();
	}

	public String listaLibrosPrestados() {
		return "Libros prestados: \n" + listaPrestamos.getDatosOrden();
	}

	public LocalDate asignarFechaEntrega(Prestamo p) {
		LocalDate date = p.getFechaDePrestamo();
		date = date.plusDays(2);
		if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			date = date.plusDays(2);
		} else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY))
			date = date.plusDays(1);

		return date;

	}

	/*
	 * public String consultarLibrosAlumno(String numControl) { String salida =
	 * "Libros prestados a: " + grupo.consultar(numControl).getNombre() + " " +
	 * grupo.consultar(numControl).getPaterno() + " " +
	 * grupo.consultar(numControl).getMaterno() + "\n"; Alumno alumno = new
	 * Alumno(); alumno.setNumeroControl(numControl); Nodo<Prestamo> p =
	 * listaPrestamos.getRaiz();
	 * 
	 * boolean bandera = false; while (p != null) { if
	 * ((p.getDato().compareTo(numControl))) { salida += "ISBN: " +
	 * p.getDato().getISBN() + " TITULO: " +
	 * estante.consultar(p.getDato().getISBN()).getTitulo() + "\n"; } if (!bandera)
	 * { p = p.getHijoDerecho(); bandera = p == null ? true : false; } else { p =
	 * p.getHijoIzquierdo(); }
	 * 
	 * } return salida; }
	 */

	public void tienePrestado(Nodo<Prestamo> raiz, String num) {

		if (raiz != null) {
			tienePrestado(raiz.getHijoIzquierdo(), num);
			if (raiz.getDato().getNumeroDeControl().equals(num))
				contadorL++;
			tienePrestado(raiz.getHijoDerecho(), num);
		}

	}

	public boolean hasPres(String num) {
		Nodo<Prestamo> rai = listaPrestamos.getRaiz();
		tienePrestado(rai, num);
		int contadorL = this.contadorL;
		this.contadorL = 0;
		return contadorL > 0;
	}

	public String enOrden(Nodo<Prestamo> raiz, String num) {

		if (raiz != null) {
			enOrden(raiz.getHijoIzquierdo(), num);
			if (raiz.getDato().getNumeroDeControl().equals(num)) {
				salida += "Titulo: " + estante.consultar(raiz.getDato().getISBN()).getTitulo() + "\n";
				salida += "Fecha Salida: " + raiz.getDato().getFechaDePrestamo() + ("   ");
				salida += "Fecha Entrega: " + raiz.getDato().getFechaDeEntrega() + "\n";
			}
			enOrden(raiz.getHijoDerecho(), num);
		}
		return salida;

	}

	public String consultarLibrosAlumno(String numControl) {
		String salida = "Libros prestados a: " + grupo.consultar(numControl).getNombre() + " "
				+ grupo.consultar(numControl).getPaterno() + " " + grupo.consultar(numControl).getMaterno() + "\n";
		Alumno alumno = new Alumno();
		alumno.setNumeroControl(numControl);
		Nodo<Prestamo> p = listaPrestamos.getRaiz();
		salida += enOrden(p, numControl);
		this.salida = "";
		return salida;
	}

	public Prestamo consultar(String isbn) {
		Prestamo prestamo = new Prestamo();
		prestamo.setISBN(isbn);
		return listaPrestamos.buscar(prestamo) != null ? listaPrestamos.buscar(prestamo).getSegundo().getDato() : null;
	}

	/*
	 * public boolean existeAlumno(Alumno alumno) { return listaPrestamos. }
	 */

}
