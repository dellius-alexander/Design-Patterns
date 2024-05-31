package org.example.Factory

import org.example.Product.ConcreteProductA
import org.example.Product.Product

/**
 * 'ConcreteFactoryA' is a concrete implementation of the 'AbstractFactory' interface.
 * It knows how to create instances of 'ConcreteProductA'.
 */
class ConcreteFactoryA : AbstractFactory {
    override fun createProduct(): Product {
        return ConcreteProductA()
    }
}
