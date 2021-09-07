class Solution {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var maxInterval = 0
        val maxIntervalChars = mutableSetOf<Char>()
        for (index in releaseTimes.indices) { 
            var interval = if (index == 0) releaseTimes[0] else releaseTimes[index] - releaseTimes[index - 1]
            when { 
                interval == maxInterval -> { 
                    maxIntervalChars.add(keysPressed[index])
                }
                interval > maxInterval -> { 
                    maxInterval = interval
                    maxIntervalChars.clear()
                    maxIntervalChars.add(keysPressed[index])
                }
            }
        }
        
        return maxIntervalChars.sortedDescending().first()
    }
}