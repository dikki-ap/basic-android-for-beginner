package dikki.basicandroid.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dikki.basicandroid.R

class BarVolumeActivity : AppCompatActivity() {

    // Declaring all components
    lateinit var lengthEditText: EditText
    lateinit var widthEditText: EditText
    lateinit var heightEditText: EditText
    lateinit var calculateButton: Button
    lateinit var resultTextView: TextView

    // Saving STATE from the Activity onSavedInstance
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    // Take an id from all components
    private fun initComponents(){
        lengthEditText = findViewById(R.id.lengthEditText)
        widthEditText = findViewById(R.id.widthEditText)
        heightEditText = findViewById(R.id.heightEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bar_volume_activity)

        // Calling all Components
        initComponents()

        // Calculate Button Click Action
        calculateButton.setOnClickListener {
            var isEmptyField = false

            var inputLength = lengthEditText.text.toString().trim()
            var inputWidth = widthEditText.text.toString().trim()
            var inputHeight = heightEditText.text.toString().trim()

            if(inputLength.isEmpty()){
                isEmptyField = true
                lengthEditText.error = "Must be filled!"
            }
            if(inputWidth.isEmpty()){
                isEmptyField = true
                widthEditText.error = "Must be filled!"
            }
            if(inputHeight.isEmpty()){
                isEmptyField = true
                heightEditText.error = "Must be filled!"
            }

            if(!isEmptyField){
                var volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                resultTextView.text = volume.toString()
            }

        }

        // U can call savedInstanceState if u have the value when something happen2
        if (savedInstanceState != null) {
            // Using getString() Method to get the Saved State
            val result = savedInstanceState.getString(STATE_RESULT)
            resultTextView.text = result
        }
    }

    // Saving STATE from the Activity onSaveInstanceState
    // So when u rotate the Orientation to Landscape it will be saving the result
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        // And it will be display using putString() method
        outState.putString(STATE_RESULT, resultTextView.text.toString())
    }
}