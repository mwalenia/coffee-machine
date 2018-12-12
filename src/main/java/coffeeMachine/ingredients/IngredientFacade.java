package coffeeMachine.ingredients;

import coffeeMachine.drinks.DrinkOption;
import coffeeMachine.drinks.RecipeRepository;
import coffeeMachine.ingredients.simpleIngredients.*;
import coffeeMachine.processing.Grinder;
import coffeeMachine.processing.MilkSteamer;
import coffeeMachine.processing.MilkWarmer;
import coffeeMachine.processing.WaterHeater;
import coffeeMachine.storage.StorageFacade;
import lombok.AllArgsConstructor;
import coffeeMachine.storage.exceptions.InsufficientIngredientException;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;
import coffeeMachine.storage.exceptions.NotEnoughMilkException;
import coffeeMachine.storage.exceptions.NotEnoughWaterException;

@AllArgsConstructor
public class IngredientFacade extends IngredientProvider {
	private final StorageFacade storageFacade;
	private final Grinder grinder;
	private final MilkSteamer steamer;
	private final MilkWarmer warmer;
	private final WaterHeater waterHeater;
	private final RecipeRepository recipeRepository;

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
		recipeRepository.getDrinkRecipe(DrinkOption.ESPRESSO).getIngredients()
				.forEach(simpleIngredient -> simpleIngredient.accept(this));
		return new EspressoBase(1);
	}
}