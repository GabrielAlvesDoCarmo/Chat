package com.gdsdevtec.chat.ui.activity.intro

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.gdsdevtec.chat.R
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide

class SlideIntroActivity : IntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSlideShow()
    }

    private fun initSlideShow() {
        configIntro()
        fragmentSlide(R.layout.slide_intro_one, back = false)
        fragmentSlide(R.layout.slide_intro_two)
        fragmentSlide(R.layout.slide_intro_three)
        fragmentSlide(R.layout.slide_chat_id, next = false)
    }

    private fun configIntro() {
        isButtonBackVisible = false
        isButtonNextVisible = false
    }

    private fun fragmentSlide(
        @LayoutRes fragmentView: Int,
        back: Boolean = true,
        next: Boolean = true
    ) {
        addSlide(
            FragmentSlide.Builder()
                .background(R.color.white)
                .fragment(fragmentView)
                .canGoBackward(back)
                .canGoForward(next)
                .build()
        )
    }
}