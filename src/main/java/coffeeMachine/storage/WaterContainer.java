package coffeeMachine.storage;


import coffeeMachine.ingredients.basicIngredients.ColdWater;
import coffeeMachine.storage.exceptions.NotEnoughWaterException;

public class WaterContainer extends IngredientContainer<ColdWater>{

	public WaterContainer(int capacity) {
		super(capacity);
	}

	@Override
	public ColdWater dispense(int quantity) throws NotEnoughWaterException {
		if (quantity > ingredientLevel) {
			throw new NotEnoughWaterException();
		} else {
			return new ColdWater(quantity);
		}
	}
}