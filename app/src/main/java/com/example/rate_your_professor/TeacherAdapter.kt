package com.example.rate_your_professor

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = teacherList[position]


        holder.itemView.apply {
            tvTeacherItemName.text = curTodo.teacherName
            tvTeacherItemRatting.text = (curTodo.ratting.toString() + "/" + "5")
            tvTeacherItemTakeAgain.text = curTodo.wouldTakeAgainPercen.toString() + "%"
            tvTeacherItemDifficulty.text = curTodo.levelOfDifficulty.toString()

            teacherItem.setOnClickListener {
                val intent = Intent(context, ProfesorInfo::class.java)
                intent.putExtra("Username","John Doe")
                context.startActivity( intent )

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
                teacherList.addAll(itemsCopy)
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