package ie.wit.models;

interface FoodStore {
    fun findAll() : List<FoodModel>
    fun findById(id: Long) : FoodModel?
    fun create(buy: FoodModel)
    //fun update(buy: FoodModel)
    //fun delete(buy: FoodModel)
}