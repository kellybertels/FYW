package ie.wit.fragments


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import ie.wit.R
import ie.wit.adapters.FAdapter
import ie.wit.main.FYWApp
import ie.wit.models.FoodModel
import kotlinx.android.synthetic.main.fragment_basket.*
import kotlinx.android.synthetic.main.fragment_basket.view.*














class BasketFragment : Fragment() {

    lateinit var app: FYWApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as FYWApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_basket, container, false)

        root.recyclerView.setLayoutManager(LinearLayoutManager(activity))
        root.recyclerView.adapter = FAdapter(app.deliveriesStore.findAll())


        //handles the swipe function on recycler view
        //Incompleete
        //https://www.youtube.com/watch?v=5JsLk8IkhXE
        // val itemSwipe: object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
        //    override fun onMove(recyclerView:RecyclerView,viewHolder: RecyclerView.ViewHolder){
        // return false

}
           // override fun onSwiped(viewHolder: RecyclerView.ViewHolder,direction:Int){
             //   showDialog()
         //   }
       // }
     //   val swap =ItemTouchHelper(itemSwipe)
     //   swap.attachToRecyclerView(recyclerView)
     //   return root
 //   }


    //shows dialog for deleting item or not
 /*fun showDialog(viewHolder: RecyclerView.ViewHolder){
val builder =AlertDialog.Builder(activity)
    builder.setTitle("DeleteItem")
    builder.setMessage("Are you sure you want to delete item.")
    builder.setPositiveButton("Confirm"){
        dialog, which ->
        val position =viewHolder.adapterPosition

    }
    builder.setNegativeButton("Cancel"){
        dialog,which->
        viewHolder.adapterPosition

    }
    builder.show()
}
*/



    companion object {
        @JvmStatic
        fun newInstance() =
            BasketFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}
