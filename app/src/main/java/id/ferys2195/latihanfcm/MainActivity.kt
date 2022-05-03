package id.ferys2195.latihanfcm

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnGetToken = findViewById<Button>(R.id.button)
        val textToken = findViewById<TextView>(R.id.textView)

        btnGetToken.setOnClickListener {
            FirebaseMessaging.getInstance().token
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w(TAG, "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }
                    val token = task.result.toString()
                    textToken.text = token
                    Log.d(TAG, token)
                    Toast.makeText(baseContext, token, Toast.LENGTH_LONG).show()
                })
        }
    }
}
