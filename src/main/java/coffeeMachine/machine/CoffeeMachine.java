package coffeeMachine.machine;

import coffeeMachine.drinks.Beverage;
import coffeeMachine.drinks.DrinkOption;
import coffeeMachine.drinks.DrinkRecipe;
import coffeeMachine.drinks.RecipeRepository;
import coffeeMachine.ingredients.IngredientFacade;
import coffeeMachine.ingredients.simpleIngredients.SimpleIngredient;
import coffeeMachine.storage.exceptions.InsufficientIngredientException;
import lombok.AllArgsConstructor;
import coffeeMachine.storage.StorageFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CoffeeMachine {
	private IngredientFacade ingredientFacade;
	private RecipeRepository recipeRepository;
	private StorageFacade storageFacade;

	public Beverage makeDrink(DrinkOption drinkOption) throws InsufficientIngredientException {
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
