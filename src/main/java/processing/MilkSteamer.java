package processing;

import ingredients.basicIngredients.ColdMilk;
import ingredients.simpleIngredients.SteamedMilk;

public class MilkSteamer implements Processor<ColdMilk> {
	@Override
	public SteamedMilk process(ColdMilk ingredient) {
		return new SteamedMilk(ingredient.getQuantity());
	}
}
