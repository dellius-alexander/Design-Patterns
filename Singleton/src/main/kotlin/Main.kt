package org.example

class Logger {
    companion object {
        private var instance: Logger? = null

        @Synchronized
        fun getInstance(): Logger {
            if (instance == null) {
                instance = Logger()
            }
            return instance!!
        }
    }

    private constructor() {
        // Initialize the logger here if needed
    }

    fun log(message: String) {
        // Implement your logging logic here
        println("Logged: $message")
    }
}



fun main() {
    if (Logger.getInstance() === null) {
        val logger = Logger.getInstance()
        logger.log("Hello, world!")

        // Create another instance of Logger
        val anotherLogger = Logger.getInstance()
        // Both references point to the same instance
        println(logger == anotherLogger)  // true
    } else {
        println("Logger instance already exists")
    }
}
