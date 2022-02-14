package com.example.imageapp.Model

import android.graphics.Bitmap
import java.io.Serializable

data class Person(
    val name: String,
    val image: Bitmap
) : Serializable


