package org.example.document

data class ValuableDocument(var content: String): IDocument {

    override fun copy(): IDocument {
        return ValuableDocument(content)
    }
}
