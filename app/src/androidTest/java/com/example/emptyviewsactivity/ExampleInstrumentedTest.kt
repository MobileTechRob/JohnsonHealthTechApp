package com.example.emptyviewsactivity

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.viewsactivity.datamodels.Workout
import com.example.viewsactivity.updateWorkoutFromIntent
import com.example.viewsactivity.deserialIntoObjectList

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun testupdateWorkoutFromIntent()
    {
        val workoutlist = mutableListOf(Workout("1","myworkout","piece of equipment",30,"hard" ))

        val intent = Intent().apply {
            putExtra("WorkoutId","1")
            putExtra("WorkoutName", "mynewwork")
            putExtra("Equipment","armcurl")
            putExtra("Duration","45")
            putExtra("Difficulty","medium")
        }

        val updatedWorkout = updateWorkoutFromIntent(workoutlist, intent)

        assertNotNull(updatedWorkout)
        if (updatedWorkout != null) {
            assertSame(updatedWorkout.id, "1")
            assertSame(updatedWorkout.name, "mynewwork")
            assertSame(updatedWorkout.equipment, "armcurl")
            assertSame(updatedWorkout.duration, 45)
            assertSame(updatedWorkout.difficulty, "medium")
        }
    }

    @Test
    fun testDeserialization_OneWorkout()
    {

        val workoutFromFile = "[{'id':'1','name':'MyGymWorkOut','equipment':'asd','duration':23,'difficulty':'asd'}]"
        val workoutlist = deserialIntoObjectList(workoutFromFile)

        assertNotNull(workoutlist)

        assertNotNull(workoutlist.find { w -> w.id =="1"})

        val w = workoutlist.find { w -> w.id == "1"}

        val name = w?.name
        val foundworkoutname = workoutlist.find { workout -> workout.id == "1"}?.name

        assertEquals(foundworkoutname ,"MyGymWorkOut")
    }

    @Test
    fun testDeserialization_ThreeWorkouts()
    {

        val workoutFromFile = "[{'id':'1','name':'MyGymWorkOut_1','equipment':'Pullup','duration':45,'difficulty':'hard'}," +
                "{'id':'2','name':'MyGymWorkOut_2','equipment':'Pulldown','duration':35,'difficulty':'medium'}," +
                 "{'id':'3','name':'MyGymWorkOut_3','equipment':'Chest','duration':23,'difficulty':'easy'}]"

        val workoutlist = deserialIntoObjectList(workoutFromFile)

        assertNotNull(workoutlist)
        assertTrue (workoutlist.count() == 3)

        assertNotNull(workoutlist.find { w -> w.id =="1"})
        assertNotNull(workoutlist.find { w -> w.id =="2"})
        assertNotNull(workoutlist.find { w -> w.id =="3"})

        val w1 = workoutlist.find { w -> w.id == "1"}
        val w2 = workoutlist.find { w -> w.id == "2"}
        val w3 = workoutlist.find { w -> w.id == "3"}

        assertNotNull(w1)
        assertNotNull(w2)
        assertNotNull(w3)

        assertEquals(w1?.name,"MyGymWorkOut_1")
        assertEquals(w1?.equipment,"Pullup")
        assertEquals(w1?.duration,45)
        assertEquals(w1?.difficulty,"hard")


        assertEquals(w2?.name,"MyGymWorkOut_2")
        assertEquals(w2?.equipment,"Pulldown")
        assertEquals(w2?.duration,35)
        assertEquals(w2?.difficulty,"medium")


        assertEquals(w3?.name,"MyGymWorkOut_3")
        assertEquals(w3?.equipment,"Chest")
        assertEquals(w3?.duration,23)
        assertEquals(w3?.difficulty,"easy")
    }

}