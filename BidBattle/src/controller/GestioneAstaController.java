package controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Asta;
import model.DbMock;
import model.Prodotto;

public class GestioneAstaController {

	private List<Asta> listaAste= new ArrayList<>();
	public GestioneAstaController() {};
	public Asta creaAsta(Prodotto prodotto, String [] arr, LocalDateTime l,double prezzo) {
		
		Asta res = null;
		res= new Asta(arr[0].toString(),arr[1].toString(),l,prodotto,arr[2].toString(),prezzo);
		DbMock.getCurrentUser().getAstePersonali().add(res);
		DbMock.getAsteDaMostare().add(res);
		return res;
	}
	public List<Asta> getListaAste() {
		return listaAste;
	}
	public void setListaAste(List<Asta> listaAste) {
		this.listaAste = listaAste;
	};
	
}
