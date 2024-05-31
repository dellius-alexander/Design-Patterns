import org.example.Department
import org.example.IndividualEmployee
import org.junit.jupiter.api.*
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositePatternTest {

    private lateinit var organization: Department

    @BeforeAll
    fun setUp() {
        val ceo = IndividualEmployee("Alice Johnson", 250000.0)
        organization = Department("Acme Corporation")
        organization.addEmployee(ceo)

        // Creating departments and adding employees
        val departments = listOf(
            "Sales", "Marketing", "Engineering", "Finance", "HR",
            "IT", "Research", "Legal", "Operations", "Customer Service"
        )

        departments.forEach { deptName ->
            val department = Department(deptName)
            department.addEmployee(IndividualEmployee("${deptName} Manager", 80000.0))
            organization.addEmployee(department)
        }
    }

    @AfterAll
    fun tearDown() {
        // Not strictly necessary in this case, but good practice
        organization = Department("") // Reset organization
    }

    @Test
    fun testTotalSalaryExpense() {
        val expectedSalary = 250000.0 + (10 * 80000.0) // CEO + 10 managers
        assertEquals(expectedSalary, organization.getSalary())
    }

    @Test
    fun testAddAndRemoveEmployee() {
        val newEmployee = IndividualEmployee("John Doe", 50000.0)
        val salesDepartment = organization.getEmployees().first { it.getName() == "Sales" } as Department
        salesDepartment.addEmployee(newEmployee)

        assertEquals(130000.0, salesDepartment.getSalary()) // Manager + new employee

        salesDepartment.removeEmployee(newEmployee)
        assertEquals(80000.0, salesDepartment.getSalary()) // Back to just manager
    }

    // ... Add more tests as needed
}