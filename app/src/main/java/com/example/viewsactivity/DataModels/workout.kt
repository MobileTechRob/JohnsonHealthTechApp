// File: app/src/main/java/com/example/myapp/DataModel/Workout.kt
package com.example.viewsactivity.datamodels

data class Workout(
    var name: String,
    val id: String,
    var equipment: String,
    var duration: Int,
    var difficulty: String
)
