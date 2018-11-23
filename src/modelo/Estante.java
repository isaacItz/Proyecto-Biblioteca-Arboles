package modelo;

public class Estante {

	private int contador;
	private Arbol<Libro> estante;

	public Estante() {
		this.contador = 0;
		this.estante = new Arbol<>();
	}

	public void agregar(Libro libro) {
		estante.insertar(libro);
	}

	public void eliminar(Pareja<Nodo<Libro>> pareja) {
		estante.eliminar(pareja);
	}

	public boolean existeLibro(String isbn) {
		Libro libro = new Libro();
		libro.setIsbn(isbn);
		Pareja<Nodo<Libro>> lib = estante.buscar(libro);
		return estante.existe(lib);
	}

	public boolean estaVacio() {
		return estante.estaVacio();
	}

	public String listar() {
		return estante.getDatosOrden();
	}

	public void eliminar(String isbn) {
		Libro libro = new Libro();
		libro.setIsbn(isbn);
		Pareja<Nodo<Libro>> lib = estante.buscar(libro);
		estante.eliminar(lib);
	}

	public Libro consultar(String isbn) {
		Libro libro = new Libro();
		libro.setIsbn(isbn);
		return estante.buscar(libro) != null ? estante.buscar(libro).getSegundo().getDato() : null;
	}

}
