/*
    Assignment:  Meal Planner
	Program:     MealPlannerApp
	Programmer:  Ben Savage
	Created:     11/15/2019
*/

package mealplanner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * MealPlanner handles the backend logic for MealPlannerGui. In abstract terms, a Meal Planner allows the user to create
 * a plan for what they are going to eat for each meal in a week and provides nutritional information correspondingly.
 */
class MealPlanner implements Serializable {

    private static final long serialVersionUID = -3343003503855596278L;

    /**
     * A fixed list of possible meals that the User can select from, sorted by the BLD category.
     * The list is read in from a file and parsed to create the meal objects.
     * @see Meal.BLD
     * @see Meal
     */
    private final ArrayList<Meal> mealList;

    /**
     * An ArrayList of the Meal Plans that the user has created.
     * In "simple" terms this is a list of lists of lists of meals.
     * @see MealPlan
     */
    private ArrayList<MealPlan> currentPlans;

    /**
     * The user provided name of the account.
     */
    private String name;

    public MealPlanner(String name) {
        this.mealList = createMealList();
        this.name = name;
        this.currentPlans = new ArrayList<>();
    }

    /**
     * Reads in data from a file and parses it to create the all the Meals in mealList
     * @return the created Meal list
     * @see Meal
     * @see #mealList
     * TODO read the data in from a file and add it to meals
     */
    private ArrayList<Meal> createMealList() {
        ArrayList<Meal> meals = new ArrayList<>(35);
        return meals;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public ArrayList<MealPlan> getCurrentPlans() {
        return currentPlans;
    }

    public void setCurrentPlans(ArrayList<MealPlan> currentPlans) {
        this.currentPlans = currentPlans;
    }

    public boolean addToCurrentPlans(MealPlan newPlan) {
        try {
            this.currentPlans.add(newPlan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeFromCurrentPlans(MealPlan plan) {
        try {
            this.currentPlans.remove(plan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * A Meal Plan is defined by a list of Days, each Day being an ArrayList of meals. A Meal Plan has a name as well
     * as a Calorie count
     * @see Days
     * @see Meal
     */
    public static class MealPlan implements Serializable {
        private static final long serialVersionUID = 3704996779778809043L;

        /**
         * An ArrayList of Days with a initial capacity of 7. A week plan, in relation to a meal plan, is used as the
         * container for the days in the meal plan, each day also being a list of meals.
         * The capacity of a week plan should remain at 7 but isn't declared final because of the changing contents.
         * An ArrayList is used instead of a linked list because it contains mutable objects. Also used instead of
         * Days.values() to match its containers and contents, both being ArrayLists, though week plan is initialized to
         * the values of Days.values() in the constructor.
         * @see Days
         * @see MealPlan
         */
        private ArrayList<Days> weekPlan = new ArrayList<>(7);


        /**
         * The total amount of Calories in a meal plan, that being the sum of each day's total Calories,
         * a day's calories being the sum of each meal in that day.
         * @see Days#getTotalCalories()
         * @see Meal#getCalories()
         */
        private int totalCalories;

        /**
         * The user specified name of the meal plan. Examples like "low calorie" or "Chicken" or "Week 1".
         * Defaults to "Default" when not specified.
         */
        private String planName;

        public MealPlan() {
            this.planName = "Default Plan";
            this.weekPlan.addAll(Arrays.asList(Days.values()));
            this.totalCalories = getTotalCalories();

        }

        public MealPlan(String planName) {
            this.planName = planName;
            this.weekPlan.addAll(Arrays.asList(Days.values()));
            this.totalCalories = getTotalCalories();
        }

        public ArrayList<Days> getWeekPlan() {
            return weekPlan;
        }

        /**
         * Calculates the amount of Calories in a plan by adding the total calories of each day in the plan.
         * @return the summed total of Calories
         * @see Days#getTotalCalories()
         */
        public int getTotalCalories() {
            int calCount = 0;
            for (Days el :
                    weekPlan) {
                calCount += el.getTotalCalories();
            }
            return calCount;
        }

        public String getPlanName() {
            return planName;
        }

        public void setTotalCalories(int totalCalories) {
            this.totalCalories = totalCalories;
        }

        public void setPlanName(String planName) {
            this.planName = planName;
        }
    }

}
