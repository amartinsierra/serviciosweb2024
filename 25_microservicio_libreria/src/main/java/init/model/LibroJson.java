package init.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class LibroJson {
	private String titulo;
	private double precio;
	private int paginas;
	@JsonAlias("temaDto")
	private TemaJson temaJson;
	public LibroJson(String titulo, double precio, int paginas, TemaJson temaJson) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.paginas = paginas;
		this.temaJson = temaJson;
	}
	public LibroJson() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public TemaJson getTemaJson() {
		return temaJson;
	}
	public void setTemaJson(TemaJson temaJson) {
		this.temaJson = temaJson;
	}
	
}
