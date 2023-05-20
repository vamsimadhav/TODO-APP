package com.example.todo

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ToDoApp: Application() {
    private val koinModule = module {
        single {
            ToDoRepositary()
        }
        viewModel {
            RosterMotor(get())
        }
        viewModel {
            (modelId: String) -> SingleModelMotor(modelId,get())
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            modules(koinModule)
        }

    }
}