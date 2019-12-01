package mealplanner;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MealPlanTest {

    private MealPlan tester = new MealPlan("Week 1");

    @Test
    void getWeekPlan() {
        ArrayList<Days> testList = new ArrayList<>(Arrays.asList(Days.values()));
        assertEquals(testList, tester.getWeekPlan());
    }

    @Test
    void getWeekPlanTest2() {
        assertEquals(Days.Sunday, tester.getWeekPlan().get(0));
    }

    @Test
    void getTotalCalories() {
        tester.getWeekPlan().get(0).addMeal(new Meal("chicken", new ImageIcon(), 120, Meal.BLD.Lunch));
        tester.getWeekPlan().get(0).addMeal(new Meal("chips", new ImageIcon(), 60, Meal.BLD.Snack));
        tester.getWeekPlan().get(3).addMeal(new Meal("Nut Bar", new ImageIcon(), 20, Meal.BLD.Breakfast));
        assertEquals(200, tester.getTotalCalories());
    }

    @Test
    void getPlanName() {
        assertEquals("Week 1", tester.getPlanName());
    }
}