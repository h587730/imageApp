package com.example.imageapp.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imageapp.R
import com.example.imageapp.Database.Datasource
import com.example.imageapp.helper.PersonAdapter
import com.example.imageapp.Model.Person

private const val TAG1 = "onCreateOptionsMenu"
private const val TAG2 = "onOptionsItemSelected"
private const val TAG3 = "PersonRecieved"


class MainActivity : AppCompatActivity() {

    private lateinit var personList: MutableList<Person>
    private lateinit var adapter: PersonAdapter
    private var ADD_REQ: Int = 42
    private var QUIZ_REQ: Int = 43

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = resources

        //Initialise the data
        //personList = Datasource().loadPersons(res)

        //Initialise the data
        Datasource().initialisePersonList(res)

        //initialise adapter
        adapter = PersonAdapter(this, Datasource().getPersonList())

        val recyclerView = findViewById<RecyclerView>(R.id.rvPersons)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        Log.i(TAG1, "Menu created")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Add Picture to database
        if (item.itemId == R.id.miAdd) {
            // Navigate to AddActivity
            val intent = Intent(this, AddActivity::class.java)
            startActivityForResult(intent, ADD_REQ)
            Log.i(TAG2, "Add picture selected")
            return true
        }
        //Go to quiz
        if (item.itemId == R.id.miQuiz) {
            // Navigate to QuizActivity
            val intent = Intent(this, QuizActivity::class.java)
            startActivityForResult(intent, QUIZ_REQ)
            Log.i(TAG2, "Quiz item selected")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_REQ && resultCode == Activity.RESULT_OK) {
            val newPerson = data?.getSerializableExtra("person") as Person
            Log.i(TAG3, "Person recieved")
            Datasource().addToPersonList(newPerson)
            //personList.add(newPerson)
            adapter.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}