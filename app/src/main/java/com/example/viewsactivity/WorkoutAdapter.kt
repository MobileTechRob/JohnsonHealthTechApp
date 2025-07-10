package com.example.viewsactivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ArrayAdapter
import com.example.viewsactivity.datamodels.Workout

class WorkoutAdapter(
    context: Context,
    private val workouts: List<Workout>
) : ArrayAdapter<Workout>(context, 0, workouts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_workout, parent, false)

        val workout = workouts[position]

//        val workoutNameTextView = view.findViewById<TextView>(R.id.editTextWorkoutName)
//        val equipmentTextView = view.findViewById<TextView>(R.id.editTextEquipment)
//        val durationTextView = view.findViewById<TextView>(R.id.editTextDuration)
//        val difficultyTextView = view.findViewById<TextView>(R.id.editTextDifficulty)

        val workoutNameTextView = view.findViewById<TextView>(R.id.labelWorkoutName)
        val equipmentTextView = view.findViewById<TextView>(R.id.labelEquipment)
        val durationTextView = view.findViewById<TextView>(R.id.labelDuration)
        val difficultyTextView = view.findViewById<TextView>(R.id.labelDifficulty)

        val workoutName = "WorkOut:" + workout.name
        workoutNameTextView.setText(workoutName)

        val equipment = "Equipment:" + workout.equipment
        equipmentTextView.setText(equipment)

        val durationText = "Duration: " + workout.duration.toString()
        durationTextView.setText(durationText)

        val difficulty = "Difficulty: " +workout.difficulty
        difficultyTextView.setText(difficulty)

        return view
    }
}
