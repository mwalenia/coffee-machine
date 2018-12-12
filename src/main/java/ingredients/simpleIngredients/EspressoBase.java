package ingredients.simpleIngredients;

import ingredients.IngredientProvider;
import storage.exceptions.NotEnoughBeansException;
import storage.exceptions.NotEnoughWaterException;

public class EspressoBase extends SimpleIngredient {
	public EspressoBase(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughBeansException, NotEnoughWaterException {
		return provider.dispense(this);
	}
}