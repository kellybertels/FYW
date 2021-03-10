package ie.wit.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ie.wit.R
import ie.wit.main.FYWApp
import ie.wit.models.FoodModel
import kotlinx.android.synthetic.main.fragment_donate.view.*
import org.jetbrains.anko.toast


class FoodFragment : Fragment() {

    lateinit var app: FYWApp
    var totalDonated = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app = activity?.application as FYWApp
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_donate, container, false)
        activity?.title = getString(R.string.action_donate)

        root.progressBar.max = 10
        root.amountPicker.minValue = 1
        root.amountPicker.maxValue = 10

        root.amountPicker.setOnValueChangedListener { _, _, newVal ->
            //Display the newly selected number to paymentAmount
            root.paymentAmount.setText("$newVal")
        }
        setButtonListener(root)
        return root;
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FoodFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    fun setButtonListener( layout: View) {
        layout.donateButton.setOnClickListener {
            val amount = if (layout.paymentAmount.text.isNotEmpty())
                layout.paymentAmount.text.toString().toInt() else layout.amountPicker.value
            if(totalDonated >= layout.progressBar.max)
                activity?.toast("Donate Amount Exceeded!")
            else {
                val paymentmethod = if(layout.paymentMethod.checkedRadioButtonId == R.id.Direct) "Direct" else "Paypal"
                totalDonated += amount
                layout.totalSoFar.text = "$$totalDonated"
                layout.progressBar.progress = totalDonated
                app.deliveriesStore.create(FoodModel(paymentmethod = paymentmethod,amount = amount))
            }
        }
    }
}
