package com.example.dpa14_15

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
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
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.buttonShowMenu)
        val popupMenuForImage = PopupMenu(this, imageView)
        popupMenuForImage.menuInflater.inflate(R.menu.popupmenu, popupMenuForImage.menu)

        popupMenuForImage.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu1 -> {
                    textView.text = "Clicked popupmenu 1"
                    true
                }
                R.id.menu2 -> {
                    textView.text = "Clicked popupmenu 2"
                    true
                }
                R.id.menu3 -> {
                    textView.text = "Clicked popupmenu 3"
                    true
                }
                R.id.submenu -> {
                    textView.text = "Clicked submenu"
                    true
                }
                R.id.menu4 -> {
                    menuItem.isChecked = !menuItem.isChecked
                    textView.text = "Menu 4: ${if (menuItem.isChecked) "checked" else "unchecked"}"
                    true
                }
                R.id.menu5 -> {
                    textView.text = "Clicked popupmenu 5"
                    true
                }
                R.id.menu6 -> {
                    textView.text = "Clicked popupmenu 6"
                    true
                }
                else -> false
            }
        }

        imageView.setOnClickListener {
            popupMenuForImage.show()
        }

        val popupMenu2 = PopupMenu(this, button)
        popupMenu2.menuInflater.inflate(R.menu.colormenu, popupMenu2.menu)

        popupMenu2.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.red -> {
                    textView.background = ColorDrawable(Color.RED)
                    textView.text = "Red color"
                    true
                }
                R.id.yellow -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "Yellow color"
                    true
                }
                R.id.green -> {
                    textView.background = ColorDrawable(Color.GREEN)
                    textView.text = "Green color"
                    true
                }
                else -> false
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupMenu2.setForceShowIcon(true)
        }

        button.setOnClickListener {
            popupMenu2.show()
        }

        val popupMenuForText = PopupMenu(this, textView)
        popupMenuForText.menuInflater.inflate(R.menu.textsizemenu, popupMenuForText.menu)

        popupMenuForText.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.size_small -> {
                    textView.textSize = 14f
                    textView.text = "Text size: 14sp"
                    true
                }
                R.id.size_medium -> {
                    textView.textSize = 18f
                    textView.text = "Text size: 18sp"
                    true
                }
                R.id.size_large -> {
                    textView.textSize = 24f
                    textView.text = "Text size: 24sp"
                    true
                }
                R.id.size_extra_large -> {
                    textView.textSize = 32f
                    textView.text = "Text size: 32sp"
                    true
                }
                else -> false
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupMenuForText.setForceShowIcon(true)
        }
        textView.setOnLongClickListener {
            popupMenuForText.show()
            true
        }
    }
}