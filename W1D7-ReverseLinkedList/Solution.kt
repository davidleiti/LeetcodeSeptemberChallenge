/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

 class SolutionRecursive {
    fun reverseList(head: ListNode?): ListNode? = head?.let { node -> reverseList(node, null) }

    fun reverseList(node: ListNode, lastPrev: ListNode?): ListNode? { 
        var next: ListNode? = node?.next
        if (next == null) { 
            node.next = lastPrev
            return node
        }
        
        node?.next = lastPrev
        return reverseList(next, node)
    }
}

class SolutionIterative {
    fun reverseList(head: ListNode?): ListNode? {
        var node: ListNode? = head
        var prev: ListNode? = null
        while (node?.next != null) { 
            var next: ListNode? = node?.next
            node?.next = prev
            prev = node
            node = next
        }
        
        node?.next = prev
        return node
    }
}