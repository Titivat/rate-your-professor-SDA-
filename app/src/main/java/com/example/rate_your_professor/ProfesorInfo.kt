package com.example.rate_your_professor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.profesor_information_page.*

class ProfesorInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profesor_information_page )

        btnInfoBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnRateProfessor.setOnClickListener{
            startActivity(Intent(this, RattingProfeso::class.java))
        }


    }
}