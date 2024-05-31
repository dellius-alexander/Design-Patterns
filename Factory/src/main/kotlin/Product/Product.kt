package org.example.Product

import java.io.Serializable

/**
 * The 'Product' interface defines the common interface for various products.
 * It declares the behavior that all products must support.
 */
interface Product : Serializable {
    /**
     * This operation represents the unique behavior of a product.
     */
    fun use()
}
