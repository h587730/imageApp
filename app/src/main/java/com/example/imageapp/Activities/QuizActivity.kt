package com.example.imageapp.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.imageapp.Model.Person
import com.example.imageapp.R

class QuizActivity : AppCompatActivity() {


    private lateinit var ivQuizPic: ImageView
    private lateinit var btnAlt1: Button
    private lateinit var btnAlt2: Button
    private lateinit var btnAlt3: Button

    private var total: Int = 0
    private var score: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        ivQuizPic = findViewById(R.id.ivQuizPic)
        btnAlt1 = findViewById(R.id.btnAlt1)
        btnAlt2 = findViewById(R.id.btnAlt2)
        btnAlt3 = findViewById(R.id.btnAlt3)


       /* getPerson()

        startQuiz()

        btnAlt1.setOnClickListener()

        btnAlt2.setOnClickListener()

        btnAlt3.setOnClickListener()*/

    }



    //Start quiz

    //Randomly select photo from personList

    //Show the correct name and also two random wrong names in random order

    //Indicate whether or not the user pressed the correct number

    //Keep score of the number of correct attempts

    //Leave quiz



}