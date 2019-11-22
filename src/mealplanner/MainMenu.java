// Assignment Meal Planner
// Program THE_meal_planner
// Author Fernando Araujo
// Created Nov 18, 2019


package mealplanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbltheMealPlanner = new JLabel("\"THE\" Meal Planner");
		lbltheMealPlanner.setFont(new Font("Javanese Text", Font.BOLD, 25));
		lbltheMealPlanner.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbltheMealPlanner, BorderLayout.NORTH);
		
		JLabel lblTurkey = new JLabel("");
		lblTurkey.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurkey.setIcon(new ImageIcon(MainMenu.class.getResource("/images/Turkey.jpg")));
		frame.getContentPane().add(lblTurkey, BorderLayout.CENTER);
			
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		JButton btnViewPlans = new JButton("View Plans");
		//Button takes User to Plans
		btnViewPlans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame2 = new JFrame();
				frame2.setBounds(100, 100, 900, 600);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnViewPlans.setFont(new Font("Javanese Text", Font.BOLD, 20));
		panel.add(btnViewPlans);
	
		
		
		
	}

}
