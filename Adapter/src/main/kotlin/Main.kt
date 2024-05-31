interface Shape {
    fun draw()
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing a rectangle")
    }
}

class Square : Shape {
    override fun draw() {
        println("Drawing a square")
    }
}


interface LegacyShape {
    fun display()
}

class LegacySquare : LegacyShape {
    override fun display() {
        println("Displaying a square (legacy)")
    }
}

class LegacyCircle : LegacyShape {
    override fun display() {
        println("Displaying a circle (legacy)")
    }
}

class LegacyTriangle : LegacyShape {
    override fun display() {
        println("Displaying a triangle (legacy)")
    }
}


class ShapeAdapter(private val legacyShape: LegacyShape) : Shape {
    override fun draw() {
        legacyShape.display() // Adapting legacy display to new draw
    }
}
// Client code (main function)
fun main() {
    val rectangle = Rectangle()
    val square = Square()
    val legacySquare = LegacySquare()
    val legacyCircle = LegacyCircle()
    val legacyTriangle = LegacyTriangle()

    val shapeAdapter1 = ShapeAdapter(legacySquare)
    val shapeAdapter2 = ShapeAdapter(legacyCircle)
    val shapeAdapter3 = ShapeAdapter(legacyTriangle)

    rectangle.draw()
    square.draw()
    legacySquare.display()
    legacyCircle.display()
    legacyTriangle.display()
    legacyTriangle.display()

    shapeAdapter1.draw() // Using the adapter
    shapeAdapter2.draw()
    shapeAdapter3.draw()
}