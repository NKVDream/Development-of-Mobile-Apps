package com.example.dpa8_9

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private var secretNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun startGame(view: View) {
        val minInput = findViewById<EditText>(R.id.minEditText2)
        val maxInput = findViewById<EditText>(R.id.maxEditText2)

        val min = minInput.text.toString().toIntOrNull() ?: 1
        val max = maxInput.text.toString().toIntOrNull() ?: 100

        if (min >= max) {
            Toast.makeText(this, "Минимум должен быть меньше максимума", Toast.LENGTH_SHORT).show()
            return
        }

        secretNumber = Random.nextInt(min, max + 1)
        findViewById<TextView>(R.id.statusText).text = "Противник сделал свой ход. Введите ваш вариант"
        findViewById<EditText>(R.id.guessInput).isEnabled = true
        findViewById<Button>(R.id.checkButton).isEnabled = true
    }

    fun checkGuess(view: View) {
        val guessInput = findViewById<EditText>(R.id.guessInput)
        val guess = guessInput.text.toString().toIntOrNull()

        if (guess == null) {
            Toast.makeText(this, "Введите число", Toast.LENGTH_SHORT).show()
            return
        }

        val resultText = findViewById<TextView>(R.id.resultText2)

        if (guess == secretNumber) {
            resultText.text = "Вы угадали число $secretNumber!"
            findViewById<EditText>(R.id.guessInput).isEnabled = false
            findViewById<Button>(R.id.checkButton).isEnabled = false
        } else {
            resultText.text = "Не угадали."
            guessInput.text.clear()
        }
    }
}
