package app.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpajanjeNaBazu {
	
	public static Connection veza;
	public static SpajanjeNaBazu baza = null;

	public SpajanjeNaBazu() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			veza = DriverManager.getConnection(
					"jdbc:mysql://localhost/skijanje?useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false&CharacterEncoding=utf-8",
					"root", "Borac666");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection DohvatiVezu() {

		if (baza == null) {
			baza = new SpajanjeNaBazu();

		}
		return veza;

	}

	public static void ZatvoriVezu() {
		try {
			veza.close();
		} catch (SQLException ex) {
			Logger.getLogger(SpajanjeNaBazu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


}
