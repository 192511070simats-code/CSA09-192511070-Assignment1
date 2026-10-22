# Task 6 — Design the Inheritance Hierarchy



## 1. Superclass and Subclasses



The `Vehicle` class is the superclass containing common fields and methods such as vehicle number, displaying vehicle details, and calculating parking fees.



The subclasses are:

- `Car` — inherits common vehicle details and adds car-specific information.

- `ElectricCar` — inherits from `Car` and adds battery capacity.



This uses hierarchical inheritance when multiple classes extend `Vehicle`, and multilevel inheritance for `Vehicle → Car → ElectricCar`.



## 2. Inherited and Additional Members



`Car` inherits the fields and methods of `Vehicle` and adds its own car-related information. `ElectricCar` inherits members from both `Car` and `Vehicle` and adds battery capacity. Constructors are not inherited; each subclass defines its own constructor.



## 3. Use of super



The `super` keyword calls a superclass constructor, accesses superclass methods, and refers to superclass members when needed. Using `super(...)` avoids repeating common initialization code.



## 4. Constructor Execution Trace



When an `ElectricCar` object is created, constructors execute in this order:



1. `Vehicle` constructor

2. `Car` constructor

3. `ElectricCar` constructor



The superclass constructor runs before the subclass constructor.



## 5. UML Class Diagram



```text

       Vehicle

          |

          v

         Car

          |

          v

     ElectricCar

```



## 6. Alternative Concept: Composition



With composition, a single `Vehicle` class can contain a `VehicleType` object that stores the vehicle type and parking rate.



Adding a new type through inheritance may require a new subclass. With composition, a new type can often be added by creating another `VehicleType` object, without creating a new subclass.



If fee calculation takes constant time, fee calculation is O(1) in both designs. Each vehicle uses O(1) space for a fixed set of fields. Composition also stores a reference to a `VehicleType` object; shared type objects can reduce duplicated rate data. Inheritance is suitable when types have different behaviours, while composition is flexible when types mainly differ by data such as rates.

