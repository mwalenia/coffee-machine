package coffeeMachine.drinks;

import coffeeMachine.ingredients.simpleIngredients.SimpleIngredient;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Beverage {
	private List<SimpleIngredient> ingredients = new ArrayList<>();

	public void drink() {
		System.out.println("Yum!");
	}
}
