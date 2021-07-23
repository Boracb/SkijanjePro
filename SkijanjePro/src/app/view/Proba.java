package app.view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import app.databaseConnection.KreiranjeTablicaBaza;
import app.databaseConnection.SpajanjeNaBazu;
import app.model.SkijasTrkac;
import app.utility.Excel;
import app.utility.JTablePomagalo;
import app.utility.Pomagala;


import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Proba extends JFrame implements TableModelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	static JTable table;

	static JFileChooser jfileChooeser;
	static DefaultTableModel model = null;

	static int tableWidth = 0;
	static int tableHeight = 0;
	private JTable table_1;

	TableModel myTableModel;

	public ArrayList<SkijasTrkac> natjecatelji = new ArrayList<SkijasTrkac>();
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void pokreniProba() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proba frame = new Proba();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setUndecorated(true);
					Pomagala.centrirajFrame(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Proba() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 824);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Excel exc = new Excel();
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 1416, 777);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Unos podataka", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 27, 1227, 713);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		//natjecatelji = JTablePomagalo.bazaNatjecateljiToArrayList();

		JButton btnNewButton = new JButton("Ucitaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				jfileChooeser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = jfileChooeser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {

					File file = jfileChooeser.getSelectedFile();
					if (!file.getName().endsWith("xls") && file.exists()) {
						JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						TableColumnModel tcm = table.getColumnModel();

						exc.dohvatiExcelTablicu(file);
						model = new DefaultTableModel(Excel.getData(), Excel.getHeaders());
						tableWidth = model.getColumnCount() * 150;
						tableHeight = model.getRowCount() * 25;
						table.setPreferredSize(new Dimension(tableWidth, tableHeight));

						table.setModel(model);
						tcm.getColumn(5).setPreferredWidth(300);
						tcm.getColumn(8).setPreferredWidth(300);
						tcm.getColumn(17).setPreferredWidth(300);
					}

				}

			}
		});
		btnNewButton.setBounds(26, 27, 85, 21);
		panel.add(btnNewButton);

		table = new JTable();
		scrollPane.setViewportView(table);

		natjecatelji = JTablePomagalo.bazaNatjecateljiToArrayList();

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		myTableModel = new MyTableModel();

		table_1 = new JTable(myTableModel);

		table_1.setPreferredScrollableViewportSize(table_1.getPreferredSize());

		table_1.setFillsViewportHeight(true);
		
	

		//myTableModel.addTableModelListener(this);

		JButton btnNewButton_1 = new JButton("Snimi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		

				DefaultTableModel dm = (DefaultTableModel) table.getModel();

				JTablePomagalo.listaNAtjecatelja(table);

				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				
				Proba.pokreniProba();
										
			}

		});
		btnNewButton_1.setBounds(26, 58, 85, 21);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Izbri\u0161i");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				removeSelectedRows(table);

			}
		});
		btnNewButton_2.setBounds(26, 89, 85, 21);
		panel.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
	
		tabbedPane.addTab("Natjecatelji", null, panel_1, null);
		
		panel_1.setLayout(null);


		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(100, 31, 1282, 683);
		panel_1.add(scrollPane_1);

		// table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_3 = new JButton("Osvje\u017Ei");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
		
				
			}
		});
		btnNewButton_3.setBounds(10, 40, 85, 21);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Izbri\u0161i");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					KreiranjeTablicaBaza.izbrisiTablicu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Proba.pokreniProba();
				
				try {
					KreiranjeTablicaBaza.kreirajTablice();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(10, 71, 85, 21);
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tablice", null, panel_2, null);
		panel_2.setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(190, 24, 370, 354);
		panel_2.add(table_2);
		
		table_3 = new JTable();
		table_3.setBounds(811, 24, 391, 362);
		panel_2.add(table_3);
		
		table_4 = new JTable();
		table_4.setBounds(486, 412, 382, 309);
		panel_2.add(table_4);

		jfileChooeser = new JFileChooser();
		
		SwingUtilities.invokeLater(new Runnable()
		{
		    public void run()
		    {
		        tabbedPane.setSelectedIndex(1);
		    }
		});

	}

	public void removeSelectedRows(JTable table) {
		DefaultTableModel model = (DefaultTableModel) Proba.table.getModel();
		int[] rows = table.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		


		Connection con = SpajanjeNaBazu.DohvatiVezu();
		PreparedStatement ps = null;


		int row = e.getFirstRow();
		int column = e.getColumn();
		// String value = myTable.getModel().getValueAt(row, column).toString();

//		// postavanjenje uzglavalja za table_2 u u tabu natjecatelji

//		myTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "natjecatelj_id", "MJESTO", "BROJ", "KOD",
//				"PREZIME", "IME", "KLUB", "KATEGORIJA", "VRIJEME", "ZAOSTATAK", "BOD" }));
////
//		myTable.getModel().addTableModelListener(myTable);
//		
//		myTable.repaint();
	

		// stao

		myTableModel = (MyTableModel) e.getSource();
		String columnName = myTableModel.getColumnName(column);
		// Object data = myTableModel.getValueAt(row, column);


		try {
			if (columnName.equals("MJESTO")) {
				ps = con.prepareStatement("update Natjecatelji set mjesto=?where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getMjesto());
				ps.executeUpdate();
			} else if (columnName.equals("BROJ")) {
				ps = con.prepareStatement("update Natjecatelji set Broj=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getBroj());
				ps.executeUpdate();
			} else if (columnName.equals("KOD")) {
				ps = con.prepareStatement("update Natjecatelji set kod=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getKod());
				ps.executeUpdate();
			} else if (columnName.equals("PREZIME")) {
				ps = con.prepareStatement("update Natjecatelji set prezime=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getPrezime());
				ps.executeUpdate();
			} else if (columnName.equals("IME")) {
				ps = con.prepareStatement("update Natjecatelji set ime=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getIme());
				ps.executeUpdate();
			} else if (columnName.equals("KLUB")) {
				ps = con.prepareStatement("update Natjecatelji set klub=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getKlub());
				ps.executeUpdate();
			} else if (columnName.equals("KATEGORIJA")) {
				ps = con.prepareStatement("update Natjecatelji set kategorija=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getKategorija());
				ps.executeUpdate();
			}

			else if (columnName.equals("VRIJEME")) {
				ps = con.prepareStatement("update Natjecatelji set vrijeme=? where id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setString(1, natjecatelji.get(row).getVrijeme());
				ps.executeUpdate();
			}

			else if (columnName.equals("BOD")) {
				ps = con.prepareStatement("update Natjecatelji set bod=? where natjecatelj_id = '"
						+ natjecatelji.get(row).getId() + "'");
				ps.setInt(1, natjecatelji.get(row).getBod());
				ps.executeUpdate();
			}

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	

	}

	// ArrayList<Natjecatelj> natjecatelj =
	// SpremiIzTabliceUListu.bazaNatjecateljiToArrayList();

	class MyTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;

		// UpisiPodtakeIzTabliceUBazu up = new UpisiPodtakeIzTabliceUBazu();

		String[] natjecateljiColumnNames = { "ID", "MJESTO", "BROJ", "KOD", "PREZIME", "IME", "KLUB", "KATEGORIJA",
				"VRIJEME", "ZAOSTATAK", "BOD" };

		public MyTableModel() {
	
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return natjecatelji.size();

		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 11;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {

			switch (columnIndex) {
			case 0:
				return natjecatelji.get(rowIndex).getId();
			case 1:
				return natjecatelji.get(rowIndex).getMjesto();
			case 2:
				return natjecatelji.get(rowIndex).getBroj();
			case 3:
				return natjecatelji.get(rowIndex).getKod();
			case 4:
				return natjecatelji.get(rowIndex).getPrezime();
			case 5:
				return natjecatelji.get(rowIndex).getIme();
			case 6:
				return natjecatelji.get(rowIndex).getKlub();
			case 7:
				return natjecatelji.get(rowIndex).getKategorija();
			case 8:
				return natjecatelji.get(rowIndex).getVrijeme();
			case 9:
				return natjecatelji.get(rowIndex).getRazlika();
			case 10:
				return natjecatelji.get(rowIndex).getBod();

			default:
				break;
			}

			return "";
		}

		public String getColumnName(int col) {
			return natjecateljiColumnNames[col];
		}

		public boolean isCellEditable(int row, int col) {

			if (col == 1) {
				return false;
			} else if (col == 2) {
				return true;
			} else if (col == 3) {
				return true;
			} else if (col == 4) {
				return true;
			} else if (col == 5) {
				return true;
			} else if (col == 6) {
				return true;
			} else if (col == 7) {
				return true;
			} else if (col == 8) {
				return true;
			} else if (col == 9) {
				return true;
			} else if (col == 10) {
				return false;
		
			} else {
				return false;
			}
		}

		// Update the model when the use changes the quantity
		public void setValueAt(Object value, int row, int col) {

			if (col == 1) {
				natjecatelji.get(row).setMjesto(String.valueOf(value));

			} else if (col == 2) {
				natjecatelji.get(row).setBroj(String.valueOf(value));

			} else if (col == 3) {
				natjecatelji.get(row).setKod(String.valueOf(value));

			} else if (col == 4) {
				natjecatelji.get(row).setPrezime(String.valueOf(value));

			} else if (col == 5) {
				natjecatelji.get(row).setIme(String.valueOf(value));

			} else if (col == 6) {
				natjecatelji.get(row).setKlub(String.valueOf(value));

			} else if (col == 7) {
				natjecatelji.get(row).setKategorija(String.valueOf(value));

			} else if (col == 8) {
				natjecatelji.get(row).setVrijeme(String.valueOf(value));

			} else if (col == 9) {
				natjecatelji.get(row).setRazlika(String.valueOf(value));

			} else if (col == 10) {
				natjecatelji.get(row).setBod(Integer.parseInt((String) value));

			}

			TableModelEvent event = new TableModelEvent(this, row, row, col);
			fireTableChanged(event);

			tableChanged(event);

		}

	}
}
