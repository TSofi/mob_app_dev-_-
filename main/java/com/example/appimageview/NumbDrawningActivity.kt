package com.example.appimageview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.random.Random
import android.os.Handler
import android.os.Looper
import android.view.View


class NumbDrawningActivity : AppCompatActivity() {

    fun lotto(n: Int = 6, m: Int = 49): IntArray {
        if (m < n) {
            println("Range cannot be smaller than array size")
            return IntArray(n)
        } else {
            var numbers = IntArray(n)
            var iterator = 0
            var number: Int
            var check: Boolean
            do {
                number = (1..m).random()
                check = true
                for (i in 0 until iterator) {
                    if (numbers[i] == number) {
                        check = false
                        break
                    }
                }
                if (check) {
                    numbers[iterator++] = number
                }
            } while (iterator < n)
            return numbers
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numb_drawning)

        val intent = intent


        val getNumbersButton = findViewById<Button>(R.id.getNumbersButton)
        val textViewRandom1 = findViewById<TextView>(R.id.textViewRandom1)
        val textViewRandom2 = findViewById<TextView>(R.id.textViewRandom2)
        val textViewRandom3 = findViewById<TextView>(R.id.textViewRandom3)
        val textViewRandom4 = findViewById<TextView>(R.id.textViewRandom4)
        val textViewRandom5 = findViewById<TextView>(R.id.textViewRandom5)
        val textViewRandom6 = findViewById<TextView>(R.id.textViewRandom6)
        val numbersTextView = findViewById<TextView>(R.id.numbersTextView)


        val selectedNumbers = intent.getIntArrayExtra("SELECTED_NUMBERS")
        // checks if selectedNumbers contain 6 numbers
        if (selectedNumbers != null && selectedNumbers.size == 6) {
            val chosenNumbersText = "Your chosen numbers: " + selectedNumbers.joinToString(", ")
            numbersTextView.text = chosenNumbersText
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


        getNumbersButton.setOnClickListener {
            val randomNumbers = genRandNumbers()

            val textViewList = listOf(
                textViewRandom1,
                textViewRandom2,
                textViewRandom3,
                textViewRandom4,
                textViewRandom5,
                textViewRandom6
            )
            for (textView in textViewList) {
                textView.visibility = View.INVISIBLE




                for (i in 0 until randomNumbers.size) {
                    val textView = textViewList[i]
                    val number = randomNumbers[i]
                    textView.text = number.toString()

                    if (selectedNumbers != null && selectedNumbers.contains(number)) {
                        textView.setTextColor(Color.GREEN)
                    } else {
                        textView.setTextColor(Color.RED)
                    }
                }
                for (textView in textViewList) {
                    textView.setTextColor(Color.BLACK)
                }


                val progressBar = findViewById<ProgressBar>(R.id.progressBar)
                progressBar.max = 6
                val delayMillis = 1000L
                val handler = Handler(Looper.getMainLooper())


                val buttons = textViewList

                Thread {
                    var progressStatus = 0
                    val drawingNumbs = lotto()

                    for (button in buttons) {
                        progressStatus += 1
                        handler.post {
                            progressBar.progress = progressStatus
                            button.text = drawingNumbs[progressStatus - 1].toString()
                            if (selectedNumbers != null) {
                                if (drawingNumbs[progressStatus - 1] in selectedNumbers) {
                                    button.setTextColor(Color.GREEN)
                                } else {
                                    button.setTextColor(Color.RED)
                                }
                            }
                            button.visibility = View.VISIBLE
                        }
                        try {
                            Thread.sleep(delayMillis)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                }.start()


            }



        }


    }
}