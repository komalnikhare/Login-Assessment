package com.example.loginassessment.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.loginassessment.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultCode = intent.getIntExtra("statusCode", 1)
        if (resultCode == 0){
            status.text = "Login Successful"
            val username = intent.getStringExtra("userName")
            welcomeString.text = "Welcome $username"
        }else{
            status.text = "Login Failed Invalid credential"
            val actionbar = supportActionBar
            actionbar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}