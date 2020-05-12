import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TableSelection extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblTableSelectionPage = new JLabel("Table Selection Page");
		lblTableSelectionPage.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTableSelectionPage.setBounds(234, 12, 220, 33);
		contentPane.add(lblTableSelectionPage);
		
		JButton btnTable1 = new JButton("Table-1");
		btnTable1.setBounds(12, 59, 117, 71);
		contentPane.add(btnTable1);
		
		JButton btnTable2 = new JButton("Table-2");
		btnTable2.setBounds(12, 142, 117, 71);
		contentPane.add(btnTable2);
		
		JButton btnTable3 = new JButton("Table-3");
		btnTable3.setBounds(12, 225, 117, 71);
		contentPane.add(btnTable3);
		
		JButton btnTable4 = new JButton("Table-4");
		btnTable4.setBounds(12, 308, 117, 71);
		contentPane.add(btnTable4);
		
		JButton btnTable5 = new JButton("Table-5");
		btnTable5.setBounds(12, 391, 117, 71);
		contentPane.add(btnTable5);
		
		JButton btnTable6 = new JButton("Table-6");
		btnTable6.setBounds(295, 57, 117, 71);
		contentPane.add(btnTable6);
		
		JButton btnTable7 = new JButton("Table-7");
		btnTable7.setBounds(295, 142, 117, 71);
		contentPane.add(btnTable7);
		
		JButton btnTable8 = new JButton("Table-8");
		btnTable8.setBounds(295, 225, 117, 71);
		contentPane.add(btnTable8);
		
		JButton btnTable9 = new JButton("Table-9");
		btnTable9.setBounds(295, 308, 117, 71);
		contentPane.add(btnTable9);
		
		JButton btnTable10 = new JButton("Table-10");
		btnTable10.setBounds(295, 391, 117, 71);
		contentPane.add(btnTable10);
		
		JButton btnTable11 = new JButton("Table-11");
		btnTable11.setBounds(583, 59, 117, 71);
		contentPane.add(btnTable11);
		
		JButton btnTable12 = new JButton("Table-12");
		btnTable12.setBounds(583, 142, 117, 71);
		contentPane.add(btnTable12);
		
		JButton btnTable13 = new JButton("Table-13");
		btnTable13.setBounds(583, 225, 117, 71);
		contentPane.add(btnTable13);
		
		JButton btnTable14 = new JButton("Table-14");
		btnTable14.setBounds(583, 308, 117, 71);
		contentPane.add(btnTable14);
		
		JButton btnTable15 = new JButton("Table-15");
		btnTable15.setBounds(583, 391, 117, 71);
		contentPane.add(btnTable15);
	}

}
