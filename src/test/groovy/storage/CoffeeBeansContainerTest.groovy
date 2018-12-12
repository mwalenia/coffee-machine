package storage

import ingredients.basicIngredients.CoffeeBeans
import spock.lang.Specification
import storage.exceptions.NotEnoughBeansException

class CoffeeBeansContainerTest extends Specification {
    def static MAX_CAPACITY = 1000
    def static OVERDRAFT = 1005
    def static NORMAL_DRAW = 15

    def 'Coffee container dispenses coffee'() {
        given:
        def coffeeBeansContainer = new CoffeeBeansContainer(MAX_CAPACITY)
        coffeeBeansContainer.refill()

        when:
        def beans = coffeeBeansContainer.dispense(NORMAL_DRAW)

        then:
        beans.class == CoffeeBeans
    }

    def 'When container is full, we get desired amount of coffee'() {
        given:
        def coffeeBeansContainer = new CoffeeBeansContainer(MAX_CAPACITY)
        coffeeBeansContainer.refill()

        when:
        def beans = coffeeBeansContainer.dispense(NORMAL_DRAW)

        then:
        assert beans.quantity == NORMAL_DRAW
    }

    def 'Container will not give more than max capacity'() {
        given:
        def coffeeBeansContainer = new CoffeeBeansContainer(MAX_CAPACITY)

        when:
        coffeeBeansContainer.dispense(OVERDRAFT)

        then:
        thrown(NotEnoughBeansException)
    }

    def 'Refill fills container with low ingredient level'() {
        given:
        def coffeeBeansContainer = new CoffeeBeansContainer(MAX_CAPACITY)

        when:
        coffeeBeansContainer.refill()

        then:
        coffeeBeansContainer.ingredientLevel == MAX_CAPACITY
    }
}
