package ingredients;


import ingredients.simpleIngredients.*;
import storage.exceptions.InsufficientIngredientException;

public abstract class IngredientProvider {

	public abstract SimpleIngredient dispense(HotWater hotWater) throws InsufficientIngredientException;
	public abstract SimpleIngredient dispense(GroundCoffee groundCoffee) throws InsufficientIngredientException;
	public abstract SimpleIngredient dispense(HotMilk hotMilk) throws InsufficientIngredientException;
	public abstract SimpleIngredient dispense(SteamedMilk steamedMilk) throws InsufficientIngredientException;
	public abstract SimpleIngredient dispense(EspressoBase espressoBase) throws InsufficientIngredientException;
}
