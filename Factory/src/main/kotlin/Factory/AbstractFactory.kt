package org.example.Factory

import org.example.Product.Product

interface AbstractFactory {
    fun createProduct(): Product
}