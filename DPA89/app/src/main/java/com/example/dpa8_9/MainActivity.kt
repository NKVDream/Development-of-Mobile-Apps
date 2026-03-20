package com.example.dpa8_9

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun computerGuess(view: View) {
        val minInput = findViewById<EditText>(R.id.minEditText)
        val maxInput = findViewById<EditText>(R.id.maxEditText)
        val userNumberInput = findViewById<EditText>(R.id.userNumberInput)

        val min = minInput.text.toString().toIntOrNull()
        val max = maxInput.text.toString().toIntOrNull()
        val userNumber = userNumberInput.text.toString().toIntOrNull()

        // Проверка ввода
        if (min == null || max == null || userNumber == null) {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            return
        }

        if (min >= max) {
            Toast.makeText(this, "Минимум должен быть меньше максимума", Toast.LENGTH_SHORT).show()
            return
        }

        if (userNumber < min || userNumber > max) {
            Toast.makeText(this, "Число должно быть в диапазоне", Toast.LENGTH_SHORT).show()
            return
        }

        // противник гадает
        val computerGuess = Random.nextInt(min, max + 1)

        val resultText = findViewById<TextView>(R.id.resultText)
        if (computerGuess == userNumber) {
            resultText.text = "Противник угадал"
        } else {
            resultText.text = "Противнки не угадал. Он назвал $computerGuess."
        }
    }

    fun openSecondActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}
