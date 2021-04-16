package com.chad.foodrecipeapp.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chad.foodrecipeapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseActivity() : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}