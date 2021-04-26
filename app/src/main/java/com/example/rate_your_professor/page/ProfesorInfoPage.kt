package com.example.rate_your_professor.page

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rate_your_professor.api.ProfessorInfoApi
import com.example.rate_your_professor.R
import com.example.rate_your_professor.adapter.StudentAdapter
import com.example.rate_your_professor.model.apiCall.studentComment.StudentComment
import kotlinx.android.synthetic.main.profesor_information_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfesorInfoPage : AppCompatActivity() {
    private lateinit var studentCommentAdapter: StudentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profesor_information_page)

        val intent = intent
        val teacherInfo = intent.getSerializableExtra("TeacherInfo") as HashMap<String, String>?

        tvInfoRatting.text = teacherInfo?.get("teacherName")
        tvInfoName.text = teacherInfo?.get("ratting") + "/5"
        tvInfoAgainPercent.text = teacherInfo?.get("takeAgainPercent") + "%"
        tvInfoDifficulty.text = teacherInfo?.get("difficultyLevel")

        btnInfoBack.setOnClickListener{
            startActivity(Intent(this, MainActivityPage::class.java))
        }

        btnRateProfessor.setOnClickListener{
            val intent = Intent(this, RattingProfessorPage::class.java)
            intent.putExtra("TeacherInfo", teacherInfo)
            startActivity(intent)
        }

        studentCommentAdapter = StudentAdapter(mutableListOf())

        this.callApi( teacherInfo?.get("id") )

        rvStudentComment.adapter = studentCommentAdapter
        rvStudentComment.layoutManager = LinearLayoutManager( this)

    }

    private fun callApi(id: String?){
        if (id != null) {
            ProfessorInfoApi().getStudentCommentInfo( id ).enqueue(object : Callback<StudentComment> {
                override fun onFailure(call: Call<StudentComment>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<StudentComment>, response: Response<StudentComment>) {
                    response.body()?.let {
                        studentCommentAdapter.setTeacherInfo(it)
                    }
                }

            })
        }
    }
}
