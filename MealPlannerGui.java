/*
    Assignment:  Meal Planner
	Program:     MealPlannerGui
	Programmer:  Ben Savage
	Created:     11/15/2019
*/

package mealplanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MealPlannerGui {
    //Temporary for proof of concept
    private static MealPlanner planner = deserialize("planner.ser");
    private static ArrayList<Meal> mealList = planner.getMealList();
    private static ArrayList<MealPlanner.MealPlan> currentPlans = planner.getCurrentPlans();


    public static void main(String[] args) {
        //Proof of concept, first meal in the first plan
        //currently null pointer
        Meal temp = currentPlans.get(0).getWeekPlan().get(0).getMeals().get(0);
    }

    private static void serialize(String filename) {
        try (ObjectInputStream out = new ObjectInputStream(new FileInputStream(filename))) {

        } catch (IOException e) {
            //Display message that says there was a problem saving the data
        }
    }

    /**
     * @param filename
     * @return the previously saved account or a new one if none are found.
     * TODO make this not bare bones. Create new MealPlanner if none are found. User input for the name. File
     * TODO name could be based on the user provided name for the MealPlanner. Opens possibility for multiple users.
     */
    private static MealPlanner deserialize(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (MealPlanner) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //Should display a message explaining to the user that no data was found
            //This block will run the first time the user uses the program
            return new MealPlanner("Temp");
        }
    }
}
