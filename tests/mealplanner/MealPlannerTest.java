package mealplanner;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MealPlannerTest {

    private MealPlanner tester = new MealPlanner("tester");

    @Test
    void addToCurrentPlans() {
        MealPlan testPlan = new MealPlan();
        tester.addToCurrentPlans(testPlan);
        assertEquals(tester.getCurrentPlans().get(0), testPlan);
    }

    @Test
    void removeFromCurrentPlans() {
        MealPlan testPlan = new MealPlan();
        tester.addToCurrentPlans(testPlan);
        tester.removeFromCurrentPlans(testPlan);
        assertEquals(0, tester.getCurrentPlans().size());
    }

    @Test
    void createMealList() {
        //assertEquals();
    }

    @Test
    void accessMealPlans() {
        tester.addToCurrentPlans(new MealPlan());
        tester.getCurrentPlans().get(0).getWeekPlan().get(3).addMeal(
                new Meal("name",new ImageIcon(),255, Meal.BLD.Breakfast));
        assertEquals(255,tester.getCurrentPlans().get(0).getTotalCalories());
    }

    @Test
    void accessMealPlans2() {
        tester.addToCurrentPlans(new MealPlan());
        tester.getCurrentPlans().get(0).getWeekPlan().get(0).addMeal(
                new Meal("name",new ImageIcon(),255, Meal.BLD.Breakfast));
        tester.addToCurrentPlans(new MealPlan());
        tester.getCurrentPlans().get(1).getWeekPlan().get(0).addMeal(
                new Meal("name",new ImageIcon(),255, Meal.BLD.Breakfast));
        assertEquals(255,tester.getCurrentPlans().get(0).getTotalCalories());
    }
}