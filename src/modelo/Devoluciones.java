package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Devoluciones {
	private Arbol<Devolucion> devoluciones;

	public Devoluciones() {

		devoluciones = new Arbol<>();
	}

	public void devolverLibro(Devolucion devolucion) {
		devoluciones.insertar(devolucion);
	}

	public String listaDevoluciones() {
		return "Historial de Devoluciones : \n" + devoluciones.getDatosOrden();
	}

	public boolean estaVacio() {
		return devoluciones.estaVacio();
	}

	public LocalDate asignarFechaEntrega(Prestamo p) {
		LocalDate date = LocalDate.now();
		date = date.plusDays(2);
		if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			date = date.plusDays(2);
		} else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY))
			date = date.plusDays(1);
		return date;

	}

}
