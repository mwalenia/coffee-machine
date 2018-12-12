package coffeeMachine.processing;

import coffeeMachine.ingredients.basicIngredients.Ingredient;
import coffeeMachine.ingredients.simpleIngredients.SimpleIngredient;

interface Processor<T extends Ingredient> {
	 SimpleIngredient process(T ingredient);
}
