package com.example.viewsactivity

import android.content.Intent
import com.example.viewsactivity.WorkoutRepository.WorkoutRepository
import com.example.viewsactivity.datamodels.Workout

fun updateWorkoutFromIntent(workouts: MutableList<Workout>, returnedIntent:Intent?):Workout?
{
    val workoutId = returnedIntent?.getStringExtra("WorkoutId")
    val workoutName = returnedIntent?.getStringExtra("WorkoutName")
    val equipment = returnedIntent?.getStringExtra("Equipment")
    val duration = returnedIntent?.getStringExtra("Duration")
    val difficulty = returnedIntent?.getStringExtra("Difficulty")

    if (workoutName != null) {
        workouts.find { workout -> workout.id == workoutId}?.name = workoutName
    }

    if (equipment != null) {
        workouts.find { workout -> workout.id == workoutId}?.equipment = equipment
    }

    if (duration != null) {
        workouts.find { workout -> workout.id == workoutId}?.duration = duration.toInt()
    }

    if (difficulty != null) {
        workouts.find { workout -> workout.id == workoutId}?.difficulty = difficulty
    }

    val w = workouts.find { workout -> workout.id == workoutId}

    return w;
}
