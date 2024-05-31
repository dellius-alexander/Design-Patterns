package org.example

import org.example.Factory.ConcreteFactoryA
import org.example.Factory.ConcreteFactoryB

/**
 * Entry-point class.
 */
fun main() {
    val client = Client()

    // Client uses the first factory to create and use a product
    val factoryA = ConcreteFactoryA()
    client.useFactory(factoryA)

    // Client uses the second factory to create and use a product
    val factoryB = ConcreteFactoryB()
    client.useFactory(factoryB)
}