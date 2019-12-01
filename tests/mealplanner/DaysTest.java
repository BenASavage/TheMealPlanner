package mealplanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

class DayTest {

    @Test
    void getTotalCalories() {
        Day TestDay = new Day("Monday");
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        TestDay.addMeal(m);
        TestDay.addMeal(new Meal("test", new ImageIcon(), 150, Meal.BLD.Snack));
        Assert.assertEquals(270, TestDay.getTotalCalories());
    }

    @org.junit.jupiter.api.Test
    void addMeal() {
        Day TestDay = new Day("Monday");
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        TestDay.addMeal(m);
        Assert.assertEquals(m, TestDay.getMeals().get(0));
    }

    @org.junit.jupiter.api.Test
    void removeMeal() {
        Day TestDay = new Day("Monday");
        Meal m = new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch);
        TestDay.addMeal(m);
        TestDay.removeMeal(m);
        Assert.assertEquals(0, TestDay.getMeals().size());
    }
}