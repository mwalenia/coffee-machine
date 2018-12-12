package coffeeMachine.processing;

import coffeeMachine.ingredients.basicIngredients.ColdMilk;
import coffeeMachine.ingredients.simpleIngredients.SteamedMilk;

public class MilkSteamer implements Processor<ColdMilk> {
	@Override
	public SteamedMilk process(ColdMilk ingredient) {
		return new SteamedMilk(ingredient.getQuantity());
	}
}
