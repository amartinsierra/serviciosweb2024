package init.model;

public class Book {
	private String titulo;
	private String tematica;
	private double precio;
	private int clasificacion;
	public Book(String titulo, String tematica, double precio, int clasificacion) {
		super();
		this.titulo = titulo;
		this.tematica = tematica;
		this.precio = precio;
		this.clasificacion = clasificacion;
	}
	public Book() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
