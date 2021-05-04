package com.example.hw3_sirenamurphree_kotlinunittest

class problem3 {
    fun search(hayStack: Array<String>?, needle: String?): Int {
        if (hayStack == null || needle == null || needle.equals(""))
            return -1
        return searchR(hayStack, needle, 0, hayStack.size-1)
    }

    private fun searchR(hayStack: Array<String>, needle: String, first: Int, last: Int): Int {
        if (first > last)
            return -1
        var mid = ((last + first) / 2) as Int
        if (hayStack.get(mid).isEmpty()) {
            var left = mid - 1
            var right = mid + 1
            while (true) {
                if (left < first && right > last) {
                    return -1
                } else if (right <= last && !hayStack.get(right).isEmpty()) {
                    mid = right
                    break
                } else if (left >= first && !hayStack.get(left).isEmpty()) {
                    mid = left
                    break
                }
                right++
                left--
            }
        }

        if (needle.equals(hayStack.get(mid))) {
            return mid
        } else if (hayStack.get(mid).compareTo(needle) < 0) {
            return searchR(hayStack, needle, mid + 1, last)
        }else{
            return searchR(hayStack, needle, first, mid - 1)
        }
    }
}