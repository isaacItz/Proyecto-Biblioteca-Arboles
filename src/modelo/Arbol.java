package modelo;

public class Arbol<T extends Comparable<T>> {
	private Nodo<T> raiz;
	private String salida;

	public Arbol() {
		this.salida = "";
	}

	public void insertar(T dato) {
		Nodo<T> siguiente = raiz;
		Nodo<T> aux = null;

		if (raiz == null) {
			raiz = new Nodo<>(dato);
		} else {
			while (siguiente != null) {
				aux = siguiente;
				if (dato.compareTo(siguiente.getDato()) >= 0)
					siguiente = siguiente.getHijoDerecho();
				else
					siguiente = siguiente.getHijoIzquierdo();

			}
			if (dato.compareTo(aux.getDato()) > 0)
				aux.setHijoDerecho(new Nodo<T>(dato));
			else
				aux.setHijoIzquierdo(new Nodo<T>(dato));

		}
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	public String enOrden(Nodo<T> raiz) {

		if (raiz != null) {
			enOrden(raiz.getHijoIzquierdo());
			salida += raiz.getDato();
			enOrden(raiz.getHijoDerecho());
		}
		return salida;

	}

	public Pareja<Nodo<T>> buscar(T dato) {
		Nodo<T> q = null;
		Nodo<T> p = raiz;
		while (p != null && p.getDato().compareTo(dato) != 0) {
			q = p;
			if (dato.compareTo(p.getDato()) > 0) {
				p = p.getHijoDerecho();
			} else
				p = p.getHijoIzquierdo();
		}
		return new Pareja<Nodo<T>>(q, p);
	}

	public boolean existe(Pareja<Nodo<T>> pareja) {
		return pareja.getSegundo() != null;
	}

	public void eliminar(Pareja<Nodo<T>> pareja) {
		Nodo<T> q = (Nodo<T>) pareja.getPrimero();
		Nodo<T> p = (Nodo<T>) pareja.getSegundo();
		Nodo<T> v;
		if (p.getHijoDerecho() == null && p.getHijoIzquierdo() == null) {
			v = null;
		} else {
			if (p.getHijoDerecho() != null && p.getHijoIzquierdo() != null) {
				Nodo<T> aux = p;
				v = p.getHijoDerecho();
				Nodo<T> s = v.getHijoIzquierdo();
				while (s != null) {
					aux = v;
					v = s;
					s = s.getHijoIzquierdo();
				}
				if (aux != null) {
					aux.setHijoIzquierdo(v.getHijoDerecho());
					v.setHijoDerecho(p.getHijoDerecho());
				}
				v.setHijoIzquierdo(p.getHijoIzquierdo());
				aux = null;
			} else {
				if (p.getHijoIzquierdo() == null) {
					v = p.getHijoDerecho();
				} else {
					v = p.getHijoIzquierdo();
				}
			}
			p.setHijoIzquierdo(null);
			p.setHijoDerecho(null);
		}
		if (q != null) {
			if (p == q.getHijoIzquierdo()) {
				q.setHijoIzquierdo(v);
			} else {
				q.setHijoDerecho(v);
			}
		} else {
			raiz = v;
		}
		p = null;
	}

	public void eliminar1(Pareja<Nodo<T>> pareja) {
		Nodo<T> v;
		Nodo<T> q = pareja.getPrimero();
		Nodo<T> p = pareja.getSegundo();
		if (p.getHijoDerecho() == null && p.getHijoIzquierdo() == null) {
			v = null;
		} else {
			if (p.getHijoDerecho() != null && p.getHijoIzquierdo() != null) {
				Nodo<T> s;
				Nodo<T> aux = p;
				v = p.getHijoDerecho();
				s = v.getHijoIzquierdo();
				while (s != null) {
					aux = v;
					v = s;
					s = s.getHijoIzquierdo();
				}
				if (aux != p) {
					aux.setHijoIzquierdo(v.getHijoDerecho());
					v.setHijoDerecho(p.getHijoDerecho());
				}
				v.setHijoIzquierdo(p.getHijoIzquierdo());
				aux = null;
			} else {
				v = p.getHijoIzquierdo();
			}
		}
		p.setHijoIzquierdo(null);
		p.setHijoDerecho(null);
		if (q != null) {
			if (p == q.getHijoIzquierdo()) {
				q.setHijoIzquierdo(v);
			} else {
				q.setHijoDerecho(v);
			}
		} else {
			raiz = v;
		}
		p = null;
	}

	public String getDatosOrden() {
		enOrden(raiz);
		String re = salida;
		salida = "";
		return re;
	}

	public boolean estaVacio() {
		return raiz == null;
	}

}
