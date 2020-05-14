import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablePage extends JFrame {

	private JPanel contentPane;
	private String tableName;
	private Check check;
	private JTable orderTable;
	private DatabaseManager databaseManager;

	/**
	 * Create the frame.
	 */
	public TablePage(String tableName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.tableName = tableName;
		check = new Check();
		databaseManager = DatabaseManager.getDatabaseManager();
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Price", "Quantity"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		orderTable.setBounds(276, 12, 578, 316);
		contentPane.add(orderTable);
		
		JPanel panelFood = new JPanel();
		panelFood.setBounds(12, 12, 252, 316);
		contentPane.add(panelFood);
		panelFood.setLayout(null);
		
		JPanel panelDrink = new JPanel();
		panelDrink.setVisible(false);
		panelDrink.setBounds(12, 12, 252, 316);
		contentPane.add(panelDrink);
		panelDrink.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmFoods = new JMenuItem("Foods");
		mntmFoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFood.setVisible(true);
				panelDrink.setVisible(false);
			}
		});
		mnOptions.add(mntmFoods);
		
		JMenuItem mntmDrinks = new JMenuItem("Drinks");
		mntmDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelDrink.setVisible(true);
				panelFood.setVisible(false);
			}
		});
		mnOptions.add(mntmDrinks);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setTitle(tableName);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableSelection tableSelection = new TableSelection();
				setVisible(false);
				tableSelection.setVisible(true);
			}
		});
		btnBack.setBounds(251, 343, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setBounds(105, 12, 44, 15);
		panelDrink.add(lblDrink);
		
		JButton btnWater = new JButton("Water");
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Drink water = new NonAlcoholDrink("Water", 2.00, 1, 500, true);
				databaseManager.addItemToCheck(tableName, water);
			}
		});
		btnWater.setBounds(57, 39, 139, 25);
		panelDrink.add(btnWater);
		
		JButton btnMineralWater = new JButton("Mineral Water");
		btnMineralWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnMineralWater.setBounds(57, 76, 139, 25);
		panelDrink.add(btnMineralWater);
		
		JButton btnCoke = new JButton("Coke");
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCoke.setBounds(57, 113, 139, 25);
		panelDrink.add(btnCoke);
		
		JButton btnTea = new JButton("Tea");
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnTea.setBounds(57, 150, 139, 25);
		panelDrink.add(btnTea);
		
		JButton btnBeer = new JButton("Beer");
		btnBeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnBeer.setBounds(57, 187, 139, 25);
		panelDrink.add(btnBeer);
		
		JButton btnWine = new JButton("Wine");
		btnWine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnWine.setBounds(57, 224, 139, 25);
		panelDrink.add(btnWine);
		
		JButton btnRaki = new JButton("Raki");
		btnRaki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnRaki.setBounds(57, 261, 139, 25);
		panelDrink.add(btnRaki);
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setBounds(105, 12, 44, 15);
		panelFood.add(lblFood);
		
		JButton btnChicken = new JButton("Chicken");
		btnChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnChicken.setBounds(57, 39, 139, 25);
		panelFood.add(btnChicken);
		
		JButton btnHamburger = new JButton("Hamburger");
		btnHamburger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnHamburger.setBounds(57, 76, 139, 25);
		panelFood.add(btnHamburger);
		
		JButton btnSalad = new JButton("Salad");
		btnSalad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSalad.setBounds(57, 113, 139, 25);
		panelFood.add(btnSalad);
		
		JButton btnPasta = new JButton("Pasta");
		btnPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnPasta.setBounds(57, 150, 139, 25);
		panelFood.add(btnPasta);
		
		JButton btnSteak = new JButton("Steak");
		btnSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSteak.setBounds(57, 187, 139, 25);
		panelFood.add(btnSteak);
		
		JButton btnFriedPotatoes = new JButton("Fried Potatoes");
		btnFriedPotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnFriedPotatoes.setBounds(57, 224, 139, 25);
		panelFood.add(btnFriedPotatoes);
		
		JButton btnMeatball = new JButton("Meatball");
		btnMeatball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnMeatball.setBounds(57, 261, 139, 25);
		panelFood.add(btnMeatball);
		
		
	}
}
