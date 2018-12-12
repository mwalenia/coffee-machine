package storage.dispenserInterfaces;

import ingredients.basicIngredients.ColdWater;
import storage.exceptions.InsufficientIngredientException;

public interface ColdWaterDispenser {
	ColdWater getColdWater(int quantity) throws InsufficientIngredientException;

	void refillWater();
}
