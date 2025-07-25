package com.example.viewsactivity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditWorkout : AppCompatActivity()
{
    private var workoutId= "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_edit_workout) // this is your second layout

        val workoutNameEditText = this.findViewById<EditText>(R.id.editTextWorkoutName)
        val equipmentEditText = this.findViewById<EditText>(R.id.editTextEquipment)
        val durationEditText = this.findViewById<EditText>(R.id.editTextDuration)
        val difficultyEditText = this.findViewById<EditText>(R.id.editTextDifficulty)

        val button = findViewById<Button>(R.id.saveButton)
        button.setOnClickListener { SaveChanges() }

        workoutId = intent.getStringExtra("WorkoutId").toString()
        val workoutName = intent.getStringExtra("WorkoutName")
        val equipment = intent.getStringExtra("Equipment")
        val duration = intent.getIntExtra("Duration",0)
        val difficulty = intent.getStringExtra("Difficulty")

        workoutNameEditText.setText(workoutName)
        equipmentEditText.setText(equipment)
        durationEditText.setText(duration.toString())
        difficultyEditText.setText(difficulty)
    }

    fun SaveChanges()
    {
        val resultIntent = Intent()

        val workoutNameEditText = this.findViewById<EditText>(R.id.editTextWorkoutName)
        val equipmentEditText = this.findViewById<EditText>(R.id.editTextEquipment)
        val durationEditText = this.findViewById<EditText>(R.id.editTextDuration)
        val difficultyEditText = this.findViewById<EditText>(R.id.editTextDifficulty)

        val workoutName = workoutNameEditText.text.toString()
        val equipment = equipmentEditText.text.toString()
        val duration = durationEditText.text.toString()
        val difficulty = difficultyEditText.text.toString()

        var validate=true;

        try {
            duration.toInt()
        }
        catch (e: NumberFormatException)
        {
            validate=false
        }

        if (validate == true)
        {
            resultIntent.putExtra("WorkoutId", workoutId)
            resultIntent.putExtra("WorkoutName",  workoutName)
            resultIntent.putExtra("Equipment", equipment)
            resultIntent.putExtra("Duration", duration)
            resultIntent.putExtra("Difficulty", difficulty)

            setResult(Activity.RESULT_OK, resultIntent)
            finish() // Closes SecondActivity and returns to MainActivity
        }
        else
            Toast.makeText(this,"Duration must be a number", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        super.onSaveInstanceState(outState)

        val returnIntent= Intent()

        val workoutNameEditText = this.findViewById<EditText>(R.id.editTextWorkoutName)
        val equipmentEditText = this.findViewById<EditText>(R.id.editTextEquipment)
        val durationEditText = this.findViewById<EditText>(R.id.editTextDuration)
        val difficultyEditText = this.findViewById<EditText>(R.id.editTextDifficulty)

        outState.putString("WorkoutId", workoutId)
        outState.putString("WorkoutName", workoutNameEditText.toString())
        outState.putString("Duration",durationEditText.toString())
        outState.putString("Difficulty",difficultyEditText.toString())
    }
}

