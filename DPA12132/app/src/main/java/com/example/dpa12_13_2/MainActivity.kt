package com.example.dpa12_13_2

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.main)
        textView = findViewById(R.id.textView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action1 -> {
                rootLayout.setBackgroundColor(Color.RED)
                textView.text = "You selected item1 - Background changed to RED"
                Toast.makeText(this, "Item 1 selected: Background color changed to RED", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action2 -> {
                rootLayout.setBackgroundColor(Color.GREEN)
                textView.text = "You selected item2 - Background changed to GREEN"
                Toast.makeText(this, "Item 2 selected: Background color changed to GREEN", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action3 -> {
                rootLayout.setBackgroundColor(Color.BLUE)
                textView.text = "You selected item3 - Background changed to BLUE"
                Toast.makeText(this, "Item 3 selected: Background color changed to BLUE", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.action_settings -> {
                rootLayout.setBackgroundColor(Color.YELLOW)
                textView.text = "You selected settings - Background changed to YELLOW"
                Toast.makeText(this, "Settings selected: Background color changed to YELLOW", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}