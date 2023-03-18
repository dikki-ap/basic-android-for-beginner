package dikki.basicandroid.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import dikki.basicandroid.R

class IntentActivity : AppCompatActivity() {

    private lateinit var moveButton: Button
    private lateinit var moveDataButton: Button
    private lateinit var moveObjectButton: Button
    private lateinit var dialButton: Button
    private lateinit var moveResultButton : Button
    private lateinit var resultTextView : TextView

    private fun initComponents(){
        moveButton = findViewById(R.id.moveButton)
        moveDataButton = findViewById(R.id.moveDataButton)
        moveObjectButton = findViewById(R.id.moveObjectButton)
        dialButton = findViewById(R.id.dialButton)
        moveResultButton = findViewById(R.id.moveResultButton)
        resultTextView = findViewById(R.id.resultTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        initComponents()


        // In order to create an Activity that can return a value, we need to create an ActivityResultLauncher object first
        /*
            You need to register the return type to the system using the registerForActivityResult code with an ActivityResultContract parameter of ActivityResultContract.
            This is because we will get the return value after calling the new Activity.
            Please note that we can also get the return value from other than Activity,
            for example like a photo from the gallery by defining a different contract.
         */
        val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == IntentResultActivity.RESULT_CODE && result.data != null) {
                val selectedValue =
                    result.data?.getIntExtra(IntentResultActivity.EXTRA_SELECTED_VALUE, 0)
                resultTextView.text = "Result : $selectedValue"
            }
        }

        moveButton.setOnClickListener {
            // Make a Intent Object
            // Intent(this@CurrentActivity, TargetActivity::class.java)
            var moveIntent = Intent(this@IntentActivity, IntentActivity2::class.java)

            startActivity(moveIntent)
            // finish()
            // U can add "finish()" if u dont want to go back to previous Intent
        }

        moveDataButton.setOnClickListener {
            // Make a Intent Object
            // Intent(this@CurrentActivity, TargetActivity::class.java)
            var moveWithDataIntent = Intent(this@IntentActivity, IntentActivityData::class.java)

            // Make a Data that will be send to Another Intent
            // U can use  putExtra(TargetActivity."key", "value")
            moveWithDataIntent.putExtra(IntentActivityData.EXTRA_NAME, "Dikki AP")
            moveWithDataIntent.putExtra(IntentActivityData.EXTRA_AGE, 22)

            startActivity(moveWithDataIntent)
            // finish()
            // U can add "finish()" if u dont want to go back to previous Intent
        }

        moveObjectButton.setOnClickListener {
            val person = Person(
                "Dikki AP",
                22,
                "dikki.ap@gmail.com",
                "Medan"
            )
            val moveWithObjectIntent = Intent(this@IntentActivity, IntentObject::class.java)
            moveWithObjectIntent.putExtra(IntentObject.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
        }

        dialButton.setOnClickListener {
            val phoneNumber = "081210841382"
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }

        moveResultButton.setOnClickListener {
            val moveForResultIntent = Intent(this@IntentActivity, IntentResultActivity::class.java)

            // U need to use "launch()" method from ActivityResultLauncher if u want to get Return Value from Another Activity
            // Usually u can use startActivity() method
            resultLauncher.launch(moveForResultIntent)
        }
    }
}