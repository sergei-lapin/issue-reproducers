package com.example.myapplication

import android.app.Application
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [SomeModule::class])
internal interface RootComponent {

    val application: Application
    val `interface`: Interface

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): RootComponent
    }
}

@Module
interface SomeModule {

    @Binds
    fun bind(impl: Impl): Interface
}

interface Interface

@Singleton
class Impl @Inject constructor() : Interface