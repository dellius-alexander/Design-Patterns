import org.example.Car
import org.example.CarBuilder
import org.example.CarDirector
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var carBuilder: CarBuilder
    private lateinit var carDirector: CarDirector<Car>

    @BeforeEach
    fun setup() {
        carBuilder = CarBuilder()
        carDirector = CarDirector(carBuilder)
    }
    @Test
    fun `car details are correct`() {
        carDirector.construct("V8", 5, 4)
        val car = carBuilder.build()

        assertEquals("V8", car.engine)
        assertEquals(5, car.seats)
        assertEquals(4, car.windows)
    }


    @Test
    fun `car details are constructed correctly`() {
        carDirector.construct("V8", 5, 4)
        val car = carBuilder.build()

        assertEquals("V8", car.engine)
        assertEquals(5, car.seats)
        assertEquals(4, car.windows)
    }

    @Test
    fun `car details are reset correctly`() {
        carDirector.construct("V6", 4, 6)
        carBuilder.reset()
        val car = carBuilder.build()

        assertEquals("", car.engine)
        assertEquals(0, car.seats)
        assertEquals(0, car.windows)
    }
}