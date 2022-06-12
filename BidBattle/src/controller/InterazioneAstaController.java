package controller;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Asta;
import model.DbMock;
import model.Offerta;

public class InterazioneAstaController {
DbMock db = new DbMock();
List<Asta> aste= DbMock.getAsteDaMostare();

public InterazioneAstaController() {};
	 public Offerta inserisciOfferta(Asta asta, double importo, String email)
	 {
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
