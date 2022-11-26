package com.gdsdevtec.chat.util.extensions

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            return
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            return
        }
    })
}