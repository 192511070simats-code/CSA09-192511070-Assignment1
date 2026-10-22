# Task 11 — Implement, Test and Defend the Design



## 1. Implementation



The parking system stores parking slots and active tickets in arrays. It supports bikes, cars, and electric cars. The system validates vehicle details, rejects duplicate registration numbers, allocates free slots, calculates parking fees, and releases slots when vehicles exit.



## 2. Test Table



| Test case | Expected result | Actual result |

|---|---|---|

| Bike parks for 60 minutes | Fee ₹10 | Fee ₹10 |

| Car parks for 120 minutes | Fee ₹60 | Fee ₹60 |

| Parking capacity reached | Third vehicle rejected | Third vehicle rejected |

| Unknown vehicle type | Rejected | Rejected |

| Duplicate registration | Rejected | Rejected |

| Invalid slot number 0 | Invalid | Invalid |

| Zero-minute parking | Fee ₹0 | Fee ₹0 |

| Stay exactly 60 minutes | One hour charged | One hour charged |



## 3. Daily Collection Calculation



The test scenario contains two vehicles:



- Bike: 60 minutes × ₹10 per hour = ₹10

- Car: 120 minutes × ₹30 per hour = ₹60



Total collection = ₹10 + ₹60 = ₹70.



The program should display `Total collection: Rs 70.0`, matching the manual calculation.



## 4. Design Evaluation



- Encapsulation: Fields are private and accessed through methods.

- Inheritance and abstraction: The earlier tasks demonstrate

