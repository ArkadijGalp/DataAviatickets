package space.arkady.aviaticketsdao.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import space.arkady.aviaticketsdao.R
import space.arkady.aviaticketsdao.databinding.FragmentFlightHistoryBinding
import space.arkady.aviaticketsdao.presentation.recycler.FlightsAdapter
import space.arkady.aviaticketsdao.presentation.swipetodeletecallback.SwipeToDeleteCallback
import space.arkady.aviaticketsdao.presentation.viewmodels.HistoryFragmentViewModel
import space.arkady.aviaticketsdao.utils.dialog
import space.arkady.aviaticketsdao.utils.showSnack

class FragmentFlightHistory : Fragment(R.layout.fragment_flight_history) {
    private val binding by viewBinding<FragmentFlightHistoryBinding>()
    private val viewTicketModel by viewModel<HistoryFragmentViewModel>()
    private val adapter by lazy { FlightsAdapter() }

    companion object {
        const val TAG = "Flights History"
        fun newInstance() = FragmentFlightHistory()
    }

    private val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.bindingAdapterPosition
            dialog(
                message = getString(R.string.finalQuestion),
                context = requireActivity(),
                onPositiveButtonClick = {
                    viewTicketModel.removeItem(position)?.let { flightTicket ->
                        viewTicketModel.deleteFlightTicket(flightTicket)
                    }
                    binding.recyclerFlightsStory.adapter?.notifyItemRemoved(position)
                },
                onNegativeButtonClick = { viewTicketModel.getFlightTickets() }
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewTicketModel.getFlightTickets()
        initObserver()
    }

    private fun initObserver() {

        binding.recyclerFlightsStory.adapter = adapter

        viewTicketModel.flightTicket.observe(viewLifecycleOwner) { ticketList ->
            adapter.submitItem(ticketList)
        }

        ItemTouchHelper(swipeToDeleteCallback).attachToRecyclerView(binding.recyclerFlightsStory)

        viewTicketModel.snack.observe(viewLifecycleOwner) { action ->
            showSnack(requireActivity().getString(action), requireView())
        }
    }
}