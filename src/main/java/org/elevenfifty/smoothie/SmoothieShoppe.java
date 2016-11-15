package org.elevenfifty.smoothie;

import static org.elevenfifty.smoothie.util.Inventory.hasSufficientInventory;
import java.io.IOException;
import java.util.InputMismatchException;

import org.elevenfifty.smoothie.beans.Recipe;
import org.elevenfifty.smoothie.util.PrettyPrinter;

public class SmoothieShoppe {

	public static void main(String[] args) throws IOException {
		Configuration config = Configuration.configure("recipes.csv", "ingredients.csv");

		// Recipe Example
		/*Recipe r = config.getRecipe("Best Smoothie");
		PrettyPrinter.print(r);*/
		

		// Decorator Pattern Example
		/*Smoothie s = new Smoothie(config.getIngredient("Orange"));
		s = new Smoothie(config.getIngredient("Banana"), s);
		PrettyPrinter.print(s);*/
		
		

		Browser browser = new Browser(config);
		/*browser.displayRecipes();*/
		/*Recipe selectedRecipe = browser.readRecipe();*/
		/*selectedRecipe.consumeIngredients();
		PrettyPrinter.print(selectedRecipe);*/
		try {
			while (true) {
				browser.displayRecipes();
				Recipe selectedRecipe = browser.readRecipe();


				if (hasSufficientInventory(selectedRecipe)) {
					selectedRecipe.consumeIngredients();
					PrettyPrinter.print(selectedRecipe);
				} else {
					System.out.println("Insufficient Inventory");
				}
			}
		} catch (InputMismatchException e) {
			// Non-integer entered
		}

	}
}
