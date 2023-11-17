package com.example.appimageview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast

class NumberSelectionActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_selection)
        val intent = intent
        val name = intent.getStringExtra("NAME")
        val email = intent.getStringExtra("EMAIL")
        val phone = intent.getStringExtra("PHONE")

        val welcomeText = findViewById<TextView>(R.id.selectedNumbersText)
        welcomeText.text = "$name, please select your lucky numbers!"

        val numbersPicker = findViewById<NumberPicker>(R.id.numbersPicker)
        numbersPicker.maxValue = 49
        numbersPicker.minValue = 1

        val selectButton = findViewById<Button>(R.id.selectButton)
        val selectedNumbers = HashSet<Int>()  //for storing numbers which user choose
        val getRichButton = findViewById<Button>(R.id.getRichButton)
        val numbersText = findViewById<TextView>(R.id.numbersText)
        val numbersArray = IntArray(6)
        var i = 0
        var text = ""


        selectButton.setOnClickListener {
            var selectedNumber = numbersPicker.value
            if (selectedNumbers.contains(selectedNumber)) { //for repeated numbers which user choose

            } else {
                selectedNumbers.add(selectedNumber)

                if (text.isNotEmpty()) {
                    text += ", "    //for separating numbers by coma
                }
                numbersArray[i++] = selectedNumber

                text += "$selectedNumber"
                numbersText.text = "Your numbers: $text"
                if (i >= numbersArray.size) {
                    selectButton.isEnabled = false
                    getRichButton.isEnabled = true
                }

            }


        }
        getRichButton.setOnClickListener {
            if (i == 6) { // Ensure 6 numbers are selected
                val intent = Intent(this, NumbDrawningActivity::class.java)
                intent.putExtra("SELECTED_NUMBERS", selectedNumbers.toIntArray())
                startActivity(intent)
            } else {
                // Handle the case where not enough numbers are selected
                val remainingNumbers = 6 - i
                val message = "Please select $remainingNumbers more number(s)."
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}