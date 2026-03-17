package com.example.dpa67

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val redButton : Button = findViewById(R.id.redButton)
        val greenButton : Button = findViewById(R.id.brownButton)
        val blueButton : Button = findViewById(R.id.BlueButton)
        val textView : TextView = findViewById(R.id.textView)
        val rLayout : ConstraintLayout = findViewById(R.id.root_layout)

        redButton.setOnClickListener{
            textView.text = "Красный"
            textView.textSize = 40f
            rLayout.setBackgroundColor(resources.getColor(R.color.redColor,null))
        }
        greenButton.setOnClickListener {
            textView.text = "Коричневый"
            textView.textSize = 50f
            rLayout.setBackgroundColor(resources.getColor(R.color.brownColor,null))
        }
        blueButton.setOnClickListener {
            textView.text = "Синий"
            textView.textSize = 70f
            rLayout.setBackgroundColor(resources.getColor(R.color.blueColor,null))
        }
    }
}
