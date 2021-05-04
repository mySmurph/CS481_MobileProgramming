package com.example.hw3_sirenamurphree_kotlinunittest

class problem4 {
    fun merge(a:IntArray, b:IntArray, a_last:Int, b_last:Int):Unit{
        var a_index = a_last - 1
        var b_index = b_last - 1
        var i_merge = b_last + a_last - 1

        while (a_index >= 0 && b_index >= 0){
            if(a[a_index] > b[b_index]){
                a[i_merge--] = a[a_index--]
            }else{
                a[i_merge--] = b[b_index--]
            }
        }
        while (b_index >= 0){
            a[i_merge--] = b[b_index--]
        }
    }
}