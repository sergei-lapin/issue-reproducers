package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ParcelableModel

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val model =
        ParcelableModel(
            field = "Imma from Parcelable",
        )
    startActivity(Intent(this, MainActivity::class.java).apply { putExtra("key", model) })
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    intent?.getParcelableExtra<ParcelableModel>("key")?.let { model ->
      Toast.makeText(this, model.field, Toast.LENGTH_LONG).show()
    }
  }
}
