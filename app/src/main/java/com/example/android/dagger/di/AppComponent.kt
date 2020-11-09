package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [StorageModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    // Classes that can be injected by this Component
    fun inject(activity: RegistrationActivity)
    fun inject(activity: MainActivity)
}