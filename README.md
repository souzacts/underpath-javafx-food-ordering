# underpath-javafx-food-ordering
JavaFX desktop app for building customizable subs and milkshakes, managing in-memory orders, and calculating subtotal, tax, delivery fee, and total through a GUI.

# Underpath

Underpath is a JavaFX desktop application for building a simple food order through a graphical interface. The app lets the user create custom **subs** and **milkshakes**, add them to an order, and view a running order summary with subtotal, tax, delivery fee, and final total.

## Features

- JavaFX GUI built with **FXML**
- Build-to-order subs and shakes using dropdown selections
- Calculates item prices based on size and selected options
- Maintains an in-memory order with multiple items
- Displays an itemized order summary
- Uses popup dialogs to confirm added items and completed orders

## Project Structure

```text
Underpath/
├── src/
│   ├── App.java
│   ├── Controller.java
│   ├── MainScene.fxml
│   ├── Item.java
│   ├── Order.java
│   ├── Sub.java
│   ├── Shake.java
│   └── AlertBox.java
├── bin/
└── .vscode/
```

## Main Components

- **App.java**: launches the JavaFX application and loads the main FXML scene.
- **Controller.java**: handles GUI events, initializes choice boxes, and adds items to the order.
- **Item.java**: abstract base class for menu items.
- **Sub.java**: models customizable sub orders with size, bread, meat, and topping options.
- **Shake.java**: models customizable milkshake orders with size, flavor, and topping options.
- **Order.java**: stores all ordered items and computes subtotal, tax, delivery fee, and total.
- **AlertBox.java**: reusable popup window for confirmations and messages.
- **MainScene.fxml**: JavaFX layout for the ordering interface.

## Concepts Used

- Object-oriented design
- Inheritance and abstract classes
- Enums for menu options and pricing
- JavaFX event-driven programming
- FXML-based UI design
- Collections for order storage

## Running the Project

This project uses **JavaFX**, so it should be opened in an IDE configured for JavaFX support, such as:

- IntelliJ IDEA
- Eclipse
- VS Code with Java extensions and JavaFX configured

General steps:

1. Open the project folder.
2. Make sure Java and JavaFX are installed and configured.
3. Run `App.java`.

## Notes

- The order is stored only while the program is running.
- The application currently focuses on the ordering flow and total calculation.
- Compiled `.class` files are included in `bin/`.



## Author

Created as a Java project demonstrating GUI development, object-oriented programming, and simple order-processing logic.
