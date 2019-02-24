package com.axce.components

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.app.DialogFragment
import android.view.Window
import com.axce.R
import com.axce.activity.HomeActivity
import kotlinx.android.synthetic.main.dialog_box.*

class DialogBox: DialogFragment(){
    fun showNoticeDialog(context: Context) {
        val activity = context as Activity
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_box)

        dialog.btn_batal.setOnClickListener {
            dialog.dismiss()
        }

        dialog.btn_done.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.putExtra("BUTTON", "local")
            intent.putExtra("IP", dialog.edt_ip.text.toString())
            activity.startActivity(intent)
        }

        dialog.show()
    }
}