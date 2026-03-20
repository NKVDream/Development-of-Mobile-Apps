package com.example.dpa10_11

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Activity1 : AppCompatActivity() {
    var colors = arrayOf(0xFFC5CAE9.toInt(), 0xFFB2EBF2.toInt(), 0xFFFFF9C4.toInt())

    val text by lazy { findViewById<EditText>(R.id.text) }
    var sheetNumber = 0
    var fontSize = 20f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        sheetNumber = intent.getIntExtra("sheetNumber", 0)

        val next: Button = findViewById(R.id.next)
        next.setOnClickListener {
            saveData()
            if (sheetNumber < colors.size - 1) {
                val intent = Intent(this, this::class.java)
                intent.putExtra("sheetNumber", sheetNumber + 1)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "That's all", Toast.LENGTH_SHORT).show()
            }
        }

        val btnPlus: Button = findViewById(R.id.btnPlus)
        val btnMinus: Button = findViewById(R.id.btnMinus)

        btnPlus.setOnClickListener {
            fontSize += 2f
            text.textSize = fontSize
        }

        btnMinus.setOnClickListener {
            if (fontSize > 10f) {
                fontSize -= 2f
                text.textSize = fontSize
            }
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun saveData() {
        val prefs = getPreferences(Context.MODE_PRIVATE).edit()
        prefs.putString("note$sheetNumber", text.text.toString())
        prefs.putFloat("size$sheetNumber", fontSize)
        prefs.apply()
    }

    override fun onResume() {
        super.onResume()
        val sheet: ConstraintLayout = findViewById(R.id.sheet)
        sheet.setBackgroundColor(colors[sheetNumber])

        val prefs = getPreferences(Context.MODE_PRIVATE)

        val saveState = prefs.getString("note$sheetNumber", "")
        text.setText(saveState)

        fontSize = prefs.getFloat("size$sheetNumber", 20f)
        text.textSize = fontSize
    }
}
