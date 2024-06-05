package org.example

interface Employee { // Component
    fun getName(): String
    fun getSalary(): Double
}

class IndividualEmployee(private val name: String, private val salary: Double) : Employee { // Leaf
    override fun getName(): String = name
    override fun getSalary(): Double = salary
}

class Department(private val name: String) : Employee { // Composite
    private val employees = mutableListOf<Employee>()

    fun addEmployee(employee: Employee) = employees.add(employee)
    fun removeEmployee(employee: Employee) = employees.remove(employee)
    fun getEmployees(): List<Employee> = employees

    override fun getName(): String = name

    override fun getSalary(): Double {
        return employees.sumOf { it.getSalary() }
    }
}

// Building the Organization
fun main() {    // Client implementation
    val ceo = IndividualEmployee("Alice Johnson", 250000.0)
    val organization = Department("Acme Corporation")
    organization.addEmployee(ceo)

    // Creating departments and adding employees
    val departments = listOf(
        "Sales", "Marketing", "Engineering", "Finance", "HR",
        "IT", "Research", "Legal", "Operations", "Customer Service"
    )

    departments.forEach { deptName ->
        val department = Department(deptName)
        // Add a few employees to each department (for simplicity, just managers)
        department.addEmployee(IndividualEmployee("${deptName} Manager", 80000.0))
        organization.addEmployee(department)
    }

    println("Total Salary Expense: $${organization.getSalary()}")
}