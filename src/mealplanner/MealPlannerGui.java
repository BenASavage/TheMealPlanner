/*
    Assignment:  Meal Planner
	Program:     MealPlannerGui
	Programmer:  Ben Savage
	Created:     11/15/2019
*/

package mealplanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;

public class MealPlannerGui {
    private static MealPlanner planner = deserialize();
    private static ArrayList<Meal> mealList = planner.getMealList();
    private static JFrame frame = new JFrame();
    private static JPanel contentPane = new JPanel();


    public static void main(String[] args) {
        MainMenu();
        frame.setVisible(true);
    }

    /**
     * Saves the user's account including all their plans to "planner.ser". That file is deserialized every time the
     * program is run, allowing the user to save progress. This method is called every time the program is closed.
     */
    private static void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data/" +
                planner.getName() + "planner.ser"))) {
            out.writeObject(planner);
        } catch (IOException e) {
            //Display message that says there was a problem saving the data
            JOptionPane.showMessageDialog(frame, "There was a problem saving your data");
        }
    }

    /**
     *
     * @return the previously saved account or a new one if none are found.
     * TODO make this not bare bones. Create new MealPlanner if none are found. User input for the name. File
     * TODO name could be based on the user provided name for the MealPlanner. Opens possibility for multiple users.
     */
    private static MealPlanner deserialize() {
        String name = JOptionPane.showInputDialog(frame,"Welcome to The Meal Planner! Enter your name:");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data/" + name + "planner.ser"))) {
            MealPlanner planner = (MealPlanner) in.readObject();
            JOptionPane.showMessageDialog(frame,"Welcome Back " + planner.getName() + "!");
            return planner;
        } catch (IOException | ClassNotFoundException e) {
            //This block will run the first time the user uses the program
            return new MealPlanner(name);
        }
    }

    private static void MainMenu() {
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                serialize();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        JLabel lbltheMealPlanner = new JLabel("\"THE\" Meal Planner");
        lbltheMealPlanner.setFont(new Font("Javanese Text", Font.BOLD, 25));
        lbltheMealPlanner.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lbltheMealPlanner, BorderLayout.NORTH);

        JLabel lblTurkey = new JLabel("");
        lblTurkey.setHorizontalAlignment(SwingConstants.CENTER);
        lblTurkey.setIcon(new ImageIcon("images/Turkey.jpg"));
        frame.getContentPane().add(lblTurkey, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        JButton btnViewPlans = new JButton("View Plans");
        //Button takes User to Plans
        btnViewPlans.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().revalidate();
                frame.repaint();
                plansGUI();
            }
        });
        btnViewPlans.setFont(new Font("Javanese Text", Font.BOLD, 20));
        panel.add(btnViewPlans);
    }

    private static void plansGUI() {
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
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
                frame.getContentPane().removeAll();
                frame.getContentPane().revalidate();
                frame.repaint();
                MainMenu();
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
                //displayCurrentPlans();
            }
        });

        JButton Deletebtn = new JButton("Delete a Plan");
        Deletebtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        btnpanel.add(Deletebtn);
        Deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plan = JOptionPane.showInputDialog("Enter the name of the Plan you would like to remove");
                boolean inPlans = false;
                for (MealPlanner.MealPlan el : planner.getCurrentPlans()) {
                    if (el.getPlanName().equals(plan)) {
                        planner.removeFromCurrentPlans(el);
                        inPlans = true;
                        break;
                    }
                }
                if (!inPlans) {
                    JOptionPane.showMessageDialog(frame, plan + " plan could not be removed");
                }

                //displayCurrentPlans();
            }
        });

        JPanel planlistpanel = new JPanel();
        contentPane.add(planlistpanel, BorderLayout.CENTER);
        planlistpanel.setLayout(new BorderLayout(0, 0));

        JLabel lblNoCurrentPlans = new JLabel("No Current Plans Listed");
        lblNoCurrentPlans.setFont(new Font("Javanese Text", Font.BOLD | Font.ITALIC, 24));
        lblNoCurrentPlans.setHorizontalAlignment(SwingConstants.CENTER);
        planlistpanel.add(lblNoCurrentPlans, BorderLayout.NORTH);
    }

    private static void currentPlansGUI() {
        JLabel lblCurrentPlan = new JLabel("Current Plan");
        lblCurrentPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurrentPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
        contentPane.add(lblCurrentPlan, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2, 0, 0));

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
    }

    private static void MealList() {
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JLabel lblNewLabel = new JLabel("Plan Name:");
        lblNewLabel.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        panel.add(lblNewLabel);

        JTextField textField = new JTextField();
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