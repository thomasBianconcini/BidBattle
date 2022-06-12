package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DbMock {

	static List<Utente> utenti= new ArrayList<>();

	static List<Asta> asteDaMostare= new ArrayList<>();
	
	static boolean init = false;
	
	public DbMock() {
		if(!init)
		{
			init = true;
			for(int i = 0; i<12 ;i++)
			{
				Prodotto p1 = new Prodotto("titolo"+i, "descrizione"+i, i+"" ,""+ i);
				Asta a1  = new Asta("123"+i, "descrizione"+i, LocalDateTime.now(), p1, i+"");
				asteDaMostare.add(a1);
			}
			for(int i = 0; i<12 ;i++)
			{
				Utente u1= new Utente("u+"+i+"@"+"gmail.com", "Password", "via bella bella");
				u1.setDescrizione("ciao sono bellissimo e sono il numero "+ i+i+i+i+i+i);
				u1.setNomeProfilo("Il magnifico"+ i+i+i+i+i+i );
				utenti.add(u1);
			}
		}
	};
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
	
}
