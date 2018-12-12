package ingredients.simpleIngredients;

import ingredients.IngredientProvider;
import storage.exceptions.NotEnoughMilkException;

public class SteamedMilk extends SimpleIngredient {

	public SteamedMilk(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughMilkException {
		return provider.dispense(this);
	}
}