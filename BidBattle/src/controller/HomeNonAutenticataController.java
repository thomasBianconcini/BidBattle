package controller;

import java.util.ArrayList;
import java.util.List;

import model.Asta;
import model.DbMock;
import model.Utente;

public class HomeNonAutenticataController {
	private DbMock db;
	private List<Asta> aste= new ArrayList<>();
	private List<Utente> utenti= new ArrayList<>();
public HomeNonAutenticataController() {
	db =new DbMock();
	aste = DbMock.getAsteDaMostare();
	utenti = DbMock.getUtenti();
}
public List<Asta> ricercaPerAste(String ricerca)
{
	List<Asta> asteRic= new ArrayList<>();
	for(Asta a : aste)
	{
		
		if(a.getTitoloAsta().toLowerCase().contains(ricerca.toLowerCase()))
		{
			
			asteRic.add(a);
		}
	}
	return asteRic;
	
}
public List<Utente> ricercaPerUtenti(String ricerca)
{
	System.out.println("ecco  "+ ricerca);
	List<Utente> utentiRic= new ArrayList<>();
	System.out.println("size "+utenti.size());
	for(Utente u : DbMock.getUtenti())
	{
		if(u.getNomeProfilo().toLowerCase().contains(ricerca.toLowerCase()))
		{
			utentiRic.add(u);
		}
	}
	return utentiRic;
	
}
}
