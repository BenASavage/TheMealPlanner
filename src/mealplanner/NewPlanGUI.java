// Assignment Meal Planner
// Program NewPlan
// Author Fernando Araujo
// Created Nov 19, 2019


package mealplanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;

public class NewPlanGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPlanGUI frame = new NewPlanGUI();
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
	public NewPlanGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 2000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// need to get the scroll bar working
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
			}
			
		});
		contentPane.add(scrollBar, BorderLayout.EAST);
		scrollBar.setBackground(new Color(200, 200, 200));
		scrollBar.setBounds(new Rectangle(2000, 40, 0, 400));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Plan Name:");
		lblNewLabel.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		panel.add(textField);
		textField.setColumns(10);
		
		JButton Setbtn = new JButton("Set Plan");
		Setbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
		panel.add(Setbtn);
		
		JButton Resetbtn = new JButton("Reset");
		Resetbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
		panel.add(Resetbtn);
		
		JButton Cancelbtn = new JButton("Cancel");
		Cancelbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
		panel.add(Cancelbtn);
		
		JLabel lblNewPlan = new JLabel("New Plan");
		lblNewPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
		contentPane.add(lblNewPlan, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel Breakfastpanel = new JPanel();
		panel_1.add(Breakfastpanel);
		Breakfastpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		Breakfastpanel.add(lblBreakfast, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		Breakfastpanel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(7, 0, 0, 4));
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setIcon(null);
		panel_2.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		panel_2.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		panel_2.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		panel_2.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		panel_2.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		panel_2.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		panel_2.add(checkBox_6);
		
		JPanel Lunchpanel = new JPanel();
		panel_1.add(Lunchpanel);
		Lunchpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLunch = new JLabel("Lunch");
		lblLunch.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		
		Lunchpanel.add(lblLunch, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		Lunchpanel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(7, 1, 0, 4));
		
		JCheckBox checkBox_7 = new JCheckBox("");
		panel_3.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("");
		panel_3.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("");
		panel_3.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("");
		panel_3.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("");
		panel_3.add(checkBox_11);
		
		JCheckBox checkBox_12 = new JCheckBox("");
		panel_3.add(checkBox_12);
		
		JCheckBox checkBox_13 = new JCheckBox("");
		panel_3.add(checkBox_13);
		
		JPanel Dinnerpanel = new JPanel();
		panel_1.add(Dinnerpanel);
		Dinnerpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDinner = new JLabel("Dinner");
		lblDinner.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		Dinnerpanel.add(lblDinner, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dinnerpanel.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new GridLayout(7, 0, 0, 4));
		
		JCheckBox checkBox_14 = new JCheckBox("");
		panel_4.add(checkBox_14);
		
		JCheckBox checkBox_15 = new JCheckBox("");
		panel_4.add(checkBox_15);
		
		JCheckBox checkBox_16 = new JCheckBox("");
		panel_4.add(checkBox_16);
		
		JCheckBox checkBox_17 = new JCheckBox("");
		panel_4.add(checkBox_17);
		
		JCheckBox checkBox_18 = new JCheckBox("");
		panel_4.add(checkBox_18);
		
		JCheckBox checkBox_19 = new JCheckBox("");
		panel_4.add(checkBox_19);
		
		JCheckBox checkBox_20 = new JCheckBox("");
		panel_4.add(checkBox_20);
		
		JPanel Dessertpanel = new JPanel();
		panel_1.add(Dessertpanel);
		Dessertpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		Dessertpanel.add(lblDessert, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(5, 5, 5, 5));
		Dessertpanel.add(panel_5, BorderLayout.WEST);
		panel_5.setLayout(new GridLayout(7, 0, 0, 4));
		
		JCheckBox checkBox_21 = new JCheckBox("");
		panel_5.add(checkBox_21);
		
		JCheckBox checkBox_22 = new JCheckBox("");
		panel_5.add(checkBox_22);
		
		JCheckBox checkBox_23 = new JCheckBox("");
		panel_5.add(checkBox_23);
		
		JCheckBox checkBox_24 = new JCheckBox("");
		panel_5.add(checkBox_24);
		
		JCheckBox checkBox_26 = new JCheckBox("");
		panel_5.add(checkBox_26);
		
		JCheckBox checkBox_27 = new JCheckBox("");
		panel_5.add(checkBox_27);
		
		JCheckBox checkBox_25 = new JCheckBox("");
		panel_5.add(checkBox_25);
		
		JPanel Snackpanel = new JPanel();
		panel_1.add(Snackpanel);
		Snackpanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSnack = new JLabel("Snack");
		lblSnack.setFont(new Font("Javanese Text", Font.PLAIN, 17));
		Snackpanel.add(lblSnack, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(5, 5, 5, 5));
		Snackpanel.add(panel_6, BorderLayout.WEST);
		panel_6.setLayout(new GridLayout(7, 0, 0, 4));
		
		JCheckBox checkBox_28 = new JCheckBox("");
		panel_6.add(checkBox_28);
		
		JCheckBox checkBox_29 = new JCheckBox("");
		panel_6.add(checkBox_29);
		
		JCheckBox checkBox_30 = new JCheckBox("");
		panel_6.add(checkBox_30);
		
		JCheckBox checkBox_31 = new JCheckBox("");
		panel_6.add(checkBox_31);
		
		JCheckBox checkBox_32 = new JCheckBox("");
		panel_6.add(checkBox_32);
		
		JCheckBox checkBox_33 = new JCheckBox("");
		panel_6.add(checkBox_33);
		
		JCheckBox checkBox_34 = new JCheckBox("");
		panel_6.add(checkBox_34);
	}

}
