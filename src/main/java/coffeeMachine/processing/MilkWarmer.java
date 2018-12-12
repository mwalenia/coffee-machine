package coffeeMachine.processing;

import coffeeMachine.ingredients.basicIngredients.ColdMilk;
import coffeeMachine.ingredients.simpleIngredients.HotMilk;

public class MilkWarmer implements Processor<ColdMilk> {
	@Override
	public HotMilk process(ColdMilk ingredient) {
		return new HotMilk(ingredient.getQuantity());
	}
}
