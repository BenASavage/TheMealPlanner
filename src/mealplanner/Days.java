package mealplanner;

import java.util.ArrayList;

/**
 * Days is a enum containing the standard days of the week. Each Day is an ArrayList of meals,
 * set to an initial capacity of 3.
 */
public enum Days {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

    private ArrayList<Meal> meals;

    /**
     * The sum total of the Calories in each meal in the day's meals.
     */
    private int totalCalories;

    Days() {
        this.meals = new ArrayList<>();
        this.totalCalories = getTotalCalories();
    }

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

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public boolean addMeal(Meal m) {
        try {
            this.meals.add(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeMeal(Meal m) {
        try {
            this.meals.remove(m);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
