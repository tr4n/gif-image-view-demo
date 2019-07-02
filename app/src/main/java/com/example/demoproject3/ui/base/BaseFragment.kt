package com.example.demoproject3.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding> : Fragment() {

    protected lateinit var viewDataBinding: VB
    protected abstract val layoutResource: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        viewDataBinding = DataBindingUtil.inflate(inflater, layoutResource, container, false) as VB
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    protected abstract fun initComponents()

    protected fun toastMsg(msg: String) {
        context?.let {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
    }

    protected fun toastMsg(resId: Int) {
        context?.run {
            Toast.makeText(context, this.getString(resId), Toast.LENGTH_SHORT).show()
        }
    }

    protected fun replaceFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        activity?.supportFragmentManager?.beginTransaction()?.replace(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    protected fun addFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        activity?.supportFragmentManager?.beginTransaction()?.add(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    protected fun backToPreviousFragment() = activity?.supportFragmentManager?.run {
        if (backStackEntryCount > 0) popBackStack()
    }
}
