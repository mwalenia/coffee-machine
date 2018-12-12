package ingredients.simpleIngredients;

import ingredients.IngredientProvider;
import storage.exceptions.NotEnoughBeansException;

public class GroundCoffee extends SimpleIngredient {

	public GroundCoffee(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughBeansException {
		return provider.dispense(this);
	}
}