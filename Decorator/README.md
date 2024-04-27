# Decorator Design Pattern: Housing Market Example

### Introduction

The Decorator pattern is a structural design pattern that allows for the dynamic attachment of new behaviors or features to existing objects. It provides a flexible alternative to subclassing when it comes to extending functionality.  In the context of the housing market, the Decorator pattern elegantly models the process of a buyer selecting a base house model and then customizing it with various upgrades or amenities.

### Class Diagram

Let's first examine the class diagram representing the core relationships within this implementation:

### Class Diagram

```mermaid
classDiagram
    Home <|.. BasicHome : implements
    Home <|.. AdvancedHome : implements
    Home <|.. Luxury : implements
    Luxury <|.. Playground : implements
    Luxury <|.. SwimmingPool : implements
    Playground o-- Home : decorates
    SwimmingPool o-- Home : decorates
    class Home {
        +build(): String
        +cost(): Int
    }
    class BasicHome {
        +build(): String
        +cost(): Int
    }
    class AdvancedHome {
        +build(): String
        +cost(): Int
    }
    class Luxury {
        +addLuxury(): String
    }
    class Playground {
        -home: Home
        +build(): String
        +cost(): Int
        +addLuxury(): String
    }
    class SwimmingPool {
        -home: Home
        +build(): String
        +cost(): Int
        +addLuxury(): String
    }
```

### Explanation:

- Home: The foundational interface, defining core house actions (build(), cost()).
- BasicHome and AdvancedHome: Concrete house types offering different base options.
- Luxury:  Base interface for potential upgrades.
- Playground and SwimmingPool:  Specific decorators enhancing a house.
- Decorators hold a reference ('home') to the object they decorate.

---

### Sequence Diagram

```mermaid

sequenceDiagram

    participant Buyer as Buyer
    participant BasicHome as BasicHome
    participant AdvancedHome as AdvancedHome
    participant Playground as Playground
    participant SwimmingPool as SwimmingPool

    Buyer->>+BasicHome: Select BasicHome
    BasicHome-->>Buyer: Return BasicHome instance
    Buyer->>+AdvancedHome: Select AdvancedHome
    AdvancedHome-->>Buyer: Return AdvancedHome instance
    Buyer->>+Playground: Decorate with Playground
    Playground->>BasicHome: build()
    Playground-->>Buyer: Return Playground instance
    Buyer->>+SwimmingPool: Decorate with SwimmingPool
    SwimmingPool->>Playground: build()
    SwimmingPool-->>Buyer: Return SwimmingPool instance
```

### Explanation:

- Base Selection: The buyer selects either a BasicHome or AdvancedHome.
- Customization: The buyer can then dynamically decorate the base house with Playground and/or SwimmingPool objects.
- Delegation:  Calls to build() on the top-level decorator propagate through the chain, enabling each decorator to contribute to the final description.


