package processing;

import ingredients.basicIngredients.ColdMilk;
import ingredients.simpleIngredients.HotMilk;

public class MilkWarmer implements Processor<ColdMilk> {
	@Override
	public HotMilk process(ColdMilk ingredient) {
		return new HotMilk(ingredient.getQuantity());
	}
}
