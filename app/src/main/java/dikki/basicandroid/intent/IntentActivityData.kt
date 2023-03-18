package dikki.basicandroid.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import dikki.basicandroid.R

class IntentActivityData : AppCompatActivity() {

    private lateinit var dataReceivedTextView: TextView

    private fun initComponents(){
        dataReceivedTextView = findViewById(R.id.dataReceivedTextView)
    }

    // Make an Object that storing "key" Data from Intent
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_data)

        initComponents()

        // Getting "value" Data from Intent using getExtra and the "key" as a parameter
        val name = intent.getStringExtra(EXTRA_NAME) // U can use "getStringExtra(params)" for String
        val age = intent.getIntExtra(EXTRA_AGE, 0) // U can use "getIntExtra(params)" for Int

        val text = "Name : $name, Your Age : $age"
        dataReceivedTextView.text = text
    }
}