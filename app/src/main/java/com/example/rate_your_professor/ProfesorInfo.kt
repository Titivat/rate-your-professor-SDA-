package com.example.rate_your_professor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.profesor_information_page.*
import kotlinx.android.synthetic.main.student_comment_item.*

class ProfesorInfo : AppCompatActivity() {
    private lateinit var studentCommentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profesor_information_page )

        btnInfoBack.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnRateProfessor.setOnClickListener{
            startActivity(Intent(this, RattingProfesor::class.java))
        }

        studentCommentAdapter = StudentAdapter( mutableListOf() )

        var item1 = StudentCommnetInfo("commentId","credit","attendance","grade","textBook","comment","studyAgain","ratting")
        studentCommentAdapter.addTodo( item1 )

        var item2 = StudentCommnetInfo("commentId","credit","attendance","grade","textBook","comment","studyAgain","ratting")
        studentCommentAdapter.addTodo( item2 )

        var item3 = StudentCommnetInfo("commentId","credit","attendance","grade","textBook","comment","studyAgain","ratting")
        studentCommentAdapter.addTodo( item3 )

        var item4 = StudentCommnetInfo("commentId","credit","attendance","grade","textBook","comment","studyAgain","ratting")
        studentCommentAdapter.addTodo( item4 )


        rvStudentComment.adapter = studentCommentAdapter
        rvStudentComment.layoutManager = LinearLayoutManager( this)


    }
}