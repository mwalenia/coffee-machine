package machine

import drinks.DrinkOption
import spock.lang.Specification
import storage.exceptions.InsufficientIngredientException

class CoffeeMachineTest extends Specification {
    def coffeeMachine

    def setup() {
        coffeeMachine = new CoffeeMachineBuilder().defaultComponents().build()
    }

    def 'It\'s impossible to make coffee with empty containers'() {
        when:
        coffeeMachine.makeDrink(DrinkOption.ESPRESSO)

        then:
        thrown(InsufficientIngredientException)
    }

    def 'After filling containers, it\'s possible to make a Latte'() {
        given:
        coffeeMachine.refillWater()
        coffeeMachine.refillMilk()
        coffeeMachine.refillCoffeeBeans()

        when:
        def drink = coffeeMachine.makeDrink(DrinkOption.LATTE)

        then:
        drink.ingredients.size() == 3
    }

    def 'Machine gives us a drink list'() {
        when:
        def list = coffeeMachine.getDrinkList()

        then:
        list.containsAll(Arrays.asList(DrinkOption.values()))
    }
}
