package mealplanner;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MealPlanner handles the backend logic for MealPlannerGui. In abstract terms, a Meal Planner allows the user to create
 * a plan for what they are going to eat for each meal in a week and provides nutritional information correspondingly.
 */
class MealPlanner implements Serializable {

    private static final long serialVersionUID = -3343003503855596278L;

    /**
     * A fixed list of possible meals that the User can select from, sorted by the BLD category.
     * The list is read in from a file and parsed to create the meal objects.
     * @see Meal.BLD
     * @see Meal
     */
    private transient ArrayList<Meal> mealList;

    /**
     * An ArrayList of the Meal Plans that the user has created.
     * In "simple" terms this is a list of lists of lists of meals.
     * @see MealPlan
     */
    private ArrayList<MealPlan> currentPlans;

    /**
     * The user provided name of the account.
     */
    private String name;

    /**
     * Constructor for MealPlanner. mealList is created using the createMealList method. name is initialized to
     * specified name. currentPlans is initialized to a default ArrayList.
     * @param name name of the account
     */
    public MealPlanner(String name) {
        this.mealList = createMealList();
        this.name = name;
        this.currentPlans = new ArrayList<>();
    }

    /**
     * Reads in data from a file and parses it to create the all the Meals in mealList
     * @return the created Meal list
     * @see Meal
     * @see #mealList
     */
    public ArrayList<Meal> createMealList() {
        ArrayList<Meal> meals = new ArrayList<>(35);
        try (Scanner scan = new Scanner(this.getClass().getResourceAsStream("/MealList.csv"))) {
            while (scan.hasNextLine()) {
                try {
                    String nextLine = scan.nextLine();
                    String[] lineValues = nextLine.split(",");
                    meals.add(new Meal(lineValues[0], new ImageIcon(this.getClass().getResource("/BLD/" + lineValues[2] + "/"
                            + lineValues[0] + ((lineValues[2].equals("Dinner") || lineValues[2].equals("Snack")) ? ".jpeg" : ".jpg"))),
                            Integer.parseInt(lineValues[1]), Meal.BLD.valueOf(lineValues[2])));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("There was a problem creating the meal list");
                }
            }
        } catch (Exception e) {
            System.err.println("There was a problem creating the meal list");
        }
        meals.sort(Meal::compareTo);
        return meals;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Meal> meals) {
        this.mealList = meals;
    }

    public ArrayList<MealPlan> getCurrentPlans() {
        return currentPlans;
    }

    public void setCurrentPlans(ArrayList<MealPlan> currentPlans) {
        this.currentPlans = currentPlans;
    }

    /**
     * Adds to current plans
     * @param newPlan plan to be added
     * @return True or false based on the success of the method
     */
    public boolean addToCurrentPlans(MealPlan newPlan) {
        try {
            this.currentPlans.add(newPlan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Removes from current plans
     * @param plan plan to be added
     * @return True or false based on the success of the method
     */
    public boolean removeFromCurrentPlans(MealPlan plan) {
        try {
            this.currentPlans.remove(plan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
