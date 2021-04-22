package com.example.rate_your_professor.page

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rate_your_professor.api.ProfessorInfoApi
import com.example.rate_your_professor.R
import com.example.rate_your_professor.adapter.TeacherAdapter
import com.example.rate_your_professor.model.apiCall.profesorInfo.ProfessorModel
import com.example.rate_your_professor.model.pageList.TeacherInfo
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPage : AppCompatActivity() {
    private lateinit var professorInfoAdapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        professorInfoAdapter = TeacherAdapter(mutableListOf())
        var item1 = TeacherInfo(
                "Mark Haug",
                2F,
                26,
                4.5F
        )
        professorInfoAdapter.addTodo( item1 )

        var item2 = TeacherInfo(
                "Craig Martin ",
                3F,
                100,
                3.9F
        )
        professorInfoAdapter.addTodo( item2 )

        var item3 = TeacherInfo(
                "David Holmes ",
                4F,
                30,
                2.9F
        )
        professorInfoAdapter.addTodo( item3 )

        var item4 = TeacherInfo(
                "Jeffrey Lang ",
                4.6F,
                30,
                1.6F
        )
        professorInfoAdapter.addTodo( item4 )

        this.callApi()

        rvTeacherInfo.adapter = professorInfoAdapter
        rvTeacherInfo.layoutManager = LinearLayoutManager( this)

        svSeach.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    professorInfoAdapter.filter(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    professorInfoAdapter.filter(newText)
                }
                return true
            }
        })
    }

    private fun callApi(){
        ProfessorInfoApi().getProfessorInfo().enqueue(object : Callback<ProfessorModel> {

            override fun onFailure(call: Call<ProfessorModel>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ProfessorModel>, response: Response<ProfessorModel>) {
                response.body()?.let {
                    professorInfoAdapter.setTeacherInfo(it)
                }
            }

        })
    }

}