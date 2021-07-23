package app.model;

import java.util.ArrayList;

public class SkijasTrkac extends Osoba {

	private String mjesto;
	private String broj;
	private String kod;
	private String klub;
	private short bod;
	private String kategorija;
	private String vrijeme;
	private String razlika;
	private ArrayList<SkijasTrkac> skijasiTrkaci;
	
	
	
	public SkijasTrkac(int id, String ime, String prezime) {
		super(id, ime, prezime);
	}

	public SkijasTrkac(int id, String ime, String prezime, String mjesto, String broj, String kod, String klub,
			short bod, String kategorija, String vrijeme, String razlika) {
		super(id, ime, prezime);
		this.mjesto = mjesto;
		this.broj = broj;
		this.kod = kod;
		this.klub = klub;
		this.bod = bod;
		this.kategorija = kategorija;
		this.vrijeme = vrijeme;
		this.razlika = razlika;
	}

	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getKlub() {
		return klub;
	}

	public void setKlub(String klub) {
		this.klub = klub;
	}

	public short getBod() {
		return bod;
	}

	public void setBod(int i) {
		this.bod = (short) i;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getVrijeme() {
		return vrijeme;
	}

	public void setVrijeme(String vrijeme) {
		this.vrijeme = vrijeme;
	}

	public String getRazlika() {
		return razlika;
	}

	public void setRazlika(String razlika) {
		this.razlika = razlika;
	}

	public ArrayList<SkijasTrkac> getSkijasiTrkaci() {
		return skijasiTrkaci;
	}

	public void setSkijasiTrkaci(ArrayList<SkijasTrkac> skijasTrkac) {
		this.skijasiTrkaci = skijasTrkac;
	}

}
