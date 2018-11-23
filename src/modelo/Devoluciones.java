package modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

	public boolean hayDevoluciones() {
		return devoluciones.estaVacio();
	}

	public String getFechaEntrega() {
		Calendar fecha = new GregorianCalendar();
		int dia = (fecha.get(Calendar.DATE)) + 3;
		int mes = (fecha.get(Calendar.MONTH) + 1);
		int annio = fecha.get(Calendar.YEAR);
		String salida = dia + " / " + mes + " / " + annio;

		return salida;

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

	public String getFechaPrestamo() {
		Calendar fecha = new GregorianCalendar();

		int dia = (fecha.get(Calendar.DATE));
		int mes = (fecha.get(Calendar.MONTH) + 1);
		int annio = fecha.get(Calendar.YEAR);
		String salida = dia + " / " + mes + " / " + annio;

		return salida;

	}

}
