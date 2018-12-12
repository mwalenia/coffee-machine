package coffeeMachine.storage;


import coffeeMachine.ingredients.basicIngredients.Ingredient;
import coffeeMachine.storage.exceptions.InsufficientIngredientException;

abstract class IngredientContainer<T extends Ingredient>  {
	private final int capacity;
	protected int ingredientLevel = 0;

	IngredientContainer(int capacity) {
		this.capacity = capacity;
	}

	void refill() {
		ingredientLevel = capacity;
	}

	abstract T dispense(int quantity) throws InsufficientIngredientException;
}
