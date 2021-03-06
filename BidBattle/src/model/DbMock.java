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
			Utente test= new Utente("rick@gmail.com","Password","Viale terme 45");
			test.setDescrizione("Amante dei quadri e dell'arte, sono alla ricerca di oggetti che raccontano una storia");
			test.setNomeProfilo("Rick 77");
			test.setImmagineProfilo("admin.jpg");
			utenti.add(test);
		    DbMock.setCurrent(test);
		   
		    Prodotto q = new Prodotto("Vinile AC/DC ", "Many Faces of AC/DC ", "Musica" ,"acdc.jpg");
			Asta qq  = new Asta("Disco storico AC/DC", "Many Faces of AC/DC", LocalDateTime.now().minusDays(1), q, "mike@gmail.com",1.00);
			Offerta qqq = new Offerta(50,"rick@gmail.com", qq);
			qq.inserisci(qqq);
			test.getAsteVinte().add(qq);
			asteTerminate.add(qq);
			
			Prodotto w = new Prodotto("Jordan 1", "Jordan 1 High", "Sport" ,"jj.jpg");
			Asta ww  = new Asta("Scarpa Jordan", "Jordan1 high", LocalDateTime.now().minusDays(1), w, "mike@gmail.com",1.00);
			Offerta www = new Offerta(50,"rick@gmail.com", ww);
			ww.inserisci(www);
			test.getAsteVinte().add(ww);
			asteTerminate.add(ww);
		    
			/*for(int i = 0; i<3 ;i++)
			{
					Prodotto p1 = new Prodotto("vinta"+i, "descrizione"+i, "Sport" ,"logo.jpg");
					Asta a1  = new Asta("vinta"+i, "descrizione"+i, LocalDateTime.now().minusDays(1), p1, "u"+i+"@"+"gmail.com",1.00);
					Offerta of = new Offerta(5,"c", a1);
					a1.inserisci(of);
					test.getAsteVinte().add(a1);
					asteTerminate.add(a1);
			}*/
			Utente u1= new Utente("mark@gmail.com", "Password", "via mark 1");
			u1.setDescrizione("Giocatore di scacchi professionista");
			u1.setNomeProfilo("Mark chess" );
			u1.setImmagineProfilo("p5.jpg");
			utenti.add(u1);
			
			Utente u2= new Utente("mike@gmail.com", "Password", "via mike 1");
			u2.setDescrizione("Tecnico laureato in Telecomunicazioni ");
			u2.setNomeProfilo("Ingegner Mike" );
			u2.setImmagineProfilo("p6.jpg");
			utenti.add(u2);
			
			Utente u3= new Utente("luke@gmail.com", "Password", "via luke 1");
			u3.setDescrizione("Appassionato di videogiochi");
			u3.setNomeProfilo("Luke 93" );
			u3.setImmagineProfilo("p7.jpg");
			utenti.add(u3);
			
			Utente u4= new Utente("fre@gmail.com", "Password", "via fre 1");
			u4.setDescrizione("MakeUp Artist");
			u4.setNomeProfilo("Fre88" );
			u4.setImmagineProfilo("p4.jpg");
			utenti.add(u4);
			
			Utente u5= new Utente("linda@gmail.com", "Password", "Via Friuli 7");
			u5.setDescrizione("Collezionatrice seriale di cimeli");
			u5.setNomeProfilo("Linda" );
			u5.setImmagineProfilo("p1.jpg");
			utenti.add(u5);
			
			Utente u6= new Utente("marika@gmail.com", "Password", "via marika 1");
			u6.setDescrizione("46 yo, NY");
			u6.setNomeProfilo("_Marika_" );
			u6.setImmagineProfilo("p2.jpg");
			utenti.add(u6);
			
			Utente u7= new Utente("pol@gmail.com", "Password", "via pol 1");
			u7.setDescrizione("Modellismo 4ever");
			u7.setNomeProfilo("Pol");
			u7.setImmagineProfilo("p8.jpg");
			utenti.add(u7);
			
			Utente u8= new Utente("renzo@gmail.com", "Password", "via renzo 1");
			u8.setDescrizione(" ");
			u8.setNomeProfilo("x_Renzo_x" );
			u8.setImmagineProfilo("p9.jpg");
			utenti.add(u8);
			
			Utente u9= new Utente("hu@gmail.com", "Password", "via hu 1");
			u9.setDescrizione("China, esperta di massaggi");
			u9.setNomeProfilo("hu" );
			u9.setImmagineProfilo("p10.jpg");
			utenti.add(u9);
			
			Utente u10= new Utente("lia@gmail.com", "Password", "via lia 1");
			u10.setDescrizione("Alla ricerca del sacro Graal!! <3");
			u10.setNomeProfilo("Lia" );
			u10.setImmagineProfilo("p3.jpg");
			utenti.add(u10);
			
			Prodotto p1 = new Prodotto("Computer", "Computer lenovo", "Tecnologia" ,"pc.jpg");
			Asta a1  = new Asta("Computer nuovissimo ", "computer 2022 nuova generazione", LocalDateTime.now().plusMinutes(1), p1, "mark@gmail.com",1.00);
			Offerta of = new Offerta(100,"rick@gmail.com", a1);
			a1.inserisci(of);
			asteDaMostare.add(a1);
			
			Prodotto p2 = new Prodotto("Racchetta", "Racchetta Babolat", "Sport" ,"racchetta.jpg");
			Asta a2  = new Asta("Racchetta di Federer ", "Racchetta Babolat usata da federer", LocalDateTime.now().plusDays(2).plusMonths(3), p2, "rick@gmail.com",1.00);
			Offerta of21 = new Offerta(19, "linda@gmail.com", a2);
			a2.inserisci(of21);
			u5.getOfferteInCorso().add(of21);
			asteDaMostare.add(a2);
			test.add(a2);
			
			Prodotto p3 = new Prodotto("Cabinato arcade", "Antico cabinato", "Tecnologia" ,"arcade.jpg");
			Asta a3  = new Asta("Storico cabinato", "Uno dei pi? antichi cabinati", LocalDateTime.now().plusDays(2), p3, "rick@gmail.com",1.00);
			Offerta of22 = new Offerta(19, "linda@gmail.com", a3);
			a3.inserisci(of22);
			u5.getOfferteInCorso().add(of22);
			asteDaMostare.add(a3);
			test.add(a3);
			
			Prodotto p4 = new Prodotto("Cilindro ", "Cilindro per KTM ", "Motori" ,"cilindro.jpg");
			Asta a4  = new Asta("Nuovo cilindro ", "Cilindro 2020 per KTM", LocalDateTime.now().plusDays(2), p4, "rick@gmail.com",1.00);
			Offerta of23 = new Offerta(19,"linda@gmail.com", a4);
			a4.inserisci(of23);
			u5.getOfferteInCorso().add(of23);
			asteDaMostare.add(a4);
			test.add(a4);
			
			Prodotto p5 = new Prodotto("Manubrio palestra", "5kg di manubrio", "Sport" ,"peso.jpg");
			Asta a5  = new Asta("Manubrio da palestra ", "Prezzo scontato per manubri 5 kg", LocalDateTime.now().plusDays(2), p5, "rick@gmail.com",1.00);
			Offerta of222 = new Offerta(19, "linda@gmail.com", a5);
			a5.inserisci(of222);
			u5.getOfferteInCorso().add(of222);
			asteDaMostare.add(a5);
			test.add(a5);
			
			Prodotto p6 = new Prodotto("Smartwatch", "Orologio da palestra", "Sport" ,"smartwatch.jpg");
			Asta a6  = new Asta("Smartwatch per veri sportivi", "Inizia anche tu ad allenarti con smartwatch", LocalDateTime.now().plusDays(2), p6, "rick@gmail.com",1.00);
			Offerta of2222 = new Offerta(19, "linda@gmail.com", a6);
			a6.inserisci(of2222);
			u5.getOfferteInCorso().add(of2222);
			asteDaMostare.add(a6);
			test.add(a6);
			
			Prodotto p7 = new Prodotto("Piscina idromassaggio", "Jacuzzi", "Arredo" ,"piscina.jpg");
			Asta a7  = new Asta("Jacuzzi nuova", "Jacuzzi nuova per relax 2 mt di diametro", LocalDateTime.now().plusSeconds(20), p7, "fre@gmail.com",1.00);
			Offerta of22223 = new Offerta(19, "linda@gmail.com", a7);
			a7.inserisci(of22223);
			u5.getOfferteInCorso().add(of22223);
			asteDaMostare.add(a7);
			
			Prodotto p8 = new Prodotto("Clessidra", "Clessidra in vetro", "Arredo" ,"clessidra.jpg");
			Asta a8  = new Asta("Clessidra 5 minuti", "Clessidra moderna modello desert", LocalDateTime.now().plusDays(2), p8, "pol@gmail.com",1.00);
			Offerta of222222 = new Offerta(19, "linda@gmail.com", a8);
			a8.inserisci(of222222);
			u5.getOfferteInCorso().add(of222222);
			asteDaMostare.add(a8);
			
			Prodotto p9 = new Prodotto("Quadro", "Quadro astratto", "Arredo" ,"quadro.jpg");
			Asta a9  = new Asta("Quadro 1895 ", "Quadro antico stile astrattismo", LocalDateTime.now().plusDays(2), p9, "mark@gmail.com",1.00);
			Offerta of22222 = new Offerta(19, "rick@gmail.com", a9);
			Offerta of4444 = new Offerta(100,"linda@gmail.com", a9);
			a9.inserisci(of22222);
			a9.inserisci(of4444);
			test.getOfferteInCorso().add(of22222);
			u5.getOfferteInCorso().add(of4444);
			asteDaMostare.add(a9);
			
			Prodotto p10 = new Prodotto("Scarpe da calcio", "Predator 13 tacchetti", "Sport" ,"pr.png");
			Asta a10  = new Asta("Scarpe da calcio Predator", "Condizione nuova, provate una volta", LocalDateTime.now().plusDays(2), p10, "pol@gmail.com",1.00);
			Offerta of2222222 = new Offerta(19, "linda@gmail.com", a10);
			a10.inserisci(of2222222);
			u5.getOfferteInCorso().add(of2222222);
			asteDaMostare.add(a10);
			
			Prodotto p11 = new Prodotto("Guantoni da box", "Marca Leone", "Sport" ,"guantoni.jpg");
			Asta a11  = new Asta("Guantoni da Box ", "Comodi per chi ? nuovo allo sport", LocalDateTime.now().plusDays(2), p11, "pol@gmail.com",1.00);
			Offerta of22222222 = new Offerta(19, "linda@gmail.com", a11);
			a11.inserisci(of22222222);
			asteDaMostare.add(a11);
			
			Prodotto p12 = new Prodotto("Scarpe da calcio Adidas", "Scarpe 13 tacchetti", "Sport" ,"scarpa2.jpg");
			Asta a12  = new Asta("Scarpe da calcio Adidas 13 ", "Scarpa fascia economica ", LocalDateTime.now().plusDays(2), p12, "pol@gmail.com",1.00);
			Offerta of222222222 = new Offerta(25, "linda@gmail.com", a12);
			a12.inserisci(of222222222);
			asteDaMostare.add(a12);
			
			Ricarica r = new Ricarica(1000, "dollaro", LocalDateTime.now().minusDays(45));
			test.getWallet().getListaRicariche().add(r);
			test.getWallet().setSaldo(test.getWallet().getSaldo()+1000);
			Prelievo p=new Prelievo(150,"euro", LocalDateTime.now().minusDays(35));
			test.getWallet().getListaPrelievi().add(p);
			test.getWallet().setSaldo(test.getWallet().getSaldo()-150);
			Prelievo p21=new Prelievo(230,"euro", LocalDateTime.now().minusDays(30));
			test.getWallet().getListaPrelievi().add(p21);
			test.getWallet().setSaldo(test.getWallet().getSaldo()-230);
			Ricarica r2 = new Ricarica(100, "pound", LocalDateTime.now().minusDays(22));
			test.getWallet().getListaRicariche().add(r2);
			test.getWallet().setSaldo(test.getWallet().getSaldo()+100);
			Prelievo p31=new Prelievo(340,"euro", LocalDateTime.now().minusDays(5));
			test.getWallet().getListaPrelievi().add(p31);
			test.getWallet().setSaldo(test.getWallet().getSaldo()-340);
			Ricarica r3 = new Ricarica(3512, "dollaro", LocalDateTime.now().minusDays(45));
			u5.getWallet().getListaRicariche().add(r3);
			u5.getWallet().setSaldo(u5.getWallet().getSaldo()+3512);
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
	public static void setCurrent(Utente currentUser2)
	{
		DbMock.currentUser = currentUser2;
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
	public static List<Asta> getAsteTerminate() {
		return asteTerminate;
	}
	public static void setAsteTerminate(List<Asta> asteTerminate) {
		DbMock.asteTerminate = asteTerminate;
	}
	
}
