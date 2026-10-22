\# Task 8 — Apply Polymorphism



\## 1. Compile-Time Polymorphism



Method overloading allows methods to have the same name but different parameter lists. The `calculateFee(int minutes)` and `calculateFee(LocalTime in, LocalTime out)` methods demonstrate overloading. The compiler selects the method based on the arguments supplied.



\## 2. Runtime Polymorphism



A `Vehicle\[]` array can store references to `TwoWheeler`, `Car`, and `ElectricCar` objects through upcasting.



When `v.calculateFee(130)` is called, Java uses dynamic method dispatch. The declared reference type is `Vehicle`, while the actual object may be `TwoWheeler`, `Car`, or `ElectricCar`. The overridden `ratePerHour()` method belonging to the actual object is executed.



For example, when `v` refers to a `Car`, `ratePerHour()` returns ₹30. Since 130 minutes counts as 3 started hours, the parking fee is ₹90.



\## 3. Expected Output



```text

TwoWheeler TN01A1 -> Rs 30.0

Car TN02B2 -> Rs 90.0

ElectricCar TN03C3 -> Rs 210.0

true

```



The electric car pays ₹90 for parking and ₹120 for charging 10 kWh, giving ₹210 total.



\## 4. Equality Behaviour



The last line prints `true` because `equals()` compares registration numbers. Both objects have registration number `TN02B2`, even though one is a `Car` and the other is an `ElectricCar`.



This behaviour is correct if registration number alone defines vehicle identity in the system. If vehicle category must be part of identity, the equality rule should be changed.



\## 5. Alternative and Complexity Analysis



An alternative is to use `instanceof` checks and casting for each vehicle type. With `k` vehicle types, this approach may require up to `k` checks, giving O(k) dispatch time in the worst case. Dynamic method dispatch selects the appropriate overridden method directly, giving O(1) dispatch overhead.



Overriding keeps type-specific behaviour in separate classes. A long conditional chain grows as new vehicle types are added and is harder to maintain.

