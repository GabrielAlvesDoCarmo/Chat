package com.gdsdevtec.chat.ui.activity.intro

import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide

class SlideIntroActivity : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSlide(
            object : SimpleSlide.Builder()
                .title("tutui")
                .description("dmfjklj")
                .background(android.R.color.background_dark)
                .image(android.R.drawable.ic_menu_report_image)
                .build()
        )
    }
}