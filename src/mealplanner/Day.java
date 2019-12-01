package mealplanner;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Day is an object coresponding the standard days of the week. Each Day is an ArrayList of meals, as well as a calorie count, and has
 * a name.
 */
public class Day implements Serializable {

    private static final long serialVersionUID = -4134671311526659428L;

    /**
     * A list of meals tied to the day.
     */
    private ArrayList<Meal> meals;

    /**
     * The sum total of the Calories in each meal in the day's meals.
     */
    private int totalCalories;

    /**
     * The name of the Day. Only values used in the project are the days of the week. Eg. Sunday - Saturday
     */
    private String name;

    /**
     * Constructor for Day. Initializes name to specified name. Meals is initialized to a default ArrayList.
     * totalCalories are calculated using the getTotalCalories method.
     * @param name String name of the day of the week.
     */
    Day(String name) {
        this.name = name;
        this.meals = new ArrayList<>();
        this.totalCalories = getTotalCalories();
    }

    /**
     * Calculates the total amount of Calories in a day by summing the calories of each meal in that day.
     * @return Calorie total of the Day
     */
    public int getTotalCalories() {
        int calCount = 0;
        for (Meal el : meals) {
            calCount += el.getCalories();
        }
        return calCount;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public String getName() {
        return name;
    }

    /**
     * Getter for meals. Sorts based on Meal Type.
     * @return Sorted Meal ArrayList
     */
    public ArrayList<Meal> getMeals() {
        meals.sort(Meal::compareTo);
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    /**
     * Adds a meal to the Day's meals ArrayList.
     * @param m meal to be added.
     * @return True if successfully added, false if there was a problem.
     */
    public boolean addMeal(Meal m) {
        try {
            this.meals.add(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Removes a meal from the Day's meals ArrayList .
     * @param m meal to be removed.
     * @return true if removed, false if there was a problem.
     */
    public boolean removeMeal(Meal m) {
        try {
            this.meals.remove(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
