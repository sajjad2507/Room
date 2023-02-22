package com.example.rommnvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var users: List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        val tv = findViewById<TextView>(R.id.tv)

        val userDao = db.userDao()


        GlobalScope.launch {
            val obj = User(1, "sajjad", "ali")
            userDao.insertAll(obj)
            users = userDao.getAll()

            val text = users.toString()

            Log.e("@@@", text)

        }

    }
}