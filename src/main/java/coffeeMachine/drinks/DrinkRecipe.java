package coffeeMachine.drinks;

import coffeeMachine.ingredients.simpleIngredients.SimpleIngredient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DrinkRecipe {
	private List<SimpleIngredient> ingredients;
}
