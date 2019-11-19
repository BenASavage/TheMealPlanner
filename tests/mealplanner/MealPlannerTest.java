package mealplanner;

import org.junit.Assert;

class MealPlannerTest {

    MealPlanner tester = new MealPlanner("tester");

    @org.junit.jupiter.api.Test
    void addToCurrentPlans() {
        MealPlanner.MealPlan testPlan = new MealPlanner.MealPlan();
        tester.addToCurrentPlans(testPlan);
        Assert.assertEquals(tester.getCurrentPlans().get(0), testPlan);
    }

    @org.junit.jupiter.api.Test
    void removeFromCurrentPlans() {
        MealPlanner.MealPlan testPlan = new MealPlanner.MealPlan();
        tester.addToCurrentPlans(testPlan);
        tester.removeFromCurrentPlans(testPlan);
        Assert.assertEquals(0, tester.getCurrentPlans().size());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Assert.assertEquals("tester", tester.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        tester.setName("new name");
        Assert.assertEquals("new name", tester.getName());
    }
}