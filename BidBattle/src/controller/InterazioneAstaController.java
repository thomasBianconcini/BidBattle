package controller;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Asta;
import model.DbMock;
import model.Offerta;
import model.Utente;

public class InterazioneAstaController {
DbMock db = new DbMock();
List<Asta> aste= DbMock.getAsteDaMostare();

public InterazioneAstaController() {};
	 public Offerta inserisciOfferta(Asta asta, double importo, String email)
	 {
		 List<Asta> asteUtente= DbMock.getAsteFromVenditore(asta.getVenditore());
		 Asta elimina=null;
		 Asta inserisci = null;
		 Offerta res = null;
		 for(Asta a: aste)
		 {
			 if(a.getTitoloAsta().equals(asta.getTitoloAsta()))
			 {
				 if(importo>a.getCurrent())
				 {
					 elimina=a;
					 res= new Offerta(importo,email,asta);
					 String emailDaRimborsare= a.getOfferteInCorso().get(a.getOfferteInCorso().size()-1).getUtente();
					 System.out.println(emailDaRimborsare);
					 Utente u= DbMock.getUtente(emailDaRimborsare);
					 System.out.println(u.getWallet().getSaldo());
					 u.getWallet().setSaldo(u.getWallet().getSaldo()+a.getOfferteInCorso().get(a.getOfferteInCorso().size()-1).getPrezzo());
					 System.out.println(u.getWallet().getSaldo());
					 a.inserisci(res);
				 }
				 else
				 {
					 // pop up per annullo
					 return null;
				 }
				 if(Duration.between(a.getDurataAsta(), LocalDateTime.now()).getSeconds()<30)
				 {
					 a.setDurataAsta(LocalDateTime.now().plusSeconds(60));
				 } 
				inserisci=a;
			 }
		 }
		 aste.remove(elimina);
		 aste.add(inserisci);
		 asteUtente.remove(elimina);
		 asteUtente.add(inserisci);
		 DbMock.getCurrentUser().getWallet().setSaldo( DbMock.getCurrentUser().getWallet().getSaldo()-importo);
		 DbMock.getUtente(email).getOfferteInCorso().add(res);
		 return res;
	}
	 public void add(Asta a)
	 {
		 aste.add(a);
	 }
	
	public List<Asta> getAste() {
		return aste;
	}
	public void setAste(List<Asta> aste) {
		this.aste = aste;
	}
	 
}
