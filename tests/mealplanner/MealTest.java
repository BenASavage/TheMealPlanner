package mealplanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void getRecipe() {
        Meal testMeal = new Meal("Berry Pie Oatmeal",new ImageIcon(
                "BLD/Breakfast/Berry Pie Oatmeal.jpg"),445, Meal.BLD.Breakfast);
        assertEquals("INGREDIENTS\n" +
                "1/2 cup rolled oats\n" +
                "1/2 cup milk or almond milk\n" +
                "1/2 cup water\n" +
                "1/2 teaspoon vanilla\n" +
                "Pinch of salt\n" +
                "1/2 cup blueberries, divided\n" +
                "1 teaspoon butter\n" +
                "1/2 teaspoon cinnamon\n" +
                "2 tablespoons vanilla Greek yogurt\n" +
                "2 teaspoons maple syrup\n" +
                "INSTRUCTIONS\n" +
                "In a medium microwave-safe bowl, add oats, milk, water, vanilla, and salt. Stir to combine.\n" +
                "Microwave for about 3 minutes, or until oats are cooked through.\n" +
                "When oats are cooked, add half the blueberries (1/4 cup), butter, and cinnamon. Stir to combine.\n" +
                "Top oatmeal with yogurt and remaining blueberries. Drizzle maple syrup on top.\n" +
                "For extra sweetness, you can add 1 tablespoon brown sugar or 2-4 tablespoons applesauce.\n",
                testMeal.getRecipe());
    }
}