package coffeeMachine.ingredients.simpleIngredients;

import coffeeMachine.ingredients.IngredientProvider;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;
import coffeeMachine.storage.exceptions.NotEnoughWaterException;

public class EspressoBase extends SimpleIngredient {
	public EspressoBase(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughBeansException, NotEnoughWaterException {
		return provider.dispense(this);
	}
}