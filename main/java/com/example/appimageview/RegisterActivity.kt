package com.example.appimageview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        editTextPassword.contentDescription = getString(R.string.password_field_description)


        val signUpButton: Button = findViewById(R.id.SignUpButton)
        signUpButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}