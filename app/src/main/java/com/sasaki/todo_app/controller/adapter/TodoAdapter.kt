package com.sasaki.todo_app.controller.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.sasaki.todo_app.R
import com.sasaki.todo_app.domain.model.TodoItem

class TodoAdapter(
        private val context: Context,
        val deleteTodo: (Int) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoListHolder>() {
    override fun onBindViewHolder(holder: TodoListHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.todo_title).text = list[position].todoTitle
        holder.itemView.findViewById<TextView>(R.id.limit_date).text = "期限：${list[position].todoLimitDate}まで"
        var memo = holder.itemView.findViewById<TextView>(R.id.memo)
        if (list[position].todoMemo.isNotEmpty()){
            memo.text = list[position].todoMemo
            holder.itemView.findViewById<CardView>(R.id.todo_card).setOnClickListener {
                if (memo.visibility == View.GONE) {
                    memo.visibility = View.VISIBLE
                } else {
                    memo.visibility = View.GONE
                }
            }
        }
        holder.itemView.findViewById<ImageView>(R.id.delete).setOnClickListener {
            deleteTodo(position)
        }
    }

    private var list = arrayListOf<TodoItem>()

    override fun getItemCount(): Int {
        return this.list.size
    }

    fun setTodoList(list: ArrayList<TodoItem>) {
        this.list = list
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TodoAdapter.TodoListHolder {
        val todoView = (context as Activity).layoutInflater.inflate(R.layout.layout_todo,p0,false)
        return TodoListHolder(todoView)
    }
    inner class TodoListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun reloadAllData(){
        this.notifyDataSetChanged()
    }
}