package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val employees = listOf(
                "John Doe" to "Manager",
                "Jane Smith" to "Executive",
                "Bob Johnson" to "Engineer"
            )

            PrintDepartment.printCards(employees)
        }
    }

}