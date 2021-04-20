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

        btnSummit.setOnClickListener{
            this.handleSummit()
        }

    }

    fun handleSummit(){
        val comment = etComment.text.toString()
        val couseCode = etCouseCode.text.toString()
        val rateProfesor = sbRate.getProgress()
        val grade = spGrade.getSelectedItem().toString();
        val difficulty = sbDifficulty.getProgress()
        val have_takeAgain = swTakeAgain.isChecked()
        val have_takeCredit = swTakeCredit.isChecked()
        val have_textBook = swTextBook.isChecked()
        val have_attendance = swAttendance.isChecked()
    }
}