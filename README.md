# Design Pattern Use Cases and Mars Rover Programming

This repository demonstrates various design patterns in Java, including Behavioral, Creational, and Structural patterns. Additionally, it includes a Mars Rover simulation exercise using the Command and Composite design patterns. Each section contains use cases with explanations and instructions to run the code.

## Behavioral Design Patterns

### 1. **Strategy Pattern**
The Strategy Pattern enables selecting an algorithm at runtime. This pattern is useful when you have multiple ways to perform an operation, and you want the ability to change the behavior dynamically.

#### **Use Case:** 
In this example, different payment strategies (e.g., credit card, PayPal) are implemented. The `PaymentContext` class dynamically switches between these strategies.

#### **Code to Run:**
```bash
cd '.\Behavioral Design Patterns\' 
cd '.\Strategy Pattern\'
javac StrategyPatternDemo.java
java StrategyPatternDemo
```

### 2. **Observer Pattern**
The Observer Pattern defines a one-to-many dependency, so when one object changes state, all its dependents are notified and updated automatically. This pattern is useful in implementing event handling systems.

#### **Use Case:** 
A stock market price change notification system where multiple observers (clients) are notified whenever the stock price changes.

#### **Code to Run:**
```bash
cd '.\Behavioral Design Patterns\' 
cd '.\Observer Pattern\'
javac ObserverPatternDemo.java
java ObserverPatternDemo
```

## Creational Design Patterns

### 1. **Singleton Pattern**
The Singleton Pattern restricts a class to have only one instance and provides a global point of access to it. This pattern is beneficial when managing shared resources like a configuration object.

#### **Use Case:** 
In this example, a database connection manager is implemented as a Singleton, ensuring that only one instance of the connection manager exists in the system.

#### **Code to Run:**
```bash
cd '.\Creational Design Patterns\' 
cd '.\Singleton Pattern\'
javac SingletonPatternDemo.java
java SingletonPatternDemo
```

### 2. **Builder Pattern**
The Builder Pattern helps in constructing complex objects step-by-step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

#### **Use Case:** 
A meal ordering system where the customer can build custom meal orders by specifying items, quantities, and extras.

#### **Code to Run:**
```bash
cd '.\Creational Design Patterns\' 
cd '.\Builder Pattern\'
javac BuilderPatternDemo.java
java BuilderPatternDemo
```

## Structural Design Patterns

### 1. **Decorator Pattern**
The Decorator Pattern allows behavior to be added to individual objects, dynamically, without affecting the behavior of other objects from the same class. It is useful for extending functionalities in a flexible and reusable way.

#### **Use Case:** 
A coffee ordering system where various add-ons like milk, sugar, and cream can be added dynamically to a basic coffee.

#### **Code to Run:**
```bash
cd '.\Structural Design Patterns\' 
cd '.\Decorator Pattern\'
javac DecoratorPatternDemo.java
java DecoratorPatternDemo
```

### 2. **Facade Pattern**
The Facade Pattern provides a simplified interface to a complex subsystem, making it easier for the client to interact with it. This pattern is useful for hiding complexity and providing an easy-to-use interface.

#### **Use Case:** 
A home theater system where the Facade class simplifies the interaction with the system's various components like the DVD player, projector, and sound system.

#### **Code to Run:**
```bash
cd '.\Structural Design Patterns\' 
cd '.\Facade Pattern\'
javac FacadePatternDemo.java
java FacadePatternDemo
```

## Mars Rover Programming Exercise

This simulation involves a Mars Rover navigating a grid-based terrain, using the **Command Pattern** to encapsulate its commands (`M`, `L`, `R`), and the **Composite Pattern** to represent the grid with obstacles. The Rover avoids obstacles and remains within the boundaries of the grid.

### Problem Statement:
1. The Rover starts at a given position on a grid with specified dimensions.
2. It can move forward, turn left, and turn right based on commands.
3. It avoids obstacles on the grid and stays within the grid boundaries.
4. The solution implements pure Object-Oriented Programming, using design patterns and avoiding `if-else` constructs.
5. Includes an optional status report feature that displays the rover's current position and facing direction.

### Features:
* **Behavioral Pattern**: The **Command Pattern** is used to encapsulate the commands `M` (move), `L` (turn left), and `R` (turn right).
* **Structural Pattern**: The **Composite Pattern** represents the grid and its obstacles.
* **Object-Oriented Principles**: Encapsulation, inheritance, and polymorphism are heavily utilized.
* The grid and obstacles can be defined dynamically.
* The rover detects and reports obstacles or grid boundaries to avoid collisions.

### Example Input:
* Grid Size: 10x10
* Initial Position: (0, 0) facing North
* Commands: `['M', 'M', 'R', 'M', 'L', 'M']`
* Obstacles: `[(2, 2), (3, 5)]`

### Example Output:
* Final Position: `(1, 3, E)`
* Status Report: "Rover is at (1, 3) facing East. No Obstacles detected."

### Code to Run:
```bash
cd '.\Mars Rover Programming\' 
javac MarsRoverSimulator.java
java MarsRoverSimulator
```

## Project Structure:
* **`Behavioral/`**: Contains use cases for behavioral design patterns like Strategy and Observer.
* **`Creational/`**: Contains use cases for creational design patterns like Singleton and Builder.
* **`Structural/`**: Contains use cases for structural design patterns like Decorator and Facade.
* **`MarsRover/`**: Contains the Mars Rover simulation code implementing the Command and Composite patterns.


## Conclusion:
This repository provides a practical demonstration of common design patterns in Java. It also showcases how to implement a real-world problem (Mars Rover simulation) using Object-Oriented principles and design patterns. Each pattern example comes with a use case, making it easier to understand its implementation and use.
