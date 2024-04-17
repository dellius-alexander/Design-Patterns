package org.example

import org.example.document.ValuableDocument

class Client {
    fun run() {
        val originalDocument = ValuableDocument("Original Content")
        val copiedDocument = originalDocument.copy() as ValuableDocument

        println("Original Document: ${originalDocument}")
        println("Copied Document: ${copiedDocument}")

        // Make changes to the copied document
        copiedDocument.content = "Modified Content"

        println("After Modification, Copied Document: ${copiedDocument}")
    }
}