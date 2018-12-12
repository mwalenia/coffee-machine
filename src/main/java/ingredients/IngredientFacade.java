package ingredients;

import ingredients.simpleIngredients.*;
import processing.Grinder;
import processing.MilkSteamer;
import processing.MilkWarmer;
import processing.WaterHeater;
import storage.StorageFacade;
import lombok.AllArgsConstructor;
import storage.exceptions.InsufficientIngredientException;
import storage.exceptions.NotEnoughBeansException;
import storage.exceptions.NotEnoughMilkException;
import storage.exceptions.NotEnoughWaterException;

@AllArgsConstructor
public class IngredientFacade extends IngredientProvider {
	private final StorageFacade storageFacade;
	private final Grinder grinder;
	private final MilkSteamer steamer;
	private final MilkWarmer warmer;
	private final WaterHeater waterHeater;

	public void refillWater() {
		storageFacade.refillWater();
	}

	public void refillMilk() {
		storageFacade.refillMilk();
	}

	public void refillBeans() {
		storageFacade.refillBeans();
	}

	@Override
	public SimpleIngredient dispense(HotWater hotWater) throws NotEnoughWaterException {
		return waterHeater.process(storageFacade.getColdWater(hotWater.getQuantity()));
	}

	@Override
	public SimpleIngredient dispense(GroundCoffee groundCoffee) throws NotEnoughBeansException {
		return grinder.process(storageFacade.getBeans(groundCoffee.getQuantity()));
	}

	@Override
	public SimpleIngredient dispense(HotMilk hotMilk) throws NotEnoughMilkException {
		return warmer.process(storageFacade.getColdMilk(hotMilk.getQuantity()));
	}

	@Override
	public SimpleIngredient dispense(SteamedMilk steamedMilk) throws NotEnoughMilkException {
		return steamer.process(storageFacade.getColdMilk(steamedMilk.getQuantity()));
	}

	@Override
	public SimpleIngredient dispense(EspressoBase espressoBase) throws InsufficientIngredientException {
		//TODO implement dispensing Espresso according to recipe once recipes are in
		return new EspressoBase(1);
	}
}