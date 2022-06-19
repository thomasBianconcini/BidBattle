package model;
import java.util.ArrayList;
import java.util.List;
public class Utente {

	private String email;
	private String indirizzo;
	private String password;
	private String immagineProfilo;
	private String nomeProfilo;
	private List<Asta> astePersonali = new ArrayList<Asta>();
	private List<Offerta> offerteInCorso= new ArrayList<Offerta>();
	private List<Asta> asteVinte= new ArrayList<Asta>();
	private Wallet wallet;
	private String descrizione;
	
	public Utente (String email,String password, String indirizzo )
	{
		this.email=email;
		this.password= password;
		this.indirizzo= indirizzo;
		wallet = new Wallet(email);
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImmagineProfilo() {
		return immagineProfilo;
	}

	public void setImmagineProfilo(String immagineProfilo) {
		this.immagineProfilo = immagineProfilo;
	}

	public String getNomeProfilo() {
		return nomeProfilo;
	}

	public void setNomeProfilo(String nomeProfilo) {
		this.nomeProfilo = nomeProfilo;
	}

	public List<Asta> getAstePersonali() {
		return astePersonali;
	}

	public void setAstePersonali(List<Asta> astePersonali) {
		this.astePersonali = astePersonali;
	}

	public List<Offerta> getOfferteInCorso() {
		return offerteInCorso;
	}

	public void setOfferteInCorso(List<Offerta> offerteInCorso) {
		this.offerteInCorso = offerteInCorso;
	}

	public List<Asta> getAsteVinte() {
		return asteVinte;
	}

	public void setAsteVinte(List<Asta> asteVinte) {
		this.asteVinte = asteVinte;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public void add (Asta a)
	{
		astePersonali.add(a);
	}
	public List<Asta> getInterazione()
	{
		List<Asta> res= new ArrayList<Asta>();
		System.out.println(offerteInCorso.size());
		for(Offerta o : offerteInCorso)
		{
			Asta a= o.getAsta();
			res.add(a);
		}
		for(Asta asta: asteVinte)
		{
			res.add(asta);
		}
		return res;
	}
	public List<String> getMovimenti()
	{
		List<String> res= new ArrayList<String>();
		for(Ricarica r: wallet.getListaRicariche())
			res.add(r.toString());
		
		for(Prelievo p: wallet.getListaPrelievi())
			res.add(p.toString());
		
		return res;
	}
}
