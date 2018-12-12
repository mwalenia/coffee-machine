package coffeeMachine.storage

import coffeeMachine.ingredients.basicIngredients.ColdWater
import spock.lang.Specification
import coffeeMachine.storage.exceptions.NotEnoughWaterException

class WaterContainerTest extends Specification {
    def static MAX_CAPACITY = 1000
    def static OVERDRAFT = 1005
    def static NORMAL_DRAW = 150

    def 'Water container indeed dispenses water'() {
        given:
        def waterContainer = new WaterContainer(MAX_CAPACITY)
        waterContainer.refill()

        when:
        def water = waterContainer.dispense(NORMAL_DRAW)

        then:
        water.class == ColdWater
    }

    def 'When container is full, we get desired amount of water'() {
        given:
        def waterContainer = new WaterContainer(MAX_CAPACITY)
        waterContainer.refill()

        when:
        def water = waterContainer.dispense(NORMAL_DRAW)

        then:
        assert water.quantity == NORMAL_DRAW
    }

    def 'Container will not give more than max capacity'() {
        given:
        def waterContainer = new WaterContainer(MAX_CAPACITY)

        when:
        waterContainer.dispense(OVERDRAFT)

        then:
        thrown(NotEnoughWaterException)
    }

    def 'Refill fills container with low capacity'() {
        given:
        def waterContainer = new WaterContainer(MAX_CAPACITY)

        when:
        waterContainer.refill()

        then:
        assert waterContainer.ingredientLevel == MAX_CAPACITY
    }
}
