package com.ce481_hw4_sirenamurphree

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.launch
import org.json.JSONObject

class API : AppCompatActivity() {
	var resultView: TextView? = null
	
    override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_api)
	
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) !== PackageManager.PERMISSION_GRANTED){
			if (ActivityCompat.shouldShowRequestPermissionRationale(this,
					Manifest.permission.INTERNET)) {
				ActivityCompat.requestPermissions(this,
					arrayOf(Manifest.permission.INTERNET), 1)
			} else {
				ActivityCompat.requestPermissions(this,
					arrayOf(Manifest.permission.INTERNET), 1)
			}
		}
		
		title = "API Activity"
		val spin_sign = findViewById<Spinner>(R.id.spin_sign)
		val spin_day = findViewById<Spinner>(R.id.spin_day)
		val btn_sign = findViewById<Button>(R.id.btn_sign)
	
		val adapt_day = ArrayAdapter.createFromResource(this, R.array.spin_day, android.R.layout.simple_spinner_item)
		val adapt_sign = ArrayAdapter.createFromResource(this, R.array.spin_sign, android.R.layout.simple_spinner_item)

		spin_day.adapter = adapt_day
		spin_sign.adapter = adapt_sign
		
		resultView = findViewById<TextView>(R.id.tv_description_api)
		
		btn_sign.setOnClickListener {
			val sign = spin_sign.selectedItem.toString()
			val day = spin_day.selectedItem.toString()
			findViewById<TextView>(R.id.tv_description_api).text = ""
			GlobalScope.async {
				getHoroscope(sign, day)
			}
		}
    }
	suspend fun getHoroscope(sign: String, day:String){
		try {
			val result = GlobalScope.async {
				println("Sign: "+ sign+" Day: "+day)
				callAztroAPI("https://sameer-kumar-aztro-v1.p.rapidapi.com/?sign=" + sign + "&day="+day)
			}.await()
			onResponse(sign, result)
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}
	
	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
											grantResults: IntArray) {
		when (requestCode) {
			1 -> {
				if (grantResults.isNotEmpty() && grantResults[0] ==
					PackageManager.PERMISSION_GRANTED) {
					if ((ContextCompat.checkSelfPermission(this,
							Manifest.permission.INTERNET) ===
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
	
	
	private fun callAztroAPI(apiUrl:String ):String?{
		var result: String? = ""
		val url: URL;
		var connection: HttpURLConnection? = null
		try {
			url = URL(apiUrl)
			connection = url.openConnection() as HttpURLConnection
			// set headers for the request
			// set host name
			connection.setRequestProperty("x-rapidapi-host", "sameer-kumar-aztro-v1.p.rapidapi.com")
			// set the rapid-api key
			connection.setRequestProperty("x-rapidapi-key", "e22c699cc5msh5e576b767f72909p1318a3jsnd1ecf3e0cc19")
			connection.setRequestProperty("content-type", "application/x-www-form-urlencoded")
			// set the request method - POST
			connection.requestMethod = "POST"
			val `in` = connection.inputStream
			val reader = InputStreamReader(`in`)
			// read the response data
			var data = reader.read()
			while (data != -1) {
				val current = data.toChar()
				result += current
				data = reader.read()
			}
			return result
		} catch (e: Exception) {
			e.printStackTrace()
		}
		// if not able to retrieve data return null
		return null
	}
	private fun onResponse(sign: String, result: String?) {
		try {
			// convert the string to JSON object for better reading
			val resultJson = JSONObject(result)
			println(result)
			var prediction ="Prediction for "+ sign+" \n"
			// Update text with various fields from response
			prediction += resultJson.getString("date_range")+"\n"
			prediction += resultJson.getString("description")
			
			resultView!!.text = prediction
		} catch (e: Exception) {
			e.printStackTrace()
			println("Oops!! something went wrong, please try again")
		}
	}
}