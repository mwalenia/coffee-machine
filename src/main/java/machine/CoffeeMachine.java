package machine;

import drinks.Beverage;
import drinks.DrinkOption;
import drinks.DrinkRecipe;
import drinks.RecipeRepository;
import ingredients.IngredientFacade;
import ingredients.simpleIngredients.SimpleIngredient;
import lombok.AllArgsConstructor;
import storage.StorageFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CoffeeMachine {
	private IngredientFacade ingredientFacade;
	private RecipeRepository recipeRepository;
	private StorageFacade storageFacade;

	public Beverage makeDrink(DrinkOption drinkOption) {
		Beverage result = new Beverage();
		DrinkRecipe recipe = recipeRepository.getDrinkRecipe(drinkOption);
		List<SimpleIngredient> drinkIngredients = recipe.getIngredients().stream()
				.map(ingredient -> ingredient.accept(ingredientFacade))
				.collect(Collectors.toList());

		result.getIngredients().addAll(drinkIngredients);
		return result;
	}

	public List<DrinkOption> getDrinkList() {
		return Arrays.asList(DrinkOption.values());
	}

	public void refillMilk() {
		storageFacade.refillMilk();
	}

	public void refillWater() {
		storageFacade.refillWater();
	}

	public void refillCoffeeBeans() {
		storageFacade.refillBeans();
	}
}
