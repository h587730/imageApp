package com.example.imageapp.Database

import android.app.Application
import android.content.res.Resources
import android.graphics.BitmapFactory
import com.example.imageapp.Model.Person
import com.example.imageapp.R


class Datasource : Application() {

    companion object{
    private lateinit var personList: MutableList<Person>
    }

    fun initialisePersonList (resources: Resources) : MutableList<Person>{
        personList = loadPersons(resources)
        return personList
    }

    fun getPersonList () : MutableList<Person>{
        return personList
    }

    fun addToPersonList (person: Person) {
        personList.add(0, person)
    }

    fun loadPersons(resources: Resources): MutableList<Person> {
        personList = mutableListOf(
            Person("Example1", BitmapFactory.decodeResource(resources,R.drawable.image1), false),
            Person("Example2", BitmapFactory.decodeResource(resources,R.drawable.image2), false),
            Person("Example3", BitmapFactory.decodeResource(resources,R.drawable.image3), false),
            Person("Example4", BitmapFactory.decodeResource(resources,R.drawable.image4), false),
            Person("Example5", BitmapFactory.decodeResource(resources,R.drawable.image5), false),
            Person("Example6", BitmapFactory.decodeResource(resources,R.drawable.image6), false),
            Person("Example7", BitmapFactory.decodeResource(resources,R.drawable.image7), false),
            Person("Example8", BitmapFactory.decodeResource(resources,R.drawable.image8), false),
            Person("Example9", BitmapFactory.decodeResource(resources,R.drawable.image9), false),
            Person("Example10", BitmapFactory.decodeResource(resources,R.drawable.image10), false)
        )
        return personList
    }
}



