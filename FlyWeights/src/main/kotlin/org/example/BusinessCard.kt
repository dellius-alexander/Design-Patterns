interface BusinessCard {
    fun printCard(employeeName: String, employeeTitle: String, employeeEmail: String)
}

class RegularCard : BusinessCard {
    override fun printCard(employeeName: String, employeeTitle: String, employeeEmail: String) {
        println("----- Regular Business Card -----")
        println("Company Logo")
        println("Company Address")
        println("$employeeName - $employeeTitle")
    }
}

class ExecutiveCard : BusinessCard {
    override fun printCard(employeeName: String, employeeTitle: String, employeeEmail: String) {
        println("----- Executive Business Card -----")
        println("Company Logo (Gold Embossed)")
        println("Company Address")
        println("$employeeName - $employeeTitle")
        println("$employeeEmail (Direct Line)")
    }
}

class BusinessCardFactory private constructor() {
    private val cards = mutableMapOf<String, BusinessCard>()

    fun getCard(type: String): BusinessCard {
        return cards.getOrPut(type) {
            when (type) {
                "regular" -> RegularCard()
                "executive" -> ExecutiveCard()
                else -> throw IllegalArgumentException("Invalid card type: $type")
            }
        }
    }

    companion object {
        private val instance = BusinessCardFactory()

        fun getCard(type: String): BusinessCard {
            return instance.getCard(type)
        }
    }
}

object PrintDepartment { // Client
    fun printCards(employees: List<Pair<String, String>>) {
        employees.forEach { (name, title) ->
            val cardType = if (title == "Executive") "executive" else "regular"
            val card = BusinessCardFactory.getCard(cardType)
            card.printCard(name, title, name.split(' ').elementAt(0).elementAt(0) + name.split(' ').elementAt(1) +"@company.com") // Assuming a standard email pattern
            println("-------------------------------")
        }
    }
}

