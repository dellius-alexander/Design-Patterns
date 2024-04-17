package org.example.Factory

import org.example.Product.ConcreteProductB
import org.example.Product.Product

class ConcreteFactoryB : AbstractFactory {
    override fun createProduct(): Product {
        return ConcreteProductB()
    }
}