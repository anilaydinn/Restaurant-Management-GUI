import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableSelection extends JFrame {

	private JPanel contentPane;
	private DatabaseManager databaseManager;

	/**
	 * Create the frame.
	 */
	public TableSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		databaseManager = DatabaseManager.getDatabaseManager();
		
		JLabel lblTableSelectionPage = new JLabel("Table Selection Page");
		lblTableSelectionPage.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTableSelectionPage.setBounds(234, 12, 220, 33);
		contentPane.add(lblTableSelectionPage);
		
		JButton btnTable1 = new JButton("Table-1");
		btnTable1.setBackground(Color.GREEN);
		btnTable1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table1 = new TablePage("Table-1");
				setVisible(false);
				table1.setVisible(true);
			}
		});
		btnTable1.setBounds(12, 59, 117, 71);
		contentPane.add(btnTable1);
		
		if(databaseManager.isFull("Table-1")) {
			btnTable1.setBackground(Color.RED);
		}
		
		JButton btnTable2 = new JButton("Table-2");
		btnTable2.setBackground(Color.GREEN);
		btnTable2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table2 = new TablePage("Table-2");
				setVisible(false);
				table2.setVisible(true);
			}
		});
		btnTable2.setBounds(12, 142, 117, 71);
		contentPane.add(btnTable2);
		
		if(databaseManager.isFull("Table-2")) {
			btnTable2.setBackground(Color.RED);
		}
		
		JButton btnTable3 = new JButton("Table-3");
		btnTable3.setBackground(Color.GREEN);
		btnTable3.setBounds(12, 225, 117, 71);
		btnTable3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table3 = new TablePage("Table-3");
				setVisible(false);
				table3.setVisible(true);
			}
		});
		contentPane.add(btnTable3);
		
		if(databaseManager.isFull("Table-3")) {
			btnTable3.setBackground(Color.RED);
		}
		
		JButton btnTable4 = new JButton("Table-4");
		btnTable4.setBackground(Color.GREEN);
		btnTable4.setBounds(12, 308, 117, 71);
		btnTable4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table4 = new TablePage("Table-4");
				setVisible(false);
				table4.setVisible(true);
			}
		});
		contentPane.add(btnTable4);
		
		if(databaseManager.isFull("Table-4")) {
			btnTable4.setBackground(Color.RED);
		}
		
		JButton btnTable5 = new JButton("Table-5");
		btnTable5.setBackground(Color.GREEN);
		btnTable5.setBounds(12, 391, 117, 71);
		btnTable5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table5 = new TablePage("Table-5");
				setVisible(false);
				table5.setVisible(true);
			}
		});
		contentPane.add(btnTable5);
		
		if(databaseManager.isFull("Table-5")) {
			btnTable5.setBackground(Color.RED);
		}
		
		JButton btnTable6 = new JButton("Table-6");
		btnTable6.setBackground(Color.GREEN);
		btnTable6.setBounds(295, 57, 117, 71);
		btnTable6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table6 = new TablePage("Table-6");
				setVisible(false);
				table6.setVisible(true);
			}
		});
		contentPane.add(btnTable6);
		
		if(databaseManager.isFull("Table-6")) {
			btnTable6.setBackground(Color.RED);
		}
		
		JButton btnTable7 = new JButton("Table-7");
		btnTable7.setBackground(Color.GREEN);
		btnTable7.setBounds(295, 142, 117, 71);
		btnTable7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table7 = new TablePage("Table-7");
				setVisible(false);
				table7.setVisible(true);
			}
		});
		contentPane.add(btnTable7);
		
		if(databaseManager.isFull("Table-7")) {
			btnTable7.setBackground(Color.RED);
		}
		
		JButton btnTable8 = new JButton("Table-8");
		btnTable8.setBackground(Color.GREEN);
		btnTable8.setBounds(295, 225, 117, 71);
		btnTable8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table8 = new TablePage("Table-8");
				setVisible(false);
				table8.setVisible(true);
			}
		});
		contentPane.add(btnTable8);
		
		if(databaseManager.isFull("Table-8")) {
			btnTable8.setBackground(Color.RED);
		}
		
		JButton btnTable9 = new JButton("Table-9");
		btnTable9.setBackground(Color.GREEN);
		btnTable9.setBounds(295, 308, 117, 71);
		btnTable9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table9 = new TablePage("Table-9");
				setVisible(false);
				table9.setVisible(true);
			}
		});
		contentPane.add(btnTable9);
		
		if(databaseManager.isFull("Table-9")) {
			btnTable9.setBackground(Color.GREEN);
		}
		
		JButton btnTable10 = new JButton("Table-10");
		btnTable10.setBackground(Color.GREEN);
		btnTable10.setBounds(295, 391, 117, 71);
		btnTable10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table10 = new TablePage("Table-10");
				setVisible(false);
				table10.setVisible(true);
			}
		});
		contentPane.add(btnTable10);
		
		if(databaseManager.isFull("Table-10")) {
			btnTable10.setBackground(Color.RED);
		}
		
		JButton btnTable11 = new JButton("Table-11");
		btnTable11.setBackground(Color.GREEN);
		btnTable11.setBounds(583, 59, 117, 71);
		btnTable11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table11 = new TablePage("Table-11");
				setVisible(false);
				table11.setVisible(true);
			}
		});
		contentPane.add(btnTable11);
		
		if(databaseManager.isFull("Table-11")) {
			btnTable11.setBackground(Color.RED);
		}
		
		JButton btnTable12 = new JButton("Table-12");
		btnTable12.setBackground(Color.GREEN);
		btnTable12.setBounds(583, 142, 117, 71);
		btnTable12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table12 = new TablePage("Table-12");
				setVisible(false);
				table12.setVisible(true);
			}
		});
		contentPane.add(btnTable12);
		
		if(databaseManager.isFull("Table-12")) {
			btnTable12.setBackground(Color.RED);
		}
		
		JButton btnTable13 = new JButton("Table-13");
		btnTable13.setBackground(Color.GREEN);
		btnTable13.setBounds(583, 225, 117, 71);
		btnTable13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table13 = new TablePage("Table-13");
				setVisible(false);
				table13.setVisible(true);
			}
		});
		contentPane.add(btnTable13);
		
		if(databaseManager.isFull("Table-13")) {
			btnTable13.setBackground(Color.RED);
		}
		
		JButton btnTable14 = new JButton("Table-14");
		btnTable14.setBackground(Color.GREEN);
		btnTable14.setBounds(583, 308, 117, 71);
		btnTable14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table14 = new TablePage("Table-14");
				setVisible(false);
				table14.setVisible(true);
			}
		});
		contentPane.add(btnTable14);
		
		if(databaseManager.isFull("Table-14")) {
			btnTable14.setBackground(Color.RED);
		}
		
		JButton btnTable15 = new JButton("Table-15");
		btnTable15.setBackground(Color.GREEN);
		btnTable15.setBounds(583, 391, 117, 71);
		btnTable15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TablePage table15 = new TablePage("Table-15");
				setVisible(false);
				table15.setVisible(true);
			}
		});
		contentPane.add(btnTable15);
		
		if(databaseManager.isFull("Table-15")) {
			btnTable15.setBackground(Color.RED);
		}
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage loginPage = new LoginPage();
				setVisible(false);
				loginPage.setVisible(true);
			}
		});
		btnExit.setBounds(583, 17, 117, 25);
		contentPane.add(btnExit);
	}

}
