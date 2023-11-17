/*package com.example.appimageview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        //intent for passing data from previous activity
        val intent = intent


        val getNumbersButton = findViewById<Button>(R.id.getNumbersButton)
        val textViewRandom1 = findViewById<TextView>(R.id.textViewRandom1)
        val textViewRandom2 = findViewById<TextView>(R.id.textViewRandom2)
        val textViewRandom3 = findViewById<TextView>(R.id.textViewRandom3)
        val textViewRandom4 = findViewById<TextView>(R.id.textViewRandom4)
        val textViewRandom5 = findViewById<TextView>(R.id.textViewRandom5)
        val textViewRandom6 = findViewById<TextView>(R.id.textViewRandom6)

        val selectedNumbersText = findViewById<TextView>(R.id.selectedNumbersText)
        val selectedNumbers = intent.getIntArrayExtra("SELECTED NUMBERS")
        if (selectedNumbers != null) {
            // Set the text of the TextView with the selected numbers
            selectedNumbersText.text = "Selected Numbers: ${selectedNumbers.joinToString(", ")}"
        } else {
            // Handle the case where selectedNumbers are not received
            selectedNumbersText.text = "No numbers selected"
        }

        getNumbersButton.setOnClickListener {
            val randomNumbers = genRandNumbers()

            setTextViewWithSnackbar(
                textViewRandom1,
                randomNumbers[0],
                intent.getIntArrayExtra("SELECTED NUMBERS"),
                "Displaying textViewRandom1"
            )

            // Delay for the next TextView with a Snackbar
            Handler(Looper.getMainLooper()).postDelayed({
                setTextViewWithSnackbar(
                    textViewRandom2,
                    randomNumbers[1],
                    intent.getIntArrayExtra("SELECTED NUMBERS"),
                    "Displaying textViewRandom2"
                )
            }, 1000) // Delay after textViewRandom1

            Handler(Looper.getMainLooper()).postDelayed({
                setTextViewWithSnackbar(
                    textViewRandom3,
                    randomNumbers[2],
                    intent.getIntArrayExtra("SELECTED NUMBERS"),
                    "Displaying textViewRandom3"
                )
            }, 1000) // Delay after textViewRandom2

            Handler(Looper.getMainLooper()).postDelayed({
                setTextViewWithSnackbar(
                    textViewRandom4,
                    randomNumbers[3],
                    intent.getIntArrayExtra("SELECTED NUMBERS"),
                    "Displaying textViewRandom4"
                )
            }, 1000) // Delay after textViewRandom3

            Handler(Looper.getMainLooper()).postDelayed({
                setTextViewWithSnackbar(
                    textViewRandom5,
                    randomNumbers[4],
                    intent.getIntArrayExtra("SELECTED NUMBERS"),
                    "Displaying textViewRandom5"
                )
            }, 1000) // Delay after textViewRandom4


            Handler(Looper.getMainLooper()).postDelayed({
                setTextViewWithSnackbar(
                    textViewRandom6,
                    randomNumbers[5],
                    intent.getIntArrayExtra("SELECTED NUMBERS"),
                    "Displaying textViewRandom6"
                )
                val numbersTextView = findViewById<TextView>(R.id.numbersTextView)
                numbersTextView.text = "Your chosen numbers: ${
                    intent.getIntArrayExtra("SELECTED NUMBERS")?.joinToString(", ")
                }"
            }, 1000) // Delay after textViewRandom5
        }
    }


}

    fun genRandNumbers(): List<Int> {
        val random = Random
        val randomNumbers =
            mutableListOf<Int>()
        while (randomNumbers.size < 6) {
            val number = random.nextInt(49) + 1
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number)


            }
        }
        return randomNumbers
    }

    fun setTextViewWithSnackbar(textView: TextView, number: Int, selectedNumbers: IntArray?, message: String) {
        textView.text = "$number"
        if (selectedNumbers != null && number in selectedNumbers) {
            textView.setTextColor(Color.GREEN)
        } else {
            textView.setTextColor(Color.RED)
        }
        showProgressSnackbar(textView, message)

    }
fun showProgressSnackbar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}




*/






