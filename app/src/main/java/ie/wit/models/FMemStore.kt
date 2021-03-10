package ie.wit.models

import android.util.Log

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class FMemStore : FoodStore {

        val deliveries = ArrayList<FoodModel>()

        override fun findAll(): List<FoodModel> {
            return deliveries
        }

        override fun findById(id:Long) : FoodModel? {
            val foundDonation: FoodModel? = deliveries.find { it.id == id }
            return foundDonation
        }

        override fun create(buy: FoodModel) {
            buy.id = getId()
            deliveries.add(buy)
            logAll()
        }

/*
    override fun update(donation: FoodModel) {

    }

    override fun delete(donation: FoodModel) {
        deliveries.remove(donation)
        logAll()
    }
    */

        fun logAll() {
            Log.v("Donate","** deliveries List **")
            deliveries.forEach { Log.v("Donate","${it}") }
        }
    }
