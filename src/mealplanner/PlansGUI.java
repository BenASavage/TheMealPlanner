// Assignment Meal Planner
// Program Plans
// Author Fernando Araujo
// Created Nov 18, 2019


package mealplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlansGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlansGUI frame = new PlansGUI();
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
	public PlansGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPlans = new JLabel("Plans");
		lblPlans.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlans.setFont(new Font("Javanese Text", Font.BOLD, 24));
		contentPane.add(lblPlans, BorderLayout.NORTH);
		
		JPanel btnpanel = new JPanel();
		contentPane.add(btnpanel, BorderLayout.SOUTH);
		
		JButton Returnbtn = new JButton("Return to Main Menu");
		Returnbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		Returnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnpanel.add(Returnbtn);
		
		JButton Addbtn = new JButton("Add a new Plan");
		Addbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		btnpanel.add(Addbtn);
		Addbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				planner.addToCurrentPlans(new MealPlanner.MealPlan());
			}
		});
		
		JButton Deletebtn = new JButton("Delete a Plan");
		Deletebtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		btnpanel.add(Deletebtn);
		
		JPanel planlistpanel = new JPanel();
		contentPane.add(planlistpanel, BorderLayout.CENTER);
		planlistpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNoCurrentPlans = new JLabel("No Current Plans Listed");
		lblNoCurrentPlans.setFont(new Font("Javanese Text", Font.BOLD | Font.ITALIC, 24));
		lblNoCurrentPlans.setHorizontalAlignment(SwingConstants.CENTER);
		planlistpanel.add(lblNoCurrentPlans, BorderLayout.NORTH);
	}

}
