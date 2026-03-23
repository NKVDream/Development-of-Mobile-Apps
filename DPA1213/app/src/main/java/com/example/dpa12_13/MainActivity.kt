package com.example.dpa12_13

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Убеждаемся, что привязан правильный файл разметки
        setContentView(R.layout.activity_1)
    }

    // 2. Создаем меню из файла menu_main.xml
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // 3. Обрабатываем нажатия
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Ищем TextView, который находится ВНУТРИ activity_1.xml
        val textView: TextView = findViewById(R.id.textView)

        when (item.itemId) {
            R.id.action_settings -> {
                textView.text = "Выбраны настройки"
                return true
            }
            R.id.action1 -> {
                textView.text = "Выбран пункт 1"
                return true
            }
            R.id.action2 -> {
                textView.text = "Выбран пункт 2"
                return true
            }
            R.id.action3 -> {
                textView.text = "Выбран пункт 3"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

