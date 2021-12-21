package com.example.videoplaydemo.common

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(ActivityCompat::class)
@Module
object ActivityModule : BaseActivityModule() {

    @Provides
    fun provideLifecycleOwner(): LifecycleOwner{
        return activity
    }
}

open class BaseActivityModule{
    @set:Inject
    lateinit var activity: AppCompatActivity
}

