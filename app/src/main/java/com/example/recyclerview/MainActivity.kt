package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfToDo = mutableListOf<ToDo>(
            ToDo("Task 1 "),
            ToDo("Task 2"),
            ToDo("Task 3"),
            ToDo("Task 4"),
            ToDo("Task 5"),
            ToDo("Task 6"),
            ToDo("Task 7"),
            ToDo("Task 8"),
        )
        val adapterView = ToDoAdapter(listOfToDo)
        val recyclerView = findViewById<RecyclerView>(R.id.rcView)
        recyclerView.adapter = adapterView
        val btnAddToDo = findViewById<Button>(R.id.btnAddToDo)
        btnAddToDo.setOnClickListener {
            val ed = findViewById<EditText>(R.id.edSetToDo)
            listOfToDo.add(ToDo(ed.text.toString()))
            adapterView.notifyItemInserted(listOfToDo.size - 1)
            ed.text.clear()
        }

    }
}