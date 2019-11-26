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
import java.awt.event.*;
import java.io.*;

public class MealPlannerGui {
    private MealPlanner planner = deserialize();
    private JFrame frame = new JFrame();
    private JPanel contentPane = new JPanel();
    private JPanel planlistpanel = new JPanel();
    private JLabel lblPlans = new JLabel();


    public static void main(String[] args) {
        MealPlannerGui runner = new MealPlannerGui();
        runner.MainMenu();
        runner.frame.setVisible(true);
    }

    /**
     * Saves the user's account including all their plans to their name + "planner.ser".
     * That file is deserialized every time the program is run, allowing the user to save progress.
     * This method is called every time the program is closed.
     */
    private void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data/" +
                planner.getName() + "planner.ser"))) {
            out.writeObject(planner);
        } catch (IOException e) {
            //Display message that says there was a problem saving the data
            JOptionPane.showMessageDialog(frame, "There was a problem saving your data");
        }
    }

    /**
     * Takes user input to deserialize a previous account, if no account matches the provided name it creates a new one
     * @return the previously saved account or a new one if none are found.
     */
    private MealPlanner deserialize() {
        String name = JOptionPane.showInputDialog(frame,"Welcome to The Meal Planner! Enter your name:");
        if (name == null || name.isEmpty() || name.isBlank()) {
            System.exit(0);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data/" + name + "planner.ser"))) {
            MealPlanner planner = (MealPlanner) in.readObject();
            JOptionPane.showMessageDialog(frame,"Welcome Back " + planner.getName() + "!");
            return planner;
        } catch (IOException | ClassNotFoundException e) {
            //This block will run the first time the user uses the program
            return new MealPlanner(name);
        }
    }

    private void MainMenu() {
        frame.setBounds(100, 100, 900, 600);
        frame.setTitle(planner.getName());
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

        JLabel lblTurkey = new JLabel();
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

    private void plansGUI() {
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

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
                displayCurrentPlans();
            }
        });

        JButton Deletebtn = new JButton("Delete a Plan");
        Deletebtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        btnpanel.add(Deletebtn);
        Deletebtn.addActionListener(e -> {
            String plan = JOptionPane.showInputDialog(frame,"Enter the name of the Plan you would like to remove");
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

            displayCurrentPlans();
        });

        displayCurrentPlans();
        contentPane.add(planlistpanel, BorderLayout.CENTER);
        planlistpanel.setLayout(new BoxLayout(planlistpanel,BoxLayout.Y_AXIS));

    }

    private void displayCurrentPlans() {
        if (planner.getCurrentPlans().isEmpty()) {
            lblPlans.setText("No Plans Available");
        }
        else {
            lblPlans.setText("Current Plans");
        }

        planlistpanel.removeAll();
        for (MealPlanner.MealPlan el : planner.getCurrentPlans()) {
            JButton planButton = new JButton(el.getPlanName() + " Calories: " + el.getTotalCalories());
            planButton.addActionListener(e -> {
                contentPane.removeAll();
                contentPane.revalidate();
                mealPlanGUI(el);
            });
            planButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            planlistpanel.add(planButton);
        }
        planlistpanel.revalidate();
        planlistpanel.repaint();
    }

    private void mealPlanGUI(MealPlanner.MealPlan plan) {
        JLabel lblCurrentPlan = new JLabel(plan.getPlanName());
        lblCurrentPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurrentPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
        contentPane.add(lblCurrentPlan, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2, 0, 0));

        for (Days el : plan.getWeekPlan()) {
            JPanel dayPanel = new JPanel();
            panel.add(dayPanel);
            dayPanel.setLayout(new BorderLayout(0, 0));

            JLabel lblDay = new JLabel(el.toString());
            lblDay.setFont(new Font("Javanese Text", Font.PLAIN, 17));
            dayPanel.add(lblDay, BorderLayout.NORTH);

            JPanel mealPanel = new JPanel();
            dayPanel.add(mealPanel, BorderLayout.SOUTH);
            mealPanel.setLayout(new BoxLayout(mealPanel, BoxLayout.Y_AXIS));

            JButton btnAddToThis = new JButton("Add to this day");
            btnAddToThis.setFont(new Font("Javanese Text", Font.PLAIN, 13));
            btnAddToThis.addActionListener(e -> {
                contentPane.removeAll();
                contentPane.revalidate();
                mealListGUI(plan, el);
            });
            mealPanel.add(btnAddToThis);
        }

        JPanel btnpanel = new JPanel();
        contentPane.add(btnpanel, BorderLayout.SOUTH);

        JLabel lblNewLabel = new JLabel("Plan Name:");
        lblNewLabel.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        btnpanel.add(lblNewLabel);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        btnpanel.add(textField);
        textField.setColumns(10);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String newName = textField.getText();
                    if (!newName.isEmpty() && !newName.isBlank()) {
                        plan.setPlanName(newName);
                        contentPane.removeAll();
                        contentPane.revalidate();
                        mealPlanGUI(plan);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JButton Viewbtn = new JButton("View Other Plans");
        Viewbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        Viewbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();
                plansGUI();
            }
        });
        btnpanel.add(Viewbtn);

        JButton Resetbtn = new JButton("Reset this Plan");
        Resetbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        btnpanel.add(Resetbtn);
    }

    private void mealListGUI(MealPlanner.MealPlan plan, Days thisDay) {
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        JButton Setbtn = new JButton("Set Plan");
        Setbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
        panel.add(Setbtn);

        JButton Resetbtn = new JButton("Reset");
        Resetbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
        panel.add(Resetbtn);
        Resetbtn.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.revalidate();
            mealListGUI(plan, thisDay);
        });

        JButton Cancelbtn = new JButton("Cancel");
        Cancelbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
        panel.add(Cancelbtn);
        Cancelbtn.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.revalidate();
            mealPlanGUI(plan);
        });

        JLabel lblNewPlan = new JLabel(thisDay.toString());
        lblNewPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
        contentPane.add(lblNewPlan, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scrollPane);

        for (int i = 0; i < 35; i+=7) {
            JPanel mealPanel = new JPanel();
            panel_1.add(mealPanel);
            mealPanel.setLayout(new BorderLayout(0, 0));

            JLabel lblType = new JLabel(Meal.BLD.values()[i/7].toString());
            lblType.setFont(new Font("Javanese Text", Font.PLAIN, 17));
            mealPanel.add(lblType, BorderLayout.NORTH);

            JPanel panel_2 = new JPanel();
            panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
            mealPanel.add(panel_2, BorderLayout.WEST);
            panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

            for (int j = 0; j < 7; j++) {
                JCheckBox checkBox_1 = new JCheckBox("");
                panel_2.add(checkBox_1);
            }
        }
    }

}