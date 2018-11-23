package modelo;

public class Grupo {
	private Arbol<Alumno> grupo;

	public Grupo() {
		this.grupo = new Arbol<>();
	}

	public void eliminar(Pareja<Nodo<Alumno>> pareja) {
		grupo.eliminar(pareja);
	}

	public boolean existeAlumno(String numControl) {
		Alumno alumno = new Alumno();
		alumno.setNumeroControl(numControl);
		Pareja<Nodo<Alumno>> alum = grupo.buscar(alumno);
		return grupo.existe(alum);
	}
	
	public void agregar(Alumno alumno) {
		grupo.insertar(alumno);
	}

	public boolean estaVacio() {
		return grupo.estaVacio();
	}

	public String listar() {
		return grupo.getDatosOrden();
	}

	public int librosPrestados(Alumno alumno) {
		return alumno.getLibrosPrestados();
	}
	

	public void eliminar(String numControl) {
		Alumno alumno = new Alumno();
		alumno.setNumeroControl(numControl);
		Pareja<Nodo<Alumno>> alum = grupo.buscar(alumno);
		grupo.eliminar(alum);
	}
	
	public Alumno consultar(String numControl) {
		Alumno alumno = new Alumno();
		alumno.setNumeroControl(numControl);
		return grupo.buscar(alumno) != null ? grupo.buscar(alumno).getSegundo().getDato() : null;
	}


}
