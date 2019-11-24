package mealplanner;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MealPlannerTest {

    private MealPlanner tester = new MealPlanner("tester");

    @Test
    void addToCurrentPlans() {
        MealPlanner.MealPlan testPlan = new MealPlanner.MealPlan();
        tester.addToCurrentPlans(testPlan);
        assertEquals(tester.getCurrentPlans().get(0), testPlan);
    }

    @Test
    void removeFromCurrentPlans() {
        MealPlanner.MealPlan testPlan = new MealPlanner.MealPlan();
        tester.addToCurrentPlans(testPlan);
        tester.removeFromCurrentPlans(testPlan);
        assertEquals(0, tester.getCurrentPlans().size());
    }

    @Test
    void createMealList() {
        //assertEquals();
    }

    @Test
    void accessMealLists() {
        tester.addToCurrentPlans(new MealPlanner.MealPlan());
        tester.getCurrentPlans().get(0).getWeekPlan().get(0).addMeal(
                new Meal("name",new ImageIcon(),255, Meal.BLD.Breakfast));
        assertEquals(255,tester.getCurrentPlans().get(0).getTotalCalories());
    }
}