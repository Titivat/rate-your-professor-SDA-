package com.example.rate_your_professor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )

        todoAdapter = TeacherAdapter( mutableListOf() )

        var item1 = TeacherInfo("Mark Haug", 2F, 26, 4.5F)
        todoAdapter.addTodo( item1 )

        var item2 = TeacherInfo("Craig Martin ", 3F, 100, 3.9F)
        todoAdapter.addTodo( item2 )

        var item3 = TeacherInfo("David Holmes ", 4F, 30, 2.9F)
        todoAdapter.addTodo( item3 )

        var item4 = TeacherInfo("Jeffrey Lang ", 4.6F, 30, 1.6F)
        todoAdapter.addTodo( item4 )

        rvTeacherInfo.adapter = todoAdapter
        rvTeacherInfo.layoutManager = LinearLayoutManager( this)
    }

}