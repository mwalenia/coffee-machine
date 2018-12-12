package coffeeMachine.ingredients

import coffeeMachine.drinks.RecipeRepository
import coffeeMachine.ingredients.simpleIngredients.GroundCoffee
import coffeeMachine.ingredients.simpleIngredients.HotMilk
import coffeeMachine.ingredients.simpleIngredients.HotWater
import coffeeMachine.ingredients.simpleIngredients.SteamedMilk
import coffeeMachine.processing.Grinder
import coffeeMachine.processing.MilkSteamer
import coffeeMachine.processing.MilkWarmer
import coffeeMachine.processing.WaterHeater
import spock.lang.Specification
import spock.lang.Unroll
import coffeeMachine.storage.CoffeeBeansContainer
import coffeeMachine.storage.MilkContainer
import coffeeMachine.storage.StorageFacade
import coffeeMachine.storage.WaterContainer
import coffeeMachine.storage.exceptions.NotEnoughBeansException
import coffeeMachine.storage.exceptions.NotEnoughMilkException
import coffeeMachine.storage.exceptions.NotEnoughWaterException

class IngredientFacadeTest extends Specification {
    def final static MILK_CAPACITY = 500
    def final static WATER_CAPACITY = 1000
    def final static COFFEE_CAPACITY = 1000
    def final static MEDIUM_QUANTITY = 100
    def final static SMALL_QUANTITY = 10

    IngredientFacade ingredientFacade

    def setup() {
        def milkContainer = new MilkContainer(MILK_CAPACITY)
        def waterContainer = new WaterContainer(WATER_CAPACITY)
        def coffeeBeansContainer = new CoffeeBeansContainer(COFFEE_CAPACITY)
        def grinder = new Grinder()
        def steamer = new MilkSteamer()
        def warmer = new MilkWarmer()
        def waterHeater = new WaterHeater()
        def storageFacade = new StorageFacade(milkContainer, coffeeBeansContainer, waterContainer)
        def recipeRepository = new RecipeRepository()
        ingredientFacade = new IngredientFacade(storageFacade, grinder, steamer, warmer, waterHeater, recipeRepository)
    }

    @Unroll
    def 'Can\'t get #desc if containers are empty'() {
        when:
        ingredient.accept(ingredientFacade)

        then:
        thrown(expectedException)

        where:
        desc     | ingredient                       | expectedException
        'milk'   | new HotMilk(MEDIUM_QUANTITY)     | NotEnoughMilkException
        'coffee' | new GroundCoffee(SMALL_QUANTITY) | NotEnoughBeansException
        'water'  | new HotWater(MEDIUM_QUANTITY)    | NotEnoughWaterException
    }

    def 'After refilling water container, water can be drawn'() {
        given:
        ingredientFacade.refillWater()
        def ingredient = new HotWater(MEDIUM_QUANTITY)

        when:
        def water = ingredient.accept(ingredientFacade)

        then:
        water.getQuantity() == MEDIUM_QUANTITY
    }

    def 'After refilling coffee container, coffee can be drawn'() {
        given:
        ingredientFacade.refillBeans()
        def ingredient = new GroundCoffee(SMALL_QUANTITY)

        when:
        def coffee = ingredient.accept(ingredientFacade)

        then:
        coffee.getQuantity() == SMALL_QUANTITY
    }

    def 'After refilling milk container, milk can be drawn'() {
        given:
        ingredientFacade.refillMilk()
        def ingredient = new SteamedMilk(MEDIUM_QUANTITY)

        when:
        def milk = ingredient.accept(ingredientFacade)

        then:
        milk.getQuantity() == MEDIUM_QUANTITY
    }

    def 'Full containers dispense all ingredients in a list'() {
        given:
        ingredientFacade.refillMilk()
        ingredientFacade.refillBeans()
        ingredientFacade.refillWater()
        def ingredientList = Arrays.asList(new HotMilk(MEDIUM_QUANTITY), new GroundCoffee(SMALL_QUANTITY), new HotWater(MEDIUM_QUANTITY))

        when:
        def resultList = ingredientList.collect {
            ingredient -> ingredient.accept(ingredientFacade)
        }

        then:
        resultList.size() == 3
    }
}
