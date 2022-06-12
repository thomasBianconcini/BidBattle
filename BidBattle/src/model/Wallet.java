package model;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
	private double saldo ;
	private String divisa;
	private String proprietario;
	private List<Ricarica> listaRicariche= new ArrayList<Ricarica>();
	private List<Prelievo> listaPrelievi= new ArrayList<Prelievo>();
	public Wallet(String proprietario)
	{
		this.proprietario=proprietario;
		this.saldo=0F;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getDivisa() {
		return divisa;
	}
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public List<Ricarica> getListaRicariche() {
		return listaRicariche;
	}
	public void setListaRicariche(List<Ricarica> listaRicariche) {
		this.listaRicariche = listaRicariche;
	}
	public List<Prelievo> getListaPrelievi() {
		return listaPrelievi;
	}
	public void setListaPrelievi(List<Prelievo> listaPrelievi) {
		this.listaPrelievi = listaPrelievi;
	}
	public void ricarica(Ricarica ricarica)
	{
		listaRicariche.add(ricarica);
		saldo=saldo+ricarica.getImporto();
	}
	public void prelievo(Prelievo prelievo)
	{
		listaPrelievi.add(prelievo);
		saldo=saldo - prelievo.getImporto();
	}
}
