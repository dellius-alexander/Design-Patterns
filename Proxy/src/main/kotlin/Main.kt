package org.example

interface BankAccount {
    fun getBalance(): Int
    fun withdraw(amount: Int): Boolean
    fun deposit(amount: Int)
}

class RealBankAccount : BankAccount {
    private var balance = 5000 // Initial balance
    override fun getBalance(): Int {
        return balance
    }
    override fun withdraw(amount: Int): Boolean {
        if (amount <= balance) {
            balance -= amount
            return true
        }
        return false
    }
    override fun deposit(amount: Int) {
        balance += amount
    }
}

class ATMProxy : BankAccount {
    private val realAccount = RealBankAccount()
    override fun getBalance(): Int {
        return realAccount.getBalance()
    }
    override fun withdraw(amount: Int): Boolean {
        if (realAccount.getBalance() >= amount) {
            println("Withdrawing $amount")
            return realAccount.withdraw(amount)
        } else {
            println("Insufficient funds.")
            return false
        }
    }
    override fun deposit(amount: Int) {
        println("Depositing $amount")
        realAccount.deposit(amount)
    }
}

fun main() {
    val bankAccount: BankAccount = ATMProxy()
    println("Current balance: ${bankAccount.getBalance()}")
    val withdrawalSuccessful = bankAccount.withdraw(2000)
    if (withdrawalSuccessful) {
        println("Withdrawal successful")
    }
    bankAccount.deposit(1000)
    println("New balance: ${bankAccount.getBalance()}")
}
