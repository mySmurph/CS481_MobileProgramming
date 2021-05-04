package com.example.hw3_sirenamurphree_kotlinunittest
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Objects.isNull

class problem2 {
    val stackSize = 100;
    val buffer = IntArray(stackSize*3)
    val stackPointers = arrayOf(-1, -1, -1)

    private fun absTopOfStack(stack:Int):Int{
        return stack*stackSize+stackPointers[stack];
    }

    fun push(stack:Int, item:Int):Boolean{
        var pushSuccess = false;
        if(stack in 0..2){
            if(stackPointers[stack]+1 < stackSize){
                ++stackPointers[stack]
                buffer[absTopOfStack(stack)] = item
                pushSuccess = true
            }
        }
        if(!pushSuccess){
            println("Error: Stack Full");
        }
        return pushSuccess
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun pop(stack:Int):Int?{
        var item: Int? = null;
        if(stack in 0..2){
            if(!isEmpty(stack)){
                item = buffer[absTopOfStack(stack)]
                buffer[absTopOfStack(stack)] = 0
                --stackPointers[stack]
            }
        }

        if(isNull(item)){
            println("TriStack Error-> Stack Empty")
        }
        return item;
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun peek(stack:Int):Int?{
        var item: Int? = null;
        if(stack in 0..2){
            if(!isEmpty(stack)){
                item = buffer[absTopOfStack(stack)]
            }
        }

        if(isNull(item)){
            println("TriStack Error-> Stack Empty")
        }
        return item;
    }

    fun isEmpty(stack:Int):Boolean{
        return if (stack in 0..2) stackPointers[stack] ==-1 else true
    }
}