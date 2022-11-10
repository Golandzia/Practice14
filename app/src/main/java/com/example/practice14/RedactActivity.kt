package com.example.practice14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RedactActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redact)
        val arguments: Bundle? = intent.extras
        val editTextEmailRedact :EditText = findViewById(R.id.editTextEmailRedact)
        val editTextFullNameRedact :EditText = findViewById(R.id.editTextFullNameRedact)

        if(arguments != null){
            editTextEmailRedact.setText("${arguments.get("email")}")
            editTextFullNameRedact.setText("${arguments.get("fullName")}")
        }
        else{
            val errorToast = Toast.makeText(this, "Ошибка передачи данных\nCode:1", Toast.LENGTH_SHORT)
            errorToast.show()
        }
    }

    fun sendRedactedData(view: View){
        val redactedToMainActivity = Intent(this@RedactActivity, MainActivity::class.java)
        val editTextEmailRedact :EditText = findViewById(R.id.editTextEmailRedact)
        val editTextFullNameRedact :EditText = findViewById(R.id.editTextFullNameRedact)
        if(editTextEmailRedact.text.isNotEmpty() && editTextFullNameRedact.text.isNotEmpty()){
            redactedToMainActivity.putExtra("emailRedacted", editTextEmailRedact.text.toString() + "*")
            redactedToMainActivity.putExtra("fullNameRedacted", editTextFullNameRedact.text.toString() + "*")
            startActivity(redactedToMainActivity)
        }
        else{
            val errorToast = Toast.makeText(this, "Ошибка передачи данных\nCode:2", Toast.LENGTH_SHORT)
            errorToast.show()
        }
    }
}
