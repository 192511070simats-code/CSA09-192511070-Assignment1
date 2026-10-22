\# Task 9 — Introduce Abstraction



\## 1. Abstract Class



`Vehicle` is an abstract class because all vehicles share common data, such as registration number, and common behaviour. The `ratePerHour()` method is abstract because each vehicle type defines its own parking rate.



An abstract class can contain fields, constructors, concrete methods, and abstract methods.



\## 2. Interface



`Chargeable` is an interface representing the charging capability. Electric vehicles can implement it and provide their own `chargingFee()` implementation.



\## 3. Why Use Both?



An abstract class is suitable for shared state and common implementation. An interface is suitable for defining a capability that different classes can implement.



A class can implement multiple interfaces, allowing it to obtain multiple behaviours without inheriting from multiple classes.



\## 4. Default and Static Interface Methods



A default method is useful when all implementing classes can share a standard implementation. A static method is useful for a utility operation related to the interface that can be called using the interface name.



\## 5. Alternative Design and Complexity Analysis



If `Vehicle` became an interface with default methods, it could define behaviour but could not use an ordinary instance constructor to initialize shared instance state in the same way as an abstract class. Each implementing class would need to manage its own registration-number field.



If `Chargeable` became an abstract class, a class could not extend both `Vehicle` and `Chargeable`, because Java allows a class to extend only one class. This would restrict combining vehicle identity and charging capability through inheritance.



Both designs can provide constant-time method calls when their implementations perform constant work. Changing between them does not automatically change the time complexity. Per-object space depends on the instance fields stored by the concrete class; interfaces themselves do not add a separate object for each implemented capability.



\## Conclusion



The abstract `Vehicle` class represents shared vehicle state and behaviour, while the `Chargeable` interface represents an optional capability. This design improves reuse, flexibility, and maintainability.

