package test.kotlin

import org.example.document.IDocument
import org.example.document.ValuableDocument
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.UUID

class PrototypeTest {

    private lateinit var originalDocument: ValuableDocument

    @BeforeEach
    fun setup() {
        originalDocument = ValuableDocument(content = "Original Document Content")
    }

    @Test
    fun `test Document Copying using Prototype pattern`() {
        val copiedDocument: IDocument = originalDocument.copy()

        // Assert that the copied document is of the same type as the original
        assertTrue(copiedDocument is ValuableDocument)

        // Assert that the content of the copied document is the same as the original
        assertEquals(originalDocument, copiedDocument)

        //**Modifying the content of the copied document should not affect the original**
        val uniqueString = UUID.randomUUID().toString()
        (copiedDocument as ValuableDocument).content = uniqueString
        assertNotEquals(originalDocument.content, copiedDocument.content)
    }
}

