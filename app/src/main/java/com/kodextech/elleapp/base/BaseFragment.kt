@file:Suppress("DEPRECATION")

package com.kodextech.cleaques.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kodextech.cleaques.utils.HideUtil


abstract class BaseFragment : Fragment() {
    lateinit var mContext: Context
    lateinit var mActivity: BaseActivity
    lateinit var mView: View
    var isNewScreenOpen: Boolean = false
    var newScreenOpened: ((Boolean) -> Unit)? = null

    open
    fun openPreviousState() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = context as BaseActivity
    }


    protected open fun onBecameVisibleToUser() {
        //
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HideUtil.init(mActivity)
        initIds()
        initListener()
    }

    protected open fun onRecycle() {
        //
    }

    final override fun onDestroy() {
        onRecycle()
        super.onDestroy()
    }

    protected open fun onBecameInvisibleToUser() {
        //
    }

    abstract fun initIds()
    abstract fun initListener()


    final override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            onBecameVisibleToUser()
        } else {
            onBecameInvisibleToUser()
        }
    }
}

interface CanManagePlayback {

    fun startPlayback()

    fun stopPlayback()

}