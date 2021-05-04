package com.example.hw3_sirenamurphree_kotlinunittest

import org.junit.*
import org.junit.Assert.*

class problem2Test {
    lateinit var p2:problem2;

    @Test
    fun isEmptyTest(){
        p2 = problem2()
        assertTrue(p2.isEmpty(0))
        assertTrue(p2.isEmpty(1))
        assertTrue(p2.isEmpty(2))

        p2.push(0, 1)
        assertFalse(p2.isEmpty(0))
        assertTrue(p2.isEmpty(1))
        assertTrue(p2.isEmpty(2))

        p2.pop(0)
        p2.push(1, 1)
        assertTrue(p2.isEmpty(0))
        assertFalse(p2.isEmpty(1))
        assertTrue(p2.isEmpty(2))

        p2.pop(1)
        p2.push(2, 1)
        assertTrue(p2.isEmpty(0))
        assertTrue(p2.isEmpty(1))
        assertFalse(p2.isEmpty(2))
    }

    @Test
    fun pushTest(){
        p2 = problem2()
        for(i in 1..100)
            assertTrue(p2.push(0, i))
        assertFalse(p2.push(0, 101))

        for(i in 1..100)
            assertTrue(p2.push(1, i))
        assertFalse(p2.push(1, 101))

        for(i in 1..100)
            assertTrue(p2.push(2, i))
        assertFalse(p2.push(2, 101))
    }

    @Test
    fun popTest(){
        p2 = problem2()

        p2.push(1, 5)
        assertEquals(5, p2.pop(1))

        p2.push(1, 4)
        p2.push(1, 3)
        p2.push(1, 2)
        p2.push(1, 1)
        assertEquals(1, p2.pop(1))
        assertEquals(2, p2.pop(1))
        assertEquals(3, p2.pop(1))
        assertEquals(4, p2.pop(1))
        assertNull(p2.pop(1))
    }

    @Test
    fun peekTest(){
        p2 = problem2()
        p2.push(1, 5)
        assertEquals(5, p2.peek(1))

        p2.push(1, 4)
        p2.push(1, 3)
        p2.push(1, 2)
        p2.push(1, 1)
        assertEquals(1, p2.peek(1))
        p2.pop(1)   // 1
        p2.pop(1)   // 2
        p2.pop(1)   // 3
        assertEquals(4, p2.peek(1))
        p2.pop(1)   // 4
        p2.pop(1)   // 5
        assertNull(p2.peek(1))
    }
}