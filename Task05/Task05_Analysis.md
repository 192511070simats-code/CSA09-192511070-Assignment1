# Task 5 — Apply Static Members and the Object Life Cycle



## 1. Static Members



A static variable belongs to the class and is shared by all its objects. A static ticket counter is suitable when ticket numbers must be unique across multiple parking facilities. An instance counter would give each object its own count and could cause duplicate ticket numbers.



A static method can generate or return ticket numbers using class-level data. A static block can initialize shared data when the class is initialized.



## 2. Object Life Cycle



When a vehicle leaves, its parking ticket may no longer be needed. If no reachable references point to the ticket object, it becomes eligible for garbage collection. The JVM decides when its memory is reclaimed.



## 3. Passing and Returning Objects



Java passes object references by value. A method can access or modify an object through the received reference. A method can also return an object reference, such as a newly created ParkingTicket.



## 4. Alternative Concept and Complexity Analysis



If the ticket counter were an instance variable of ParkingFacility, each facility would have its own counter. North and south gates could generate duplicate ticket numbers unless their numbering ranges were separated.



If ticket numbers must be unique across all facilities, a static counter shared by the ticket-generating class is suitable. If each facility uses independent numbering, an instance counter is appropriate.



For k facility objects and n ticket objects, a static counter uses O(1) space for the shared counter. An instance counter uses O(k) space for the facility counters. The n ticket objects require O(n) space in either approach, assuming each ticket has a fixed number of fields

