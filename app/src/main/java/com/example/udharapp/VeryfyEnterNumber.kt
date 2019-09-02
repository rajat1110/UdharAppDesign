package com.example.udharapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_veryfy_enter_number.*

class VeryfyEnterNumber : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veryfy_enter_number)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnOk.setOnClickListener {view->

            if (etNumber.text.toString().length!=10){

                Snackbar.make(view,R.string.wrongnumberotp,Snackbar.LENGTH_SHORT).show()

            }else{

                val intent = Intent(this,CheckOtp::class.java)
                intent.putExtra("number",etNumber.text.toString())
                startActivity(intent)

            }



        }

    }
}
