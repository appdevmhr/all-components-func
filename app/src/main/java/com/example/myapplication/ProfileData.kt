package com.example.myapplication

import android.graphics.drawable.PaintDrawable
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ProfileData(val name: String, val desc: String)
data class SurvayAnswerModel(val image: Int, val text: String)
data class GreetingModel(val name: String)

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String, val lastName: String, val age: Int
)