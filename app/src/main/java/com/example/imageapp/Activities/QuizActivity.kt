package com.example.imageapp.Activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imageapp.Database.Datasource
import com.example.imageapp.Model.Person
import com.example.imageapp.R

private const val TAG1 = "testQuizLogic"

class QuizActivity : AppCompatActivity() {


    private lateinit var ivQuizPic: ImageView
    private lateinit var btnAlt1: Button
    private lateinit var btnAlt2: Button
    private lateinit var btnAlt3: Button
    private lateinit var tvAttemptsX: TextView
    private lateinit var tvScoreX: TextView

    companion object {
        private var total: Int = 0
        private var score: Int = 0
    }


    private lateinit var correctPerson : Person
    private lateinit var wrongPerson1 : Person
    private lateinit var wrongPerson2 : Person

    private lateinit var randomList: MutableList<Person>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        ivQuizPic = findViewById(R.id.ivQuizPic)
        btnAlt1 = findViewById(R.id.btnAlt1)
        btnAlt2 = findViewById(R.id.btnAlt2)
        btnAlt3 = findViewById(R.id.btnAlt3)
        tvAttemptsX = findViewById(R.id.tvAttemptsX)
        tvScoreX = findViewById(R.id.tvScoreX)


        assignQuizValues()

        initScoreAndAttempts()

        setCorrectImage()

        randomizeAndAssignButtons()

        btnAlt1.setOnClickListener{
            if(randomList.component1().isCorrect) {
                btnAlt1.setTextColor(0xffffff)
                score++
                tvScoreX.text = score.toString()
            }
            total++
            tvAttemptsX.text = total.toString()
            Log.i(TAG1, "total: ${total},score: ${score}")
            finish()
            startActivity(this.intent)
        }

        btnAlt2.setOnClickListener{
            if(randomList.component2().isCorrect){
                btnAlt2.setTextColor(0xffffff)
                score++
                tvScoreX.text = score.toString()
            }
            total++
            tvAttemptsX.text = total.toString()
            Log.i(TAG1, "total: ${total},score: ${score}")
            finish()
            startActivity(this.intent)
        }

        btnAlt3.setOnClickListener{
            if(randomList.component3().isCorrect){
                btnAlt3.setTextColor(0xffffff)
                score++
                tvScoreX.text = score.toString()
            }
            total++
            tvAttemptsX.text = total.toString()
            Log.i(TAG1, "total: ${total},score: ${score}")
            finish()
            startActivity(this.intent)
        }



    }



    private fun shufflePersonList (): List<Person> {
        return Datasource().getPersonList().shuffled()
    }

    private fun assignQuizValues () {
        val shuffledPersonList: List<Person> = shufflePersonList()
        correctPerson = shuffledPersonList.component1()
        correctPerson.isCorrect = true
        wrongPerson1 = shuffledPersonList.component2()
        wrongPerson2 = shuffledPersonList.component3()

        Log.i(TAG1, "correctPerson: ${correctPerson}"+ "wrongPerson1: ${wrongPerson1}"+ "wrongPerson2: ${wrongPerson2}")

    }


    private fun initScoreAndAttempts () {
        tvAttemptsX.text = total.toString()
        tvScoreX.text = score.toString()
        Log.i(TAG1, "total: ${total},score: ${score}")
    }

    private fun setCorrectImage () {
        ivQuizPic.setImageBitmap(correctPerson.image)
        Log.i(TAG1, "correct image: ${correctPerson.image}")
    }

    private fun randomizeAndAssignButtons () {
        randomList = randomizeOrder(correctPerson, wrongPerson1, wrongPerson2)

        Log.i(TAG1, "randomList: ${randomList.component1()}, ${randomList.component2()},${randomList.component3()}")


        btnAlt1.text = randomList.component1().name
        btnAlt2.text = randomList.component2().name
        btnAlt3.text = randomList.component3().name
        Log.i(TAG1, "btnAlt1: ${btnAlt1.text}, btnAlt2: ${btnAlt2.text}, btnAlt3: ${btnAlt3.text}")
    }

    private fun randomizeOrder(
        correctPerson: Person,
        wrongPerson1: Person,
        wrongPerson2: Person) : MutableList<Person>{

        val randomizedList : List<Person> = listOf(correctPerson, wrongPerson1, wrongPerson2)
        return randomizedList.shuffled().toMutableList()
    }



}