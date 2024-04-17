package org.example

class Singleton<T : Any>(private val clazz: Class<T>, creator: () -> T) {
    private var creator: (() -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(): T {
        val checkInstance = instance
        if (checkInstance != null) {
            if (clazz.isInstance(checkInstance)) {
                return checkInstance
            }
        }

        return synchronized(this) {
            val checkInstanceAgain = instance
            if (checkInstanceAgain != null) {
                if (clazz.isInstance(checkInstanceAgain)) {
                    checkInstanceAgain
                } else {
                    val created = creator!!()
                    instance = created
                    creator = null
                    created
                }
            } else {
                val created = creator!!()
                instance = created
                creator = null
                created
            }
        }
    }
}

class Car {
    var engine: String = ""
    var seats: Int = 0
    var windows: Int = 0

    override fun toString(): String {
        return "Car(engine='$engine', seats=$seats, windows=$windows)"
    }
}

