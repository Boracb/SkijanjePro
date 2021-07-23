package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import app.databaseConnection.SpajanjeNaBazu;
import app.model.SkijasTrkac;

public class SkijasTrkacDAO {

	public static int save(SkijasTrkac n) {
		int status = 0;
		try {
			Connection con = SpajanjeNaBazu.DohvatiVezu();
			PreparedStatement ps = con.prepareStatement(
					"insert into natjecatelji(mjesto,broj,klub,kategorija,kod,prezime,ime,bodovi,vrijeme,zaostatak) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, n.getMjesto());
			ps.setString(2, n.getBroj());
			ps.setString(3, n.getKlub());
			ps.setString(4, n.getKategorija());
			ps.setString(5, n.getKod());
			ps.setString(6, n.getPrezime());
			ps.setString(7, n.getIme());
			ps.setInt(8, n.getBod());
			ps.setString(9, n.getVrijeme());
			ps.setString(10, n.getRazlika());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// lista natjecatelja za potrebe u aplikaciji
	public static List<SkijasTrkac> view() {

		List<SkijasTrkac> list = new ArrayList<SkijasTrkac>();

		try {
			Connection con = SpajanjeNaBazu.DohvatiVezu();
			PreparedStatement ps = con.prepareStatement("select * from natjecatelji");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SkijasTrkac s = new SkijasTrkac(0, null, null, null, null, null, null, (short) 0, null, null, null);
				s.setId(rs.getInt("natjecatelj_id"));
				s.setMjesto(rs.getString("mjesto"));
				s.setBroj(rs.getString("broj"));
				s.setKlub(rs.getString("klub"));
				s.setKategorija(rs.getString("kategorija"));
				s.setKod(rs.getString("kod"));
				s.setPrezime(rs.getString("prezime"));
				s.setIme(rs.getString("ime"));
				s.setBod(rs.getShort("bodovi"));
				s.setVrijeme(rs.getString("vrijeme"));
				list.add(s);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	
	
}
