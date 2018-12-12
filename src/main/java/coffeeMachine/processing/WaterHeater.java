package coffeeMachine.processing;

import coffeeMachine.ingredients.basicIngredients.ColdWater;
import coffeeMachine.ingredients.simpleIngredients.HotWater;

public class WaterHeater implements Processor<ColdWater> {
	@Override
	public HotWater process(ColdWater ingredient) {
		return new HotWater(ingredient.getQuantity());
	}
}
