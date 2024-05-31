package org.example

import org.example.Factory.AbstractFactory

/**
 * The 'Client' class uses the abstract factory to create products without depending on their concrete classes.
 * It demonstrates the client's usage of different factories and products.
 */
class Client {
    /**
     * This method uses the given factory to create a product and then invokes its 'use' method.
     * @param factory The abstract factory that will be used to create the product.
     */
    fun useFactory(factory: AbstractFactory) {
        val product = factory.createProduct()
        product.use()
    }
}
