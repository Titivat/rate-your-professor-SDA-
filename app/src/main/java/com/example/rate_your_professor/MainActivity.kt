package com.example.rate_your_professor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TeacherAdapter( mutableListOf() )

        var item1 = TeacherInfo("Mark Haug", 2, 26, 4.5F)
        todoAdapter.addTodo( item1 )

        var item2 = TeacherInfo("Craig Martin ", 3, 100, 3.9F)
        todoAdapter.addTodo( item2 )

        rvTeacherInfo.adapter = todoAdapter
        rvTeacherInfo.layoutManager = LinearLayoutManager( this)
    }
}