class Solution {
    fun arrayNesting(nums: IntArray): Int {
        var maxLength = 0 
        var discarded: MutableSet<Int> = HashSet()
        for (num in nums) { 
            if (num in discarded) continue
            
            val sequence: MutableSet<Int> = HashSet()
            var nextIndex = nums[num]
            while (nums[nextIndex] !in sequence) { 
                sequence.add(nums[nextIndex])
                nextIndex = nums[nextIndex]
            }
            
            maxLength = Math.max(maxLength, sequence.size)  
            discarded.addAll(sequence)
        }
        
        return maxLength
    }
}