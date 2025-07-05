 # Fawry E-commerce Console Java Application

A comprehensive Java console application implementing an e-commerce system with shopping cart functionality, product management, and checkout processing. This project was developed as part of the Fawry internship selection process.

## 🚀 Features

- **Product Management**: Support for different product types (Perishable, Electronics, Digital)
- **Shopping Cart**: Add, remove, and manage products with quantities
- **Checkout System**: Complete checkout process with balance validation
- **Shipping Services**: Automatic shipping calculation for physical products
- **Inventory Management**: Stock tracking and validation
- **Expiration Handling**: Automatic detection and rejection of expired products
- **Error Handling**: Comprehensive error handling for various scenarios

## 📋 Product Types

### Perishable Products
- Implements `Shippable` and `Expirable` interfaces
- Has weight and expiration date
- Examples: Cheese, Biscuits

### Electronics Products
- Implements `Shippable` interface
- Has weight for shipping calculations
- Examples: TV, Laptop

### Digital Products
- No shipping required
- Instant delivery
- Examples: Scratch Cards, Software

## 🏗️ Architecture

The application follows object-oriented design principles with clear separation of concerns:

```
src/
├── App.java                 # Main application with demo scenarios
├── Shippable.java          # Interface for shippable items
├── Expirable.java          # Interface for expirable items
├── Product.java            # Abstract base class for all products
├── PerishableProduct.java  # Concrete product class
├── ElectronicsProduct.java # Concrete product class
├── DigitalProduct.java     # Concrete product class
├── Customer.java           # Customer management
├── ShoppingCart.java       # Shopping cart functionality
├── ShippableItem.java      # Shipping item wrapper
├── ShippingService.java    # Shipping processing
└── CheckoutService.java    # Checkout processing
```


## 📊 Demo Scenarios

The application includes 6 comprehensive demo scenarios that showcase different functionalities:

### Demo 1: Successful Checkout
```
===== demo 1 Expected Output: {successful checkout} =====

** Shipment notice **
2x cheese          400g
1x biscuits        700g
Total package weight 1.1kg

** Checkout receipt **
2x cheese          200
1x biscuits        150
------------------------
Subtotal        350
Shipping        11
Amount          361
------------------------
Payment successful. Youssef Mohamed's new balance is 9639.00.

========================================================
```

### Demo 2: Cart with Non-Shippable and Shippable Items
```
===== demo 2 Expected Output: {cart with non-shippable and shippable items} =====
Initial TV stock: 5

** Shipment notice **
1x TV              8000g
Total package weight 8.0kg

** Checkout receipt **
1x TV              5000
3x scratch card    150
------------------------
Subtotal        5150
Shipping        80
Amount          5230
------------------------
Payment successful. Youssef Mohamed's new balance is 4409.00.
Final TV stock: 4

========================================================
```

### Demo 3: Error - Insufficient Balance
```
===== demo 3 Expected Output: {ERROR - insufficient balance} =====
customer balance before trying: 4409.00
Checkout Error: Insufficient customer balance.

========================================================
```

### Demo 4: Error - Out of Stock
```
===== demo 4 Expected Output: {ERROR - out of stock} =====
available cheese: 8
Checkout Error: Product cheese is out of stock.

========================================================
```

### Demo 5: Error - Expired Item
```
===== demo 5 Expected Output: {ERROR - expired item} =====
Checkout Error: Product old cheese is expired.

========================================================
```

### Demo 6: Error - Empty Cart
```
===== demo 6 Expected Output: {ERROR - empty cart} =====
Checkout Error: Cart is empty.

========================================================
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Youssef Mohamed**

---

*Developed as part of Fawry internship selection process*