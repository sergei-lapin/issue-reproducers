package com.example.lib

import android.content.Context
import android.content.res.Configuration
import java.util.*

class Foo {

    fun bar(context: Context): Context {
        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(Locale.getDefault())
        return context.createConfigurationContext(configuration)
    }
}