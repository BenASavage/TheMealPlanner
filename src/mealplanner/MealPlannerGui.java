/*
    Assignment:  Meal Planner
	Program:     MealPlannerGui
	Programmer:  Ben Savage
	Created:     11/15/2019
*/

package mealplanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MealPlannerGui {
    private static MealPlanner planner = deserialize();
    private static ArrayList<Meal> mealList = planner.getMealList();

    public static void main(String[] args) {

    }

    private static void serialize(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("planner.ser"))) {
            out.writeObject(planner);
        } catch (IOException e) {
            //Display message that says there was a problem saving the data
        }
    }

    /**
     *
     * @return the previously saved account or a new one if none are found.
     * TODO make this not bare bones. Create new MealPlanner if none are found. User input for the name. File
     * TODO name could be based on the user provided name for the MealPlanner. Opens possibility for multiple users.
     */
    private static MealPlanner deserialize() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("planner.ser"))) {
            return (MealPlanner) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //Should display a message explaining to the user that no data was found
            //This block will run the first time the user uses the program
            return new MealPlanner("Temp");
        }
    }
}