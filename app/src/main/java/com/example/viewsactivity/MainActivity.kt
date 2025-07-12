package com.example.viewsactivity
import android.app.Activity
import com.example.viewsactivity.datamodels.Workout

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewsactivity.WorkoutRepository.WorkoutRepository
import com.google.gson.Gson
import java.io.IOException

class MainActivity : AppCompatActivity()
{
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var workoutAdapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result : ActivityResult ->
            processCallBack(result)
        }

        var workouts = ""

        if (savedInstanceState == null)
        {
            val persistedStorageData= loadSettingFileFromStoredFile(this, "workouts.json" )

            if (persistedStorageData == "")
            {
                workouts = loadSettingFileFromAssets(this,"workouts.json")
            }
            else
            {
                workouts = loadSettingFileFromStoredFile(this, "workouts.json")
            }

            WorkoutRepository.workoutList = deserialIntoObjectList(workouts)
            workoutAdapter = WorkoutAdapter(this, WorkoutRepository.workoutList)
        }

        val listView = findViewById<ListView>(R.id.listView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listView))
        { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView.adapter = workoutAdapter
        listView.setOnItemClickListener{ parent, view, position, id ->
            // Optionally pass data to second activity

            val aWorkout  = WorkoutRepository.workoutList[position]
            val intent = Intent(this, EditWorkout::class.java)

            intent.putExtra("WorkoutId", aWorkout.id)
            intent.putExtra("WorkoutName", aWorkout.name)
            intent.putExtra("Equipment", aWorkout.equipment)
            intent.putExtra("Duration", aWorkout.duration)
            intent.putExtra("Difficulty", aWorkout.difficulty)

            resultLauncher.launch(intent)
        }
    }

    private fun processCallBack(result:ActivityResult)
    {
        if (result.resultCode == Activity.RESULT_OK)
        {
            val returnedIntent: Intent? = result.data

            updateWorkoutFromIntent(WorkoutRepository.workoutList.toMutableList(), returnedIntent)

            val jsonList = WorkoutRepository.workoutList.toList()
            saveSettingsToStoreFile(this, "workouts.json", jsonList)

            val workoutList: MutableList<Workout> = WorkoutRepository.workoutList.toMutableList()
            workoutAdapter.clear()
            workoutAdapter.addAll(workoutList)
            workoutAdapter.notifyDataSetChanged()

            Toast.makeText(this, "Workout Updated", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadSettingFileFromAssets(context: Context, filename: String):String
    {
        return context.assets.open(filename).bufferedReader().use { it.readText() }
    }

    fun saveSettingsToStoreFile(context: Context, fileName: String, workouts: List<Workout>)
    {
        try {
            var gson = Gson()

            val jsonString = gson.toJson(workouts)
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use { output ->
                output.write(jsonString.toByteArray(Charsets.UTF_8))
            }
            Log.d("FileSave", "Saved to ${context.filesDir}/$fileName")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun loadSettingFileFromStoredFile(context: Context, fileName: String): String {
        return try {
            context.openFileInput(fileName).bufferedReader(Charsets.UTF_8).use {it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }
    }
}

