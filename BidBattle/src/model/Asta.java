package model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Asta {
	private int idAsta;
	private String titoloAsta;
	private String descrizioneAsta;
	private LocalDateTime durataAsta;
	private Prodotto prodotto;
	private double prezzoIniziale;
	public double getPrezzoIniziale() {
		return prezzoIniziale;
	}
	public void setPrezzoIniziale(double prezzoIniziale) {
		this.prezzoIniziale = prezzoIniziale;
	}
	private List<Offerta> offerteInCorso = new ArrayList<Offerta>();
	private String venditore;
	public Asta(String titolo, String descrizione, LocalDateTime durata, Prodotto prodotto, String venditore, Double prezzo_iniziale)
	{
		//bisognerà modificarlo
		this.idAsta=1;
		this.titoloAsta=titolo;
		this.descrizioneAsta=descrizione;
		this.durataAsta=durata;
		this.prodotto=prodotto;
		this.venditore= venditore;
		this.prezzoIniziale= prezzo_iniziale;
	}
	public double getCurrent()
	{
		if(offerteInCorso.isEmpty())
			return -1;
		return offerteInCorso.get(offerteInCorso.size()-1).getPrezzo();
	}
	public void inserisci(Offerta o)
	{
		offerteInCorso.add(o);
	}
	public int getIdAsta() {
		return idAsta;
	}
	public void setIdAsta(int idAsta) {
		this.idAsta = idAsta;
	}
	public String getTitoloAsta() {
		return titoloAsta;
	}
	public void setTitoloAsta(String titoloAsta) {
		this.titoloAsta = titoloAsta;
	}
	public String getDescrizioneAsta() {
		return descrizioneAsta;
	}
	public void setDescrizioneAsta(String descrizioneAsta) {
		this.descrizioneAsta = descrizioneAsta;
	}
	public LocalDateTime getDurataAsta() {
		return durataAsta;
	}
	public void setDurataAsta(LocalDateTime durataAsta) {
		this.durataAsta = durataAsta;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public List<Offerta> getOfferteInCorso() {
		return offerteInCorso;
	}
	public void setOfferteInCorso(List<Offerta> offerteInCorso) {
		this.offerteInCorso = offerteInCorso;
	}
	public String getVenditore() {
		return venditore;
	}
	public void setVenditore(String venditore) {
		this.venditore = venditore;
	}
	
	
}
