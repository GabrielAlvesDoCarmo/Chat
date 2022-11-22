package com.gdsdevtec.chat.ui.activity.core

import android.view.View
import com.gdsdevtec.chat.databinding.ActivitySetupAppBinding

class SetupAppActivity : BaseActivity<ActivitySetupAppBinding>() {
    override fun activityBind(): ActivitySetupAppBinding {
        return ActivitySetupAppBinding.inflate(layoutInflater)
    }

    override fun viewRoot(): View {
        return binding.root
    }

    override fun onCreateCode() {
        finish()
    }

}