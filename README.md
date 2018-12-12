# Coffee machine

The goal of the project is to create a coffee machine simulation.

Machine will consist of three modules:

* storage components
* processing components
* main machine, ie. mixer

Components will be accessible through facades. Recipes for drinks will
be lists of ingredients along with required quantities, e.g. 1 espresso,
100ml steamed milk and 100ml hot milk for a cappuccino.

In order to allow ingredient lists to be processed efficiently, some form
of multiple dispatch needs to be implemented - Visitor pattern seems best
suited for the job.

---

## Installing

To install the application run

    ./gradlew install

The output .jar will be in /build/libs directory

## Testing

To perform all the tests run

    ./gradlew check

### Built with:

* Gradle
* Spock
* Lombok
* Java 8

