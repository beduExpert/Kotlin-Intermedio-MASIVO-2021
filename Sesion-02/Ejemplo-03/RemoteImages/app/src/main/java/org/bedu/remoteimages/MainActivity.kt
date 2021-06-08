package org.bedu.remoteimages

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.api.load


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        imageView.load("https://raw.githubusercontent.com/beduExpert/Kotlin-Intermedio-2020/master/images/android-kotlin.png")

    }
}
