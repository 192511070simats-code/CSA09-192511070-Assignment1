# Task 4 — Design Classes, Objects and Constructors



## 1. Class Fields and Methods



- Vehicle: Stores vehicle number and type. Methods can display vehicle details.

- ParkingSlot: Stores slot number and the parked vehicle. Methods can park or remove a vehicle.

- ParkingFloor: Stores and manages the slots on one floor.

- ParkingLot: Manages floors, vehicle allocation and parking availability.

- ParkingTicket: Stores ticket number, vehicle number and entry time.

- MonthlyPass: Stores pass details and validity dates.



Each class has a specific responsibility, making the system easier to maintain and extend.



## 2. Constructors, this and Constructor Chaining



A default constructor initializes an object without arguments. A parameterized constructor accepts values during object creation. Constructor overloading allows multiple constructors with different parameter lists.



The `this` keyword refers to the current object. It distinguishes object fields from parameters with the same name. Constructor chaining uses `this(...)` to call another constructor in the same class and avoid repeated initialization code.



## 3. Copy Constructor



A copy constructor creates a new object using the values of an existing object. It can be useful when preparing a duplicate ticket, but the duplicate should receive a new unique ticket number. The original ticket must remain unchanged.



## 4. Object Memory



A reference variable refers to an object. Objects created using `new` are generally stored in heap memory, while local reference variables are typically stored in a method's stack frame. Multiple references can refer to the same object.



## 5. Alternative Approaches and Complexity



With a default constructor followed by setter calls, an object may temporarily contain incomplete or invalid values. Validation in

