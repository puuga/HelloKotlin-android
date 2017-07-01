package com.puuga.hellokotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.puuga.hellokotlin.R
import com.puuga.hellokotlin.util.Constant
import com.puuga.hellokotlin.util.NotiUtil

class MainActivity : AppCompatActivity() {
    val TAG:String = javaClass.simpleName

    var tvAction: TextView? = null
    var btnAction: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindWidget()
        checkIntent()
    }

    private fun checkIntent() {
        if (intent.hasExtra(Constant.KEY_FROM_NOTIFICATION)) {
            Log.d(TAG, "KEY_FROM_NOTIFICATION: " + intent.getStringExtra(Constant.KEY_FROM_NOTIFICATION))
        }
    }

    private fun bindWidget() {
        tvAction = findViewById(R.id.tvAction)
        btnAction = findViewById(R.id.btnAction)

        btnAction?.setOnClickListener(onClickListener)
    }

    var onClickListener: View.OnClickListener = View.OnClickListener { view ->
        if (view == btnAction) {
            Log.d(TAG, "OnClickListener: btnAction")
            NotiUtil().showNoti(this)
        }
    }
}
