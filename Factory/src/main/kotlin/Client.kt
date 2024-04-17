package org.example

import org.example.Factory.AbstractFactory

class Client {
    fun useFactory(factory: AbstractFactory) {
        val product = factory.createProduct()
        product.use()
    }
}