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
            Person("Vince", BitmapFactory.decodeResource(resources,R.drawable.vince), false),
            Person("Ari", BitmapFactory.decodeResource(resources,R.drawable.ari), false),
            Person("Dana", BitmapFactory.decodeResource(resources,R.drawable.dana), false),
            Person("Eric", BitmapFactory.decodeResource(resources,R.drawable.eric), false),
            Person("Johnny Drama", BitmapFactory.decodeResource(resources,R.drawable.johnnydrama), false),
            Person("Lloyd", BitmapFactory.decodeResource(resources,R.drawable.lloyd), false),
            Person("Mrs. Ari", BitmapFactory.decodeResource(resources,R.drawable.mrsari), false),
            Person("Scott", BitmapFactory.decodeResource(resources,R.drawable.scott), false),
            Person("Turtle", BitmapFactory.decodeResource(resources,R.drawable.turtle), false),
            Person("Shauna", BitmapFactory.decodeResource(resources,R.drawable.shauna), false),
            Person("Sloan", BitmapFactory.decodeResource(resources,R.drawable.sloan), false),
            Person("Andrew", BitmapFactory.decodeResource(resources,R.drawable.andrew), false
            )
        )
        return personList
    }
}



