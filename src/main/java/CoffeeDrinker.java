import coffeeMachine.drinks.Beverage;
import coffeeMachine.drinks.DrinkOption;
import coffeeMachine.machine.CoffeeMachine;
import coffeeMachine.machine.CoffeeMachineBuilder;
import coffeeMachine.storage.exceptions.NotEnoughBeansException;
import coffeeMachine.storage.exceptions.NotEnoughMilkException;
import coffeeMachine.storage.exceptions.NotEnoughWaterException;

public class CoffeeDrinker {
	public static void main(String[] args) {
		CoffeeMachine coffeeMachine = new CoffeeMachineBuilder().defaultComponents().build();

		Beverage latte = makeCoffee(coffeeMachine, DrinkOption.LATTE);
		latte.drink();
	}

	private static Beverage makeCoffee(CoffeeMachine coffeeMachine, DrinkOption choice) {
		try {
			return coffeeMachine.makeDrink(choice);
		} catch (NotEnoughMilkException milk) {
			coffeeMachine.refillMilk();
			makeCoffee(coffeeMachine, choice);
		} catch (NotEnoughWaterException water) {
			coffeeMachine.refillWater();
			makeCoffee(coffeeMachine, choice);
		} catch (NotEnoughBeansException beans) {
			coffeeMachine.refillCoffeeBeans();
			makeCoffee(coffeeMachine, choice);
		}
		return new Beverage();
	}
}
