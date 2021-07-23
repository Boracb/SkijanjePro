package app.utility;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.view.PocetniProzor;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel {
	



	public static Vector<String> getHeaders() {
		return headers;
	}




	public static void setHeaders(Vector<String> headers) {
		Excel.headers = headers;
	}




	public static Vector<Vector<String>> getData() {
		return data;
	}




	public static void setData(Vector<Vector<String>> data) {
		Excel.data = data;
	}




	//zaglavlje excel dokumenta
    static Vector<String> headers = new Vector<String>();
	//podaci iz excel redaka
	  static Vector<Vector<String>> data = new Vector<Vector<String>>();
	
	
	
	
	public void dohvatiExcelTablicu(File file) {
		
		 Workbook workbook = null;
	        try {
	            try {
	                workbook = Workbook.getWorkbook(file);
	            } catch (IOException ex) {
	                Logger.getLogger(
	                        PocetniProzor.class.
	                        getName()).log(Level.SEVERE,
	                                null, ex);
	            }
	            Sheet sheet = workbook.getSheet(0);

	            headers.clear();
	            for (int i = 0; i < sheet.getColumns(); i++) {
	                Cell cell1 = sheet.getCell(i, 0);
	                headers.add(cell1.getContents());
	            }

	            data.clear();
	            for (int j = 1; j < sheet.getRows(); j++) {
	                Vector<String> d = new Vector<String>();
	                for (int i = 0; i < sheet.getColumns(); i++) {

	                    Cell cell = sheet.getCell(i, j);

	                    d.add(cell.getContents());

	                }
	                d.add("\n");
	                data.add(d);
	            }
	        } catch (BiffException e) {
	            e.printStackTrace();
	        }
	}
	
	

	

}
