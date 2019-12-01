/*
    Assignment:  MealPlanner
	Program:     MealPlan
	Programmer:  Ben Savage
	Created:     11/30/2019
*/

package mealplanner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Meal Plan is defined by a list of Days, each Day being an ArrayList of meals. A Meal Plan has a name as well
 * as a Calorie count
 * @see Days
 * @see Meal
 */
public class MealPlan implements Serializable {
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

    /**
     * No-arg constructor for MealPlan. Name of the plan is set to Default Plan. Week Plan is initialized to the
     * values of the Days enum. Total Calories are calculated using the getTotalCalories Method.
     */
    public MealPlan() {
        this.planName = "Default Plan";
        this.weekPlan.addAll(Arrays.asList(Days.values()));
        this.totalCalories = getTotalCalories();

    }

    /**
     * Constructor for MealPlan. Name of the plan is set to the specified name. Week Plan is initialized to the
     * values of the Days enum. Total Calories are calculated using the getTotalCalories Method.
     */
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


