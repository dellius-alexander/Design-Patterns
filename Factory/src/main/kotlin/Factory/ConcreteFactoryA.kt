package org.example.Factory

import org.example.Product.ConcreteProductA
import org.example.Product.Product

class ConcreteFactoryA : AbstractFactory {
    override fun createProduct() : Product {
        return ConcreteProductA()
    }
}