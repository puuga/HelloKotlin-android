package com.puuga.hellokotlin.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puuga.hellokotlin.R

/**
 * A placeholder fragment containing a simple view.
 */
class NotificationActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_notification, container, false)
    }
}
