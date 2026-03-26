package com.example.dpa16_17

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView = findViewById(R.id.sun)
        val sunRiseAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        imageView.startAnimation(sunRiseAnimation)
        val imageView1: ImageView = findViewById(R.id.clock)
        val clockTurnAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.clock_turn)
        val imageView2: ImageView = findViewById(R.id.hour_hand)
        val hourTurnAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.hour_turn)
        imageView2.startAnimation(hourTurnAnimation)


    }
}