package com.example.rate_your_professor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ratting_profesos.*

class RattingProfesorPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratting_profesos)

        bthBack.setOnClickListener{
            val intent = intent
            val teacherInfo = intent.getSerializableExtra("TeacherInfo") as HashMap<String, String>?
            startActivity(Intent(this, ProfesorInfoPage::class.java).putExtra("TeacherInfo", teacherInfo))
        }

        btnSummit.setOnClickListener{
            this.handleSummit()
        }

    }

    fun handleSummit(){
        val comment = etComment.text.toString()
        val causeCode = etCouseCode.text.toString()
        val rateProfessor = sbRate.progress
        val grade = spGrade.selectedItem.toString();
        val difficulty = sbDifficulty.progress
        val haveTakeAgain = swTakeAgain.isChecked
        val haveTakeCredit = swTakeCredit.isChecked
        val haveTextBook = swTextBook.isChecked
        val haveAttendance = swAttendance.isChecked
    }
}