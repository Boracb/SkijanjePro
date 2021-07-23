package app.databaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class KreiranjeTablicaBaza {
	
	private static Connection veza;
	private static Statement izraz;

	// kreiranje u bazi data tablice  Natjecatelji
	private static boolean kreirajTablicuNatjecatelji() throws SQLException {

		try {

			System.out.println("Connected");

			veza = SpajanjeNaBazu.DohvatiVezu();

			System.out.println("Opened database successfully");

			izraz = veza.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS `Natjecatelji` (\r\n"
					+ "  `id` int(10) NOT NULL AUTO_INCREMENT,\r\n" + "  `MJESTO` varchar(200) NOT NULL,\r\n" 
					+ "  `BROJ` varchar(200) NOT NULL,\r\n"
					+ "  `KLUB` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `KATEGORIJA` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `KOD` varchar(100) NOT NULL,\r\n"
					+ "  `PREZIME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `IME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `BODOVI` int(10),\r\n" 
					+ "  `VRIJEME` varchar(100),\r\n" 
					+ "  `zaostatak` varchar(100),\r\n" + "  PRIMARY KEY (`id`)\r\n"
					+ ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ; ";

			izraz.executeUpdate(sql);
			
		

		} catch (Exception e4) {
			System.err.println(e4.getClass().getName() + ": " + e4.getMessage());
			System.exit(0);

		} finally {

		}

		return false;

	}
	
	public static void kreirajTablice() throws SQLException {
		
		kreirajTablicuNatjecatelji();
		
	}
	
	public static void izbrisiTablicu() throws SQLException{ 
	   	
		   veza = SpajanjeNaBazu.DohvatiVezu();
		     // izraz =veza.prepareStatement("DROP TABLE KLUBOVI");
		     // rs = izraz.executeQuery();
		      
		      izraz = veza.createStatement();
		      
		      String sql = "DROP TABLE natjecatelji ";
		 
		      izraz.executeUpdate(sql);
		      
		      System.out.println("izbrisano");
		   
		     //veza.close();
		     }
	

	// kreiranje u bazi data tablice  Natjecatelji
	private static boolean kreirajTablicuKluboviBodovi() throws SQLException {

		try {

			System.out.println("Connected");

			veza = SpajanjeNaBazu.DohvatiVezu();

			System.out.println("Opened database successfully");

			izraz = veza.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS `Natjecatelji` (\r\n"
					+ "  `id` int(10) NOT NULL AUTO_INCREMENT,\r\n" + "  `MJESTO` varchar(200) NOT NULL,\r\n" 
					+ "  `BROJ` varchar(200) NOT NULL,\r\n"
					+ "  `KLUB` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `KATEGORIJA` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `KOD` varchar(100) NOT NULL,\r\n"
					+ "  `PREZIME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `IME` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,\r\n"
					+ "  `BODOVI` int(10),\r\n" 
					+ "  `VRIJEME` varchar(100),\r\n" 
					+ "  `zaostatak` varchar(100),\r\n" + "  PRIMARY KEY (`id`)\r\n"
					+ ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ; ";

			izraz.executeUpdate(sql);
			
		

		} catch (Exception e4) {
			System.err.println(e4.getClass().getName() + ": " + e4.getMessage());
			System.exit(0);

		} finally {

		}

		return false;

	}
	

}
