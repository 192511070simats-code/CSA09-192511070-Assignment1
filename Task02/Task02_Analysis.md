# Task 2 — Choose the Data Representation



## 1. Data Types and Justification



The following Java data types are selected for the Campus Smart-Parking System:



| Field | Java Data Type | Justification |

|---|---|---|

| Slot number | `int` | Represents a whole-number identifier for each parking slot. |

| Vehicle number | `String` | Vehicle registration numbers can contain letters and digits. |

| Entry time | `long` | Stores entry timestamps in milliseconds. |

| Duration | `double` | Represents parking duration in hours, including fractional hours. |

| Fee | `double` | Supports fractional currency values during fee calculation. |



For a production billing system, `BigDecimal` would be preferable for accurate monetary calculations.



## 2. Array Representation



A jagged two-dimensional array (`String\[]\[]`) is selected to represent the parking floors and slots. Each row represents one floor, and each element represents a slot on that floor.



Unlike a rectangular two-dimensional array, a jagged array allows each floor to have a different number of slots. This makes it suitable for a campus parking system where floor capacities may vary.



Example:



```java

String[][] slots = {

&#x20;   {"A1", "A2", "A3"},

&#x20;   {"B1", "B2"},

&#x20;   {"C1", "C2", "C3", "C4"}

};

```



The slot on a particular floor can be accessed using its floor index and slot index, such as `slots\[1]\[0]`. This provides direct access in O(1) time when both indices are known.



## 3. Type Conversion, Casting, and Fee Calculation



Type conversion is required when calculating parking duration in hours from minutes. Using integer division can discard the fractional part and produce an incorrect fee.



For example, if a vehicle parks for 90 minutes and the rate is ₹30 per hour, the correct fee is ₹45. However, `90 / 60` using integer operands evaluates to `1`, producing an incorrect fee of ₹30.



The calculation can be corrected by using floating-point division:



```java

int minutes = 90;

double ratePerHour = 30.0;



double hours = minutes / 60.0;

double fee = hours \* ratePerHour;

```



Here, `60.0` ensures floating-point division, preserving the fractional duration. Casting the result after integer division does not restore the lost precision. For example, `(double) (90 / 60)` evaluates to `1.0`, not `1.5`.



Therefore, floating-point division must be performed before the fractional part is lost. For production billing, `BigDecimal` can be used to manage monetary precision and rounding rules.



## 4. Input Method



The `Scanner` class is selected to read input from the keyboard. It allows the parking operator to enter vehicle numbers, slot numbers, and other details while the program is running.



Example:



```java

Scanner sc = new Scanner(System.in);



System.out.print("Enter vehicle number: ");

String vehicleNumber = sc.next();



System.out.print("Enter slot number: ");

int slotNumber = sc.nextInt();

```



`Scanner` is suitable because it is simple to use and supports interactive input. Input validation should be performed to handle invalid values safely.



Command-line arguments are an alternative, but numeric arguments must be converted from strings using methods such as `Integer.parseInt()`. Invalid numeric input may cause a `NumberFormatException`.



## 5. Alternative Representations and Complexity Analysis



### A. One-Dimensional Array



A one-dimensional array can store all parking slots in a single sequence. When every floor has the same number of slots, the index can be calculated using:



`index = floor \* slotsPerFloor + slot`



This provides O(1) access when the floor and slot indices are known. However, when floors have different capacities, this formula cannot be used directly with one fixed `slotsPerFloor` value. Prefix offsets or a separate mapping are required to calculate the correct index.



### B. ArrayList



An `ArrayList` can store slot objects or slot records in a resizable collection. It is useful when the number of slots changes dynamically. Access by a known index takes O(1) time, but locating a slot by its identifier generally takes O(n) time without an additional index or map.



### C. Jagged Two-Dimensional Array



A jagged array stores each floor in a separate row, allowing different numbers of slots per floor. Accessing a slot by its floor and slot indices takes O(1) time. Searching every slot by vehicle number or slot identifier takes O(n) time in the worst case.



### D. Space Complexity



If there are n total parking slots, all three representations require O(n) space for the slot entries. A jagged array avoids allocating unused positions for nonexistent slots. A flat array with prefix offsets requires additional O(f) space for f floors, while an `ArrayList` may allocate some extra capacity as it grows.



Therefore, a jagged two-dimensional array is selected because it represents the actual floor structure clearly, supports different floor capacities, and provides direct access using floor and slot indices.

