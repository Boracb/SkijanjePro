package app.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.controller.SkijasTrkacDAO;
import app.databaseConnection.SpajanjeNaBazu;
import app.model.SkijasTrkac;


public class JTablePomagalo {
	

	
	private static Connection veza;
	private static Statement izraz;
	private static ResultSet rs;
	
	static ArrayList<SkijasTrkac> natjecateljLista = new ArrayList<SkijasTrkac>();

	public static ArrayList<SkijasTrkac> listaNAtjecatelja(JTable table) {

		ArrayList<SkijasTrkac> listaNatjecatelja = new ArrayList<>();

		int brojacTablice = table.getColumnCount();

		if (brojacTablice != 0) {

			for (int i = 0; i < table.getRowCount(); i++) {

				SkijasTrkac nat = new SkijasTrkac(i, null, null);;


				nat.setMjesto((String) table.getValueAt(i, table.getColumn("#").getModelIndex()));

				nat.setBroj((String) table.getValueAt(i, table.getColumn("Bib").getModelIndex()));
				
				nat.setKod((String) table.getValueAt(i, table.getColumn("Code").getModelIndex()));
				
				nat.setPrezime((String) table.getValueAt(i, table.getColumn("Lastname").getModelIndex()));
				
				nat.setIme((String) table.getValueAt(i, table.getColumn("Firstname").getModelIndex()));

				nat.setKlub((String) table.getValueAt(i, table.getColumn("Club").getModelIndex()));
		
				nat.setKategorija((String) table.getValueAt(i, table.getColumn("Class").getModelIndex()));

				nat.setVrijeme((String) table.getValueAt(i, table.getColumn("Run 1").getModelIndex()));

				nat.setRazlika((String) table.getValueAt(i, table.getColumn("Diff").getModelIndex()));

				switch (nat.getMjesto()) {
				case "1":
				case "=1":
					nat.setBod((short) 50);
					break;

				case "2":
				case "=2":
					nat.setBod((short) 40);
					break;

				case "3":
				case "=3":
					nat.setBod((short) 30);
					break;

				case "4":
				case "=4":
					nat.setBod((short) 24);
					break;

				case "5":
				case "=5":
					nat.setBod((short) 22);
					break;

				case "6":
				case "=6":
					nat.setBod((short) 20);
					break;

				case "7":
				case "=7":
					nat.setBod((short) 18);
					break;

				case "8":
				case "=8":
					nat.setBod((short) 16);
					break;

				case "9":
				case "=9":
					nat.setBod((short) 14);
					break;

				case "10":
				case "=10":
					nat.setBod((short) 12);
					break;

				case "11":
				case "=11":
					nat.setBod((short) 10);
					break;

				case "12":
				case "=12":
					nat.setBod((short) 8);
					break;

				case "13":
				case "=13":
					nat.setBod((short) 6);
					break;

				case "14":
				case "=14":
					nat.setBod((short) 4);
					break;

				case "15":
				case "=15":
					nat.setBod((short) 2);
					break;

				case "":
					nat.setBod((short) 0);
					break;

				default:

					nat.setBod((short) 1);
					break;

				}
				listaNatjecatelja.add(nat);
			}
			for (SkijasTrkac natjecatelj : listaNatjecatelja) {
				
				SkijasTrkacDAO.save(natjecatelj);
			}

		}

	
		return listaNatjecatelja;

	}
	


	public static ArrayList<SkijasTrkac> bazaNatjecateljiToArrayList() throws SQLException {
		
	
         
        	try {
				try {
					veza = SpajanjeNaBazu.DohvatiVezu();
					izraz  = veza.createStatement();
					rs = izraz.executeQuery("SELECT * FROM natjecatelji");
					while (rs.next()) {
					    SkijasTrkac natjecatelj = new SkijasTrkac(0, null, null);
					    natjecatelj.setId(rs.getInt("id"));
					    natjecatelj.setMjesto(rs.getString("MJESTO"));
					    natjecatelj.setBroj(rs.getString("BROJ"));
					    natjecatelj.setKod(rs.getString("KOD"));
					    natjecatelj.setPrezime(rs.getString("PREZIME"));
					    natjecatelj.setIme(rs.getString("IME"));
					    natjecatelj.setKlub(rs.getString("KLUB"));
					    natjecatelj.setKategorija(rs.getString("KATEGORIJA"));
					    natjecatelj.setVrijeme(rs.getString("VRIJEME"));
					    natjecatelj.setRazlika(rs.getString("ZAOSTATAK"));
					    natjecatelj.setBod(rs.getShort("BODOVI"));
					    natjecateljLista.add(natjecatelj);
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return natjecateljLista;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return natjecateljLista;
	
            
	
	}
	
	public static void napuniJTable(JTable table_1, ArrayList<SkijasTrkac> natjecateljLista ) throws SQLException {

	

		

		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		Object[] row = new Object[11];
		for (int i = 0; i < natjecateljLista.size(); i++) {
			row[0] = natjecateljLista.get(i).getId();
			row[1] = natjecateljLista.get(i).getMjesto();
			row[2] = natjecateljLista.get(i).getBroj();
			row[3] = natjecateljLista.get(i).getKod();
			row[4] = natjecateljLista.get(i).getPrezime();
			row[5] = natjecateljLista.get(i).getIme();
			row[6] = natjecateljLista.get(i).getKlub();
			row[7] = natjecateljLista.get(i).getKategorija();
			row[8] = natjecateljLista.get(i).getVrijeme();
			row[9] = natjecateljLista.get(i).getRazlika();
			row[10] = natjecateljLista.get(i).getBod();		

			model.addRow(row);

	
			
		}
	}


}
