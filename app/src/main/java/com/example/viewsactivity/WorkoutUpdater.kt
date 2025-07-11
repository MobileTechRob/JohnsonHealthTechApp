package com.example.viewsactivity

import android.content.Intent
import com.example.viewsactivity.WorkoutRepository.WorkoutRepository
import com.example.viewsactivity.datamodels.Workout

fun updateWorkoutFromIntent(workouts: MutableList<Workout>, returnedIntent:Intent?):Workout?
{
    //val returnedIntent: Intent = result.data

    val workoutId = returnedIntent?.getStringExtra("workoutId")
    val workoutName = returnedIntent?.getStringExtra("workoutName")
    val equipment = returnedIntent?.getStringExtra("Equipment")
    val duration = returnedIntent?.getStringExtra("Duration")
    val difficulty = returnedIntent?.getStringExtra("Difficulty")

    if (workoutName != null) {
        WorkoutRepository.workoutList.find { workout -> workout.id == workoutId}?.name = workoutName
    }

    if (equipment != null) {
        WorkoutRepository.workoutList.find { workout -> workout.id == workoutId}?.equipment = equipment
    }

    if (duration != null) {
        WorkoutRepository.workoutList.find { workout -> workout.id == workoutId}?.duration = duration.toInt()
    }

    if (difficulty != null) {
        WorkoutRepository.workoutList.find { workout -> workout.id == workoutId}?.difficulty = difficulty
    }

    val w = WorkoutRepository.workoutList.find { workout -> workout.id == workoutId}

    return w;
}
