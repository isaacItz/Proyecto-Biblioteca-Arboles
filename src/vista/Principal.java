package vista;

import static modelox.Utileria.continuar;
import static modelox.Utileria.escribir;
import static modelox.Utileria.leerCadena;
import static modelox.Utileria.leerInt;
import static modelox.Utileria.leerchar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

import modelo.Alumno;
import modelo.Devolucion;
import modelo.Devoluciones;
import modelo.Domicilio;
import modelo.Estante;
import modelo.Grupo;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Prestamos;

public class Principal extends JFrame {

	private Fondo contentPane;
	private Grupo grupo;
	private Estante estante;
	private Prestamos prestamos;
	private Devoluciones devoluciones;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new Fondo("space.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		grupo = new Grupo();
		estante = new Estante();
		prestamos = new Prestamos(estante, grupo);
		devoluciones = new Devoluciones();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu controlAlumnos = new JMenu("Control de Alumnos");
		menuBar.add(controlAlumnos);

		JMenuItem registrarAlumno = new JMenuItem("Registrar");
		controlAlumnos.add(registrarAlumno);
		registrarAlumno.addActionListener(new oyenteRegistrarAlumno());

		JMenuItem consultarAlumno = new JMenuItem("Consultar");
		controlAlumnos.add(consultarAlumno);
		consultarAlumno.addActionListener(new oyenteConsultarAlumno());

		JMenuItem modificarAlumno = new JMenuItem("Modificar");
		controlAlumnos.add(modificarAlumno);
		modificarAlumno.addActionListener(new oyenteModificarAlumno());

		JMenuItem eliminarAlumno = new JMenuItem("Eliminar");
		controlAlumnos.add(eliminarAlumno);
		eliminarAlumno.addActionListener(new oyenteEliminarAlumno());

		JMenuItem listarAlumnos = new JMenuItem("Lista de Alumnos");
		controlAlumnos.add(listarAlumnos);
		listarAlumnos.addActionListener(new oyenteListaGrupo());

		JMenu controlLibros = new JMenu("Control de Libros");
		menuBar.add(controlLibros);

		JMenuItem registrarLibro = new JMenuItem("Registrar");
		controlLibros.add(registrarLibro);
		registrarLibro.addActionListener(new oyenteRegistrarLibro());

		JMenuItem consultarLibro = new JMenuItem("Consultar");
		controlLibros.add(consultarLibro);
		consultarLibro.addActionListener(new oyenteConsultarLibro());

		JMenuItem modificarLibro = new JMenuItem("Modificar");
		controlLibros.add(modificarLibro);
		modificarLibro.addActionListener(new oyenteModificarLibro());

		JMenuItem eliminarLibro = new JMenuItem("Eliminar");
		controlLibros.add(eliminarLibro);
		eliminarLibro.addActionListener(new oyenteEliminarLibro());

		JMenuItem listarLibros = new JMenuItem("Lista de Libros");
		controlLibros.add(listarLibros);
		listarLibros.addActionListener(new oyenteListaLibros());

		JMenu controlPrestamos = new JMenu("Control de Prestamos");
		menuBar.add(controlPrestamos);

		JMenuItem prestarLibro = new JMenuItem("Prestar Libro");
		controlPrestamos.add(prestarLibro);
		prestarLibro.addActionListener(new oyentePrestarLibro());

		JMenuItem consultarAlumnoLibrosPrestados = new JMenuItem("Consultar Alumno y Libros Prestados");
		controlPrestamos.add(consultarAlumnoLibrosPrestados);
		consultarAlumnoLibrosPrestados.addActionListener(new oyenteConsultarLibrosAlumno());

		JMenuItem librosPrestados = new JMenuItem("Libros Prestados");
		controlPrestamos.add(librosPrestados);
		librosPrestados.addActionListener(new oyenteListaPrestamos());

		JMenu controlDevoluciones = new JMenu("Control de Devoluciones");
		menuBar.add(controlDevoluciones);

		JMenuItem devolverLibro = new JMenuItem("Devolver Libro");
		controlDevoluciones.add(devolverLibro);
		devolverLibro.addActionListener(new oyenteDevolverLibro());

		JMenuItem historialPrestamos = new JMenuItem("Historial de Prestamos");
		controlDevoluciones.add(historialPrestamos);
		historialPrestamos.addActionListener(new oyenteHistorialPrestamos());

	}

