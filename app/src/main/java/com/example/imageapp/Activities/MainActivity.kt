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


class MainActivity : AppCompatActivity() {

    private lateinit var personList: MutableList<Person>
    private lateinit var adapter: PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = resources

        //Initialise the data
        personList = Datasource().loadPersons(res)

        //initialise adapter
        adapter = PersonAdapter(this, personList)


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
            // Navigate to ContactsActivity
            val intent = Intent(this, AddActivity::class.java)
            startActivityForResult(intent, 42)
            Log.i(TAG2, "Add picture selected")
            return true
        }
        //Go to quiz
        if (item.itemId == R.id.miQuiz) {
            // Navigate to QuizActivity
            val intent = Intent(this, QuizActivity::class.java)
            startActivityForResult(intent, 42)
            Log.i(TAG2, "Quiz item selected")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            val newPerson = data?.getSerializableExtra("person") as Person
            personList.add(0, newPerson)
            adapter.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}