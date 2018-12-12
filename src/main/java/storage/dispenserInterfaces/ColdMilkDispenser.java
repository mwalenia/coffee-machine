package storage.dispenserInterfaces;

import ingredients.basicIngredients.ColdMilk;
import storage.exceptions.NotEnoughMilkException;

public interface ColdMilkDispenser {
	ColdMilk getColdMilk(int quantity) throws NotEnoughMilkException;

	void refillMilk();
}
