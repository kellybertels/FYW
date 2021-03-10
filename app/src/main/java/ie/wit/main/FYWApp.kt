package ie.wit.main

import android.app.Application
import android.util.Log
import ie.wit.models.FMemStore
import ie.wit.models.FoodStore

class FYWApp : Application() {

    lateinit var deliveriesStore: FoodStore

    override fun onCreate() {
        super.onCreate()
        deliveriesStore = FMemStore()

        Log.v("FWY","Food Your Way App. ")
    }
}