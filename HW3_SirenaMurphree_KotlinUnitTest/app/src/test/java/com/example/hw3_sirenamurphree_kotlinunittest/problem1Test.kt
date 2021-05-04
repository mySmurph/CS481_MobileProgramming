package com.example.hw3_sirenamurphree_kotlinunittest

import org.junit.*
import org.junit.Assert.*


class problem1Test {

    lateinit var testMatrix : Array<Array<Int>>;
    val p1:problem1 = problem1()
    @Test
    fun rotateTest_Even(){
        val n = 6
        testMatrix = arrayOf(
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6)
        )
        val matrix_r1 = arrayOf(
            arrayOf(1, 1, 1, 1, 1, 1),
            arrayOf(2, 2, 2, 2, 2, 2),
            arrayOf(3, 3, 3, 3, 3, 3),
            arrayOf(4, 4, 4, 4, 4, 4),
            arrayOf(5, 5, 5, 5, 5, 5),
            arrayOf(6, 6, 6, 6, 6, 6),
        )
        val matrix_r2 = arrayOf(
            arrayOf(6, 5, 4, 3, 2, 1),
            arrayOf(6, 5, 4, 3, 2, 1),
            arrayOf(6, 5, 4, 3, 2, 1),
            arrayOf(6, 5, 4, 3, 2, 1),
            arrayOf(6, 5, 4, 3, 2, 1),
            arrayOf(6, 5, 4, 3, 2, 1),
        )
        val matrix_r3 = arrayOf(
            arrayOf(6, 6, 6, 6, 6, 6),
            arrayOf(5, 5, 5, 5, 5, 5),
            arrayOf(4, 4, 4, 4, 4, 4),
            arrayOf(3, 3, 3, 3, 3, 3),
            arrayOf(2, 2, 2, 2, 2, 2),
            arrayOf(1, 1, 1, 1, 1, 1),
        )
        val matrix_r4 = arrayOf(
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6),
            arrayOf(1, 2, 3, 4, 5, 6)
        )
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r1, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r2, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r3, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r4, testMatrix)
    }

    @Test
    fun rotateTest_Odd(){
        val n = 5
        testMatrix = arrayOf(
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5)
        )
        val matrix_r1 = arrayOf(
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(2, 2, 2, 2, 2),
            arrayOf(3, 3, 3, 3, 3),
            arrayOf(4, 4, 4, 4, 4),
            arrayOf(5, 5, 5, 5, 5)
        )
        val matrix_r2 = arrayOf(
            arrayOf(5, 4, 3, 2, 1),
            arrayOf(5, 4, 3, 2, 1),
            arrayOf(5, 4, 3, 2, 1),
            arrayOf(5, 4, 3, 2, 1),
            arrayOf(5, 4, 3, 2, 1),
        )
        val matrix_r3 = arrayOf(
            arrayOf(5, 5, 5, 5, 5),
            arrayOf(4, 4, 4, 4, 4),
            arrayOf(3, 3, 3, 3, 3),
            arrayOf(2, 2, 2, 2, 2),
            arrayOf(1, 1, 1, 1, 1),
        )
        val matrix_r4 = arrayOf(
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5),
            arrayOf(1, 2, 3, 4, 5)
        )
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r1, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r2, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r3, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_r4, testMatrix)
    }

    @Test
    fun rotateTest_Empty(){
        val n = 0
        testMatrix = arrayOf( arrayOf() )
        val matrix_empty : Array<Array<Int>>  = arrayOf( arrayOf() )
        p1.rotate(testMatrix, n)
        assertEquals(matrix_empty, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_empty, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_empty, testMatrix)
        p1.rotate(testMatrix, n)
        assertEquals(matrix_empty, testMatrix)
    }

}