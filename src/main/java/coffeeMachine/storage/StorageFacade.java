package coffeeMachine.storage;

import coffeeMachine.ingredients.basicIngredients.CoffeeBeans;
import coffeeMachine.ingredients.basicIngredients.ColdMilk;
import coffeeMachine.ingredients.basicIngredients.ColdWater;
import lombok.AllArgsConstructor;
import coffeeMachine.storage.dispenserInterfaces.CoffeeBeanDispenser;
import coffeeMachine.storage.dispenserInterfaces.ColdMilkDispenser;
import coffeeMachine.storage.dispenserInterfaces.ColdWaterDispenser;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;
import coffeeMachine.storage.exceptions.NotEnoughMilkException;
import coffeeMachine.storage.exceptions.NotEnoughWaterException;

@AllArgsConstructor
public class StorageFacade implements CoffeeBeanDispenser, ColdWaterDispenser, ColdMilkDispenser {

	private MilkContainer milkContainer;
	private CoffeeBeansContainer coffeeBeansContainer;
	private WaterContainer waterContainer;


	@Override
	public CoffeeBeans getBeans(int quantity) throws NotEnoughBeansException {
		return coffeeBeansContainer.dispense(quantity);
	}

	@Override
	public void refillBeans() {
		coffeeBeansContainer.refill();
	}

	@Override
	public ColdWater getColdWater(int quantity) throws NotEnoughWaterException {
		return waterContainer.dispense(quantity);
	}

	@Override
	public void refillWater() {
		waterContainer.refill();
	}

	@Override
	public ColdMilk getColdMilk(int quantity) throws NotEnoughMilkException {
		return milkContainer.dispense(quantity);
	}

	@Override
	public void refillMilk() {
		milkContainer.refill();
	}
}
