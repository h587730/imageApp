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
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image1), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image2), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image3), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image4), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image5), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image6), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image7), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image8), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image9), false),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image10), false)
        )
        return personList
    }
}



