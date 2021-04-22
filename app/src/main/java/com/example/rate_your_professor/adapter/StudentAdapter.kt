package com.example.rate_your_professor.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rate_your_professor.R
import com.example.rate_your_professor.model.apiCall.profesorInfo.ProfessorData
import com.example.rate_your_professor.model.apiCall.studentComment.CommentData
import com.example.rate_your_professor.model.apiCall.studentComment.StudentComment
import com.example.rate_your_professor.model.pageList.StudentCommnetInfo
import com.example.rate_your_professor.model.pageList.TeacherInfo
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

    fun setTeacherInfo(studentComment: StudentComment) {
        var list = listOf<CommentData>()
        list  = studentComment.data

        for (item in list) {
            var newItem = StudentCommnetInfo(
                    item.color,
                    "Yes",
                    "Not Mandatory",
                    "A",
                    "No",
                    "Make no mistake, this will most likely be the most difficult class you will take at the B-school. The class builds on itself and it is critical that you keep up with the work. Rely on the example problems for quizzes and go to TA office hours. Haug is a caring professor, even if the grades don't reflct that.\n",
                    "5.0",
                    "5.0"
            )
            this.addTodo( newItem )
        }

        notifyDataSetChanged()
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
