package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import model.DbMock;
import model.Utente;

public class RegistrazioneController {

	private DbMock db;
	private List<Utente> utenti= new ArrayList<>();
	public RegistrazioneController()
	{
		db =new DbMock();
		utenti = db.getUtenti();
	}
	
	public String Registrazione(String email, String password, String conferma ,String indirizzo )
	{
		final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).+$");
		if(password.equals(conferma) && email.contains("@") && password.length()>=8 && password.length()<40 && textPattern.matcher(password).matches())
		{
			Utente u = new Utente(email, password, indirizzo);
			utenti.add(u);
			db.setUtenti(utenti);
			return "OK";
		}else if(!password.equals(conferma))
		{
			return "Le password non coincidono";
		}else if(!email.contains("@"))
		{
			return " Email non è un email";
		}else if(password.length()<8)
		{
			return " Password troppo corta";
		}else if(password.length()>=40)
		{
			return " Password troppo lunga";
		}else if(!textPattern.matcher(password).matches())
		{
			return "Non è presente alcuna maiuscola";
		}
		
		return null;
	}
}
