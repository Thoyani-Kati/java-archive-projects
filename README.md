# Java Projects Collection

A collection of Java projects developed while studying Computer Science and Information Technology.

The repository covers object-oriented programming, data structures and algorithms, file handling, GUI development, recursion, trees, graphs, and basic software system design.

---

## Projects

| Project | Description | Main Concepts |
|---|---|---|
| `BankManagement` | Console-based banking system | OOP, inheritance, file handling, transactions |
| `MyDataStructures` | Custom data structures and algorithms | Data structures, algorithms, recursion, generics |
| `TicTacToe` | Tic-Tac-Toe with console and GUI versions | OOP, Swing, event handling, game logic |
| `studentManagement` | Student and academic management system | OOP, file handling, user roles, data management |

---

# 1. Bank Management System

**Location:** `BankManagement/`

A Java banking application demonstrating object-oriented design and file-based data persistence.

## Features

- Bank account management
- Account inheritance
- Traditional and Shariah account types
- Interest-bearing accounts
- Transaction management
- File-based persistence
- Console-based interaction

## Main Classes

```text
BankAccount
├── TraditionalAccount
├── ShariahAccount
└── InterestBearingAccount

Transaction
Main
```

## Data Files

```text
accounts.txt
transact.txt
```

### Concepts Demonstrated

- Classes and objects
- Encapsulation
- Inheritance
- Polymorphism
- File handling
- Basic domain modelling

---

# 2. Data Structures and Algorithms

**Location:** `MyDataStructures/dataStructuresAndAlgo/`

This project contains implementations of common data structures and algorithms developed from scratch in Java.

## Linear Data Structures

Located in:

```text
src/dataStructuresAndAlgo/LinearDataStructures/
```

Includes implementations of:

- Singly linked lists
- Doubly linked lists
- Circular linked lists
- Stacks
- Queues
- Array-based stacks
- Array-based queues
- Priority queues
- Linked priority queues
- Sorted lists
- Sorting algorithms

## Non-Linear Data Structures

Located in:

```text
src/dataStructuresAndAlgo/non_LinearDataStructures/
```

Includes implementations involving:

- Binary trees
- Binary search trees
- AVL trees
- Red-Black trees
- Heaps
- Dynamic trees
- Directed acyclic graphs
- Undirected graphs
- Adjacency lists
- Vertices

## Tree Algorithms

The tree implementations include operations such as:

- Insertion
- Searching
- Deletion
- Tree traversal
- Height and depth calculations
- Minimum and maximum values
- Lowest common ancestor
- K-th smallest element
- Successor and predecessor


### Example Traversals

```text
In-order
Pre-order
Post-order
```

### Concepts Demonstrated

- Generics
- Recursion
- Abstract data structures
- Algorithm implementation
- Tree algorithms
- Graph structures
- Searching
- Sorting
- Dynamic data structures

---

# 3. Tic-Tac-Toe

**Location:** `TicTacToe/`

A Tic-Tac-Toe implementation developed in two versions to explore the progression from console-based interaction to a graphical user interface.

## Version 1

**Location:**

```text
TicTacToe/Version1/
```

Console-based implementation featuring:

- Configurable board size
- Player input
- Input validation
- Win detection
- Draw detection
- Game flow management

### Main Classes

```text
Main
Playing
gameboard
```

## Version 2

**Location:**

```text
TicTacToe/Version2/
```

A Java Swing GUI implementation.

Features include:

- Graphical game board
- Mouse interaction
- Configurable board size
- Win detection
- Draw detection
- Winning-line visualisation
- GUI dialogs

### Main Classes

```text
Main
Gameboard
GameBoardData
Square
```

### Concepts Demonstrated

- Object-oriented programming
- Java Swing
- Event handling
- User input
- GUI development
- Game logic
- State management

---

# 4. Student Management System

**Location:** `studentManagement/`

A Java-based student management application demonstrating object-oriented programming and file-based data management.

## Main Components

```text
User
├── Admin
└── Student

studentManagementSystem
```

## Features

- Student management
- User management
- Administrative functionality
- Module management
- Academic records
- Test records
- File-based data storage
- Registration data management

## Data Files

The project uses text files to store application data, including:

```text
Students.txt
Admins.txt
Modules.txt
COMP102.txt
COMP107.txt
ISTN103.txt
MATH140.txt
```

Additional registration and assessment files are included as part of the project data.

### Concepts Demonstrated

- Object-oriented programming
- Classes and inheritance
- Encapsulation
- File handling
- Data persistence
- User roles
- Basic system modelling

---

# Repository Structure

```text
Java Projects
│
├── BankManagement
│   ├── src
│   │   └── banking
│   ├── accounts.txt
│   └── transact.txt
│
├── MyDataStructures
│   └── dataStructuresAndAlgo
│       └── src
│           └── dataStructuresAndAlgo
│               ├── LinearDataStructures
│               └── non_LinearDataStructures
│
├── TicTacToe
│   ├── Version1
│   └── Version2
│
└── studentManagement
    ├── src
    ├── images
    └── data files
```

---

# Technical Focus

This repository provides practical implementations and experiments with:

- Java
- Object-oriented programming
- Inheritance
- Polymorphism
- Encapsulation
- Generics
- Recursion
- Data structures
- Algorithms
- Searching
- Sorting
- Trees
- Graphs
- File handling
- Data persistence
- Java Swing
- Event-driven programming
- Basic software design

---

# Purpose

These projects were developed as part of my progression through Computer Science and Information Technology.

The repository demonstrates the transition from learning individual programming concepts to building complete applications and implementing fundamental computer science structures and algorithms.

The projects focus particularly on understanding **how software works internally**, rather than relying entirely on existing abstractions.

---

# Development Environment

The projects were primarily developed using:

```text
Language: Java
IDE: Eclipse / IntelliJ IDEA
Build approach: Individual Java projects
Data storage: Local text files
GUI: Java Swing
```

---

# Project Status

These projects represent academic, learning, and experimental software projects developed throughout my studies.

They are maintained primarily as a record of my development as a Java developer and as a reference for the concepts and implementations explored during my Computer Science studies.

---

# Author

**Thoyani Kati**

---
