package coffeeMachine.machine;

import coffeeMachine.drinks.RecipeRepository;
import coffeeMachine.ingredients.IngredientFacade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import coffeeMachine.processing.Grinder;
import coffeeMachine.processing.MilkSteamer;
import coffeeMachine.processing.MilkWarmer;
import coffeeMachine.processing.WaterHeater;
import coffeeMachine.storage.CoffeeBeansContainer;
import coffeeMachine.storage.MilkContainer;
import coffeeMachine.storage.StorageFacade;
import coffeeMachine.storage.WaterContainer;

@Wither
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeMachineBuilder {
	private static final int MILK_CAPACITY = 500;
	private static final int WATER_CAPACITY = 1000;
	private static final int COFFEE_CAPACITY = 1000;

	private MilkContainer milkContainer;
	private WaterContainer waterContainer;
	private CoffeeBeansContainer coffeeBeansContainer;
	private Grinder grinder;
	private MilkSteamer steamer;
	private MilkWarmer warmer;
	private WaterHeater waterHeater;
	private StorageFacade storageFacade;
	private RecipeRepository recipeRepository;
	private IngredientFacade ingredientFacade;

	public CoffeeMachineBuilder defaultComponents() {
		milkContainer = new MilkContainer(MILK_CAPACITY);
		waterContainer = new WaterContainer(WATER_CAPACITY);
		coffeeBeansContainer = new CoffeeBeansContainer(COFFEE_CAPACITY);
		grinder = new Grinder();
		steamer = new MilkSteamer();
		warmer = new MilkWarmer();
		waterHeater = new WaterHeater();

		storageFacade = new StorageFacade(milkContainer, coffeeBeansContainer, waterContainer);
		recipeRepository = new RecipeRepository();
		ingredientFacade = new IngredientFacade(storageFacade, grinder, steamer, warmer, waterHeater, recipeRepository);

		return this;
	}

	public CoffeeMachine build() {
		if (ingredientFacade == null) {
			return defaultComponents().build();
		} else {
			return new CoffeeMachine(ingredientFacade, recipeRepository, storageFacade);
		}
	}
}
