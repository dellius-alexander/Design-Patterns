package org.example.Factory

import org.example.Product.ConcreteProductB
import org.example.Product.Product

/**
 * 'ConcreteFactoryB' is a concrete implementation of the 'AbstractFactory' interface.
 * It knows how to create instances of 'ConcreteProductB'.
 */
class ConcreteFactoryB : AbstractFactory {
    override fun createProduct(): Product {
        return ConcreteProductB()
    }
}
