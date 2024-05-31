[![Test Design Patterns](https://github.com/dellius-alexander/Design-Patterns/actions/workflows/build-and-test.yml/badge.svg?branch=main)](https://github.com/dellius-alexander/Design-Patterns/actions/workflows/build-and-test.yml)

# Design Patterns Project

---

This project is a collection of implementations of various design patterns in Kotlin and Java. Each design pattern is implemented in its own module, and each module contains a README.md file that provides a detailed explanation of the design pattern and its implementation.

The Gang of Four (GoF) discussed 23 design patterns. Each of these patterns focuses on a particular object-oriented design principle and describes the consequences and trade-offs of its use. The GoF categorized these 23 patterns based on their purposes, as shown here:

## Creational Patterns

These patterns abstract the instantiation process. They make the systems independent from how their objects are composed, created, and represented. In these patterns, you should have a basic concern: “Where should I place the ‘new’ keyword in my application?” This decision can determine the degree of coupling of your classes. The following five patterns belong to this category:

- [Singleton Design Pattern](#Singleton-Design-Pattern)
- [Prototype Design Pattern](#Prototype-Design-Pattern)
- [Factory Design Pattern](#Factory-Design-Pattern)
- [Builder Design Pattern](#Builder-Design-Pattern)
- Abstract Factory Pattern

## Structural Patterns

Here you focus on how classes and objects can be composed to form a relatively large structure. They generally use inheritance or composition to group different interfaces or implementations. Your choice of composition over inheritance (and vice versa) can affect the flexibility of your software. The following seven patterns fall into this category:

- [Proxy Design Pattern](#Proxy-Design-Pattern)
- [Flyweight Design Pattern](#Flyweight-Design-Pattern)
- Composite Pattern
- Bridge Pattern
- [Facade Design Pattern](#Facade-Design-Pattern)
- [Decorator Design Pattern](#Decorator-Design-Pattern)
- [Adapter Design Pattern](#Adapter-Design-Pattern)

## Behavioral Patterns

Here you concentrate on algorithms and the assignment of responsibilities among objects. You also need to focus on the communication between them and how the objects are interconnected. The following eleven patterns fall into this category:

- Observer Pattern
- Strategy Pattern
- Template Method Pattern
- Command Pattern
- Iterator Pattern
- Memento Pattern
- State Pattern
- Mediator Pattern
- Chain of Responsibility Pattern
- Visitor Pattern
- Interpreter Pattern

The GoF made another classification based on scope. It examines whether the pattern primarily focuses on the classes or its objects. Class patterns deal with classes and subclasses. They use inheritance mechanisms, so they are static and fixed at compile time. Object patterns deal with objects that can change at run time. So, object patterns are dynamic.

---

## Table of Contents

- [Factory Design Pattern](#Factory-Design-Pattern)
- [Prototype Design Pattern](#Prototype-Design-Pattern)
- [Builder Design Pattern](#Builder-Design-Pattern)
- [Singleton Design Pattern](#Singleton-Design-Pattern)
- [Decorator Design Pattern](#Decorator-Design-Pattern)
- [Proxy Design Pattern](#Proxy-Design-Pattern)
- [Flyweight Design Pattern](#Flyweight-Design-Pattern)
- [Facade Design Pattern](#Facade-Design-Pattern)
- [Adapter Design Pattern](#Adapter-Design-Pattern)

---

<!-- Existing content -->

## <h2 name="Factory-Design-Pattern" id="Factory-Design-Pattern">Factory Design Pattern</h2>

The Factory design pattern is a creational design pattern that provides an interface for
creating objects in a superclass, but allows subclasses to alter the type of objects
that will be created. This pattern is particularly useful when a class cannot anticipate
the class of objects it needs to create.

For more details, please refer to the [Factory README.md](Factory/README.md).

## <h2 name="Prototype-Design-Pattern" id="Prototype-Design-Pattern">Prototype Design Pattern</h2>

The Prototype design pattern is a creational design pattern that allows an object to
create a clone of itself. This pattern is particularly useful when the creation of a
new object is costly and you want to avoid the cost of creation when you need a duplicate
object.

For more details, please refer to the [Prototype README.md](Prototype/README.md).

## <h2 name="Builder-Design-Pattern" id="Builder-Design-Pattern">Builder Design Pattern</h2>

The Builder design pattern is a creational design pattern that allows for the step-by-step
creation of complex objects using the correct sequence of actions. The construction is
controlled by a director object that only needs to know the type of object it is to create.

For more details, please refer to the [Builder README.md](Builder/README.md).

## <h2 name="Singleton-Design-Pattern" id="Singleton-Design-Pattern">Singleton Design Pattern</h2>

The Singleton design pattern is a creational design pattern that ensures a class has
only one instance, and provides a global point of access to it. This pattern is
particularly useful when exactly one instance of a class is required to control actions.

For more details, please refer to the [Singleton README.md](Singleton/README.md).

## <h2 name="Decorator-Design-Pattern" id="Decorator-Design-Pattern">Decorator Design Pattern</h2>

The Decorator design pattern is a structural design pattern that allows for the dynamic attachment of new behaviors or features to existing objects. It provides a flexible alternative to subclassing when it comes to extending functionality.

For more details, please refer to the [Decorator README.md](Decorator/README.md).

## <h2 name="Proxy-Design-Pattern" id="Proxy-Design-Pattern">Proxy Design Pattern</h2>

The Proxy pattern provides a surrogate or placeholder for another object to control access to it. This pattern involves a single class which represents the functionality of another class.

For more details, please refer to the [Proxy README.md](Proxy/README.md).

## <h2 name="Flyweight-Design-Pattern" id="Flyweight-Design-Pattern">Flyweight Design Pattern</h2>

Flyweight is a structural design pattern that allows objects with incompatible interfaces to collaborate. In other words, it transforms or converts the interface of a class into another interface that a client expects.

For more details, please refer to the [Flyweight README.md](Flyweight/README.md).

## <h2 name="Facade-Design-Pattern" id="Facade-Design-Pattern">Facade Design Pattern</h2>

The Facade design pattern provides a simplified interface to a complex subsystem. It involves a single class that provides simplified methods required by client and delegates calls to methods of existing system classes.

For more details, please refer to the [Facade README.md](Facade/README.md).

## <h2 name="Adapter-Design-Pattern" id="Adapter-Design-Pattern">Adapter Design Pattern</h2>

Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate. It transforms or converts the interface of a class into another interface that a client expects.

For more details, please refer to the [Adapter README.md](Adapter/README.md).