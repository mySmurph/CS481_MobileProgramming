package com.example.hw3_sirenamurphree_kotlinunittest

import org.junit.*
import org.junit.Assert.*

class problem3Test {
    lateinit var p3:problem3
    @Test
    fun searchTest_OrderedList(){
        p3 = problem3()
        val sortedLyrics = arrayOf<String>(
            "'Cause I will always be there",
            "And I see your true colors",
            "And that's why I love you",
            "And you've taken all you can bear",
            "Can make you feel so small",
            "Can't remember when",
            "Don't be discouraged, oh I realize",
            "Don't be unhappy",
            "I last saw you laughing",
            "I see your true colors",
            "In a world full of people",
            "It's hard to take courage",
            "Just call me up",
            "Like a rainbow",
            "Shining through (true colors)",
            "Shining through",
            "Show me a smile then",
            "So don't be afraid to let them show",
            "The darkness inside you",
            "This world makes you crazy",
            "True colors are beautiful (they're beautiful)",
            "True colors are beautiful",
            "You can lose sight of it all",
            "You with the sad eyes",
            "Your true colors"
        )
        val firstElem = "'Cause I will always be there"
        val lastElem = "Your true colors"
        val midElem = "Like a rainbow"
        val doesNotExist = "Show me a smile now"
        assertEquals(0, p3.search(sortedLyrics, firstElem))
        assertEquals(13, p3.search(sortedLyrics, midElem))
        assertEquals(24, p3.search(sortedLyrics, lastElem))
        assertEquals(-1, p3.search(sortedLyrics, doesNotExist))
        assertEquals(-1, p3.search(sortedLyrics, ""))
        assertEquals(-1, p3.search(sortedLyrics, null))
    }

    @Test
    fun searchTest_EmptyList(){
        p3 = problem3()
        val emptyString = arrayOf<String>( )
        val doesNotExist = "Show me a smile now"
        assertEquals(-1, p3.search(emptyString, doesNotExist))
        assertEquals(-1, p3.search(emptyString, ""))
        assertEquals(-1, p3.search(emptyString, null))
    }

    @Test
    fun searchTest_NullList(){
        p3 = problem3()
        val doesNotExist = "Show me a smile now"
        assertEquals(-1, p3.search(null, doesNotExist))
        assertEquals(-1, p3.search(null, ""))
        assertEquals(-1, p3.search(null, null))
    }
}