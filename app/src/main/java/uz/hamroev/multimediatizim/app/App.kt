package uz.hamroev.multimediatizim.app

import android.app.Application
import uz.hamroev.multimediatizim.cache.Cache

class App : Application() {
    override fun onCreate() {
        Cache.init(this)
        super.onCreate()
    }
}