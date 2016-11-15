package org.elevenfifty.smoothie;

import java.util.Scanner;
import static org.elevenfifty.smoothie.util.Inventory.hasSufficientInventory;
import org.elevenfifty.smoothie.beans.Recipe;

public class Browser {

	private final Configuration config;
	private final Scanner in = new Scanner(System.in);

	public Browser(Configuration config) {
		this.config = config;
	}

	public void displayRecipes() {
		System.out.println();
		System.out.println("Available Recipes:");
		for (int i = 0; i < config.listRecipes().size(); i++) {
			Recipe r = config.getRecipe(i);
			if (hasSufficientInventory(r)) {
				System.out.format("%d: %s $%,01.2f%n", i + 1, r.getName(), r.getCost());
			} else {
				System.out.format("%d: %s (insufficient inventory)%n", i + 1, r.getName());
			}

		}
	}

	public Recipe readRecipe() {
		System.out.println();
		System.out.print("Select a Smoothie Recipe: ");
		/* System.out.print("Select a Smoothie Recipe (q to quit): "); */
		return config.getRecipe(in.nextInt() - 1);
	}

}
