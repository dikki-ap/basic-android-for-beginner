package dikki.basicandroid.intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dikki.basicandroid.R
import dikki.basicandroid.intent.Person

class IntentObject : AppCompatActivity() {

    private lateinit var objectReceivedTextView: TextView

    private fun initComponents(){
        objectReceivedTextView = findViewById(R.id.objectReceivedTextView)
    }

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_object)

        initComponents()

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            objectReceivedTextView.text = text
        }
    }
}