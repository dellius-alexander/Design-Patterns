package org.example

// Step 1: Define the Loan Types
class CarLoan(private var loanAmount: Double, private var assetValue: Double, private var creditScore: Int) {
    fun isLoanApproved(): Boolean {
        return loanAmount <= assetValue * 0.75 && creditScore >= 600
    }
}

class HomeLoan(private var loanAmount: Double, private var income: Double, private var creditScore: Int) {
    fun isLoanApproved(): Boolean {
        return loanAmount <= income * 0.3 && creditScore >= 650
    }
}

class PersonalLoan(private var loanAmount: Double, private var creditScore: Int, private var debtToIncomeRatio: Double) {
    fun isLoanApproved(): Boolean {
        return creditScore >= 700 && loanAmount <= 5000 && debtToIncomeRatio < 0.35
    }
}

class EducationLoan(private var loanAmount: Double, private var coSignerCreditScore: Int, private var studentAge: Int) {
    fun isLoanApproved(): Boolean {
        return coSignerCreditScore >= 750 && studentAge >= 21 && loanAmount <= 10000
    }
}

// Step 2: Define the Loan Facade
class LoanFacade {
    fun applyForLoan(loanType: LoanType, amount: Double, additionalData: Map<String, Any>): Boolean {
        return when (loanType) {
            LoanType.CAR -> {
                val carLoan = CarLoan(amount, additionalData["assetValue"] as Double, additionalData["creditScore"] as Int)
                carLoan.isLoanApproved()
            }
            LoanType.HOME -> {
                val homeLoan = HomeLoan(amount, additionalData["income"] as Double, additionalData["creditScore"] as Int)
                homeLoan.isLoanApproved()
            }
            LoanType.PERSONAL -> {
                val personalLoan = PersonalLoan(amount, additionalData["creditScore"] as Int, additionalData["debtToIncomeRatio"] as Double)
                personalLoan.isLoanApproved()
            }
            LoanType.EDUCATION -> {
                val educationLoan = EducationLoan(amount, additionalData["coSignerCreditScore"] as Int, additionalData["studentAge"] as Int)
                educationLoan.isLoanApproved()
            }
        }
    }
}

// Step 3: Define the Loan Type enumeration
enum class LoanType {
    CAR, HOME, PERSONAL, EDUCATION
}

// Step 4: Client Code
fun main() {
    val facade = LoanFacade()

    val carLoanData = mapOf("assetValue" to 15000.0, "creditScore" to 680)
    val homeLoanData = mapOf("income" to 8000.0, "creditScore" to 720)
    val personalLoanData = mapOf("creditScore" to 760, "debtToIncomeRatio" to 0.25)
    val educationLoanData = mapOf("coSignerCreditScore" to 780, "studentAge" to 25)

    println("Car Loan Approval Status: ${facade.applyForLoan(LoanType.CAR, 10000.0, carLoanData)}")
    println("Home Loan Approval Status: ${facade.applyForLoan(LoanType.HOME, 200000.0, homeLoanData)}")
    println("Personal Loan Approval Status: ${facade.applyForLoan(LoanType.PERSONAL, 3000.0, personalLoanData)}")
    println("Education Loan Approval Status: ${facade.applyForLoan(LoanType.EDUCATION, 8000.0, educationLoanData)}")
}
