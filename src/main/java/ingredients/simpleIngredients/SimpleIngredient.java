package ingredients.simpleIngredients;

import ingredients.IngredientProvider;
import ingredients.basicIngredients.Ingredient;
import storage.exceptions.InsufficientIngredientException;

public abstract class SimpleIngredient extends Ingredient {
	SimpleIngredient(int quantity) {
		super(quantity);
	}

	public abstract SimpleIngredient accept(IngredientProvider provider) throws InsufficientIngredientException;
}