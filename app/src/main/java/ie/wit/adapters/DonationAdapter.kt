package ie.wit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.R
import ie.wit.models.FoodModel
import kotlinx.android.synthetic.main.card_buy.view.*

class FAdapter constructor(private var deliveries: List<FoodModel>)
    : RecyclerView.Adapter<FAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_buy,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val buy = deliveries[holder.adapterPosition]
        holder.bind(buy)
    }

    override fun getItemCount(): Int = deliveries.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(buy: FoodModel) {
            itemView.paymentamount.text = buy.amount.toString()
            itemView.paymentmethod.text = buy.paymentmethod
            itemView.imageIcon.setImageResource(R.mipmap.ic_launcher_round)
        }
    }
}