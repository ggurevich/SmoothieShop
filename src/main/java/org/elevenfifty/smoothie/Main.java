package org.elevenfifty.smoothie;

import java.io.IOException;
import org.elevenfifty.smoothie.beans.Recipe;
import org.elevenfifty.smoothie.decoratored.beans.Smoothie;
import org.elevenfifty.smoothie.util.PrettyPrinter;

public class Main {

	public static void main(String[] args) throws IOException {
		Configuration config = Configuration.configure("recipes.csv", "ingredients.csv");

		// Recipe Example
		Recipe r = config.getRecipe("Best Smoothie");
		PrettyPrinter.print(r);

		// Decorator Pattern Example
		Smoothie s = new Smoothie(config.getIngredient("Orange"));
		s = new Smoothie(config.getIngredient("Banana"), s);
		PrettyPrinter.print(s);

		Browser browser = new Browser(config);
		browser.displayRecipes();
		PrettyPrinter.print(browser.readRecipe());

	}
}
