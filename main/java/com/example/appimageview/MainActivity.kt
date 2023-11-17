package com.example.appimageview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

           // here login activity


        val switchView = findViewById<Switch>(R.id.switch1)
        val buttonGame = findViewById<Button>(R.id.buttonGame)
        buttonGame.isEnabled = false


        switchView.setOnCheckedChangeListener { _, isChecked ->
            buttonGame.isEnabled = false
            if (isChecked == true) {
                switchView.text = "Yes"
            } else {
                switchView.text = "No"
            }
            buttonGame.isEnabled = isChecked
        }


        val InputName = findViewById<EditText>(R.id.editTextText)
        val InputMail = findViewById<EditText>(R.id.editTextEmail)

        val PasswordButtonInLoginAct: EditText = findViewById(R.id.editTextPasswordInMain)
        PasswordButtonInLoginAct.contentDescription = getString(R.string.password_field_description)


        buttonGame.setOnClickListener {
            var name = InputName.text.toString()
            if (name.isEmpty()){
                name = "unknown"
            }
            var email = InputMail.text.toString()
            if (email.isEmpty()){
                email = "unknown"
            }

            val intent = Intent(this, NumberSelectionActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("EMAIL", email)
            startActivity(intent)


        }

    }

    // Register activity
    fun registerButtonClicked(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }


}



