package coffeeMachine.processing;

import coffeeMachine.ingredients.basicIngredients.CoffeeBeans;
import coffeeMachine.ingredients.simpleIngredients.GroundCoffee;

public class Grinder implements Processor<CoffeeBeans> {

	@Override
	public GroundCoffee process(CoffeeBeans beans) {
		return new GroundCoffee(beans.getQuantity());
	}
}
