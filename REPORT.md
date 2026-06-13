# Project Report: Simple Text Editor

## 1. Introduction
The **Simple Text Editor** is a Java-based terminal application designed to perform standard text editing tasks efficiently. The core engine relies on Java's mutable string handling capabilities to simulate a lightweight document buffer.

## 2. Architecture & Design Choices
* **`StringBuffer` over `String`**: Standard Java strings are immutable. For a text editor where data changes frequently, using `String` would create multiple objects in memory, reducing performance. `StringBuffer` was chosen because it is mutable and provides built-in methods like `append()`, `reverse()`, and `delete()`.
* **Menu-Driven CLI**: A simple `do-while` loop combined with a `switch-case` block ensures a seamless user experience, continuously asking for input until the user chooses to exit.

## 3. Implementation Details
* **Error Handling**: In the `deleteText(int start, int end)` method, strict boundary checks are implemented to ensure the user doesn't pass negative indices or ranges exceeding the current text length, preventing `StringIndexOutOfBoundsException`.
* **Resource Management**: The `Scanner` object is safely closed upon exiting the program to prevent resource leaks.

## 4. Conclusion
The project successfully achieves its objective of demonstrating string manipulation in Java. Future scopes include adding an "Undo/Redo" feature using Stacks and integrating a Graphical User Interface (GUI).