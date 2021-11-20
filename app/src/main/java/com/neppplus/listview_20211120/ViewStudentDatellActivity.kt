package com.neppplus.listview_20211120

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_student_datell.*

class ViewStudentDatellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_student_datell)

        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val age = intent.getIntExtra("age",0)

        txtname.text = name
        txtAddress.text = address
        txtAge.text = "${age}세"


    }
}