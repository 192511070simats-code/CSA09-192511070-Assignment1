# Task 7 — Override and Specialise Behaviour



## 1. Method Overriding



The `calculateFee()` method is overridden in subclasses because different vehicle types may have different parking fee rules. Each subclass provides its own implementation.



The `@Override` annotation tells the compiler that a method is intended to override a superclass method. The method must have the same signature and a compatible return type. Its access level cannot be more restrictive than the superclass method.



## 2. Use of final



- A `final` variable cannot be reassigned after initialization.

- A `final` method cannot be overridden by subclasses.

- A `final` class cannot be extended.



These restrictions help protect values and behaviour that should not change.



## 3. Object Methods



`toString()` returns a readable description of a vehicle.



`equals()` compares two vehicles using their registration numbers. If the registration numbers match, the vehicles are considered equal.



`hashCode()` returns a hash value based on the registration number. Equal vehicles must have the same hash code.



## 4. Alternative Concept and Complexity Analysis



Instead of overriding `calculateFee()`, one method could use a `switch` statement on a vehicle-type field to select the fee rule.



With k vehicle types, a switch-based calculation takes O(1) time when the number of cases is fixed or each case takes constant time. The overriding approach also generally takes O(1) time per fee calculation when each implementation performs constant-time work.



With overriding, adding a new type usually requires a new subclass. With a switch-based design, the central calculation method must also be modified when a new type is added. Other changes may be needed depending on how vehicle types are represented.



Overriding keeps each vehicle type's behaviour within its own class, while a switch centralizes fee logic.

