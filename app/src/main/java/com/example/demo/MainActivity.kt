package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFragA: Button = findViewById(R.id.btnFragA)
        val btnFragB: Button = findViewById(R.id.btnFragB)
        val btnAssign: Button = findViewById(R.id.btn_assign)
        val tv_result: TextView = findViewById(R.id.tv_result)

        val fragmentMng = supportFragmentManager

        btnFragA.setOnClickListener {
            val fragmentA = AFragment()
            val fragmentTrans = fragmentManager.beginTransaction()

            fragmentTrans.replace(R.id.fragmentContainerView, fragmentA)
            fragmentTrans.addToBackStack(null) //add it into the stack so "bck" button will pop this out
            fragmentTrans.commit()
        }

        btnFragB.setOnClickListener {
            val fragmentB = BFragment()
            val fragmentTrans = fragmentManager.beginTransaction()

            fragmentTrans.replace(R.id.fragmentContainerView, fragmentB)
            fragmentTrans.addToBackStack(null)
            fragmentTrans.commit()
        }

        btnAssign.setOnClickListener {
            val fragmentA = fragmentManager.findFragmentById(R.id.fragmentContainerView) as AFragment
            fragmentA.requireView().findViewById<TextView>(R.id.tv_message).text = "Hello"
        }
    }
}