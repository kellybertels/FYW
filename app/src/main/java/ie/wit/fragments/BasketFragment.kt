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
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_basket, container, false)

        root.recyclerView.setLayoutManager(LinearLayoutManager(activity))
        root.recyclerView.adapter = FAdapter(app.deliveriesStore.findAll())


        return root
    }





    companion object {
        @JvmStatic
        fun newInstance() =
            BasketFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}
