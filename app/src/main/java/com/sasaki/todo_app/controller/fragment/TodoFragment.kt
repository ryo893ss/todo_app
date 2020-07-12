package com.sasaki.todo_app.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.sasaki.todo_app.R
import com.sasaki.todo_app.controller.adapter.TodoAdapter
import com.sasaki.todo_app.domain.model.TodoItem

class TodoFragment: Fragment() {

    private lateinit var todoAdapter: TodoAdapter
    private lateinit var recyclerView: RecyclerView
    var list = arrayListOf<TodoItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_todo, container, false)

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
            showDialg(view)
        }
        setContents(view)
        return view
    }
    private fun setContents(view: View){
        val context = context ?: return
        todoAdapter = TodoAdapter(context){
            list.removeAt(it)
            todoAdapter.setTodoList(list)
            todoAdapter.reloadAllData()
        }
        list = arrayListOf(
                TodoItem(false,"初期データ１","2020年7月3日","めもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめも"),
                TodoItem(false,"初期データ２","2020年7月3日","めもめもめもめもめもめもめもめもめもめもめもめも"),
                TodoItem(false,"初期データ３","2020年7月3日","めもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめもめも")
        )
        todoAdapter.setTodoList(list)
        todoAdapter.reloadAllData()
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = todoAdapter
    }

    fun showDialg(view: View){
        val context = context ?: return

        val factory = LayoutInflater.from(context)
        val inputView: View = factory.inflate(R.layout.layout_dialog, null)
        AlertDialog.Builder(context)
                .setTitle("新しいTODOの追加")
                .setView(inputView)
                .setPositiveButton("追加") { dialog, which ->
                    if (inputView.findViewById<EditText>(R.id.edit_title).text.toString().isEmpty()){
                        Snackbar.make(view, "タイトル入力してよ", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show()
                    } else {
                        val limit = inputView.findViewById<DatePicker>(R.id.date_picker)
                        var todoItem: TodoItem = TodoItem(
                                false,
                                inputView.findViewById<EditText>(R.id.edit_title).text.toString(),
                                "${limit.year}年${limit.month}月${limit.dayOfMonth}日",
                                inputView.findViewById<EditText>(R.id.edit_memo).text.toString()
                        )
                        list.add(todoItem)
                        todoAdapter.setTodoList(list)
                        todoAdapter.reloadAllData()
                    }
                }
                .setNegativeButton("キャンセル") { dialog, which ->

                }
                .show()
    }
}