package model;

public class Offerta {
	private double prezzo;
	private String utente;
	private Asta asta;
	
	public Offerta (double prezzo, String utente, Asta asta)
	{
		this.prezzo = prezzo;
		this.utente=utente;
		this.asta =asta;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public Asta getAsta() {
		return asta;
	}

	public void setAsta(Asta asta) {
		this.asta = asta;
	}
	
}
