package dikki.basicandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dikki.basicandroid.R

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
    }
}