	public class oyenteRegistrarAlumno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				String numControl = leerCadena("Ingrese el numero de control");
				if (!grupo.existeAlumno(numControl)) {
					String nombre = leerCadena("Ingrese su nombre");
					String paterno = leerCadena("Ingrese su apellido paterno");
					String materno = leerCadena("Ingrese su apellido materno");
					char sexo = leerchar("Ingrese su sexo: M/F");
					byte edad = (byte) leerInt("Ingrese su edad");
					byte semestre = (byte) leerInt("Ingrese su semestre");
					String carrera = leerCadena("Ingrese su carrera");
					byte numCasa = (byte) leerInt("Ingrese el numero de su casa");
					String calle = leerCadena("Ingrese su calle");
					String colonia = leerCadena("Ingrese su colonia");
					String codigoPostal = leerCadena("Ingrese su codigo postal");
					String ciudad = leerCadena("Ingrese su ciudad");
					String estado = leerCadena("Ingrese su estado");
					grupo.agregar(new Alumno(numControl, nombre, paterno, materno, sexo, edad,
							new Domicilio(numCasa, calle, colonia, codigoPostal, ciudad, estado), semestre, carrera));
					escribir("Alumno registrado");
				} else
					escribir("El alumno ya existe");
			} while (continuar("Desea registrar otro alumno?"));
		}
	}

	public class oyenteListaGrupo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!grupo.estaVacio())
				escribir(grupo.listar());
			else
				escribir("El grupo esta vacio");
		}
	}

	public class oyenteEliminarAlumno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!grupo.estaVacio()) {
					String numControl = leerCadena("Ingrese el numero de control");
					if (grupo.existeAlumno(numControl)) {
						if (!prestamos.hasPres(numControl)) {
							grupo.eliminar(numControl);
							escribir("Alumno eliminado con exito");
						} else
							escribir("No se puede eliminar al alumno ya que tiene libros prestados");
					} else
						escribir("El alumno no existe");
				} else
					escribir("El grupo esta vacio");
			} while (!grupo.estaVacio() && continuar("Desea elimnar otro alumno?"));
		}

	}

	public class oyenteConsultarAlumno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				String numControl = null;
				if (!grupo.estaVacio()) {
					numControl = leerCadena("Ingresa el numero de control");
					if (grupo.existeAlumno(numControl))
						escribir(grupo.consultar(numControl).toString());
					else
						escribir("El alumno no existe");
				} else
					escribir("El grupo esta vacio");
			} while (continuar("Desea consultar otro alumno?"));
		}

	}

	public class oyenteModificarAlumno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!grupo.estaVacio()) {
					String numControl = leerCadena("Ingrese su numero de control");
					if (grupo.existeAlumno(numControl)) {
						Alumno alumno = grupo.consultar(numControl);
						if (!prestamos.hasPres(numControl)) {

							int opModificar = 0;
							int salid = 0;

							do {
								String[] opcionesModificar = { "Nombre: " + alumno.getNombre(),
										"Ap. Paterno: " + alumno.getPaterno(), "Ap. Materno: " + alumno.getMaterno(),
										"Edad: " + String.valueOf(alumno.getEdad()),
										"Genero: " + String.valueOf(alumno.getSexo()),
										"Carrera: " + alumno.getCarrera(),
										"Semestre: " + String.valueOf(alumno.getSemestre()),
										"No. de Casa: " + alumno.getDireccion().getNumeroCasa(),
										"No. de Calle: " + alumno.getDireccion().getCalle(),
										"Col. " + alumno.getDireccion().getColonia(),
										"CP. " + alumno.getDireccion().getCodigoPostal(),
										"Ciudad: " + alumno.getDireccion().getCiudad(),
										"Estado: " + alumno.getDireccion().getEstado() };
								salid = opcionesModificar.length + 1;
								opModificar = obtenerSeleccion(opcionesModificar);
								switch (opModificar) {
								case 1:
									alumno.setNombre(leerCadena("Ingrese el Nuevo Nombre"));
									break;
								case 2:
									alumno.setPaterno(leerCadena("Ingrese el Nuevo Apellido Paterno"));
									break;
								case 3:
									alumno.setMaterno(leerCadena("Ingrese el Nuevo Apellitdo Materno"));
									break;
								case 4:
									alumno.setEdad((byte) leerInt("Ingrese la Nueva Edad "));
									break;
								case 5:
									alumno.setSexo(leerchar("Ingrese el Nuevo Genero"));
									break;
								case 6:
									alumno.setCarrera(leerCadena("Ingrese la Nueva Carrera"));
									break;
								case 7:
									alumno.setSemestre((byte) leerInt("Ingrese el Nuevo Semestre"));
									break;
								case 8:
									alumno.getDireccion()
											.setNumeroCasa((short) leerInt("Ingrese el Nuevo Numero de Casa"));
									break;
								case 9:
									alumno.getDireccion().setCalle(leerCadena("Ingrese el Cuevo Nombre de la Calle"));
									break;
								case 10:
									alumno.getDireccion()
											.setColonia(leerCadena("Ingrese el Nuevo Nombre de la Colonia"));
									break;
								case 11:
									alumno.getDireccion().setCodigoPostal(leerCadena("Ingrese el Nuevo Codigo Postal"));
									break;
								case 12:
									alumno.getDireccion().setCiudad(leerCadena("Ingrese la Nueva Ciudad"));
									break;
								case 13:
									alumno.getDireccion().setEstado(leerCadena("Ingrese el Nuevo Estado"));
									break;

								}
							} while (opModificar != salid);
							escribir("Alumno modificado con exito");
						} else
							escribir("El Alumno Tiene Libros Prestados, No Puede Modificarse");
					} else
						escribir("El alumno no existe");
				} else
					escribir("El grupo esta vacio");
			} while (continuar("Desea modificar otro alumno?"));
		}

	}

	public class oyenteRegistrarLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				String isbn = leerCadena("Ingrese el ISBN");
				if (!estante.existeLibro(isbn)) {
					String titulo = leerCadena("Ingrese el titulo");
					String autor = leerCadena("Ingrese el nombre del autor");
					String editorial = leerCadena("Ingrese el editorial");
					String edicion = leerCadena("Ingrese la edicion");
					estante.agregar(new Libro(isbn, titulo, autor, editorial, edicion));
					escribir("Libro Registrado");
				} else
					escribir("El libro ya existe");
			} while (continuar("Desea registrar otro libro?"));
		}

	}

	public class oyenteListaLibros implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!estante.estaVacio())
				escribir(estante.listar());
			else
				escribir("El estante esta vacio");
		}

	}

	public class oyenteConsultarLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				String isbn = null;
				if (!estante.estaVacio()) {
					isbn = leerCadena("Ingresa el ISBN");
					if (estante.existeLibro(isbn))
						escribir(estante.consultar(isbn).toString());
					else
						escribir("El Libro no existe");
				} else
					escribir("El estante esta vacio");
			} while (continuar("Desea consultar otro Libro?"));
		}

	}

	public class oyenteModificarLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!estante.estaVacio()) {
					String isbn = leerCadena("Ingrese el ISBN");
					if (estante.existeLibro(isbn)) {
						Libro libro = estante.consultar(isbn);
						if (!libro.estaPrestado()) {

							int opModificar = 0;
							int salid = 0;

							do {
								String[] opcionesModificar = { "Titulo: " + libro.getTitulo(),
										"Autor: " + libro.getAutor(), "Editorial: " + libro.getEditorial(),
										"Edicion: " + libro.getEdicion() };
								salid = opcionesModificar.length + 1;
								opModificar = obtenerSeleccion(opcionesModificar);
								switch (opModificar) {
								case 1:
									libro.setTitulo(leerCadena("Ingresa el Nuevo Nombre Para el Libro"));
									break;

								case 2:
									libro.setAutor(leerCadena("ingresa el nuevo autor para el Libro"));
									break;

								case 3:
									libro.setEditorial(leerCadena("ingresa la nueva editorial para el Libro"));
									break;
								case 4:
									libro.setEdicion(leerCadena("ingresa el nuevo Numero de Edicion para el Libro"));
									break;
								}
							} while (opModificar != salid);
							escribir("Libro modificado con exito");
						} else
							escribir("El Libro esta Prestado, No puede Ser Modificado ");
					} else
						escribir("El Libro no existe");
				} else
					escribir("El estante esta vacio");
			} while (continuar("Desea modificar otro Libro?"));
		}

	}

	public class oyenteEliminarLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!estante.estaVacio()) {
					String isbn = leerCadena("Ingrese el ISBN");
					if (estante.existeLibro(isbn)) {
						if (!(estante.consultar(isbn).estaPrestado() == true)) {
							estante.eliminar(isbn);
							escribir("Libro eliminado con exito");
						} else
							escribir("No se puede eliminar, el libro esta prestado");
					} else
						escribir("El Libro no existe");
				} else
					escribir("El estante esta vacio");
			} while (!estante.estaVacio() && continuar("Desea eliminar otro Libro?"));
		}

	}

	public class oyentePrestarLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!grupo.estaVacio()) {
					if (!estante.estaVacio()) {
						Prestamo prestamo = null;
						String numControl = leerCadena("Ingrese su numero de control");
						if (grupo.existeAlumno(numControl)) {
							String isbn = leerCadena("Ingrese el isbn del libro");
							if (estante.existeLibro(isbn)) {
								Libro l = estante.consultar(isbn);
								if (!l.estaPrestado()) {
									prestamo = new Prestamo(numControl, isbn, LocalDate.now(), null);
									prestamo.setFechaDeEntrega(prestamos.asignarFechaEntrega(prestamo));
									prestamos.agregarPrestamo(prestamo);
									estante.consultar(isbn).setEstaPrestado(true);
									grupo.consultar(numControl).prestarLibro();
									escribir("Libro prestado");
								} else
									escribir("El libro ya esta prestado");
							} else
								escribir("El libro no existe");
						} else
							escribir("El alumno no esta registrado");
					} else
						escribir("No hay libros registrados");
				} else
					escribir("No hay alumnos registrados");
			} while (estante.hayDisponibles(prestamos) && continuar("Desea hacer otro prestamo?"));

		}

	}

	public class oyenteListaPrestamos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!prestamos.hayPrestamos()) {
				escribir(prestamos.listaLibrosPrestados());
			} else
				escribir("No hay libros prestados");
		}

	}

	public class oyenteDevolverLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!prestamos.hayPrestamos()) {
					String isbn = leerCadena("Ingrese el isbn");
					if (estante.existeLibro(isbn)) {
						if (estante.consultar(isbn).estaPrestado()) {
							Prestamo prestamo = prestamos.consultar(isbn);
							Devolucion devolucion = new Devolucion(isbn, estante.consultar(isbn).getTitulo(), true,
									null);
							devolucion.setFechaDevuelto(LocalDate.now());
							if (LocalDate.now().compareTo(prestamo.getFechaDeEntrega()) > 0) {
								int dif = LocalDate.now().getDayOfYear() - prestamo.getFechaDeEntrega().getDayOfYear();
								int multa = dif * 20;
								escribir("La multa es de " + multa);
							}
							devoluciones.devolverLibro(devolucion);
							estante.consultar(isbn).setEstaPrestado(false);
							Alumno alumno = new Alumno();
							alumno.setNumeroControl(prestamo.getNumeroDeControl());
							grupo.consultar(alumno.getNumeroControl())
									.setLibrosPrestados(alumno.getLibrosPrestados() - 1);
							prestamos.eliminar(prestamo);
							escribir("Devolucion con exito");
						} else
							escribir("El libro no esta prestado");
					} else
						escribir("El libro no esta registrado");
				} else
					escribir("No hay libros prestados");
			} while (!devoluciones.estaVacio() && continuar("Desea devolver otro libro?"));
		}

	}

	public class oyenteHistorialPrestamos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!devoluciones.estaVacio())
				escribir(devoluciones.listaDevoluciones());
			else
				escribir("No han devuelto ningun libro");
		}

	}

	public class oyenteConsultarLibrosAlumno implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			do {
				if (!grupo.estaVacio()) {
					if (!estante.estaVacio()) {
						String numControl = leerCadena("Ingrese su numero de control");
						if (grupo.existeAlumno(numControl)) {
							if (grupo.consultar(numControl).getLibrosPrestados() != 0)
								escribir(prestamos.consultarLibrosAlumno(numControl));
							else
								escribir("El alumno no tiene libros prestados");
						} else
							escribir("El alumno no esta registrado");
					} else
						escribir("No hay libros en el estante");
				} else
					escribir("No hay alumnos registrados");
			} while (continuar("Desea consultar otro alumno?"));
		}

	}

	public static int obtenerSeleccion(String[] op) {

		String salida = "Selecciona una opcion\n";
		int i = 0;
		for (; i < op.length; i++) {
			salida += (i + 1) + ".- " + op[i].concat("\n");
		}
		salida += (i + 1) + ".- salir";
		return leerInt(salida);
	}
}
