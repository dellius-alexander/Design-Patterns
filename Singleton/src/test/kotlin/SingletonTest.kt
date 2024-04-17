import org.example.Singleton
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SingletonTest {

    private lateinit var singletonClass: Singleton<TestSingletonClass>

    @BeforeEach
    fun setup() {
        singletonClass = Singleton { TestSingletonClass() }
    }

    @Test
    fun `testSingletonInstantiation`() {
        // Ensure the Singleton instance is not null
        assertNotNull(singletonClass.getInstance())
    }

    @Test
    fun `testSingletonInstanceUniqueness`() {
        val firstInstance = singletonClass.getInstance()
        val secondInstance = singletonClass.getInstance()

        // Ensure that both instances are the same
        assertSame(firstInstance, secondInstance)
    }

    @Test
    fun `testMultipleThreadsReturnSameInstance`() {
        val thread1 = Thread { singletonClass.getInstance() }
        val thread2 = Thread { singletonClass.getInstance() }

        thread1.start()
        thread2.start()

        thread1.join()
        thread2.join()

        val firstInstance = thread1.getState()
        val secondInstance = thread2.getState()

        // Ensure that instances from both threads are the same
        assertSame(firstInstance, secondInstance)
    }
}

class TestSingletonClass {
    init {
        if (count > 1) {
            throw IllegalStateException("More than one instance created!")
        }
    }

    companion object {
        private var count: Int = 0

        @JvmStatic
        fun createInstance(): TestSingletonClass {
            count++
            return TestSingletonClass()
        }
    }
}