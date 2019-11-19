package mealplanner;

import java.util.ArrayList;

/**
 * Days is a enum containing the standard days of the week. Each Day is an ArrayList of meals,
 * set to an initial capacity of 3.
 */
public enum Days {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

    private ArrayList<Meal> meals;

    private int totalCalories;

    Days() {
        meals = new ArrayList<>();
    }

    public int getTotalCalories() {
        return totalCalories;
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

    public void addMeals(Meal m) {
        this.meals.add(m);
    }

    public void removeMeals(Meal m) {
        this.meals.remove(m);
    }
}
