package com.hw1_sirenamurphree

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goTo_GradeActivity = findViewById<Button>(R.id.btn_GradeAvtivity);
        goTo_GradeActivity.setOnClickListener {
            val go = Intent(this, GradeActivity::class.java);
            startActivity(go);
        }
        val goTo_FavoriteActivity = findViewById<Button>(R.id.btn_FavoriteActivity);
        goTo_FavoriteActivity.setOnClickListener {
            val go = Intent(this, FavoriteActivity::class.java);
            startActivity(go);
        }

        val switch_AP = findViewById<Switch>(R.id.switch_AP);
        val img = findViewById<ImageView>(R.id.img_AP);
        switch_AP.setOnCheckedChangeListener { _, isChecked ->  swapAvatarPhoto(isChecked, img)};

//        val myArray = arrayOf("Preston M.", "History", 3);
//        val info = findViewById<ListView>(R.id.lv_Info);
//        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myArray);
//        info.adapter = arrayAdapter;

    }
    fun swapAvatarPhoto(isChecked : Boolean, iv : ImageView ):Unit{
        val drawable_id  = if(isChecked) R.drawable.photo else R.drawable.avatar;
            iv.setImageResource(drawable_id);
    }
}