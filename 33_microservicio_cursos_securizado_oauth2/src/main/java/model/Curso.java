package model;

public class Curso {
	private String nombre;
	private String area;
	private int duracion;
	private double precio;
	public Curso(String nombre, String area, int duracion, double precio) {
		super();
		this.nombre = nombre;
		this.area = area;
		this.duracion = duracion;
		this.precio = precio;
	}
	public Curso() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
