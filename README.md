# Design Patterns Project

---

This project is a collection of implementations of various design patterns in Kotlin and Java. Each design pattern is implemented in its own module, and each module contains a README.md file that provides a detailed explanation of the design pattern and its implementation.  

## Table of Contents

- [Factory Design Pattern](#Factory-Design-Pattern)
- [Prototype Design Pattern](#Prototype-Design-Pattern)
- [Builder Design Pattern](#Builder-Design-Pattern)
- [Singleton Design Pattern](#Singleton-Design-Pattern)

---

## <h2 name="Factory Design Pattern" id="Factory-Design-Pattern">Factory Design Pattern</h2>

The Factory design pattern is a creational design pattern that provides an interface for 
creating objects in a superclass, but allows subclasses to alter the type of objects 
that will be created. This pattern is particularly useful when a class cannot anticipate 
the class of objects it needs to create.  

For more details, please refer to the [Factory README.md](Factory/README.md).  

## <h2 name="Prototype Design Pattern" id="Prototype-Design-Pattern">Prototype Design Pattern</h2>

The Prototype design pattern is a creational design pattern that allows an object to 
create a clone of itself. This pattern is particularly useful when the creation of a 
new object is costly and you want to avoid the cost of creation when you need a duplicate 
object.  

For more details, please refer to the [Prototype README.md](Prototype/README.md).  

## <h2 name="Builder Design Pattern" id="Builder-Design-Pattern">Builder Design Pattern</h2>

The Builder design pattern is a creational design pattern that allows for the step-by-step 
creation of complex objects using the correct sequence of actions. The construction is 
controlled by a director object that only needs to know the type of object it is to create.  

For more details, please refer to the [Builder README.md](Builder/README.md).  

## <h2 name="Singleton Design Pattern" id="Singleton-Design-Pattern">Singleton Design Pattern</h2>

The Singleton design pattern is a creational design pattern that ensures a class has 
only one instance, and provides a global point of access to it. This pattern is 
particularly useful when exactly one instance of a class is required to control actions.  

For more details, please refer to the [Singleton README.md](Singleton/README.md).