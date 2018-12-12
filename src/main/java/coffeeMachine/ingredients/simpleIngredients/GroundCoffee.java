package coffeeMachine.ingredients.simpleIngredients;

import coffeeMachine.ingredients.IngredientProvider;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;

public class GroundCoffee extends SimpleIngredient {

	public GroundCoffee(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughBeansException {
		return provider.dispense(this);
	}
}