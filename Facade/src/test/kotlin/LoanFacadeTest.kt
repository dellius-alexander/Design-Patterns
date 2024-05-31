import org.example.LoanFacade
import org.example.LoanType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class LoanFacadeTest {
    private lateinit var loanFacade: LoanFacade

    @BeforeEach
    fun setup() {
        loanFacade = LoanFacade()
    }

    @AfterEach
    fun tearDown() {
        // No specific tear-down needed in this case, but good practice to include.
    }

    @Test
    fun testCarLoanApproved() {
        val data = mapOf("assetValue" to 150000.0, "creditScore" to 700)
        assertTrue(loanFacade.applyForLoan(LoanType.CAR, 100000.0, data))
    }

    @Test
    fun testCarLoanNotApproved() {
        val data = mapOf("assetValue" to 100000.0, "creditScore" to 550)
        assertFalse(loanFacade.applyForLoan(LoanType.CAR, 80000.0, data))
    }

    @Test
    fun testHomeLoanApproved() {
        val data = mapOf("income" to 80000.0, "creditScore" to 720)
        assertFalse(loanFacade.applyForLoan(LoanType.HOME, 200000.0, data))
    }

    @Test
    fun testHomeLoanNotApproved() {
        val data = mapOf("income" to 50000.0, "creditScore" to 600)
        assertFalse(loanFacade.applyForLoan(LoanType.HOME, 200000.0, data))
    }

    @Test
    fun testPersonalLoanApproved() {
        val data = mapOf("creditScore" to 780, "debtToIncomeRatio" to 0.25)
        assertTrue(loanFacade.applyForLoan(LoanType.PERSONAL, 3000.0, data))
    }

    @Test
    fun testPersonalLoanNotApproved() {
        val data = mapOf("creditScore" to 650, "debtToIncomeRatio" to 0.40)
        assertFalse(loanFacade.applyForLoan(LoanType.PERSONAL, 7000.0, data))
    }

    @Test
    fun testEducationLoanApproved() {
        val data = mapOf("coSignerCreditScore" to 800, "studentAge" to 25)
        assertTrue(loanFacade.applyForLoan(LoanType.EDUCATION, 8000.0, data))
    }

    @Test
    fun testEducationLoanNotApproved() {
        val data = mapOf("coSignerCreditScore" to 700, "studentAge" to 18)
        assertFalse(loanFacade.applyForLoan(LoanType.EDUCATION, 12000.0, data))
    }
}