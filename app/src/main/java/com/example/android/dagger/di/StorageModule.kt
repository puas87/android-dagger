package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class RegistrationStorage

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LoginStorage

@Module
abstract class StorageModule {

    /**
     * A better way (@Binds is recommended because it generates less code and therefore it's more efficient):
     * @Binds
     * abstract fun provideStorage(storage: SharedPreferencesStorage) : Storage
     */
    /**
    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. Storage).
    // Function parameters are the dependencies of this type (i.e. Context).
    @Provides
    fun provideStorage(context: Context): Storage {
        // Whenever Dagger needs to provide an instance of type Storage,
        // this code (the one inside the @Provides method) will be run.
        return SharedPreferencesStorage(context)
    }
     */

    @RegistrationStorage
    @Provides
    fun providesRegistrationStorage(context: Context): Storage {
        return SharedPreferencesStorage("registration", context)
    }

    @LoginStorage
    @Provides
    fun providesLoginStorage(context: Context): Storage {
        return SharedPreferencesStorage("login", context)
    }
}