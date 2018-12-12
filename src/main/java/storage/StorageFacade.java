package storage;

import ingredients.basicIngredients.CoffeeBeans;
import ingredients.basicIngredients.ColdMilk;
import ingredients.basicIngredients.ColdWater;
import lombok.AllArgsConstructor;
import storage.dispenserInterfaces.CoffeeBeanDispenser;
import storage.dispenserInterfaces.ColdMilkDispenser;
import storage.dispenserInterfaces.ColdWaterDispenser;
import storage.exceptions.NotEnoughBeansException;
import storage.exceptions.NotEnoughMilkException;
import storage.exceptions.NotEnoughWaterException;

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
