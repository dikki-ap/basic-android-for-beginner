package dikki.basicandroid.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dikki.basicandroid.R

class IntentActivity : AppCompatActivity() {

    private lateinit var moveButton: Button
    private lateinit var moveDataButton: Button

    private fun initComponents(){
        moveButton = findViewById(R.id.moveButton)
        moveDataButton = findViewById(R.id.moveDataButton)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        initComponents()

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
    }
}