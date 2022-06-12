package model;

public class Prodotto {
	private String titolo;
	private String descrizione;
	private String categoria;
	private String immagine;
	public Prodotto(String titolo,String descrizione ,String categoria, String immagine)
	{
		this.categoria= categoria;
		this.descrizione=descrizione;
		this.titolo=titolo;
		this.immagine=immagine;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
}
