package modelo;

public class Alumno implements Comparable<Alumno>{
	private String numeroControl;
	private String nombre;
	private String paterno;
	private String materno;
	private char sexo;
	private byte edad;
	private Domicilio direccion;
	private byte semestre;
	private String carrera;
	private int librosPrestados;
	
	public Alumno() {
		
	}

	public Alumno(String numeroControl, String nombre, String paterno, String materno, char sexo, byte edad,
			Domicilio direccion, byte semestre, String carrera) {
		super();
		this.numeroControl = numeroControl;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.sexo = sexo;
		this.edad = edad;
		this.direccion = direccion;
		this.semestre = semestre;
		this.carrera = carrera;
	}

	public void devolverLibro() {
		librosPrestados--;
	}

	public void prestarLibro() {
		librosPrestados++;
	}

	public int getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(int n) {
		this.librosPrestados = n;
	}

	public byte getSemestre() {
		return semestre;
	}

	public void setSemestre(byte semestre) {
		this.semestre = semestre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getNumeroControl() {
		return numeroControl;
	}

	public void setNumeroControl(String numeroControl) {
		this.numeroControl = numeroControl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public Domicilio getDireccion() {
		return direccion;
	}

	public void setDireccion(Domicilio direccion) {
		this.direccion = direccion;
	}
	public String librosPrestados(Prestamo prestamo){
		String salida = "ISBN: " + prestamo.getISBN() + " Titulo: " ;
		return salida;
	}

	@Override
	public String toString() {
		String salida = nombre + " " + paterno + " " + materno + "\n";
		salida += "Numero de control: " + numeroControl + "\n";
		salida += "Edad: " + edad + " Años\n";
		salida += "Sexo: " + (sexo == 'F' ? "Femenino" : "Maculino") + "\n";
		salida += "Carrera: " + carrera + " Semestre: " + semestre + "\n";
		salida += "Domicilio: " + direccion;
		salida += "\nLibros Prestados " + librosPrestados + "\n";
		return salida;
	}



	@Override
	public int compareTo(Alumno o) {
		return numeroControl.compareTo(o.getNumeroControl());
	}

}
