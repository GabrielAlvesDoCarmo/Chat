package com.gdsdevtec.chat.ui.activity.core

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = activityBind()
        setContentView(viewRoot())
        onCreateCode()
    }

    abstract fun activityBind(): VB
    abstract fun viewRoot(): View
    abstract fun onCreateCode()
}