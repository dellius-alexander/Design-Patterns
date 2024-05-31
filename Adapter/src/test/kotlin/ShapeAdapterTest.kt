import org.junit.jupiter.api.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class ShapeAdapterTest {

    private lateinit var legacySquare: LegacySquare
    private lateinit var legacyCircle: LegacyCircle
    private lateinit var shapeAdapterSquare: ShapeAdapter
    private lateinit var shapeAdapterCircle: ShapeAdapter

    @BeforeEach
    fun setUp() {
        legacySquare = LegacySquare()
        legacyCircle = LegacyCircle()
        shapeAdapterSquare = ShapeAdapter(legacySquare)
        shapeAdapterCircle = ShapeAdapter(legacyCircle)
    }

    @AfterEach
    fun tearDown() {
        // Not much to tear down in this simple example
    }

    @Test
    fun testAdapterForLegacySquare() {
        // Capture standard output for assertion
        val output = captureStandardOutput {
            shapeAdapterSquare.draw()
        }

        // Assert that the adapter correctly delegates to the legacy shape
        Assertions.assertEquals("Displaying a square (legacy)\n", output)
    }

    @Test
    fun testAdapterForLegacyCircle() {
        // Capture standard output for assertion
        val output = captureStandardOutput {
            shapeAdapterCircle.draw()
        }

        // Assert that the adapter correctly delegates to the legacy shape
        Assertions.assertEquals("Displaying a circle (legacy)\n", output)
    }

    // Helper function to capture standard output
    private fun captureStandardOutput(block: () -> Unit): String {
        val originalOut = System.out
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        block()

        System.setOut(originalOut)
        return outputStream.toString()
    }
}