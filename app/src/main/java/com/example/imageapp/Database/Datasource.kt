package com.example.imageapp.Database

import android.app.Application
import android.content.res.Resources
import android.graphics.BitmapFactory
import com.example.imageapp.Model.Person
import com.example.imageapp.R


class Datasource : Application() {

    fun loadPersons(resources: Resources): MutableList<Person> {
        return mutableListOf(
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image1)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image2)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image3)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image4)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image5)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image6)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image7)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image8)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image9)),
            Person("Example", BitmapFactory.decodeResource(resources,R.drawable.image10))
        )
    }
}
