package com.example.tema1_android.helpers.extensions

import java.util.Locale

fun String.formatLetters(): String {
    return this.split(" ").joinToString(" ") { s ->
        s.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
    }
}

