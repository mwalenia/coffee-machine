package processing;

import ingredients.basicIngredients.ColdWater;
import ingredients.simpleIngredients.HotWater;

public class WaterHeater implements Processor<ColdWater> {
	@Override
	public HotWater process(ColdWater ingredient) {
		return new HotWater(ingredient.getQuantity());
	}
}
