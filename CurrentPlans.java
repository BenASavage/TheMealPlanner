// Assignment Meal Planner
// Program CurrentPlans
// Author Fernando Araujo
// Created Nov 19, 2019


package mealplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class CurrentPlans extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentPlans frame = new CurrentPlans();
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
	public CurrentPlans() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 2500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCurrentPlan = new JLabel("Current Plan");
		lblCurrentPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
		contentPane.add(lblCurrentPlan, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_1.add(lblSunday, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis = new JButton("Add to this day");
		btnAddToThis.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_9.add(btnAddToThis);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_2.add(lblMonday, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis_1 = new JButton("Add to this day");
		btnAddToThis_1.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_8.add(btnAddToThis_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_3.add(lblTuesday, BorderLayout.NORTH);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis_2 = new JButton("Add to this day");
		btnAddToThis_2.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_10.add(btnAddToThis_2);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_4.add(lblWednesday, BorderLayout.NORTH);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis_3 = new JButton("Add to this day");
		btnAddToThis_3.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_11.add(btnAddToThis_3);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_5.add(lblThursday, BorderLayout.NORTH);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis_4 = new JButton("Add to this day");
		btnAddToThis_4.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_12.add(btnAddToThis_4);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_6.add(lblFriday, BorderLayout.NORTH);
		
		JPanel panel_13 = new JPanel();
		panel_6.add(panel_13, BorderLayout.SOUTH);
		panel_13.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis_5 = new JButton("Add to this day");
		btnAddToThis_5.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_13.add(btnAddToThis_5);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel_7.add(lblSaturday, BorderLayout.NORTH);
		
		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14, BorderLayout.SOUTH);
		panel_14.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAddToThis_6 = new JButton("Add to this day");
		btnAddToThis_6.setFont(new Font("Javanese Text", Font.PLAIN, 13));
		panel_14.add(btnAddToThis_6);
		
		JPanel btnpanel = new JPanel();
		contentPane.add(btnpanel, BorderLayout.SOUTH);
		
		JButton Viewbtn = new JButton("View Other Plans");
		Viewbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		btnpanel.add(Viewbtn);
		
		JButton Addtobtn = new JButton("Add to this Plan");
		Addtobtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		btnpanel.add(Addtobtn);
		
		JButton Resetbtn = new JButton("Reset this Plan");
		Resetbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		btnpanel.add(Resetbtn);
		
		// need to get scroll bar working
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				
			}
		});
		contentPane.add(scrollBar, BorderLayout.EAST);
	}

}
