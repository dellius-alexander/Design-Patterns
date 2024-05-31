/**
 * The 'Decorator' design pattern allows you to dynamically add new features to an object at runtime.
 * It does this by wrapping the original object with an additional object that implements the same interface.
 *
 * In this example, we have a basic implementation of a 'Home' and decorators that add 'Luxury' features like a 'Playground' and 'SwimmingPool'.
 */
package org.example

/**
 * Base interface for all homes. Defines the basic features of a home.
 */
interface Home {
    /**
     * Describes the home and its features.
     * @return A string representation of the home.
     */
    fun build(): String

    /**
     * Calculates the cost of the home.
     * @return The cost of the home.
     */
    fun cost(): Int
}

/**
 *  Interface for 'Luxury' homes. Extends the Home interface to include luxury-specific features.
 */
interface Luxury : Home {
    /**
     * Adds a new luxury feature to the home.
     * @return A string describing the added luxury feature.
     */
    fun addLuxury(): String
}

/**
 * A concrete implementation of a basic home.
 */
class BasicHome : Home {
    override fun build() = "Basic Home"

    override fun cost(): Int = 50000
}

/**
 *  Concrete implementation of an advanced home.
 */
class AdvancedHome : Home {
    override fun build() = "Advanced Home"

    override fun cost(): Int = 80000
}

/**
 * Decorator that adds a 'Playground' to a given home.
 */
class Playground(private val home: Home) : Luxury {
    /**
     * Describes the home with the added playground feature.
     * @return A string representation of the home with the playground.
     */
    override fun build() = "${home.build()}, with Playground"

    /**
     * Calculates the cost of the home including the playground.
     * @return The total cost of the home with the playground.
     */
    override fun cost(): Int = home.cost() + 15000

    /**
     * Adds the information about the playground to the home.
     * @return A string stating that a playground was added.
     */
    override fun addLuxury() = "Playground added!"
}

/**
 * Decorator that adds a 'SwimmingPool' to a given home.
 */
class SwimmingPool(private val home: Home) : Luxury {
    /**
     * Describes the home with the added swimming pool feature.
     * @return A string representation of the home with the swimming pool.
     */
    override fun build() = "${home.build()}, with Swimming Pool"

    /**
     * Calculates the cost of the home including the swimming pool.
     * @return The total cost of the home with the swimming pool.
     */
    override fun cost(): Int = home.cost() + 25000

    /**
     * Adds the information about the swimming pool to the home.
     * @return A string stating that a swimming pool was added.
     */
    override fun addLuxury() = "Swimming Pool added!"
}

fun main() {
    /**
     * Start with a basic home and gradually add luxuries.
     */
    var home: Home = BasicHome()

    home = Playground(home) // Add playground
    home = SwimmingPool(home) // Add swimming pool

    println("You are building: ${home.build()}")
    println("Cost: $${home.cost()}")

    /**
     * Upgrade the home to advanced and add more luxuries.
     */
    home = AdvancedHome()
    home = SwimmingPool(home)
    home = Playground(home)

    println("You are building: ${home.build()}")
    println("Cost: $${home.cost()}")
}