package com.hw1_sirenamurphree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GradeActivity : AppCompatActivity() {
    val gradeArray = arrayOf(
            arrayOf<Int>(      60,   63,  67,   70,   73,  77,   80,   83,  87,   90,   93,  101),
            arrayOf<String>(  "F", "D-", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-",  "A")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        val btn_showLetterGrade = findViewById<Button>(R.id.btn_showLetterGrade);
        val input_grade = findViewById<EditText>(R.id.input_int_grade);
        val output_grade = findViewById<TextView>(R.id.output_showLetterGrade);
        btn_showLetterGrade.setOnClickListener { output_grade.text = intToLetter(input_grade.text.toString().toInt()) };

    }
    fun intToLetter(grade : Int) : String? {
        val defualt = "Invalid Value";
        var letter = defualt;
        if(grade >=0 && grade <=100){
            var i = 0;
            while(letter == defualt){
                if(gradeArray[0][i++] as Int > grade)
                    letter = gradeArray[1][--i] as String;
            }
        }
        return letter;
    }
}