import org.example.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecoratorTest {

    @Test
    fun `test basic home`() {
        val basicHome = BasicHome()
        assertEquals("Basic Home", basicHome.build())
        assertEquals(50000, basicHome.cost())
    }

    @Test
    fun `test advanced home`() {
        val advancedHome = AdvancedHome()
        assertEquals("Advanced Home", advancedHome.build())
        assertEquals(80000, advancedHome.cost())
    }

    @Test
    fun `test playground decorator`() {
        val basicHome = BasicHome()
        val homeWithPlayground = Playground(basicHome)
        assertEquals("Basic Home, with Playground", homeWithPlayground.build())
        assertEquals(65000, homeWithPlayground.cost())
    }

    @Test
    fun `test swimming pool decorator`() {
        val basicHome = BasicHome()
        val homeWithSwimmingPool = SwimmingPool(basicHome)
        assertEquals("Basic Home, with Swimming Pool", homeWithSwimmingPool.build())
        assertEquals(75000, homeWithSwimmingPool.cost())
    }

    @Test
    fun `test playground and swimming pool decorators`() {
        val basicHome = BasicHome()
        val homeWithPlaygroundAndPool = Playground(SwimmingPool(basicHome))
        assertEquals("Basic Home, with Swimming Pool, with Playground", homeWithPlaygroundAndPool.build())
        assertEquals(90000, homeWithPlaygroundAndPool.cost())
    }
}