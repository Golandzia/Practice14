package com.example.practice14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RedactActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redact)
        showData()
    }
        private fun showData(){
        val arguments: Bundle? = intent.extras
        val editTextEmailRedact :EditText = findViewById(R.id.editTextEmailRedact)
        val editTextFullNameRedact :EditText = findViewById(R.id.editTextFullNameRedact)

        if(arguments != null){
            val eMail :String = arguments.getString("eMail", "Ничего не передано")
            val fullname :String = arguments.getString("fullName", "Ничего не передано")
            editTextEmailRedact.setText(eMail)
            editTextFullNameRedact.setText(fullname)
        }
        else{
            editTextEmailRedact.setText("ERROR")
            editTextFullNameRedact.setText("ERROR")
        }
    }
}