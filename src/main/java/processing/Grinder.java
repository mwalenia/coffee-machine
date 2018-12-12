package processing;

import ingredients.basicIngredients.CoffeeBeans;
import ingredients.simpleIngredients.GroundCoffee;

public class Grinder implements Processor<CoffeeBeans> {

	@Override
	public GroundCoffee process(CoffeeBeans beans) {
		return new GroundCoffee(beans.getQuantity());
	}
}
