package coffeeMachine.storage.dispenserInterfaces;

import coffeeMachine.ingredients.basicIngredients.ColdMilk;
import coffeeMachine.storage.exceptions.NotEnoughMilkException;

public interface ColdMilkDispenser {
	ColdMilk getColdMilk(int quantity) throws NotEnoughMilkException;

	void refillMilk();
}
