package coffeeMachine.storage;


import coffeeMachine.ingredients.basicIngredients.CoffeeBeans;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;

public class CoffeeBeansContainer extends IngredientContainer<CoffeeBeans> {

	public CoffeeBeansContainer(int capacity) {
		super(capacity);
	}

	@Override
	public CoffeeBeans dispense(int quantity) throws NotEnoughBeansException {
		if (ingredientLevel < quantity) {
			throw new NotEnoughBeansException();
		} else {
			ingredientLevel -= quantity;
			return new CoffeeBeans(quantity);
		}
	}
}