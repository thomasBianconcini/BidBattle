package model;
import java.time.LocalDateTime;

public class Ricarica {
	private int id;
	private double importo;
	private String divisa;
	private LocalDateTime data;
	
	public Ricarica(double prezzo,String divisa){
		this.importo=prezzo;
		this.divisa=divisa;
	}

	public Ricarica() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public String getDivisa() {
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	};
	
	
}
