package com.example.hw3_sirenamurphree_kotlinunittest

import org.junit.*
import org.junit.Assert.*

class problem4Test {
    lateinit var p4: problem4

    @Test
    fun mergeTest_SpaceAvailable_aGreaterThanb(){
        p4 = problem4()
        val a_Array = IntArray(10)
        val b_Array = IntArray(10)

        a_Array[0] = 2
        a_Array[1] = 3
        a_Array[2] = 5
        a_Array[3] = 7
        a_Array[4] = 9

        b_Array[0] = 1
        b_Array[1] = 4
        b_Array[2] = 6
        b_Array[3] = 8

        val mergedResult = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        val b_unchanged  = intArrayOf(1, 4, 6, 8, 0, 0, 0, 0, 0, 0)

        p4.merge(a_Array, b_Array, 5, 4)
        assertArrayEquals(mergedResult, a_Array)
        assertArrayEquals(b_unchanged, b_Array)
    }

    @Test
    fun mergeTest_SpaceAvailable_aLessThanb(){
        p4 = problem4()
        val a_Array = IntArray(10)
        val b_Array = IntArray(10)

        a_Array[0] = 12
        a_Array[1] = 23
        a_Array[2] = 35
        a_Array[3] = 58

        b_Array[0] = -6
        b_Array[1] = 14
        b_Array[2] = 16
        b_Array[3] = 28
        b_Array[4] = 39
        b_Array[5] = 42

        val mergedResult = intArrayOf(-6, 12, 14, 16, 23, 28, 35, 39, 42, 58)
        val unchanged  = intArrayOf(-6, 14, 16, 28, 39, 42, 0, 0, 0, 0)

        p4.merge(a_Array, b_Array, 4, 6)
        assertArrayEquals(mergedResult, a_Array)
        assertArrayEquals(unchanged, b_Array)
    }

    @Test
    fun mergeTest_SpaceAvailable_aEqualb(){
        p4 = problem4()
        val a_Array = IntArray(10)
        val b_Array = IntArray(10)

        a_Array[0] = 12
        a_Array[1] = 23
        a_Array[2] = 35
        a_Array[3] = 58
        a_Array[4] = 60

        b_Array[0] = 12
        b_Array[1] = 23
        b_Array[2] = 35
        b_Array[3] = 58
        b_Array[4] = 60

        val mergedResult = intArrayOf(12, 12, 23, 23, 35, 35, 58, 58, 60, 60)
        val unchanged  = intArrayOf(12, 23, 35, 58, 60, 0, 0, 0, 0, 0)

        p4.merge(a_Array, b_Array, 5, 5)
        assertArrayEquals(mergedResult, a_Array)
        assertArrayEquals(unchanged, b_Array)
    }

    @Test
    fun mergeTest_DestinationEmpty(){
        p4 = problem4()
        val a_Array = IntArray(4)
        val b_Array = IntArray(10)

        b_Array[0] = 1
        b_Array[1] = 4
        b_Array[2] = 6
        b_Array[3] = 8

        val mergedResult = intArrayOf(1, 4, 6, 8)
        val b_unchanged  = intArrayOf(1, 4, 6, 8, 0, 0, 0, 0, 0, 0)

        p4.merge(a_Array, b_Array, 0, 4)
        assertArrayEquals(mergedResult, a_Array)
        assertArrayEquals(b_unchanged, b_Array)
    }

    @Test
    fun mergeTest_SourceEmpty(){
        p4 = problem4()
        val a_Array = IntArray(10)
        val b_Array = IntArray(0)

        a_Array[0] = 2
        a_Array[1] = 3
        a_Array[2] = 5
        a_Array[3] = 7
        a_Array[4] = 9


        val mergedResult = intArrayOf(2, 3, 5, 7, 9, 0, 0, 0, 0, 0)
        val b_unchanged  = intArrayOf()

        p4.merge(a_Array, b_Array, 5, 0)
        assertArrayEquals(mergedResult, a_Array)
        assertArrayEquals(b_unchanged, b_Array)
    }

    @Test
    fun mergeTest_SourceDestinationEmpty(){
        p4 = problem4()
        val a_Array = IntArray(10)
        val b_Array = IntArray(10)


        val mergedResult = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

        p4.merge(a_Array, b_Array, 0, 0)
        assertArrayEquals(mergedResult, a_Array)
        assertArrayEquals(mergedResult, b_Array)
    }

    @Test (expected = ArrayIndexOutOfBoundsException::class)
    fun mergeTest_SpaceUnavailable(){
        p4 = problem4()
        val a_Array = IntArray(10)
        val b_Array = IntArray(10)

        a_Array[0] = 2
        a_Array[1] = 3
        a_Array[2] = 5
        a_Array[3] = 7
        a_Array[4] = 9
        a_Array[5] = 12
        a_Array[6] = 13

        b_Array[0] = 1
        b_Array[1] = 4
        b_Array[2] = 6
        b_Array[3] = 8

        p4.merge(a_Array, b_Array, 7, 4)
    }

}