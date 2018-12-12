package coffeeMachine.ingredients.simpleIngredients;


import coffeeMachine.ingredients.IngredientProvider;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;

public class HotMilk extends SimpleIngredient {
	public HotMilk(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughBeansException {
		return provider.dispense(this);
	}
}