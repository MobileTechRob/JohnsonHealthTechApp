package com.example.viewsactivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EditWorkout : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_edit_workout) // this is your second layout

        //val workoutNameEditText = view.findViewById<EditText>(R.id.editTextWorkoutName)
        //val equipmentEditText = view.findViewById<EditText>(R.id.editTextEquipment)
        //val durationEditText = view.findViewById<EditText>(R.id.editTextDuration)
        //val difficultyEditText = view.findViewById<EditText>(R.id.editTextDifficulty)

        //workoutNameTextView
        //equipmentTextView = view.findViewById<TextView>(R.id.editTextEquipment)
        //durationTextView = view.findViewById<TextView>(R.id.editTextDuration)
        //difficultyTextView = view.findViewById<TextView>(R.id.editTextDifficulty)

    }
}

