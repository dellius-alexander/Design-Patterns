import org.example.ATMProxy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ATMProxyTest {

    @Test
    fun `getBalance should return initial balance`() {
        val atmProxy = ATMProxy()

        val balance = atmProxy.getBalance()

        assertEquals(5000, balance) // Assuming initial balance in RealBankAccount is 5000
    }

    @Test
    fun `withdraw should succeed with sufficient funds`() {
        val atmProxy = ATMProxy()

        val result = atmProxy.withdraw(1000)

        assertTrue(result)
        assertEquals(4000, atmProxy.getBalance())
    }

    @Test
    fun `withdraw should fail with insufficient funds`() {
        val atmProxy = ATMProxy()

        val result = atmProxy.withdraw(6000)

        assertFalse(result)
        assertEquals(5000, atmProxy.getBalance())
    }

    @Test
    fun `deposit should increase balance`() {
        val atmProxy = ATMProxy()

        atmProxy.deposit(500)

        assertEquals(5500, atmProxy.getBalance())
    }
}