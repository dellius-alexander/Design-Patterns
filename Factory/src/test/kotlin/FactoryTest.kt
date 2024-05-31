import org.example.Factory.ConcreteFactoryA
import org.example.Factory.ConcreteFactoryB
import org.example.Product.ConcreteProductA
import org.example.Product.ConcreteProductB
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Test suite for the 'FactoryDesignPattern' module.
 * This class ensures that the various components of the factory design pattern work as expected.
 */
class FactoryDesignPatternTest {

    /**
     * Tests the creation of ConcreteProductA by ConcreteFactoryA.
     */
    @Test
    fun `factory produces expected ConcreteProductA`() {
        // Arrange
        val factoryA = ConcreteFactoryA()

        // Act
        val productA = factoryA.createProduct()

        // Assert
        assertNotNull(productA)
        assertTrue(productA is ConcreteProductA)
    }

    /**
     * Tests the creation of ConcreteProductB by ConcreteFactoryB.
     */
    @Test
    fun `factory produces expected ConcreteProductB`() {
        // Arrange
        val factoryB = ConcreteFactoryB()

        // Act
        val productB = factoryB.createProduct()

        // Assert
        assertNotNull(productB)
        assertTrue(productB is ConcreteProductB)
    }

}