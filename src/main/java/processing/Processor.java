package processing;

import ingredients.basicIngredients.Ingredient;
import ingredients.simpleIngredients.SimpleIngredient;

interface Processor<T extends Ingredient> {
	 SimpleIngredient process(T ingredient);
}
