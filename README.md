# codility

### Problem: MaxSliceSwap
https://codility.com/programmers/task/max_slice_swap/

### Solution: main idea
1. For every array element `A(i)` compute the maximum non-negative sum of the following:
  * left slice ending at `A(i-1)`
  * right slice starting at `A(i+1)`
  * an element `A(k)` outside of both slices above (`k != i`)
2. Note, that any or both of the slices may be empty and an element worth swapping may not exist.
3. Choose the maximum of all the resulting sums.
4. Note, that if the result is zero, and `0` is not an element of the input array `A`, then the largest element of `A` is the solution.
