/**
 * CS481 Assignment 2 - Kotlin Basics
 * Sirena Murphree
 * murph135
 */

import java.util.Objects.isNull


fun main(args: Array<String>) {
//  rotate matrix ===============================================
	println("\n\n---\t--- Rotate Matrix ---\t---")
	var colorMatrix = arrayOf(
		arrayOf(1, 2, 3, 4, 5, 6),
		arrayOf(1, 2, 3, 4, 5, 6),
		arrayOf(1, 2, 3, 4, 5, 6),
		arrayOf(1, 2, 3, 4, 5, 6),
		arrayOf(1, 2, 3, 4, 5, 6),
		arrayOf(1, 2, 3, 4, 5, 6)
	);
	MatrixFunction.print(colorMatrix);
	MatrixFunction.rotate(colorMatrix, 6) // <-- rotate function call
	MatrixFunction.print(colorMatrix);
	MatrixFunction.rotate(colorMatrix, 6) // <-- rotate function call
	MatrixFunction.print(colorMatrix);
	MatrixFunction.rotate(colorMatrix, 6) // <-- rotate function call
	MatrixFunction.print(colorMatrix);

//  Stack ===============================================
	println("\n\n---\t--- Three Stacks ---\t---")
	val myStack = TriStack()      //   <-- Stack Class Object instantiated
	myStack.push(0, 5)
	myStack.push(0, 10)
	myStack.push(0, 15)
	myStack.push(0, 20)
	myStack.push(0, 25)

	myStack.push(1, 9)
	myStack.push(1, 6)
	myStack.push(1, 3)
	myStack.push(1, -3)


	myStack.push(2, 11)

	myStack.print()
	println( "stack[0].pop: " + myStack.pop(0))
	println( "stack[0].pop: " + myStack.pop(0))
	println( "stack[0].pop: " + myStack.pop(0))

	println( "stack[2].pop: " + myStack.pop(2))
	println( "stack[2].pop: " + myStack.pop(2))
	myStack.print()

//  Find String ===============================================
	println("\n\n---\t--- Recursive Find String ---\t---")
	val trueColorLyrics = arrayOf<String>(
		"You with the sad eyes",
		"Don't be discouraged, oh I realize",
		"It's hard to take courage",
		"In a world full of people",
		"You can lose sight of it all",
		"The darkness inside you",
		"Can make you feel so small",
		"",
		"Show me a smile then",
		"Don't be unhappy",
		"Can't remember when",
		"I last saw you laughing",
		"This world makes you crazy",
		"And you've taken all you can bear",
		"Just call me up",
		"'Cause I will always be there",
		"And I see your true colors",
		"Shining through",
		"I see your true colors",
		"And that's why I love you",
		"So don't be afraid to let them show",
		"Your true colors",
		"True colors are beautiful",
		"",
		"I see your true colors",
		"Shining through (true colors)",
		"I see your true colors",
		"And that's why I love you",
		"So don't be afraid to let them show",
		"Your true colors",
		"True colors are beautiful (they're beautiful)",
		"Like a rainbow"
	)
	 val missrememberedSongLyrics = arrayOf<String>(
		 "Show me a smile now",
		 "Your true colors are shining through",
		 "I see your true colors"
	 )

	missrememberedSongLyrics.forEach { line:String ->
		val isA:String = if(SearchString.searchR(trueColorLyrics, line) > 0) "is" else "is NOT"   //   <-- search function call
		println("\"" + line + "\" " +  isA + " a line in the song \"True Colors\"")
	}


//  merge sort ===============================================
	println("\n\n---\t--- Merge Sort ---\t---")

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

	print("a", a_Array)
	print("b", b_Array)

	println("Merge a and b")

	MergeSort.merge(a_Array, b_Array, 5, 4)      //    <-- merge function call
	print("a", a_Array)
}


class MatrixFunction {
	companion object {
		fun print(matrix: Array<Array<Int>>): Unit {
			matrix.forEach { row: Array<Int> ->
				row.forEach { cell: Int ->
					print("[$cell]")
				}
				print("\n");
			}
			print("\n");
		}

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
}

class TriStack{
	val stackSize = 100;
	val buffer = IntArray(stackSize*3)
	val stackPointers = arrayOf(-1, -1, -1)

	private fun absTopOfStack(stack:Int):Int{
		return stack*stackSize+stackPointers[stack];
	}

	fun push(stack:Int, item:Int):Boolean{
		var pushSuccess = false;
		if(stack in 0..2){
			if(stackPointers[stack] < stackSize){
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

	fun print():Unit{
		for(i in 0..2){
			var offset = i*stackSize
			print("\nStack[$i] -> [")
			for(item in 0..stackPointers[i]){
				val reg = buffer[offset+item]
				print("$reg] [")
			}
		}
		print("\n")
	}
}

class SearchString{
	companion object {
		fun searchR(hayStack: Array<String>, needle: String): Int {
			if (hayStack == null || needle == null || needle.equals(""))
				return -1
			return searchR(hayStack, needle, 0, hayStack.size-1)
		}

		fun searchR(hayStack: Array<String>, needle: String, first: Int, last: Int): Int {
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
}

class MergeSort{
	companion object{
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
}
fun print(name: String, array:IntArray):Unit{
	print("$name -> ")
	array.forEach {
		print("[$it] ")
	}
	println()
}