package com.test.tap2visit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.tap2visit.mvp.models.RecieveNews
import com.test.tap2visit.network.entity.Categories
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val reciver = RecieveNews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            reciver.test(category = Categories.BUSINESS)
        }
    }
}