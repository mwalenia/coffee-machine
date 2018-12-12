package coffeeMachine.storage.dispenserInterfaces;

import coffeeMachine.ingredients.basicIngredients.CoffeeBeans;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;

public interface CoffeeBeanDispenser {
	CoffeeBeans getBeans(int quantity) throws NotEnoughBeansException;

	void refillBeans();
}
