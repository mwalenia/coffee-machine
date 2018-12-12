package coffeeMachine.drinks;

import coffeeMachine.ingredients.simpleIngredients.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecipeRepository {
	private final static Map<DrinkOption, DrinkRecipe> drinkMap = new HashMap<>();

	static {
		drinkMap.put(DrinkOption.ESPRESSO, new DrinkRecipe(Arrays.asList(new GroundCoffee(10), new HotWater(40))));
		drinkMap.put(DrinkOption.LATTE, new DrinkRecipe(Arrays.asList(new SteamedMilk(20), new HotMilk(200), new EspressoBase(1))));
		drinkMap.put(DrinkOption.CAPPUCCINO, new DrinkRecipe(Arrays.asList(new EspressoBase(1), new HotMilk(75), new SteamedMilk(75))));
		drinkMap.put(DrinkOption.AMERICANO, new DrinkRecipe(Arrays.asList(new EspressoBase(1), new HotWater(200))));
		drinkMap.put(DrinkOption.FLAT_WHITE, new DrinkRecipe(Arrays.asList(new EspressoBase(1), new EspressoBase(1), new HotMilk(200))));
	}

	public DrinkRecipe getDrinkRecipe(DrinkOption drinkChoice) {
		return drinkMap.get(drinkChoice);
	}
}
