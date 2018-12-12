package coffeeMachine.storage

import coffeeMachine.ingredients.basicIngredients.ColdMilk
import spock.lang.Specification
import coffeeMachine.storage.exceptions.NotEnoughMilkException

class MilkContainerTest extends Specification {
    def static MAX_CAPACITY = 500
    def static OVERDRAFT = 505
    def static NORMAL_DRAW = 150

    def "Milk container indeed dispenses milk"() {
        given:
        def milkContainer = new MilkContainer(MAX_CAPACITY)
        milkContainer.refill()

        when:
        def milk = milkContainer.dispense(NORMAL_DRAW)

        then:
        milk.class == ColdMilk
    }

    def "When container is full, we get desired amount of milk"() {
        given:
        def milkContainer = new MilkContainer(MAX_CAPACITY)
        milkContainer.refill()

        when:
        def milk = milkContainer.dispense(NORMAL_DRAW)

        then:
        assert milk.quantity == NORMAL_DRAW
    }

    def "Container will not give more than max capacity"() {
        given:
        def milkContainer = new MilkContainer(MAX_CAPACITY)

        when:
        milkContainer.dispense(OVERDRAFT)

        then:
        thrown(NotEnoughMilkException)
    }

    def "Refill fills container with low capacity"() {
        given:
        def milkContainer = new MilkContainer(MAX_CAPACITY)

        when:
        milkContainer.refill()

        then:
        assert milkContainer.ingredientLevel == MAX_CAPACITY
    }
}
