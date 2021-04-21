package com.example.rate_your_professor.page

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rate_your_professor.api.ProfessorInfoApi
import com.example.rate_your_professor.R
import com.example.rate_your_professor.model.apiCall.summitInfo.SummitModel
import kotlinx.android.synthetic.main.activity_ratting_profesos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val grade = spGrade.selectedItem.toString()
        val difficulty = sbDifficulty.progress
        val haveTakeAgain = swTakeAgain.isChecked
        val haveTakeCredit = swTakeCredit.isChecked
        val haveTextBook = swTextBook.isChecked
        val haveAttendance = swAttendance.isChecked

        val data = SummitModel(
                "morpheus",
                "leader"
        )
        this.callApi(data)
    }

    private fun callApi(data: SummitModel) {
        ProfessorInfoApi().postSummit( data ).enqueue( object : Callback<SummitModel> {
            override fun onFailure(call: Call<SummitModel>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<SummitModel>, response: Response<SummitModel>) {
                if (response.isSuccessful){
                    Log.v("xxxxxx", response.toString())
                    Toast.makeText(this@RattingProfesorPage,"Successful",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}