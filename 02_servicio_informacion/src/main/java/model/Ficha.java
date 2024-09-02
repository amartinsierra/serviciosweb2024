package model;

public class Ficha {
	private String producto;
	private double precio;
	private String categoria;
	public Ficha(String producto, double precio, String categoria) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.categoria = categoria;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
