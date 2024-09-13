package init.model;

public class TemaJson {
	private int idTema;
	private String nombreTema;
	public TemaJson(int idTema, String nombreTema) {
		super();
		this.idTema = idTema;
		this.nombreTema = nombreTema;
	}
	public TemaJson() {
		super();
	}
	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public String getNombreTema() {
		return nombreTema;
	}
	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}
	
}
