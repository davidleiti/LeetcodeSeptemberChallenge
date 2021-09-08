# [Unique Binary Search Tree](https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3961/)

Given an integer `n`, return all the structurally unique BST's (binary search trees), which has exactly `n` nodes of unique values from `1` to `n`. Return the answer in any order.
 
### Example 1:
```
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
```

### Example 2:
```
Input: n = 1
Output: [[1]]
```

### Constraints:
- `1 <= n <= 8`

# Solution
While I figured out the jist of the solution, the actual implementation is mostly borrowed from the problem discussions.
The main idea is using a recursive divide and conquer approach: 
For each recursive call with the `start..end` interval the following rules apply:
- If `start == end`, that means we reached a leaf in the current tree, thus return a `TreeNode` with the value of `start`
- If `start > end`, that means that the indices have overlapped, return null for this branch
- Otherwise, for each number `k` from `start..end`, we can compose and return all BST options based on the list of trees that can be composed on its left and on its right, i.e. for the number intervals `0..k-1` and `k+1..n`.

## Observation:
Since the order of the trees returned is not important, we can use `LinkedList<TreeNode?>` collections for collecting the list of trees at any recursion level instead of simple `ArrayList<>` (provided by `mutableListOf<>()`) for better performance. This approach provides constant time additions to the list regardless of its size (without needing to resize).