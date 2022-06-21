package controller;

import java.util.ArrayList;
import java.util.List;

import model.Asta;
import model.DbMock;
import model.Utente;

public class LoginController {
	private DbMock db;
	private List<Asta> aste= new ArrayList<>();
	private List<Utente> utenti= new ArrayList<>();
public LoginController(){
	db =new DbMock();
	aste = DbMock.getAsteDaMostare();
	utenti = DbMock.getUtenti();
}
public boolean verificaAccesso(String email,String pass)
{
	for(Utente u: utenti)
	{
		if(u.getEmail().equals(email))
		{
			if(u.getPassword().equals(pass))
			{
				DbMock.setCurrent(u);
				return true;
			}	
		}
	}
	return false;
}
}
