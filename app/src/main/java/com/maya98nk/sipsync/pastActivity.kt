package com.maya98nk.sipsync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class pastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_past)



        // Get the current date
        val currentDate = Date()
        // Format the date to display the day
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val formattedDay = dayFormat.format(currentDate)
        // Assuming you have a TextView in your layout with the ID 'textViewDay'
        val textViewDay: TextView = findViewById(R.id.textView)
        textViewDay.text = formattedDay

    }
}