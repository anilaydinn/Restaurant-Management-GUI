import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablePage extends JFrame {

	private JPanel contentPane;
	private String tableName;

	/**
	 * Create the frame.
	 */
	public TablePage(String tableName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.tableName = tableName;

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenuItem mntmFoods = new JMenuItem("Foods");
		mnOptions.add(mntmFoods);
		
		JMenuItem mntmDrinks = new JMenuItem("Drinks");
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
	}
}
