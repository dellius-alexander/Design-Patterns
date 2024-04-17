package org.example

class Car {
    var engine: String = ""
    var seats: Int = 0
    var windows: Int = 0

    override fun toString(): String {
        return "Car(engine='$engine', seats=$seats, windows=$windows)"
    }
}

