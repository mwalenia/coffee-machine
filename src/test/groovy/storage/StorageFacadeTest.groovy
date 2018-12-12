package storage

import spock.lang.Specification
import storage.exceptions.NotEnoughBeansException
import storage.exceptions.NotEnoughMilkException
import storage.exceptions.NotEnoughWaterException

class StorageFacadeTest extends Specification {
    def static MILK_CAPACITY = 500
    def static WATER_CAPACITY = 1000
    def static COFFEE_CAPACITY = 1000
    def static SMALL_QUANTITY = 10
    StorageFacade storageFacade

    def setup() {
        def milkContainer = new MilkContainer(MILK_CAPACITY)
        def coffeeContainer = new CoffeeBeansContainer(COFFEE_CAPACITY)
        def waterContainer = new WaterContainer(WATER_CAPACITY)
        storageFacade = new StorageFacade(milkContainer, coffeeContainer, waterContainer)
    }

    def 'Cannot get coffee from empty container'() {
        when:
        storageFacade.getBeans(SMALL_QUANTITY)

        then:
        thrown(NotEnoughBeansException)
    }

    def 'Cannot get water from empty container'() {
        when:
        storageFacade.getColdWater(SMALL_QUANTITY)

        then:
        thrown(NotEnoughWaterException)
    }

    def 'Cannot get milk from empty container'() {
        when:
        storageFacade.getColdMilk(SMALL_QUANTITY)

        then:
        thrown(NotEnoughMilkException)
    }

    def 'After refilling of coffee container, we can take coffee'() {
        given:
        storageFacade.refillBeans()

        when:
        def beans = storageFacade.getBeans(SMALL_QUANTITY)

        then:
        beans.quantity == SMALL_QUANTITY
    }

    def 'After refilling of water container, we can take water'() {
        given:
        storageFacade.refillWater()

        when:
        def water = storageFacade.getColdWater(SMALL_QUANTITY)

        then:
        water.quantity == SMALL_QUANTITY
    }

    def 'After refilling of milk container, we can take milk'() {
        given:
        storageFacade.refillMilk()

        when:
        def milk = storageFacade.getColdMilk(SMALL_QUANTITY)

        then:
        milk.quantity == SMALL_QUANTITY
    }
}
