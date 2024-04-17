package org.example

import org.example.Factory.ConcreteFactoryA
import org.example.Factory.ConcreteFactoryB


fun main() {
    val client = Client()

    val factoryA = ConcreteFactoryA()
    client.useFactory(factoryA)

    val factoryB = ConcreteFactoryB()
    client.useFactory(factoryB)
}