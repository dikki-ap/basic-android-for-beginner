package dikki.basicandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Creating "late init" var so that the variable is processed only when the variable or component is accessed
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var nameTextView: TextView
    private lateinit var appNameTextView: TextView

    // Making all components into 1 Function so u already implement DRY Principle
    private fun initComponents(){
        appNameTextView = findViewById(R.id.appNameTextView)
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        nameTextView = findViewById(R.id.nameTextView)
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
    }
}