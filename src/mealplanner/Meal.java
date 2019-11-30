/*
    Assignment:  Meal Planner
	Program:     Meal
	Programmer:  Ben Savage
	Created:     11/15/2019
*/

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
    private String name;
    private ImageIcon picture;
    private ImageIcon smallPicture;
    private int calories;
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

    public String getRecipe() {
        try (Scanner scan = new Scanner(new File("Data/Recipes/" + name + ".txt"))) {
            String recipe = "";
            while (scan.hasNextLine()) {
                recipe = recipe.concat(scan.nextLine() + "\n");
            }
            return recipe;
        } catch (FileNotFoundException e) {
            return "Recipe not found";
        }
    }

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
