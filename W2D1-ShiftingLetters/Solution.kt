class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        var lastShifts: Long = 0
        val result = CharArray(s.length) { ' ' }
        for (index in shifts.lastIndex downTo 0) {
            val charShifts = (lastShifts + shifts[index]) % 26
            result[index] = s[index].shiftedBy(charShifts)
            lastShifts = charShifts
        }

        return String(result)
    }

    fun Char.shiftedBy(n: Long): Char = ((this - 'a' + n) % 26 + 97).toChar()
}