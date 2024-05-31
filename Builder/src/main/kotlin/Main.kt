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
    fun buildEngine(engine: String)
    fun buildSeats(seats: Int)
    fun buildWindows(windows: Int)
    fun build(): T
}

class CarBuilder : Builder<Car> {
    private var car: Car = Car()

    override fun reset() {
        car = Car()
    }

    override fun buildEngine(engine: String) {
        car.engine = engine
    }

    override fun buildSeats(seats: Int) {
        car.seats = seats
    }

    override fun buildWindows(windows: Int) {
        car.windows = windows
    }

    override fun build(): Car {
        return car
    }
}

class CarDirector<T>(private val builder: Builder<T>) {
    fun construct(engine: String, seats: Int, windows: Int) {
        builder.reset()
        builder.buildEngine(engine)
        builder.buildSeats(seats)
        builder.buildWindows(windows)
    }
}

fun main() {
    val carBuilder = CarBuilder()
    val carDirector = CarDirector(carBuilder)

    carDirector.construct("V8", 5, 4)
    val car = carBuilder.build()

    println("\n\nCar Details: $car")
}

