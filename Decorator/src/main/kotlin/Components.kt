package org.example

// The Component interface
interface Component {
    fun operation(): String
}

// Concrete Component
class ConcreteComponent : Component {
    override fun operation(): String = "ConcreteComponent"
}

// The Decorator base class (holding a reference to a Component)
abstract class Decorator(protected val component: Component) : Component {
    override fun operation(): String = component.operation()
}

// Concrete Decorators
class DecoratorA(component: Component) : Decorator(component) {
    override fun operation(): String = "DecoratorA(${super.operation()})"
}

class DecoratorB(component: Component) : Decorator(component) {
    override fun operation(): String = "DecoratorB(${super.operation()})"
}

fun main() {
    val component: Component = ConcreteComponent()

    // Base functionality
    println(component.operation())  // Output: ConcreteComponent

    // Dynamically adding behavior with DecoratorA
    val decoratedComponent1: Component =  DecoratorA(component)
    println(decoratedComponent1.operation())
    // Output: DecoratorA(ConcreteComponent)

    // Adding more behavior with DecoratorB
    val decoratedComponent2: Component = DecoratorB(decoratedComponent1)
    println(decoratedComponent2.operation())
    // Output: DecoratorB(DecoratorA(ConcreteComponent))
}
