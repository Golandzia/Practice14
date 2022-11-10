package com.example.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arguments: Bundle? = intent.extras
        val editTextEmailAddress :EditText = findViewById(R.id.editTextEmailAddress)
        val editTextFullName :EditText = findViewById(R.id.editTextFullName)
        if(arguments != null){
            editTextEmailAddress.setText("${arguments.get("emailRedacted")}")
            editTextFullName.setText("${arguments.get("fullNameRedacted")}")
        }
    }
    fun sendButton(view: View){
        val editActivity = Intent(this@MainActivity, RedactActivity::class.java)
        //Ниже пример отправления данных в другое Activity
        val editTextEmailAddress :EditText = findViewById(R.id.editTextEmailAddress)
        val editTextFullName :EditText = findViewById(R.id.editTextFullName)
        if(editTextEmailAddress.text.isNotEmpty() && editTextFullName.text.isNotEmpty()) {
            editActivity.putExtra("email", editTextEmailAddress.text.toString())
            editActivity.putExtra("fullName", editTextFullName.text.toString())

            startActivity(editActivity)//Запуск другого активити
        }
        else{
            val errorToast = Toast.makeText(this, "Введено некорректное значение", Toast.LENGTH_SHORT)
            errorToast.show()
        }

    }
}