package dikki.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.TextView
import dikki.basicandroid.activity.BarVolumeActivity
import dikki.basicandroid.intent.IntentActivity
import dikki.basicandroid.view.ViewActivity

class MainActivity : AppCompatActivity() {

    // Creating "late init" var so that the variable is processed only when the variable or component is accessed
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var nameTextView: TextView
    private lateinit var appNameTextView: TextView
    private lateinit var activityPracticeButton: Button
    private lateinit var intentPracticeButton: Button
    private lateinit var viewPracticeButton : Button
    private lateinit var rvPracticeButton : Button

    // Making all components into 1 Function so u already implement DRY Principle
    private fun initComponents(){
        appNameTextView = findViewById(R.id.appNameTextView)
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        nameTextView = findViewById(R.id.nameTextView)
        activityPracticeButton = findViewById(R.id.activityPracticeButton)
        intentPracticeButton = findViewById(R.id.intentPracticeButton)
        viewPracticeButton = findViewById(R.id.viewPracticeButton)
        rvPracticeButton = findViewById(R.id.rvPracticeButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        // Access all of the Components with initComponent() Function
        initComponents()

        // Getting Resource from Another Resource (from String Values (values/strings.xml) on Layout Resource TextView)
        // U can use "resources.getMethod(R.typeResource.idResource, param?)
        appNameTextView.text = resources.getText(R.string.app_name)

        /*
            Log Level
            1. Verbose          Log.v(tag, message?, throwable?)
            2. Debug            Log.d(tag, message?, throwable?)
            3. Info             Log.i(tag, message?, throwable?)
            4. Warning          Log.w(tag, message?, throwable?)
            5. Error            Log.e(tag, message?, throwable?)

            the lower the level will be higher, so when u creating Warning Log
            it will be display just to Warning and Error
            U can access it by click on Logcat and choose the type Log Level, and also u can find text log
         */

        // U can use the component without declare one by one again
        // Creating Action Listener to Button
        sayHelloButton.setOnClickListener {
            // Using Log
            Log.d("HelloWorldLog", "This is Debug Log")
            Log.i("HelloWorldLog", "This is Info Log")
            Log.w("HelloWorldLog", "This is Warn Log")
            Log.e("HelloWorldLog", "This is Error Log")

            var name = nameEditText.text.toString() // Set to editText value into variable
            nameTextView.text = "Hi $name" // Set nameTextView into "String ${value}"

            // Get an Array value from String Resources
            resources.getStringArray(R.array.names).forEach {
                Log.i("StringArrayResources", it)
            }
        }

        activityPracticeButton.setOnClickListener {
            var moveIntent = Intent(this@MainActivity, BarVolumeActivity::class.java)
            startActivity(moveIntent)
        }

        intentPracticeButton.setOnClickListener {
            var moveIntent = Intent(this@MainActivity, IntentActivity::class.java)
            startActivity(moveIntent)
        }

        viewPracticeButton.setOnClickListener {
            var moveIntent = Intent(this@MainActivity, ViewActivity::class.java)
            startActivity(moveIntent)
        }

        rvPracticeButton.setOnClickListener {
            var moveIntent = Intent(this@MainActivity, dikki.basicandroid.recyclerview.MainActivity::class.java)
            startActivity(moveIntent)
        }
    }
}