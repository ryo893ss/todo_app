package com.sasaki.todo_app.domain.model

data class TodoItem (
        var checkedFlag: Boolean = false,
        val todoTitle: String,
        val todoLimitDate: String,
        val todoMemo: String = ""
)