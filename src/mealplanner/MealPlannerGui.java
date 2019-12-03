package mealplanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MealPlannerGui {
    private MealPlanner planner;
    private JFrame frame = new JFrame();
    private JPanel contentPane = new JPanel();
    private JPanel planlistpanel = new JPanel();
    private JLabel lblPlans = new JLabel();


    public static void main(String[] args) {
        MealPlannerGui runner = new MealPlannerGui();
        runner.frame.setSize(900, 600);
        runner.frame.setLocationRelativeTo(null);
        runner.MainMenu();
        runner.frame.setVisible(true);
    }

    /**
     * Saves the user's account including all their plans to their name + "planner.ser".
     * That file is deserialized every time the program is run, allowing the user to save progress.
     * This method is called every time the program is closed.
     */
    private void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(planner.getName()
                + "planner.ser"))) {
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
    private MealPlanner deserialize(String name) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name + "planner.ser"))) {
            MealPlanner planner = (MealPlanner) in.readObject();
            JOptionPane.showMessageDialog(frame,"Welcome Back " + planner.getName() + "!");
            planner.setMealList(planner.createMealList());
            return planner;
        } catch (IOException | ClassNotFoundException e) {
            //This block will run the first time the user uses the program
            return new MealPlanner(name);
        }
    }

    /**
     * Displays the GUI for the main menu.
     */
    private void MainMenu() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbltheMealPlanner = new JLabel("\"THE\" Meal Planner");
        lbltheMealPlanner.setFont(new Font("Javanese Text", Font.BOLD, 25));
        lbltheMealPlanner.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lbltheMealPlanner, BorderLayout.NORTH);

        JLabel lblTurkey = new JLabel();
        lblTurkey.setHorizontalAlignment(SwingConstants.CENTER);
        lblTurkey.setIcon(new ImageIcon(this.getClass().getResource("/Turkey.jpg")));
        frame.getContentPane().add(lblTurkey, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(3,3));

        JLabel lblWelcome = new JLabel("Welcome to The Meal Planner! Enter your name:");
	lblWelcome.setFont(new Font("Javanese Text", Font.PLAIN, 13));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(new JLabel(""));
        panel.add(lblWelcome);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        JTextField userName = new JTextField(16);
	userName.setFont(new Font("Javanese Text", Font.PLAIN, 17));    
        userName.setHorizontalAlignment(SwingConstants.CENTER);
        userName.setAlignmentX(Component.CENTER_ALIGNMENT);

        userName.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String name = userName.getText();
                    if (!name.isEmpty() && !name.isBlank()) {
                        planner = deserialize(name);

                        panel.removeAll();
                        panel.revalidate();
                        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

                        JButton btnViewPlans = new JButton("View Plans");
                        btnViewPlans.setFocusPainted(false);
                        //Button takes User to Plans
                        btnViewPlans.addActionListener(l -> {
                            frame.getContentPane().removeAll();
                            frame.getContentPane().revalidate();
                            frame.repaint();
                            plansGUI();
                        });
                        btnViewPlans.setFont(new Font("Javanese Text", Font.BOLD, 20));
                        panel.add(btnViewPlans);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        panel.add(userName);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
    }

    /**
     * Displays the GUI for the plans view.
     */
    private void plansGUI() {
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

        frame.setTitle(planner.getName());
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
        Returnbtn.setFocusPainted(false);
        Returnbtn.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.revalidate();
            serialize();
            MainMenu();
        });
        btnpanel.add(Returnbtn);

        JButton Addbtn = new JButton("Add a new Plan");
        Addbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        Addbtn.setFocusPainted(false);
        btnpanel.add(Addbtn);
        Addbtn.addActionListener(e -> {
            planner.addToCurrentPlans(new MealPlan());
            displayCurrentPlans();
        });

        JButton Deletebtn = new JButton("Delete a Plan");
        Deletebtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        Deletebtn.setFocusPainted(false);
        btnpanel.add(Deletebtn);
        Deletebtn.addActionListener(e -> {
            String plan = JOptionPane.showInputDialog(frame,
                    "Enter the name of the Plan you would like to remove");
            boolean inPlans = false;

            if (plan == null || plan.isEmpty()) {
                inPlans = true;
            }
            if (!inPlans) {
                for (MealPlan el : planner.getCurrentPlans()) {
                    if (el.getPlanName().equals(plan)) {
                        planner.removeFromCurrentPlans(el);
                        inPlans = true;
                        break;
                    }
                }
            }

            if (!inPlans) {
                JOptionPane.showMessageDialog(frame, plan + " plan could not be removed");
            }
            displayCurrentPlans();
        });

        displayCurrentPlans();
        JScrollPane scrollPane = new JScrollPane(planlistpanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        planlistpanel.setLayout(new BoxLayout(planlistpanel,BoxLayout.Y_AXIS));

    }

    /**
     * Displays the current plans as buttons to the plansGUI.
     */
    private void displayCurrentPlans() {
        if (planner.getCurrentPlans().isEmpty()) {
            lblPlans.setText("No Plans Available");
        }
        else {
            lblPlans.setText("Current Plans");
        }

        planlistpanel.removeAll();
        for (MealPlan el : planner.getCurrentPlans()) {
            JButton planButton = new JButton(el.getPlanName() + " Calories: " + el.getTotalCalories());
            planButton.setFocusPainted(false);
            planButton.addActionListener(e -> {
                contentPane.removeAll();
                contentPane.revalidate();
                mealPlanGUI(el);
            });
            planButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	    planButton.setFont(new Font("Javanese Text", Font.PLAIN, 17));
            planButton.setMaximumSize(new Dimension(300, 50));
            planButton.setMinimumSize(new Dimension(300, 50));
            planButton.setPreferredSize(new Dimension(300, 50));
            planlistpanel.add(planButton, -1);
            planlistpanel.add(Box.createVerticalStrut(10));
        }
        planlistpanel.revalidate();
        planlistpanel.repaint();
    }

    /**
     * The GUI for viewing a plan
     * @param plan the plan being viewed
     */
    private void mealPlanGUI(MealPlan plan) {
        JLabel lblCurrentPlan = new JLabel(plan.getPlanName());
        lblCurrentPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurrentPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
        contentPane.add(lblCurrentPlan, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2, 0, 0));

        for (Day el : plan.getWeekPlan()) {
            JPanel dayPanel = new JPanel();
            panel.add(dayPanel);
            dayPanel.setLayout(new BorderLayout(0, 0));
	    dayPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
            dayPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel lblDay = new JLabel(el.getName());
            lblDay.setFont(new Font("Javanese Text", Font.PLAIN, 17));
            lblDay.setHorizontalAlignment(SwingConstants.CENTER);
            dayPanel.add(lblDay, BorderLayout.NORTH);

            JPanel mealPanel = new JPanel();
            dayPanel.add(mealPanel, BorderLayout.CENTER);
            mealPanel.setLayout(new BoxLayout(mealPanel, BoxLayout.Y_AXIS));
            mealPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            for (Meal meal : el.getMeals()) {
                JButton recipebtn = new JButton();
                recipebtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                recipebtn.setFocusPainted(false);
                recipebtn.setText(meal.getName() + " Calories: " + meal.getCalories() + " " + meal.getFoodType());
                recipebtn.setIcon(meal.getSmallPicture());
                recipebtn.setPreferredSize(new Dimension(100,100));
                recipebtn.addActionListener(e -> JOptionPane.showMessageDialog(frame, meal.getRecipe()));
                mealPanel.add(recipebtn);
                mealPanel.add(Box.createVerticalStrut(5));
            }

            JButton btnAddToThis = new JButton("Edit this day");
            btnAddToThis.setFont(new Font("Javanese Text", Font.PLAIN, 13));
            btnAddToThis.setAlignmentX(Component.CENTER_ALIGNMENT);
            btnAddToThis.setFocusPainted(false);
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
        Viewbtn.setFocusPainted(false);
        Viewbtn.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.revalidate();
            contentPane.repaint();
            plansGUI();
        });
        btnpanel.add(Viewbtn);

        JButton Resetbtn = new JButton("Reset this Plan");
        Resetbtn.setFont(new Font("Javanese Text", Font.PLAIN, 17));
        Resetbtn.setFocusPainted(false);
        btnpanel.add(Resetbtn);
    }

    /**
     * The GUI for editing a day
     * @param plan the plan the user is currently in
     * @param thisDay the day that is being edited
     */
    private void mealListGUI(MealPlan plan, Day thisDay) {
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        ArrayList<Meal> newSet = thisDay.getMeals();

        JButton Setbtn = new JButton("Set Plan");
        Setbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
        Setbtn.setFocusPainted(false);
        Setbtn.addActionListener(e -> {
            thisDay.setMeals(newSet);
            contentPane.removeAll();
            contentPane.revalidate();
            mealPlanGUI(plan);
        });
        panel.add(Setbtn);

        JButton Resetbtn = new JButton("Reset");
        Resetbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
        Resetbtn.setFocusPainted(false);
        panel.add(Resetbtn);
        Resetbtn.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.revalidate();
            mealListGUI(plan, thisDay);
        });

        JButton Cancelbtn = new JButton("Cancel");
        Cancelbtn.setFont(new Font("Javanese Text", Font.BOLD, 17));
        Cancelbtn.setFocusPainted(false);
        panel.add(Cancelbtn);
        Cancelbtn.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.revalidate();
            mealPlanGUI(plan);
        });

        JLabel lblNewPlan = new JLabel(thisDay.getName());
        lblNewPlan.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewPlan.setFont(new Font("Javanese Text", Font.BOLD, 24));
        contentPane.add(lblNewPlan, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        for (int i = 0; i < planner.getMealList().size(); i+=7) {
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
                JPanel displayPanel = new JPanel();
                JLabel lblcheck = new JLabel(planner.getMealList().get(i + j).getName());
                lblcheck.setIcon(planner.getMealList().get(i + j).getPicture());
                lblcheck.setHorizontalAlignment(SwingConstants.LEFT);
                lblcheck.setAlignmentX(Component.LEFT_ALIGNMENT);

                JCheckBox checkBox_1 = new JCheckBox();
                checkBox_1.setSelected(newSet.contains(planner.getMealList().get(i + j)));
                checkBox_1.setAlignmentX(Component.LEFT_ALIGNMENT);
                int finalJ = j;
                int finalI = i;
                checkBox_1.addItemListener(e -> {
                    if (e.getStateChange() == ItemEvent.DESELECTED) {
                        newSet.remove(planner.getMealList().get(finalI + finalJ));
                    }
                    else if (e.getStateChange() == ItemEvent.SELECTED) {
                        newSet.add(planner.getMealList().get(finalI + finalJ));
                    }
                });
                displayPanel.add(checkBox_1);
                displayPanel.add(lblcheck);
                displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
                panel_2.add(displayPanel);
                panel_2.add(Box.createVerticalStrut(25));
            }
        }
    }
}
