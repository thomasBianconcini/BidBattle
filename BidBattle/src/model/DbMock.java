package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DbMock {

	static Utente currentUser;
	static List<Utente> utenti= new ArrayList<>();
	static List<Asta> asteDaMostare= new ArrayList<>();
	static List<Asta> asteTerminate= new ArrayList<>();
	
	static boolean init = false;
	
	public DbMock() {
		if(!init)
		{
			init = true;
			Utente test= new Utente("c","c","cicicoc");
			test.setDescrizione("ecco la descrizione");
			test.setNomeProfilo("nomeTest");
			utenti.add(test);
			DbMock.setCurrentUser(test);
			
			for(int i = 0; i<12 ;i++)
			{
				Utente u1= new Utente("u"+i+"@"+"gmail.com", "Password", "via bella bella");
				u1.setDescrizione("ciao sono bellissimo e sono il numero "+ i+i+i+i+i+i);
				u1.setNomeProfilo("Il magnifico"+ i+i+i+i+i+i );
				utenti.add(u1);
			}
			
			for(int i = 0; i<12 ;i++)
			{
				if(i%2==0)
				{
					Prodotto p1 = new Prodotto("titolo"+i, "descrizione"+i, "Sport" ,""+ i);
					Asta a1  = new Asta("asta"+i, "descrizione"+i, LocalDateTime.now().plusDays(2), p1, "u"+i+"@"+"gmail.com",1.00);
					Offerta of = new Offerta(1000,"c", a1);
					Offerta of2 = new Offerta(19, "u"+4+"@"+"gmail.com", a1);
					a1.inserisci(of);
					a1.inserisci(of2);
					test.getOfferteInCorso().add(of);
					asteDaMostare.add(a1);
				}else
				{
					Prodotto p1 = new Prodotto("titolo"+i, "descrizione"+i, "Sport" ,""+ i);
					Asta a1  = new Asta("asta"+i, "descrizione"+i, LocalDateTime.now().plusDays(2), p1, "c",1.00);
					Offerta of = new Offerta(15, "u"+2+"@"+"gmail.com", a1);
					a1.inserisci(of);
					test.add(a1);
					asteDaMostare.add(a1);
				}
				if(i<3)
				{
					Prodotto p1 = new Prodotto("vinta"+i, "descrizione"+i, "Sport" ,""+ i);
					Asta a1  = new Asta("vinta"+i, "descrizione"+i, LocalDateTime.now().minusDays(1), p1, "u"+i+"@"+"gmail.com",1.00);
					Offerta of = new Offerta(5,"c", a1);
					a1.inserisci(of);
					test.getAsteVinte().add(a1);
					asteTerminate.add(a1);
				}
			}
			Ricarica r = new Ricarica(1000, "dollari", LocalDateTime.now().minusDays(45));
			test.getWallet().getListaRicariche().add(r);
			test.getWallet().setSaldo(test.getWallet().getSaldo()+1000);
			Prelievo p=new Prelievo(150,"euro", LocalDateTime.now().minusDays(35));
			test.getWallet().getListaPrelievi().add(p);
			test.getWallet().setSaldo(test.getWallet().getSaldo()-150);
			Prelievo p2=new Prelievo(230,"euro", LocalDateTime.now().minusDays(30));
			test.getWallet().getListaPrelievi().add(p2);
			test.getWallet().setSaldo(test.getWallet().getSaldo()-230);
			Ricarica r2 = new Ricarica(100, "dollari", LocalDateTime.now().minusDays(22));
			test.getWallet().getListaRicariche().add(r2);
			test.getWallet().setSaldo(test.getWallet().getSaldo()+100);
			Prelievo p3=new Prelievo(340,"euro", LocalDateTime.now().minusDays(5));
			test.getWallet().getListaPrelievi().add(p3);
			test.getWallet().setSaldo(test.getWallet().getSaldo()-340);
		}
	};
	public static List<Asta> getAsteFromVenditore(String email)
	{
		for(Utente u : utenti)
		{
			if(u.getEmail().equals(email))
			{
				return u.getAstePersonali();
			}
		}
		return null;
	}
	
	public static List<Asta> getAsteDaMostare() {
		return asteDaMostare;
	}

	public static void setAsteDaMostare(List<Asta> asteDaMostare) {
		DbMock.asteDaMostare = asteDaMostare;
	}

	public static List<Utente> getUtenti() {
		return utenti;
	}

	public static void setUtenti(List<Utente> utenti) {
		DbMock.utenti = utenti;
	}
	
	public static Asta getAstabyTitolo(String titolo)
	{
		Asta res=null;
		for(Asta a : asteDaMostare)
		{
			if(a.getTitoloAsta().equals(titolo))
			{
				res=a;
			}
		}
		for(Asta a : asteTerminate)
		{
			if(a.getTitoloAsta().equals(titolo))
			{
				res=a;
			}
		}
		return res;
	}
	public static Utente getCurrentUser() {
		return currentUser;
	}
	public static void setCurrentUser(Utente currentUser2) {
		utenti.remove(currentUser);
		utenti.add(currentUser2);
		DbMock.currentUser = currentUser2;
	}
	public static void add (Utente u)
	{
		utenti.add(u);
	}
	public static Utente  getUtente(String email)
	{
		for(Utente u : utenti)
		{
			if(email.equals(u.getEmail()))
				return u;
		}
		return null;
	}
	public static boolean  isOver(Asta a)
	{
		if(asteTerminate.contains(a))
			return true;
		else return false;
	}
}
