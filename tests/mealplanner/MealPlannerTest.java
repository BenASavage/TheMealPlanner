package mealplanner;

import org.junit.jupiter.api.Test;

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
}