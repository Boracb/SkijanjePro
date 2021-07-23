package app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.utility.Excel;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class PocetniProzor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTable table;
	static JScrollPane scrollPane;
	static DefaultTableModel model = null;
	static JFileChooser jfileChooeser;

	
	static int tableWidth = 0;
	static int tableHeight = 0;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void pokreniPocetniProzor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PocetniProzor frame = new PocetniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PocetniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		Excel exc = new Excel();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 32, 831, 536);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		

			
		jfileChooeser = new JFileChooser();
		
		JButton btnUcitajExcel = new JButton("Ucitaj Excel");
		btnUcitajExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				


				jfileChooeser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = jfileChooeser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {

					File file = jfileChooeser.getSelectedFile();
					if (!file.getName().endsWith("xls") && file.exists()) {
						JOptionPane.showMessageDialog(null, "Please select only Excel file.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						exc.dohvatiExcelTablicu(file);
						model = new DefaultTableModel(Excel.getData(),Excel.getHeaders());
						tableWidth = model.getColumnCount() * 150;
						tableHeight = model.getRowCount() * 25;
						table.setPreferredSize(new Dimension(tableWidth, tableHeight));

						table.setModel(model);
					}

				}

				

			
				
			}
		});
		btnUcitajExcel.setBounds(10, 42, 85, 21);
		contentPane.add(btnUcitajExcel);
	}
}
