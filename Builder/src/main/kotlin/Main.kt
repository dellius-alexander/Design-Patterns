package org.example

class Car {
    var engine: String = ""
    var seats: Int = 0
    var windows: Int = 0

    override fun toString(): String {
        return "Car(engine='$engine', seats=$seats, windows=$windows)"
    }
}

interface Builder<T> {
    fun reset()
    fun buildEngine()
    fun buildSeats()
    fun buildWindows()
    fun getResult(): T
}

class CarBuilder : Builder<Car> {
    private var car: Car = Car()

    override fun reset() {
        car = Car()
    }

    override fun buildEngine() {
        car.engine = "V8"
    }

    override fun buildSeats() {
        car.seats = 5
    }

    override fun buildWindows() {
        car.windows = 4
    }

    override fun getResult(): Car {
        return car
    }
}

class CarDirector<T>(private val builder: Builder<T>) {
    fun construct() {
        builder.reset()
        builder.buildEngine()
        builder.buildSeats()
        builder.buildWindows()
    }
}

fun main() {
    val carBuilder = CarBuilder()
    val carDirector = CarDirector(carBuilder)

    carDirector.construct()
    val car = carBuilder.getResult()

    println("\n\nCar Details: $car")
}

