package mealplanner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class Meal implements Serializable, Comparable<Meal>{
    private static final long serialVersionUID = -5336803356165679535L;

    /**
     * Name of the Meal.
     */
    private String name;

    /**
     * The image corresponding to the meal.
     */
    private ImageIcon picture;

    /**
     * A small version of the meal's picture.
     */
    private ImageIcon smallPicture;

    /**
     * The amount of calories in a meal.
     */
    private int calories;

    /**
     * The food type of the meal. Eg. Breakfast, Lunch, Dinner, ect.
     */
    private BLD foodType;

    public Meal(String name, ImageIcon picture, int calories, BLD foodType) {
        this.name = name;
        this.picture = new ImageIcon(getScaledImage(picture.getImage(),120,120));
        this.smallPicture = new ImageIcon(getScaledImage(picture.getImage(),60,60));
        this.calories = calories;
        this.foodType = foodType;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public ImageIcon getSmallPicture() {
        return smallPicture;
    }

    public int getCalories() {
        return calories;
    }

    public BLD getFoodType() {
        return foodType;
    }

    /**
     * Reads in, using the name of the meal, a recipe for the meal. For displaying purposes a new line character is
     * concatenated after each line read in from the txt file.
     * @return the Meal's recipe
     */
    public String getRecipe() {
        try (Scanner scan = new Scanner(this.getClass().getResourceAsStream("/Recipes/" + name + ".txt"))) {
            String recipe = "";
            while (scan.hasNextLine()) {
                recipe = recipe.concat(scan.nextLine() + "\n");
            }
            return recipe;
        } catch (Exception e) {
            return "Recipe not found";
        }
    }

    /**
     * Scales an Image to the desired height and width.
     * @param srcImg Image to be scaled
     * @param w width
     * @param h height
     * @return Scaled Image
     */
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    @Override
    public int compareTo(Meal o) {
        return this.foodType.compareTo(o.getFoodType());
    }


    /**
     * BLD, standing for Breakfast, Lunch and Dinner, is a flag that corresponds to the type of meal, relating primarily
     * to the time in which the meal is typically consumed. Used for sorting purposes.
     */
    public enum BLD {
        Breakfast, Lunch, Dinner, Dessert, Snack;
    }

}
