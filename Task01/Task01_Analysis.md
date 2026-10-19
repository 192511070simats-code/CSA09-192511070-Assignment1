# Task 1 — Problem Analysis and Object-Oriented Design

## 1. Problem Statement

The Campus Smart-Parking System is designed to manage a university parking facility containing multiple floors and parking slots. It supports different vehicle categories, including two-wheelers, cars, and electric vehicles (EVs).

The system must allocate suitable parking slots, issue parking tickets, record entry and exit times, calculate parking fees, validate monthly passes, and manage EV charging charges. It must also update slot availability when vehicles enter or leave.

The design should use object-oriented programming principles so that the system is modular, maintainable, and easy to extend with new vehicle categories and pricing rules.

## 2. Functional Requirements

1. Manage multiple parking floors, each containing several numbered slots.
2. Store vehicle registration numbers and vehicle details.
3. Identify whether each parking slot is free or occupied.
4. Match vehicles with compatible parking slots.
5. Prefer suitable EV charging slots for EVs that require charging.
6. Allocate an available slot and issue a ticket with a unique ticket number.
7. Record vehicle entry and exit times.
8. Calculate parking duration and the applicable parking fee.
9. Validate student and staff monthly passes.
10. Allow free parking for eligible users with valid monthly passes.
11. Calculate EV charging charges separately from parking fees.
12. Display an appropriate message when no suitable slot is available.
13. Release the occupied slot when a vehicle exits.
14. Support different parking-facility configurations, such as 1 floor with 20 slots, 3 floors with 50 slots each, and 5 floors with 100 slots each.

## 3. Candidate Classes and Responsibilities

### 3.1 Vehicle

The `Vehicle` class represents an individual vehicle.

**Responsibilities:**
- Store the vehicle registration number.
- Store the vehicle category, such as two-wheeler, car, or EV.
- Store relevant vehicle details, including whether EV charging is required.

**Reason for using a class:** A vehicle contains multiple related attributes. Storing them together in an object is easier to manage than maintaining several parallel arrays.

### 3.2 ParkingSlot

The `ParkingSlot` class represents one individual parking space.

**Responsibilities:**
- Store the slot number and floor association.
- Identify the slot category or supported vehicle type.
- Store whether the slot is free or occupied.
- Indicate whether charging facilities are available.

**Reason for using a class:** Each slot has its own identity, type, and availability status. These properties must be managed independently.

### 3.3 ParkingFloor

The `ParkingFloor` class represents one floor of the parking facility.

**Responsibilities:**
- Manage the parking slots belonging to that floor.
- Check whether any suitable slot is available.
- Support searching for a free, compatible slot.
- Provide information about the floor's parking availability.

**Reason for using a class:** A floor groups multiple slots together. For example, a facility with three floors and 50 slots per floor contains 150 slots managed across three floors.

### 3.4 ParkingLot

The `ParkingLot` class represents the complete parking facility.

**Responsibilities:**
- Manage all parking floors.
- Coordinate slot allocation across floors.
- Check whether a suitable slot is available anywhere in the facility.
- Coordinate vehicle entry and exit operations.

**Reason for using a class:** The parking lot coordinates the overall system, while each floor and slot manages its own level of responsibility.

### 3.5 ParkingTicket

The `ParkingTicket` class represents one parking session.

**Responsibilities:**
- Store a unique ticket number.
- Associate the ticket with the relevant vehicle and assigned slot.
- Record entry and exit times.
- Support the calculation of the parking duration.
- Keep the details of each parking session separate.

**Reason for using a class:** The same vehicle may park multiple times. Each session needs its own ticket and timestamps so that its duration and fee can be calculated correctly.

### 3.6 ParkingFeeCalculator

The `ParkingFeeCalculator` class calculates parking charges.

**Responsibilities:**
- Apply the appropriate hourly rate for the vehicle category.
- Calculate the parking fee based on the parking duration.
- Apply the valid monthly-pass rule.
- Calculate EV charging charges separately.
- Support future changes to pricing rules.

**Reason for using a class:** Keeping pricing logic separate from ticket management makes it easier to change rates and introduce new pricing rules.

### 3.7 MonthlyPass

The `MonthlyPass` class represents a student's or staff member's monthly parking pass.

**Responsibilities:**
- Store the pass identifier.
- Store the start and expiry dates.
- Check whether the pass is valid for the relevant time.
- Provide the information needed to determine parking-fee eligibility.

**Reason for using a class:** Pass validity depends on more than a simple true-or-false value. Separate pass information makes validity checks and future changes easier to manage.

## 4. Business Rules

1. A vehicle can be assigned only to a free and compatible slot.
2. The system must consider the vehicle category and slot capabilities before allocation.
3. An EV requiring charging should be assigned a suitable charging slot when one is available.
4. If no suitable slot is available, the system must inform the driver instead of assigning an incompatible slot.
5. A vehicle's entry must be associated with a parking ticket.
6. The parking duration is determined from the entry and exit timestamps.
7. The parking fee is calculated using the applicable rate and duration.
8. A valid student or staff monthly pass qualifies its holder for free parking.
9. An expired or otherwise invalid pass does not qualify for free parking.
10. EV charging charges are calculated separately from parking fees.
11. When a vehicle exits, the system records the exit time, calculates the applicable charges, and releases the assigned slot.
12. Each parking ticket must identify its own parking session.

