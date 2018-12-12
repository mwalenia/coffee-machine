package ingredients.simpleIngredients;


import ingredients.IngredientProvider;
import storage.exceptions.NotEnoughBeansException;

public class HotMilk extends SimpleIngredient {
	public HotMilk(int quantity) {
		super(quantity);
	}

	@Override
	public SimpleIngredient accept(IngredientProvider provider) throws NotEnoughBeansException {
		return provider.dispense(this);
	}
}