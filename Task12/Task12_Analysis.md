\# Task 12 — Re-evaluate and Adapt the Design



\## A. Impact Analysis



The new requirements introduce e-bikes with a flat parking fee, delivery vans charged at double the car rate between 9 AM and 5 PM, one-day passes for visitors, and a five-floor facility with unequal slot capacities.



The vehicle hierarchy, fee-calculation methods, parking allocation logic, pass-management functionality, and slot data structure are affected.



A normal two-dimensional array assumes every floor has the same number of slots. A jagged array, such as `String\[]\[] slots`, allows each floor to have a different capacity.



\## B. Evaluation of the Original Design



The original design can support new vehicle categories through subclasses, but this alone does not keep all pricing rules organised. A central switch statement must be modified whenever a new type or special pricing rule is introduced.



The original fixed-capacity array also needs adaptation for unequal floor sizes. The design is therefore reusable but requires changes to the pricing logic, slot allocation, and pass handling.



\## C. Adaptation Decision



I chose to modify the design instead of completely replacing it.



The revised design uses:

\- An abstract `Vehicle` class for common vehicle data and behaviour.

\- Separate subclasses for existing vehicles, e-bikes, and delivery vans.

\- A `PricingRule` abstraction to separate pricing policy from parking operations.

\- A `Pass` interface for one-day visitor passes.

\- A jagged array to represent five floors with different slot capacities.



E-bikes use a flat parking fee. Delivery vans use double the car rate during the specified 9 AM–5 PM period. A valid one-day pass allows the visitor to park for its validity period according to the pass rules.



\## D. Evidence-Based Defence



The modified design preserves reusable vehicle and parking concepts while isolating pricing rules. A new vehicle category can be added as a subclass with an appropriate pricing rule, reducing changes to existing allocation code.



The jagged array represents unequal floor capacities without wasting slots merely to create a rectangular structure. The pass interface keeps pass-related behaviour separate from vehicle identity.



The trade-off is that additional abstractions and classes increase the initial design complexity. However, they make future changes easier to maintain and test.



The implementation should be tested for flat-fee e-bike parking, delivery van rates during and outside the specified time window, pass validity, and allocation when floors have different capacities.

