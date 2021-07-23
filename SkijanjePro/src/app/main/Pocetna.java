package app.main;

import java.sql.SQLException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import app.databaseConnection.KreiranjeTablicaBaza;
import app.databaseConnection.SpajanjeNaBazu;
import app.utility.Excel;
import app.view.PocetniProzor;
import app.view.Proba;
import app.view.ProbaMenu;

public class Pocetna {

	public static void main(String[] args) throws SQLException {
		


		
		SpajanjeNaBazu.DohvatiVezu();
		
		KreiranjeTablicaBaza kreizanjeTablice = new KreiranjeTablicaBaza();
		
		kreizanjeTablice.kreirajTablice();
		
	
		 // izgled GUI-a / vrsta / na bazi cijele aplikacije
        try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        //ProbaMenu.ProbaMenumain();
     
        Proba.pokreniProba();
	}

}
