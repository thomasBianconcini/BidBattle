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
	aste = db.getAsteDaMostare();
	utenti = db.getUtenti();
}
public List<Asta> ricercaPerAste(String ricerca)
{
	List<Asta> asteRic= new ArrayList<>();
	System.out.println("size "+aste.size());
	for(Asta a : aste)
	{
		
		if(a.getTitoloAsta().contains(ricerca))
		{
			
			asteRic.add(a);
		}
	}
	return asteRic;
	
}
public List<Utente> ricercaPerUtenti(String ricerca)
{
	List<Utente> utentiRic= new ArrayList<>();
	System.out.println("size "+aste.size());
	for(Utente u : utenti)
	{
		
		if(u.getNomeProfilo().contains(ricerca))
		{
			utentiRic.add(u);
		}
	}
	return utentiRic;
	
}
}
