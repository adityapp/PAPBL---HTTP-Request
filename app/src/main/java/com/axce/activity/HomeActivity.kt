package com.axce.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.axce.R
import com.axce.fragment.ChildFragment
import com.axce.fragment.ParentFragment
import com.axce.models.Toko
import com.axce.utils.LahzadaService
import com.axce.utils.ServiceLahzada
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, ParentFragment()).commit()


        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.parent -> supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, ParentFragment()).commit()
                R.id.child -> supportFragmentManager.beginTransaction().replace(R.id.fragment_frame, ChildFragment()).commit()
            }
            true
        }

    }
}
