package dikki.basicandroid.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import dikki.basicandroid.R

class IntentResultActivity : AppCompatActivity() {

    private lateinit var chooseButton: Button
    private lateinit var numberRadioGroup: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    private fun initComponents(){
        chooseButton = findViewById(R.id.chooseButton)
        numberRadioGroup = findViewById(R.id.numberRadioGroup)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_result)

        initComponents()

        chooseButton.setOnClickListener {

            // Checking if the RadioGroup if there's a clicked button
            // So u MUST click the RadioButton
            if (numberRadioGroup.checkedRadioButtonId > 0) {

                var value = 0

                // Taking the value from the checked button
                when (numberRadioGroup.checkedRadioButtonId) {
                    R.id.radioButton50 -> value = 50
                    R.id.radioButton100 -> value = 100
                    R.id.radioButton150 -> value = 150
                    R.id.radioButton200 -> value = 200
                }

                val resultIntent = Intent()

                // Give Data to Intent with putExtra
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)

                // U need to use setResult for giving Return Value for the Previous Activity
                setResult(RESULT_CODE, resultIntent)
                finish() // Use finish() if don't want user can go back from "back button" to this Activity
            }
        }
    }
}