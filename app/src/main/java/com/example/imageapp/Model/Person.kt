package com.example.imageapp.Model

import android.graphics.Bitmap
import java.io.Serializable

data class Person(
    val name: String,
   @Transient val image: Bitmap,
    val isCorrect: Boolean
) : Serializable


