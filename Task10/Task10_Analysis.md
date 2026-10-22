# Task 10 — Enforce Encapsulation through Packages and Access Modifiers



## 1. Package Structure



The system can be organised into these packages:



- `parking.model` — stores model classes such as `ParkingSlot`.

- `parking.service` — contains parking-related operations.

- `parking.app` — contains the main application.



Packages organise code and improve maintainability.



## 2. Access Modifiers



- `private`: protects fields from direct external access.

- Default (package-private): allows access within the same package.

- `protected`: allows access within the package and through inheritance.

- `public`: allows access from other packages when the class is accessible.



Fields should generally be private, with public methods used to access or update them safely.



## 3. Getters, Setters and Validation



Getters return field values. Setters validate incoming values before updating fields. For example, a negative parking duration or invalid slot number should be rejected. This prevents an object from entering an invalid state.



## 4. Wrapper Classes and Autoboxing



Wrapper classes, such as `Integer`, represent primitive values as objects. Autoboxing converts a primitive `int` to an `Integer` automatically.



Using `==` to compare two `Integer` objects may compare references rather than numeric values. Use `.equals()` to compare their values.



## 5. Alternative Design and Complexity Analysis



If fields were public, calling code could change them without validation. Each caller would need to repeat the same checks, increasing duplication and the chance of errors.



A simple validation check takes O(1) time per update. With validation inside a setter, the check is centralised in one place. With public fields, the same check may need to be repeated across many calling locations.



## Conclusion



Packages organise classes, access modifiers control visibility, and private fields with validating setters protect object state.

