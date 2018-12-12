package storage;

import ingredients.basicIngredients.ColdMilk;
import storage.exceptions.NotEnoughMilkException;

public class MilkContainer extends IngredientContainer<ColdMilk>{

	public MilkContainer(int capacity) {
		super(capacity);
	}

	@Override
	public ColdMilk dispense(int quantity) throws NotEnoughMilkException {
		if (ingredientLevel < quantity) {
			throw new NotEnoughMilkException();
		} else {
			ingredientLevel -= quantity;
			return new ColdMilk(quantity);
		}
	}

}