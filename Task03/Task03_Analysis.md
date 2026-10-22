\# Task 3 — Design the Control Logic



\## 1. Allocation Pseudocode



```text

ALGORITHM AllocateSlot(vehicleNo)

&#x20;   FOR each floor f

&#x20;       FOR each slot s on floor f

&#x20;           IF slots\[f]\[s] is NULL THEN

&#x20;               slots\[f]\[s] ← vehicleNo

&#x20;               RETURN (f, s)

&#x20;           END IF

&#x20;       END FOR

&#x20;   END FOR

&#x20;   RETURN NULL

END ALGORITHM

```



\## 2. Parking Fee Pseudocode



```text

ALGORITHM CalculateFee(duration)

&#x20;   IF duration <= 1 hour THEN

&#x20;       fee ← 30

&#x20;   ELSE

&#x20;       fee ← 30 + CEILING(duration - 1) × 20

&#x20;   END IF



&#x20;   IF fee > 150 THEN

&#x20;       fee ← 150

&#x20;   END IF



&#x20;   RETURN fee

END ALGORITHM

```



\*\*Assumed fee rules:\*\* ₹30 for the first hour, ₹20 for each additional hour or part of an hour, and a daily maximum of ₹150.



\## 3. Use of break, continue, and return



\- `break` stops the nearest loop when no further searching is needed.

\- `continue` skips the current iteration and moves to the next slot.

\- `return` immediately ends the method and returns the result. Allocation returns the first free slot's coordinates or `null` if all slots are occupied.



\## 4. Alternative Concept and Complexity Analysis



In the basic approach, `allocate()` searches floor by floor and slot by slot until it finds a free slot. If all slots are occupied, it checks every slot and returns `null`. With F floors and S slots per floor, its worst-case time complexity is \*\*O(F × S)\*\*.



The `release()` method directly validates and updates the specified slot, so its time complexity is \*\*O(1)\*\*.



An alternative approach maintains a count of free slots on each floor and a stack of free slot positions. With proper updates during allocation and release, both operations can take \*\*O(1)\*\* time. The stack requires O(F × S) extra space, and the floor counts require O(F) extra space.



The basic approach uses O(F × S) space for the slot array and needs no additional allocation data structure. It is simpler, while the alternative approach uses more memory to improve allocation speed.

