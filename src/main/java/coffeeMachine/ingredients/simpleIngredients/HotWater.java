package coffeeMachine.ingredients.simpleIngredients;


import coffeeMachine.ingredients.IngredientProvider;
import coffeeMachine.storage.exceptions.NotEnoughWaterException;

public class HotWater extends SimpleIngredient {
	public HotWater(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughWaterException {
		return provider.dispense(this);
	}

}