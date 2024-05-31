package org.example.Factory

import org.example.Product.Product

/**
 * The 'AbstractFactory' interface declares the factory method for creating 'Product' objects.
 * This interface defines the creation of a product without exposing the creation logic to the client.
 */
interface AbstractFactory {
    /**
     * The factory method responsible for creating a 'Product' instance.
     * @return A newly created instance of 'Product'
     */
    fun createProduct(): Product
}