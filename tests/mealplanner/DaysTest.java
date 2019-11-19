package mealplanner;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import javax.swing.*;

class DaysTest {

    @org.junit.jupiter.api.Test
    void getTotalCalories() {
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        Days.Monday.addMeal(m);
        Days.Monday.addMeal(new Meal("test", new ImageIcon(), 150, Meal.BLD.Snack));
        Assert.assertEquals(270, Days.Monday.getTotalCalories());
    }

    @org.junit.jupiter.api.Test
    void addMeal() {
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        Days.Monday.addMeal(m);
        Assert.assertEquals(m, Days.Monday.getMeals().get(0));
    }

    @org.junit.jupiter.api.Test
    void removeMeal() {
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        Days.Monday.addMeal(m);
        Days.Monday.removeMeal(m);
        Assert.assertEquals(0, Days.Monday.getMeals().size());
    }
}