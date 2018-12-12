package storage.dispenserInterfaces;

import ingredients.basicIngredients.CoffeeBeans;
import storage.exceptions.NotEnoughBeansException;

public interface CoffeeBeanDispenser {
	CoffeeBeans getBeans(int quantity) throws NotEnoughBeansException;

	void refillBeans();
}
