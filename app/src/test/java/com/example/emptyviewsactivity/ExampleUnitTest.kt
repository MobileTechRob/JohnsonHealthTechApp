package com.example.emptyviewsactivity

import android.content.Intent
import com.example.viewsactivity.updateWorkoutFromIntent
import com.example.viewsactivity.datamodels.Workout
import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertIsNot

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testupdateWorkoutFromIntent()
    {
        val workoutlist = mutableListOf(Workout("1","myworkout","piece of equipment",30,"hard" ))

        val intent = Intent().apply {
            putExtra("id","1")
            putExtra("name", "mynewwork")
            putExtra("equipment","armcurl")
            putExtra("duration",45)
            putExtra("difficulty","medium")
        }

        val updatedWorkout = updateWorkoutFromIntent(workoutlist, intent)

        assertNotNull(updatedWorkout)
    }


    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}