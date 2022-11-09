package com.example.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun sendButton(view: View){
        val editActivity = Intent(this@MainActivity, RedactActivity::class.java)
        //Ниже пример отправления данных в другое Activity
        val editTextEmailAddress :EditText = findViewById(R.id.editTextEmailAddress)
        val editTextFullName :EditText = findViewById(R.id.editTextFullName)
        intent.putExtra("eMail", editTextEmailAddress.text)
        intent.putExtra("fullName", editTextFullName.text)
        startActivity(editActivity)//Запуск другого активити
    }
}