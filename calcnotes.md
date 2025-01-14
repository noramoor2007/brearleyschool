To find the volume of the solid obtained by rotating the region \( R \), bounded by the curves \( y = x^2 + 1 \) and \( y = x \) for \( 0 \leq x \leq 1 \), about the \( x \)-axis, we use the method of washers.

### Step 1: Identify the bounds and the curves
1. \( y = x^2 + 1 \) is the upper curve (outer radius for the washer).
2. \( y = x \) is the lower curve (inner radius for the washer).
3. The region of interest is from \( x = 0 \) to \( x = 1 \).

### Step 2: Formula for volume using washers
The volume is given by:
\[
V = \pi \int_{a}^{b} \left[ R(x)^2 - r(x)^2 \right] \, dx
\]
where:
- \( R(x) \): the outer radius (distance from \( x \)-axis to the outer curve),
- \( r(x) \): the inner radius (distance from \( x \)-axis to the inner curve).

### Step 3: Substitute the curves
- Outer radius: \( R(x) = x^2 + 1 \),
- Inner radius: \( r(x) = x \).

The volume integral becomes:
\[
V = \pi \int_{0}^{1} \left[ (x^2 + 1)^2 - x^2 \right] \, dx
\]

### Step 4: Expand and simplify the integrand
1. Expand \( (x^2 + 1)^2 \):
\[
(x^2 + 1)^2 = x^4 + 2x^2 + 1
\]
2. Subtract \( x^2 \):
\[
(x^2 + 1)^2 - x^2 = x^4 + 2x^2 + 1 - x^2 = x^4 + x^2 + 1
\]

Thus, the integral becomes:
\[
V = \pi \int_{0}^{1} \left( x^4 + x^2 + 1 \right) \, dx
\]

### Step 5: Evaluate the integral
Split the integral:
\[
V = \pi \left[ \int_{0}^{1} x^4 \, dx + \int_{0}^{1} x^2 \, dx + \int_{0}^{1} 1 \, dx \right]
\]

1. Compute each term:
   - \( \int_{0}^{1} x^4 \, dx = \frac{x^5}{5} \Big|_{0}^{1} = \frac{1}{5} \),
   - \( \int_{0}^{1} x^2 \, dx = \frac{x^3}{3} \Big|_{0}^{1} = \frac{1}{3} \),
   - \( \int_{0}^{1} 1 \, dx = x \Big|_{0}^{1} = 1 \).

2. Combine results:
\[
V = \pi \left( \frac{1}{5} + \frac{1}{3} + 1 \right)
\]

### Step 6: Simplify the result
Combine the fractions:
\[
\frac{1}{5} + \frac{1}{3} + 1 = \frac{3}{15} + \frac{5}{15} + \frac{15}{15} = \frac{23}{15}
\]

Thus:
\[
V = \pi \cdot \frac{23}{15} = \frac{23\pi}{15}
\]

### Final Answer:
The volume of the solid is:
\[
\boxed{\frac{23\pi}{15}}
\]
