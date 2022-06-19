package controller;
import java.util.ArrayList;
import java.util.List;

import model.DbMock;
import model.Prelievo;
import model.Ricarica;
import model.Utente;

public class GestioneWalletController {
private List<Prelievo> prelievi= new ArrayList<>();
private List<Ricarica> ricariche= new ArrayList<>();
public GestioneWalletController() {};
public List<Prelievo> getPrelievi() {
	return prelievi;
}
public void setPrelievi(List<Prelievo> prelievi) {
	this.prelievi = prelievi;
}
public List<Ricarica> getRicariche() {
	return ricariche;
}
public void setRicariche(List<Ricarica> ricariche) {
	this.ricariche = ricariche;
}
public boolean ricarica(double prezzo,String div)
{
	Ricarica ricarica = new Ricarica(prezzo,div);
	ricariche.add(ricarica);
	Utente u =DbMock.getCurrentUser();
	if(prezzo>0)
	{
	u.getWallet().setSaldo(u.getWallet().getSaldo()+prezzo);
	u.getWallet().getListaRicariche().add(ricarica);
	}else return false;
	return true;
}
public boolean prelievo(double prezzo,String div)
{
	Prelievo prelievo = new Prelievo(prezzo, div);
	prelievi.add(prelievo);
	Utente u =DbMock.getCurrentUser();
	if(u.getWallet().getSaldo()>=prezzo)
	{
	u.getWallet().setSaldo(u.getWallet().getSaldo()-prezzo);
	u.getWallet().getListaPrelievi().add(prelievo);
	}else return false;
	return true;
}

}
