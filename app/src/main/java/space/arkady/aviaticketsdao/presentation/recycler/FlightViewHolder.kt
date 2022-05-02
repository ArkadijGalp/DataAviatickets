package space.arkady.aviaticketsdao.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.arkady.aviaticketsdao.databinding.ItemFlightHistoryBinding
import space.arkady.aviaticketsdao.domain.models.FlightTicket
import space.arkady.aviaticketsdao.utils.getValuePassengerAge

class FlightViewHolder(private val binding: ItemFlightHistoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup) = FlightViewHolder(
            ItemFlightHistoryBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    fun bindItem(flightTicket: FlightTicket) {
        with(flightTicket) {
            binding.historyDateDestination.text = returnDate
            binding.historyDateDepart.text = departDate
            binding.historyDeparture.text = departure
            binding.historyDestination.text = destination
            binding.historyNamePassenger.text = namePassenger
            binding.historyPassengerAge.text = binding.root.context.getString(passengerAge.idAge.getValuePassengerAge())
            binding.historyNumberPassportPassenger.text = numberPassportOfPassenger
        }
    }
}