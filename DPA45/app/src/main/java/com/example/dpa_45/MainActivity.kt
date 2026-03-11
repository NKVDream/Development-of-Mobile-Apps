package com.example.dpa_45

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCounter: ImageButton = findViewById(R.id.button_counter)
        val textView: TextView = findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.imageView)
        val mainLayout: ConstraintLayout = findViewById(R.id.main)
        val topBar: View = findViewById(R.id.topBar)
        val lowBar: View = findViewById(R.id.lowBar)

        textView.text = "Protect Israel!"

        buttonCounter.setOnClickListener {
            counter++
            textView.text = "Goyim eliminated: $counter"

            if (counter == 50) {
                imageView.setImageResource(R.drawable.impressed)
                handler.postDelayed({
                    imageView.setImageResource(R.drawable.mossad)
                }, 2000)
            }
            if (counter == 67) {
                imageView.setImageResource(R.drawable.imcry)
                handler.postDelayed({
                    imageView.setImageResource(R.drawable.mossad)
                }, 2000)
            }
            if (counter == 100) {
                imageView.setImageResource(R.drawable.forisra)
                handler.postDelayed({
                    imageView.setImageResource(R.drawable.mossad)
                }, 2000)
            }
            if (counter == 120) {
                counter = 666
                val rotateAnimation = RotateAnimation(
                    0f, 360f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f
                ).apply {
                    duration = 1200
                    fillAfter = true
                }

                buttonCounter.startAnimation(rotateAnimation)
                mainLayout.setBackgroundColor(Color.BLACK)
                topBar.setBackgroundColor(Color.parseColor("#af2a2a"))
                lowBar.setBackgroundColor(Color.parseColor("#af2a2a"))
                imageView.setImageResource(R.drawable.netanyahu)
                buttonCounter.setImageResource(R.drawable.satan)
                buttonCounter.setBackgroundColor(Color.BLACK)
                textView.setTextColor(Color.parseColor("#af2a2a"))
                textView.text = "Goyim eliminated: $counter"
            }
        }
    }
}