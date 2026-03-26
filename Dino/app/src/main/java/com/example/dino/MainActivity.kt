package com.example.dino

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dino = findViewById<ImageView>(R.id.dino)
        val meteor = findViewById<ImageView>(R.id.meteor)
        val bubble = findViewById<ImageView>(R.id.done_bubble)
        val explosion = findViewById<ImageView>(R.id.explosion)

        dino.post {
            val meteorFallX = ObjectAnimator.ofFloat(meteor, "translationX", -300f).apply { duration = 3000 }
            val targetY = dino.y - meteor.height / 2
            val meteorFallY = ObjectAnimator.ofFloat(meteor, "translationY", targetY).apply { duration = 3000 }
            val showBubble = ObjectAnimator.ofFloat(bubble, "alpha", 1f).apply { duration = 300 }
            val dinoJump = ObjectAnimator.ofFloat(dino, "translationY", 0f, -100f, 0f).apply { duration = 600 }
            val bubbleJump = ObjectAnimator.ofFloat(bubble, "translationY", 0f, -100f, 0f).apply { duration = 600 }
            val sceneSet = AnimatorSet()
            sceneSet.playTogether(meteorFallX, meteorFallY)
            sceneSet.play(showBubble).after(1500)
            sceneSet.play(dinoJump).after(showBubble)
            sceneSet.play(bubbleJump).with(dinoJump)

            sceneSet.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    meteor.visibility = View.GONE
                    bubble.visibility = View.GONE
                    explosion.alpha = 1f
                    dino.setImageResource(R.drawable.ddead)
                    dino.animate()
                        .translationX(1500f)
                        .translationY(-1500f)
                        .rotation(720f)
                        .setDuration(2000)
                        .start()

                    explosion.animate()
                        .alpha(0f)
                        .setStartDelay(800)
                        .setDuration(500)
                        .start()
                }
            })

            sceneSet.start()
        }
    }
}
