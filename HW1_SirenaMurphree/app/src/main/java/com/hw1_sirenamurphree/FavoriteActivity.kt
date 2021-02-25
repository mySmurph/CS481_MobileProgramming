package com.hw1_sirenamurphree

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class FavoriteActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var toasting = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val fav_group = findViewById<RadioGroup>(R.id.radio_fav_group);
        val fav_spinner = findViewById<Spinner>(R.id.spinner_fav);
        val flower_data = arrayOf("Amaranthus", "Bleeding Heart", "Gerbera", "Hydrangea", "Snapdragon");
        val fruit_data = arrayOf("Cantaloupe", "Kiwi", "Pomegranate", "Strawberries", "Tangerine");
        val empty_data = arrayOf("");
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, empty_data);


        fav_group.setOnCheckedChangeListener { radioGroup: RadioGroup, checkedId: Int ->
            toasting = false;
            var data = empty_data;
            when(checkedId){
                R.id.radio_flower -> data = flower_data;
                R.id.radio_fruit ->  data = fruit_data;
                else ->              data = empty_data;
            }
            arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
            fav_spinner.adapter = arrayAdapter;

        }
        fav_spinner.onItemSelectedListener = this;
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, item: Int, id: Long) {
        if(toasting) {
            val fav_type = findViewById<RadioButton>(findViewById<RadioGroup>(R.id.radio_fav_group).checkedRadioButtonId).text;
            val fav_item = parent?.getItemAtPosition(item).toString();

            val toast = Toast.makeText(this,
                    "You have selected " + fav_item + " as your favorite " + fav_type + ".",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        toasting = true;
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        return;
    }
}
