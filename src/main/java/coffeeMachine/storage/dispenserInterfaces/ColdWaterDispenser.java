package coffeeMachine.storage.dispenserInterfaces;

import coffeeMachine.ingredients.basicIngredients.ColdWater;
import coffeeMachine.storage.exceptions.InsufficientIngredientException;

public interface ColdWaterDispenser {
	ColdWater getColdWater(int quantity) throws InsufficientIngredientException;

	void refillWater();
}
