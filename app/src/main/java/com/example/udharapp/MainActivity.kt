package com.example.udharapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

     private var viewhindi: String? = null
     private var viewEnglish: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLoadFirst()
        setContentView(R.layout.activity_main)

//        val actionBar = supportActionBar
//        actionBar!!.title = R.string.app_name.toString()


        btnhindi.setOnClickListener {view->

             viewhindi = view.toString()

            alertDialogCreat(viewhindi!!)

        }

        btnEnglish.setOnClickListener {view->

            viewEnglish = view.toString()

            alertDialogCreat(viewEnglish!!)


        }
    }

    private fun alertDialogCreat(view: String) {


        if(view.equals(viewhindi)){

            setLocale("hi")
            recreate()

            val intent = Intent(this,VerifyMobileActivity::class.java)
            startActivity(intent)

        }
        if (view.equals(viewEnglish)){
            setLocale("en")
            recreate()

            val intent = Intent(this,VerifyMobileActivity::class.java)
            startActivity(intent)

        }

    }

    private fun setLocale(lang: String) {

        val locale = Locale(lang)
        Locale.setDefault(locale)
        val configure = Configuration()
        configure.locale = locale

        baseContext.resources.updateConfiguration(configure,baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Lang_Settings", Context.MODE_PRIVATE).edit()
        editor.putString("MY_LANG",lang)
        editor.apply()

    }

    private fun setLoadFirst(){

        val sharedPreference = getSharedPreferences("Lang_Settings",Activity.MODE_PRIVATE)
        val language = sharedPreference.getString("MY_LANG","")
        setLocale(language)
    }


    private var doubleBackToExitPressedOnce = false

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed({

            doubleBackToExitPressedOnce = false

        }, 2000)
    }

}
