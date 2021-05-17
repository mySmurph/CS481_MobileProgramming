package com.ce481_hw4_sirenamurphree

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Permission : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_permission)
		title = "Permission Activity"
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED){
			if (ActivityCompat.shouldShowRequestPermissionRationale(this,
					Manifest.permission.CAMERA)) {
				ActivityCompat.requestPermissions(this,
					arrayOf(Manifest.permission.CAMERA), 1)
			} else {
				ActivityCompat.requestPermissions(this,
					arrayOf(Manifest.permission.CAMERA), 1)
			}
		}
	}
	
	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
	                                        grantResults: IntArray) {
		when (requestCode) {
			1 -> {
				if (grantResults.isNotEmpty() && grantResults[0] ==
					PackageManager.PERMISSION_GRANTED) {
					if ((ContextCompat.checkSelfPermission(this,
							Manifest.permission.CAMERA) ===
							   PackageManager.PERMISSION_GRANTED)) {
						Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
					}
				} else {
					Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
				}
				return
			}
		}
	}
}