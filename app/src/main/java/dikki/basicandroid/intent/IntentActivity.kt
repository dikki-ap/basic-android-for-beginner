package dikki.basicandroid.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dikki.basicandroid.R

class IntentActivity : AppCompatActivity() {

    lateinit var moveButton: Button

    private fun initComponents(){
        moveButton = findViewById(R.id.moveButton)
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
    }
}