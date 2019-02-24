package com.axce.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.axce.R
import com.axce.components.DialogBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var dialogBox: DialogBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialogBox = DialogBox()

        btn_public_api.setOnClickListener(this)
        btn_local_api.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_public_api -> {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("BUTTON", "public")
                startActivity(intent)
            }
            btn_local_api -> {
                dialogBox.showNoticeDialog(this)
            }
        }
    }
}
