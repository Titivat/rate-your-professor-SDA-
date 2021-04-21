package com.example.rate_your_professor.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rate_your_professor.R
import com.example.rate_your_professor.model.pageList.StudentCommnetInfo
import kotlinx.android.synthetic.main.student_comment_item.view.*

class StudentAdapter( private val studentCommentList: MutableList<StudentCommnetInfo> ) : RecyclerView.Adapter<StudentAdapter.TodoViewHolder>(){

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_comment_item,
                parent,
                false
            )
        )

    }

    fun addTodo( studentCommnetInfo: StudentCommnetInfo){
        studentCommentList.add( studentCommnetInfo )
        notifyItemInserted( studentCommentList.size - 1 )
    }

    override fun getItemCount(): Int {
        return studentCommentList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = studentCommentList[position]

        holder.itemView.apply {
            tvCommentId.text = curTodo.commentId
            tvStudentCommentCredit.text = curTodo.credit
            tvStudentCommentAttendance.text = curTodo.attendance
            tvStudentCommentGrade.text = curTodo.grade
            tvStudentCommentTextBook.text = curTodo.textBook
            tvStudentCommentRatting.text = curTodo.quality
            tvStudentCommentDifficulty.text = curTodo.ratting
            tvStudentCommentComment.text = curTodo.comment
        }

    }

}
