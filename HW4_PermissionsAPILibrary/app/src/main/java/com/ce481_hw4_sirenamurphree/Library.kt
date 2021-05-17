/**
 * https://ourcodeworld.com/articles/read/932/top-10-best-android-color-picker-libraries
 * https://github.com/QuadFlask/colorpicker/releases
 */

package com.ce481_hw4_sirenamurphree

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.OnColorSelectedListener
import com.flask.colorpicker.builder.ColorPickerClickListener
import com.flask.colorpicker.builder.ColorPickerDialogBuilder

class Library : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_library)
		title = "Library"
		
		val colorPickerLib = ColorPickerDialogBuilder
			.with(this)
			.setTitle("Choose color")
			.initialColor(-3750202)
			.wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
			.density(12)
			.setOnColorSelectedListener(object : OnColorSelectedListener {
				override fun onColorSelected(selectedColor: Int) {
					Toast.makeText(applicationContext, "onColorSelected: 0x" + Integer.toString(selectedColor), Toast.LENGTH_SHORT).show()
				}
			})
			.setPositiveButton("ok", object : ColorPickerClickListener {
				override fun onClick(dialog: DialogInterface?, selectedColor: Int, allColors: Array<Int?>?) {
				findViewById<ImageView>(R.id.color_here).setColorFilter(selectedColor)
				}
			})
			.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which -> })
			.build()
		val btn_color = findViewById<Button>(R.id.btn_color)
		btn_color.setOnClickListener {
			colorPickerLib.show();
		}
	}
}