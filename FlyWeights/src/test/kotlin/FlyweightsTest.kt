import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach

class FlyweightsTest {

    private val outputStreamCaptor = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun testRegularCardPrinting() {
        val employee = Pair("John Doe", "Regular")

        PrintDepartment.printCards(listOf(employee))

        val output = outputStreamCaptor.toString()
        assertEquals(
            """
----- Regular Business Card -----
Company Logo
Company Address
John Doe - Regular
JDoe@company.com
-------------------------------
            """.trim(), output.trim()
        )
    }

    @Test
    fun testExecutiveCardPrinting() {
        val employee = Pair("Jane Smith", "Executive")

        PrintDepartment.printCards(listOf(employee))

        val output = outputStreamCaptor.toString()
        assertEquals(
            """
----- Executive Business Card -----
Company Logo (Gold Embossed)
Company Address
Jane Smith - Executive
JSmith@company.com (Direct Line)
-------------------------------
            """.trim(), output.trim()
        )
    }

    @Test
    fun testMixedCardPrinting() {
        val employees = listOf(
            Pair("Alice Johnson", "Regular"),
            Pair("Bob Wilson", "Executive")
        )

        PrintDepartment.printCards(employees)

        val output = outputStreamCaptor.toString()
        val expectedOutput = """
----- Regular Business Card -----
Company Logo
Company Address
Alice Johnson - Regular
AJohnson@company.com
-------------------------------
----- Executive Business Card -----
Company Logo (Gold Embossed)
Company Address
Bob Wilson - Executive
BWilson@company.com (Direct Line)
-------------------------------
        """.trim()

        assertEquals(expectedOutput, output.trim())
    }
}