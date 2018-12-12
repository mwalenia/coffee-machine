package ingredients.simpleIngredients;


import ingredients.IngredientProvider;
import storage.exceptions.NotEnoughWaterException;

public class HotWater extends SimpleIngredient {
	public HotWater(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughWaterException {
		return provider.dispense(this);
	}

}