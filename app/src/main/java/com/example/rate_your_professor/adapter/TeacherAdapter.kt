package com.example.rate_your_professor.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rate_your_professor.page.ProfesorInfoPage
import com.example.rate_your_professor.R
import com.example.rate_your_professor.model.apiCall.profesorInfo.ProfessorData
import com.example.rate_your_professor.model.apiCall.profesorInfo.ProfessorModel
import com.example.rate_your_professor.model.pageList.TeacherInfo
import kotlinx.android.synthetic.main.teacher_item.view.*

class TeacherAdapter( private val teacherList: MutableList<TeacherInfo> ) : RecyclerView.Adapter<TeacherAdapter.TodoViewHolder>(){

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val tempTeacherList: MutableList<TeacherInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.teacher_item,
                parent,
                false
            )
        )

    }

    fun addTodo( teacherInfo: TeacherInfo){
        tempTeacherList.add( teacherInfo )
        teacherList.add( teacherInfo )
        notifyItemInserted( teacherList.size - 1 )
    }

    fun setTeacherInfo( professorModel: ProfessorModel) {
        var list = listOf<ProfessorData>()
        list = professorModel.professors

        for (item in list) {
            var newItem = TeacherInfo(
                    item.id,
                    item.name,
                    item.rating,
                    item.takeagain * 100,
                    item.difficulty
            )
            this.addTodo( newItem )
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = teacherList[position]


        holder.itemView.apply {
            val ratting = curTodo.ratting.toString()
            val teacherName = curTodo.teacherName
            val takeAgainPercent = curTodo.wouldTakeAgainPercen.toString()
            val difficultyLevel = curTodo.levelOfDifficulty.toString()
            val id = curTodo.id.toString()

            tvTeacherItemName.text = teacherName
            tvTeacherItemRatting.text = ("$ratting/5")
            tvTeacherItemTakeAgain.text = ("$takeAgainPercent%")
            tvTeacherItemDifficulty.text = difficultyLevel

            setStarBackground( ratting , ivTeacherItemStar)

            teacherItem.setOnClickListener {
                val teacherInfo = HashMap<String, String>()
                teacherInfo["id"] = id
                teacherInfo["ratting"] = ratting
                teacherInfo["teacherName"] = teacherName
                teacherInfo["takeAgainPercent"] = takeAgainPercent
                teacherInfo["difficultyLevel"] = difficultyLevel

                val intent = Intent(context, ProfesorInfoPage::class.java)
                intent.putExtra("TeacherInfo", teacherInfo)
                context.startActivity( intent )
            }
        }
    }

    private fun setStarBackground(ratting: String, imageView: ImageView){
        val rattingNumber = ratting.toFloat()
        when {
            rattingNumber > 4.5 -> {
                imageView.setBackgroundResource(R.drawable.ic_yellow_star);
            }
            rattingNumber > 3.5 -> {
                imageView.setBackgroundResource(R.drawable.ic_green_star);
            }
            rattingNumber > 2.5 -> {
                imageView.setBackgroundResource(R.drawable.ic_orange_star);
            }
            else -> {
                imageView.setBackgroundResource(R.drawable.ic_red_star);
            }
        }

    }

    fun filter(text: String) {
        val itemsCopy : MutableList<TeacherInfo> = mutableListOf()
        itemsCopy.addAll( teacherList )
        teacherList.clear()

        when {
            itemsCopy.isEmpty() -> {
                teacherList.addAll(tempTeacherList)
            }
            text.isEmpty() -> {
                teacherList.addAll(tempTeacherList)
            }
            else -> {
                var text = text.toLowerCase()
                for (item in itemsCopy) {
                    if (item.teacherName.toLowerCase().contains(text) ) {
                        teacherList.add(item)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }
}