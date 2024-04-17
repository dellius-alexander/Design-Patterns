package org.example
import org.example.Singleton

class Car {
    var engine: String = ""
    var seats: Int = 0
    var windows: Int = 0

    override fun toString(): String {
        return "Car(engine='$engine', seats=$seats, windows=$windows)"
    }
}

fun main() {
    val carSingleton = Singleton(Car::class.java) { Car() }
    val carInstance1 = carSingleton.getInstance()
    carInstance1.engine = "V8"
    carInstance1.seats = 5
    carInstance1.windows = 4

    val carInstance2 = carSingleton.getInstance()

    println(carInstance1)
    println(carInstance2)
}
