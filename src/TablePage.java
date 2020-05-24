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
import java.awt.Font;

public class TablePage extends JFrame {

	private JPanel contentPane;
	private String tableName;
	private Check check;
	private JTable orderTable;
	private DefaultTableModel model;
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
				"Name", "Quantity", "Price"
			}
		));
		orderTable.setBounds(276, 12, 578, 316);
		contentPane.add(orderTable);
		model = (DefaultTableModel)orderTable.getModel();	
		showList();
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPrice.setBounds(695, 340, 159, 40);
		contentPane.add(lblPrice);
		
		lblPrice.setText("");
		lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
		
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
		btnBack.setBounds(286, 350, 117, 25);
		contentPane.add(btnBack);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setBounds(105, 12, 44, 15);
		panelDrink.add(lblDrink);
		
		JButton btnWater = new JButton("Water");
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product water = new NonAlcoholDrink("Water",2.00,1,500,false);
				refreshTable();
				databaseManager.addProductToCheck(water, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnWater.setBounds(57, 39, 139, 25);
		panelDrink.add(btnWater);
		
		JButton btnMineralWater = new JButton("Mineral Water");
		btnMineralWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product mineralWater = new NonAlcoholDrink("Mineral Water",3.00,1,250,false);
				refreshTable();
				databaseManager.addProductToCheck(mineralWater, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnMineralWater.setBounds(57, 76, 139, 25);
		panelDrink.add(btnMineralWater);
		
		JButton btnCoke = new JButton("Coke");
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product coke = new NonAlcoholDrink("Coke",5.00,1,330,false);
				refreshTable();
				databaseManager.addProductToCheck(coke, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnCoke.setBounds(57, 113, 139, 25);
		panelDrink.add(btnCoke);
		
		JButton btnTea = new JButton("Tea");
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product tea = new NonAlcoholDrink("Tea",2.50,1,200,false);
				refreshTable();
				databaseManager.addProductToCheck(tea, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnTea.setBounds(57, 150, 139, 25);
		panelDrink.add(btnTea);
		
		JButton btnBeer = new JButton("Beer");
		btnBeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product beer = new AlcoholDrink("Beer",18.00,1,500,"5.00");
				refreshTable();
				databaseManager.addProductToCheck(beer, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnBeer.setBounds(57, 187, 139, 25);
		panelDrink.add(btnBeer);
		
		JButton btnWine = new JButton("Wine");
		btnWine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product wine = new AlcoholDrink("Wine",40.00,1,750,"12.50");
				refreshTable();
				databaseManager.addProductToCheck(wine, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnWine.setBounds(57, 224, 139, 25);
		panelDrink.add(btnWine);
		
		JButton btnRaki = new JButton("Raki");
		btnRaki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product raki = new AlcoholDrink("Raki",230.00,1,1000,"40.00");
				refreshTable();
				databaseManager.addProductToCheck(raki, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
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
				Product chicken = new Food("Chicken",16.00,1,false);
				refreshTable();
				databaseManager.addProductToCheck(chicken, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnChicken.setBounds(57, 39, 139, 25);
		panelFood.add(btnChicken);
		
		JButton btnHamburger = new JButton("Hamburger");
		btnHamburger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product hamburger = new Food("Hamburger",18.00,1,false);
				refreshTable();
				databaseManager.addProductToCheck(hamburger, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnHamburger.setBounds(57, 76, 139, 25);
		panelFood.add(btnHamburger);
		
		JButton btnSalad = new JButton("Salad");
		btnSalad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product salad = new Food("Salad",5.00,1,true);
				refreshTable();
				databaseManager.addProductToCheck(salad, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnSalad.setBounds(57, 113, 139, 25);
		panelFood.add(btnSalad);
		
		JButton btnPasta = new JButton("Pasta");
		btnPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product pasta = new Food("Pasta",10.00,1,true);
				refreshTable();
				databaseManager.addProductToCheck(pasta, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnPasta.setBounds(57, 150, 139, 25);
		panelFood.add(btnPasta);
		
		JButton btnSteak = new JButton("Steak");
		btnSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product steak = new Food("Steak",25.00,1,false);
				refreshTable();
				databaseManager.addProductToCheck(steak, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnSteak.setBounds(57, 187, 139, 25);
		panelFood.add(btnSteak);
		
		JButton btnFriedPotatoes = new JButton("Fried Potatoes");
		btnFriedPotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product friedPotatoes = new Food("Fried Potatoes",8.00,1,true);
				refreshTable();
				databaseManager.addProductToCheck(friedPotatoes, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnFriedPotatoes.setBounds(57, 224, 139, 25);
		panelFood.add(btnFriedPotatoes);
		
		JButton btnMeatball = new JButton("Meatball");
		btnMeatball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product meatball = new Food("Meatball",20.00,1,false);
				refreshTable();
				databaseManager.addProductToCheck(meatball, tableName);
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
				showList();
			}
		});
		btnMeatball.setBounds(57, 261, 139, 25);
		panelFood.add(btnMeatball);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				databaseManager.deleteCheck(tableName);
				refreshTable();
				lblPrice.setText("");
				lblPrice.setText("Price: " + Double.toString(databaseManager.getTotalPrice(tableName)) + " TL");
			}
		});
		btnPay.setBounds(560, 349, 117, 25);
		contentPane.add(btnPay);
	}
	
	public void showList() {
		
		ArrayList<Food> checkList = new ArrayList<Food>();
		
		checkList = databaseManager.getChecks(tableName);
		
		for(Food product : checkList) {
				
			Object[] willAdd = {product.getName(),product.getQuantity(),product.getPrice()};
				
			model.addRow(willAdd);
		}
	}
	
	public void refreshTable() {
		
		model.setRowCount(0);
	}
}
