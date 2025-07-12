package com.example.viewsactivity

import com.example.viewsactivity.WorkoutRepository.WorkoutRepository.workoutList
import com.example.viewsactivity.datamodels.Workout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun deserialIntoObjectList(workouts:String):MutableList<Workout>
{
    val gson = Gson()
    var listWorkoutType = object : TypeToken<MutableList<Workout>>() {}.type

    try {
        workoutList = gson.fromJson(workouts, listWorkoutType)
    }
    catch (e:Exception)
    {
        e.printStackTrace()

    }


    return workoutList
}