package org.example

interface Home {
    fun build(): String
    fun cost(): Int
}

interface Luxury : Home {
    fun addLuxury(): String
}

class BasicHome : Home {
    override fun build() = "Basic Home"
    override fun cost() = 50000
}

class AdvancedHome : Home {
    override fun build() = "Advanced Home"
    override fun cost() = 80000
}

class Playground(private val home: Home) : Luxury{
    override fun build() = "${home.build()}, with Playground"
    override fun cost() = home.cost() + 15000
    override fun addLuxury() = "Playground added!"
}

class SwimmingPool(private val home: Home) : Luxury {
    override fun build() = "${home.build()}, with Swimming Pool"
    override fun cost() = home.cost() + 25000
    override fun addLuxury() = "Swimming Pool added!"
}

fun main() {
    var home: Home = BasicHome()

    home = Playground(home)  // Add playground
    home = SwimmingPool(home) // Add swimming pool

    println("You are building: ${home.build()}")
    println("Cost: $${home.cost()}")


    home = AdvancedHome()     // Upgrade to advanced home
    home = SwimmingPool(home) // Add swimming pool
    home = Playground(home)   // Add playground

    println("You are building: ${home.build()}")
    println("Cost: $${home.cost()}")
}
