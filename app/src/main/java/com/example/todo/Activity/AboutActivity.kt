package com.example.todo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.R
import com.example.todo.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater);
        setContentView(binding.root)
        binding.materialToolbar2.title = getString(R.string.app_name)
        binding.about.loadUrl("file:///android_asset/webview_display.html")

    }
}