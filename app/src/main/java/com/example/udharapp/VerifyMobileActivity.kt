package com.example.udharapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verify_mobile.*

class VerifyMobileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_mobile)


        numberVerifyBtn.setOnClickListener {

            val intent = Intent(this,VeryfyEnterNumber::class.java)
            startActivity(intent)


        }


    }
}
