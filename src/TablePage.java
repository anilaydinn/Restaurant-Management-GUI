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
	private Check check = new Check();
	private JTable orderTable;
	private File file;

	/**
	 * Create the frame.
	 */
	public TablePage(String tableName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.tableName = tableName;
		
		
		
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
				File file = new File(tableName + ".txt");
				Product water = new NonAlcoholDrink("Water", 2.00, 1, 500, false);
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(water.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
					
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {water.getName(),water.getPrice(),water.getQuantity()});
			}
		});
		btnWater.setBounds(57, 39, 139, 25);
		panelDrink.add(btnWater);
		
		JButton btnMineralWater = new JButton("Mineral Water");
		btnMineralWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product mineralWater = new NonAlcoholDrink("Mineral Water", 2.50, 1, 250, false);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(mineralWater.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {mineralWater.getName(),mineralWater.getPrice(),mineralWater.getQuantity()});
			}
		});
		btnMineralWater.setBounds(57, 76, 139, 25);
		panelDrink.add(btnMineralWater);
		
		JButton btnCoke = new JButton("Coke");
		btnCoke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product coke = new NonAlcoholDrink("Coke", 4.00, 1, 330, false);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(coke.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {coke.getName(),coke.getPrice(),coke.getQuantity()});
			}
		});
		btnCoke.setBounds(57, 113, 139, 25);
		panelDrink.add(btnCoke);
		
		JButton btnTea = new JButton("Tea");
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product tea = new NonAlcoholDrink("Tea", 3.00, 1, 100, true);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(tea.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {tea.getName(),tea.getPrice(),tea.getQuantity()});
			}
		});
		btnTea.setBounds(57, 150, 139, 25);
		panelDrink.add(btnTea);
		
		JButton btnBeer = new JButton("Beer");
		btnBeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product beer = new AlcoholDrink("Beer", 15.00, 1, 500, 5.00);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(beer.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {beer.getName(),beer.getPrice(),beer.getQuantity()});
				
			}
		});
		btnBeer.setBounds(57, 187, 139, 25);
		panelDrink.add(btnBeer);
		
		JButton btnWine = new JButton("Wine");
		btnWine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product wine = new AlcoholDrink("Wine", 60.00, 1, 750, 13.00);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(wine.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {wine.getName(),wine.getPrice(),wine.getQuantity()});
				
			}
		});
		btnWine.setBounds(57, 224, 139, 25);
		panelDrink.add(btnWine);
		
		JButton btnRaki = new JButton("Raki");
		btnRaki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product raki = new AlcoholDrink("Raki", 230.00, 1, 100, 40.00);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(raki.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {raki.getName(),raki.getPrice(),raki.getQuantity()});
				
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
				File file = new File(tableName + ".txt");
				Product chicken = new Food("Chicken", 12.00, 1, false, 250);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(chicken.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {chicken.getName(),chicken.getPrice(),chicken.getQuantity()});
				
			}
		});
		btnChicken.setBounds(57, 39, 139, 25);
		panelFood.add(btnChicken);
		
		JButton btnHamburger = new JButton("Hamburger");
		btnHamburger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product hamburger = new Food("Hamburger", 18.00, 1, false, 250);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(hamburger.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {hamburger.getName(),hamburger.getPrice(),hamburger.getQuantity()});
				
			}
		});
		btnHamburger.setBounds(57, 76, 139, 25);
		panelFood.add(btnHamburger);
		
		JButton btnSalad = new JButton("Salad");
		btnSalad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product salad = new Food("Salad", 5.00, 1, false, 100);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(salad.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {salad.getName(),salad.getPrice(),salad.getQuantity()});
				
			}
		});
		btnSalad.setBounds(57, 113, 139, 25);
		panelFood.add(btnSalad);
		
		JButton btnPasta = new JButton("Pasta");
		btnPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product pasta = new Food("Pasta", 10.00, 1, true, 100);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(pasta.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {pasta.getName(),pasta.getPrice(),pasta.getQuantity()});
				
			}
		});
		btnPasta.setBounds(57, 150, 139, 25);
		panelFood.add(btnPasta);
		
		JButton btnSteak = new JButton("Steak");
		btnSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product steak = new Food("Steak", 24.00, 1, false, 200);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(steak.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {steak.getName(),steak.getPrice(),steak.getQuantity()});
				
			}
		});
		btnSteak.setBounds(57, 187, 139, 25);
		panelFood.add(btnSteak);
		
		JButton btnFriedPotatoes = new JButton("Fried Potatoes");
		btnFriedPotatoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product friedPotatoes = new Food("Fried Potatoes", 8.00, 1, false, 100);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(friedPotatoes.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {friedPotatoes.getName(),friedPotatoes.getPrice(),friedPotatoes.getQuantity()});
				
			}
		});
		btnFriedPotatoes.setBounds(57, 224, 139, 25);
		panelFood.add(btnFriedPotatoes);
		
		JButton btnMeatball = new JButton("Meatball");
		btnMeatball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = new File(tableName + ".txt");
				Product meatball = new Food("Meatball", 25.00, 1, false, 200);
				
				try {
					FileWriter fileWriter = new FileWriter(file,true);
					fileWriter.write(meatball.toString()+"\n");
					fileWriter.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
				model.addRow(new Object[] {meatball.getName(),meatball.getPrice(),meatball.getQuantity()});
				
			}
		});
		btnMeatball.setBounds(57, 261, 139, 25);
		panelFood.add(btnMeatball);
		
		
	}
	
	public double getTotalPrice(ArrayList<Double> prices) {
		double totalprice = 0;
		for(double i : prices) {
			totalprice += i;
		}
		return totalprice;
	}
}
