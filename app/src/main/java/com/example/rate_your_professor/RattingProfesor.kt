package com.example.rate_your_professor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ratting_profesos.*
import kotlinx.android.synthetic.main.profesor_information_page.*

class RattingProfesor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratting_profesos)

        bthBack.setOnClickListener{
            startActivity(Intent(this, ProfesorInfo::class.java))
        }

    }
}