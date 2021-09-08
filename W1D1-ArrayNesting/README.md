# [Array Nesting](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/)

You are given an integer array `nums` of length `n` where `nums` is a permutation of the numbers in the range `[0, n - 1]`.

You should build a set `s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... }` subjected to the following rule:

- The first element in `s[k]` starts with the selection of the element `nums[k]` of `index = k`.
- The next element in `s[k]` should be `nums[nums[k]]`, and then nums[nums[nums[k]]], and so on.
- We stop adding right before a duplicate element occurs in `s[k]`.

Return the **longest length of a set `s[k]`**.

### Example 1:
```
Input: nums = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
One of the longest sets s[k]:
s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}
```

### Example 2:
```
Input: nums = [0,1,2]
Output: 1
``` 

### Constraints:

- `1 <= nums.length <= 105`
- `0 <= nums[i] < nums.length`
- All the values of `nums` are **unique**.

## Solution
This problem can be easily solved by iterating over the list of numbers and applying the following logic to each element:
- Ignore it if it was already discarded (used in a previous sequence)
- Initialize a new sequence (Set<Int>) containing the current element
- Build the sequence by adding `nums[index]` to the sequence and moving on to the next `index = nums[index]` until the sequence ends (a duplicate element is found)
- If the built sequence's length is larger than the previous maximum, set it as the new maximum, and add the elements from the sequence to the discard set

After iterating over the list of numbers once with this approach, simply return the maximum sequence value found.

## Observations:
- Using `HashSet<Int>` collection instead of a simple `List<Int>` for the sequence and discard collections is much more efficient when verifiying whether or not an element is already included (simple hash code calculation vs iteration over the colletion). This modification improved the runtime efficiency drastically ~12.5ms -> ~2.5ms 
- The runtime complexity of the algorithm is *O(n)* since it can be solved with one pass of the input array and the space complexity is *O(n)* because of the additional space occupied by the discard set. **Note:** This additional allocation can be avoided by marking the visited elements directly in the input array with a special value such as `-1`.
