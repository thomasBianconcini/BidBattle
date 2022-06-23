package controller;

import java.util.List;

import model.DbMock;
import model.Utente;

public class ModificaDatiController {

	public boolean modificaDati(List<String> dati) { //in totale sono 6
        boolean res=true;
        Utente utenteToModify=DbMock.getCurrentUser();

        if(!dati.get(0).equals("tt"))
        {
        	System.out.println(dati.get(0));
            utenteToModify.setEmail(dati.get(0));
        }
        if(!dati.get(1).equals("tt"))
        {
        	System.out.println("ciao mare");
            if(dati.get(1).equals(DbMock.getCurrentUser().getPassword()))
                utenteToModify.setPassword(dati.get(2));
          //  else
            //    res=false;
        }
        if(!dati.get(3).equals("tt"))
        {
        	System.out.println(dati.get(3));
            utenteToModify.setIndirizzo(dati.get(3));
        }
        if(!dati.get(4).equals("tt"))
        {
            utenteToModify.setNomeProfilo(dati.get(4));
        }
        if(!dati.get(5).equals("tt"))
        {
            utenteToModify.setDescrizione(dati.get(5));
        }
        if(!dati.get(6).equals("tt"))
        {
            utenteToModify.setImmagineProfilo(dati.get(6));
        }
        DbMock.setCurrentUser(utenteToModify);
        return res;
    }
}
