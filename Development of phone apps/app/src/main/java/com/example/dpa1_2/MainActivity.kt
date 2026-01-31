package com.example.dpa1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView : ImageView =
            findViewById(R.id.imageView2)
        val translation = TranslateAnimation(0f,0f,-
        1000f,0f)
        translation.duration = 5000
        translation.interpolator = BounceInterpolator()
        imageView.startAnimation(translation)
    }
}
