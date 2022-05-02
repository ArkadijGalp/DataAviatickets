package space.arkady.aviaticketsdao.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.arkady.aviaticketsdao.domain.models.FlightTicket

class FlightsAdapter : RecyclerView.Adapter<FlightViewHolder>() {

    private var items: List<FlightTicket> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        return FlightViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size


    fun submitItem(item: List<FlightTicket>) {
        items = item
        notifyDataSetChanged()
    }
}
