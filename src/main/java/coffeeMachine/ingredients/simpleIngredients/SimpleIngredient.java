package coffeeMachine.ingredients.simpleIngredients;

import coffeeMachine.ingredients.IngredientProvider;
import coffeeMachine.ingredients.basicIngredients.Ingredient;
import coffeeMachine.storage.exceptions.InsufficientIngredientException;

public abstract class SimpleIngredient extends Ingredient {
	SimpleIngredient(int quantity) {
		super(quantity);
	}

	public abstract SimpleIngredient accept(IngredientProvider provider) throws InsufficientIngredientException;
}