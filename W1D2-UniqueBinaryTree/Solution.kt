/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
 
class Solution {
    fun generateTrees(n: Int): List<TreeNode?> = generateTrees(1, n)
    
    fun generateTrees(start: Int, end: Int): List<TreeNode?> { 
        return when { 
            start == end -> listOf(TreeNode(start))
            start > end -> listOf(null)
            else -> { 
                val trees: MutableList<TreeNode?> = LinkedList()
                for (num in start..end) { 
                    val leftTrees = generateTrees(start, num - 1)
                    val rightTrees = generateTrees(num + 1, end)
                    for (leftTree in leftTrees) { 
                        for (rightTree in rightTrees) { 
                            val tree = TreeNode(num).apply { 
                                left = leftTree
                                right = rightTree
                            }
                            trees.add(tree)
                        }
                    }
                }
                trees
            }
        }
    }
}