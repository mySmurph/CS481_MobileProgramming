package com.example.hw3_sirenamurphree_kotlinunittest

class problem1 {
    fun rotate(matrix: Array<Array<Int>>, n: Int): Unit {
        for (layer in 0..(n / 2) - 1) {
            val first = layer;
            val last = n - 1 - layer;

            for (i in first..last - 1) {
                val offset = i - first;
                val top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }
}