## 5. Assumptions

Some details are not fully specified in the problem statement. The following assumptions will be used unless the assignment provides a more specific rule.

### 5.1 Proportional billing

Parking fees are calculated proportionally to the actual parking duration.

For example, if the hourly rate is ₹30 and a vehicle parks for 1.5 hours:

Parking fee = ₹30 × 1.5 = ₹45.

### 5.2 Monthly-pass eligibility

A valid student or staff monthly pass makes the parking fee zero. EV charging charges remain payable when charging services are used.

### 5.3 Expired monthly passes

An expired pass is treated as invalid. The normal parking fee applies. The handling of a pass that expires during a parking session must be defined explicitly before implementation.

### 5.4 EV charging availability

An EV that requires charging should use a compatible charging slot. If none is available, the system may offer a regular slot if facility rules permit it. A regular slot does not provide charging services.

### 5.5 Slot compatibility

Vehicle dimensions and slot compatibility must be represented by explicit rules. The system must not assign a vehicle to a slot that cannot safely accommodate it.

### 5.6 Unique ticket numbers

Every parking session receives a unique ticket number. The chosen method for generating and preserving uniqueness will be determined during implementation.

### 5.7 Pricing rates

The actual rates for each vehicle category and EV charging are not specified here. The ₹30 hourly rate is an example used to explain proportional billing, not a confirmed rate for every vehicle category.

## 6. Alternative Design: Parallel Arrays

An alternative approach is to store vehicle information using separate arrays.

For example:

```text
registrationNumbers[] = vehicle registration numbers
vehicleTypes[]        = vehicle categories
needsCharging[]       = charging requirements
```

### Advantages

- Simple to understand for small datasets.
- Easy to store multiple values of the same data type.
- Can be suitable for simple programs with fixed requirements.

### Disadvantages

- All arrays must remain correctly aligned by index.
- Incorrect updates can associate a vehicle with the wrong category or charging requirement.
- Adding more attributes increases the number of arrays that must be managed.
- Parking sessions, tickets, passes, and pricing rules become harder to organize.
- The design does not clearly separate the responsibilities of the parking system.

### Object-oriented alternative

Using separate classes groups related attributes and behaviour. For example, a `Vehicle` object keeps its registration number and category together, while a `ParkingTicket` represents an individual parking session.

This structure is more suitable for a system that manages multiple floors, vehicle categories, tickets, passes, and pricing rules.

## 7. Alternative Slot Representation and Complexity Analysis

Parking slots can also be represented using different data structures.

### Option A: Two-dimensional array

A two-dimensional representation can model floors and slots:

```text
slots[floor][slot]
```

For a facility with three floors and 50 slots per floor, the structure contains 150 slot positions.

**Advantages:** The floor and slot indexes are easy to relate to the physical layout.

**Disadvantages:** It is less flexible when floors have different capacities or the parking layout changes significantly.

### Option B: Flattened one-dimensional array

All slots can be stored in one array. If each floor has the same number of slots, a floor and local slot index can be mapped to a single index using:

```text
index = floor * slotsPerFloor + slot
```

This formula assumes zero-based indexing.

**Advantages:** The structure is simple to traverse and store.

**Disadvantages:** The program must convert between the physical floor/slot coordinates and the array index.

### Option C: Object-based floor and slot collections

A `ParkingLot` can manage a collection of `ParkingFloor` objects, with each floor managing its own `ParkingSlot` objects.

**Advantages:** This approach matches the real-world hierarchy, keeps responsibilities separate, and supports different floor capacities.

**Disadvantages:** It requires more classes and relationships than a simple array-based design.

For this assignment, the object-based representation is the preferred design because the facility has multiple floors, different slot capabilities, and several business rules.

### Time complexity

Let `n` represent the total number of parking slots.

- Sequentially searching for a suitable free slot takes **O(n)** time in the worst case.
- Checking one particular slot by a direct array index takes **O(1)** time when the index is already known.
- Storing `n` parking slots requires **O(n)** space.
- A sequential search requires **O(1)** additional space, excluding the storage of the slots themselves.

For example, searching a facility with 1,000 slots may require examining more slots than searching a facility with 150 slots.

These are theoretical complexity estimates. Actual execution-time measurements can be collected after implementation and testing.

## 8. Extensibility and Maintainability

The system should be designed so that future changes do not require rewriting all existing classes.

Examples of possible extensions include:

- Introducing additional vehicle categories.
- Adding new parking-slot categories.
- Changing hourly rates.
- Introducing new monthly-pass eligibility rules.
- Adding new EV charging tariffs.
- Supporting floors with different capacities.

Separating vehicle details, slot management, parking sessions, passes, and fee calculation helps localize changes and reduces unnecessary dependencies between classes.

## 9. Conclusion

The Campus Smart-Parking System is best modelled using an object-oriented design with separate classes for vehicles, parking slots, floors, the parking lot, tickets, fee calculation, and monthly passes.

This design represents the physical parking hierarchy and separates the responsibilities of managing vehicles, allocating spaces, recording sessions, validating passes, and calculating fees. The alternative array-based approaches are useful for comparison, but the object-oriented design is more suitable for the assignment's requirements and future extensions.

The design and assumptions documented here will guide the implementation and validation tasks that follow.
