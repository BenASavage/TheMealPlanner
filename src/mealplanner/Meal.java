/*
    Assignment:  Meal Planner
	Program:     Meal
	Programmer:  Ben Savage
	Created:     11/15/2019
*/

package mealplanner;

import javax.swing.*;
import java.io.Serializable;

public class Meal implements Serializable, Comparable<Meal>{
    private static final long serialVersionUID = -5336803356165679535L;
    private String name;
    private ImageIcon picture;
    private int calories;
    private BLD foodType;

    public Meal(String name, ImageIcon picture, int calories, BLD foodType) {
        this.name = name;
        this.picture = picture;
        this.calories = calories;
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public int getCalories() {
        return calories;
    }

    public BLD getFoodType() {
        return foodType;
    }

    @Override
    public int compareTo(Meal o) {
        return this.foodType.compareTo(o.getFoodType());
    }


    /**
     * BLD, standing for Breakfast, Lunch and Dinner, is a flag that corresponds to the type of meal, relating primarily
     * to the time in which the meal is typically consumed. Used for sorting purposes.
     */
    public enum BLD {
        Breakfast, Lunch, Dinner, Dessert, Snack;
    }

}
