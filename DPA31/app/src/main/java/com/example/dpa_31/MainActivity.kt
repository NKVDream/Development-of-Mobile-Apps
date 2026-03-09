package com.example.dpa_31

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var radioGroupChoice: RadioGroup
    private lateinit var radioBath: RadioButton
    private lateinit var radioLife: RadioButton
    private lateinit var imageButton: ImageButton
    private lateinit var imageViewMain: ImageView
    private lateinit var textViewResult: TextView
    private lateinit var textViewQuestion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setupButtonListener()
    }

    private fun initViews() {
        editTextName = findViewById(R.id.editTextName)
        radioGroupChoice = findViewById(R.id.radioGroupChoice)
        radioBath = findViewById(R.id.radioBath)
        radioLife = findViewById(R.id.radioLife)
        imageButton = findViewById(R.id.imageButton)
        imageViewMain = findViewById(R.id.imageViewMain)
        textViewResult = findViewById(R.id.textViewResult)
        textViewQuestion = findViewById(R.id.textViewQuestion)
        imageViewMain.setImageResource(R.drawable.ic_bath_or_life)
    }


    private fun setupButtonListener() {
        imageButton.setOnClickListener {
            val catName = editTextName.text.toString().trim()
            val selectedId = radioGroupChoice.checkedRadioButtonId

            when (selectedId) {
                R.id.radioBath -> {
                    imageViewMain.setImageResource(R.drawable.ic_bath)

                    val message = if (catName.isEmpty()) {
                        "He had suffered so much!"
                    } else {
                        "$catName will learn his lesson."
                    }
                    textViewResult.text = message
                    textViewQuestion.text = "There are fates worse than death"
                }

                R.id.radioLife -> {
                    imageViewMain.setImageResource(R.drawable.ic_life)

                    val message = if (catName.isEmpty()) {
                        "He will be meowing happily until next trial!"
                    } else {
                        "$catName slipped away from the bath again"
                    }
                    textViewResult.text = message
                    textViewQuestion.text = "He is safe. For now..."
                }

                else -> {
                    Toast.makeText(this, "Make your damn choice!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}