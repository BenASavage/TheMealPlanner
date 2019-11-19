package mealplanner;

import org.junit.Assert;

import javax.swing.*;

class DaysTest {

    @org.junit.jupiter.api.Test
    void getTotalCalories() {
    }

    @org.junit.jupiter.api.Test
    void addMeal() {
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        Days.Monday.addMeal(m);
        Assert.assertEquals(m, Days.Monday.getMeals().get(0));
    }

    @org.junit.jupiter.api.Test
    void removeMeal() {
    }
}