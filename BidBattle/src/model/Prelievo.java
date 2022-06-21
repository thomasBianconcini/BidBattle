package model;
import java.time.LocalDateTime;

import com.ibm.icu.util.LocalePriorityList;

public class Prelievo {
@Override
	public String toString() {
		return "Movimento: Prelievo\nImporto= " + importo + " | Divisa= " + divisa + " | Data= "+data.getDayOfMonth()+ "/"+(data.getMonthValue())+"/" +data.getYear()+ " "+ data.getHour()+":"+data.getMinute();
	}
private int id;
private double importo;
private String divisa;
private LocalDateTime data;
public Prelievo(double prezzo, String divisa) {
	importo=prezzo;
	this.divisa=divisa;
	data=LocalDateTime.now();
}
public Prelievo(double prezzo, String divisa,LocalDateTime ldt) {
	importo=prezzo;
	this.divisa=divisa;
	data=ldt;
}
public Prelievo() {
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
