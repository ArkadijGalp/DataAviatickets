package space.arkady.aviaticketsdao.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.switchmaterial.SwitchMaterial
import org.koin.androidx.viewmodel.ext.android.viewModel
import space.arkady.aviaticketsdao.R
import space.arkady.aviaticketsdao.databinding.FragmentFlightRegistrationBinding
import space.arkady.aviaticketsdao.domain.models.FlightTicket
import space.arkady.aviaticketsdao.presentation.datepickmanager.DatePickerManager
import space.arkady.aviaticketsdao.presentation.viewmodels.FlightFragmentViewModel
import space.arkady.aviaticketsdao.utils.openFragment
import space.arkady.aviaticketsdao.utils.showSnack


class FragmentFlightRegistration : Fragment(R.layout.fragment_flight_registration) {

    private val binding by viewBinding<FragmentFlightRegistrationBinding>()
    private val viewModel by viewModel<FlightFragmentViewModel>()
    private val dataPicker by lazy { DatePickerManager(requireContext()) }

    companion object {
        const val TAG = "Flights Registration"
        fun newInstance() = FragmentFlightRegistration()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        checkHistory()
        initTextSwitchComponent()
    }

    private fun initTextSwitchComponent() {
        with(binding) {
            textViewOffSwitch.text = getString(R.string.Adult)
            textViewOnSwitch.text = getString(R.string.Child)
        }
    }

    private fun initViews() {
        with(binding) {
            showDepartureDate.setOnClickListener {
                dataPicker.openDateTimePicker(showDepartureDate)
            }
            showArrivalDate.setOnClickListener {
                dataPicker.openDateTimePicker(showArrivalDate)
            }
            buttonToConfirmFlight.setOnClickListener {
                createFlight()
            }
        }
    }

    private fun createFlight() {
        with(binding) {
            viewModel.createFlightTicket(
                departure = inputFlightDeparture.text.toString(),
                destination = inputFlightDestination.text.toString(),
                departDate = showDepartureDate.text.toString(),
                returnDate = showArrivalDate.text.toString(),
                numberPassportPassenger = passportPassenger.text.toString(),
                namePassenger = namePassenger.text.toString(),
                passengerAge = passengerAgeCategory.checkPassengerAge(),

            )
        }
        viewModel.snack.observe(viewLifecycleOwner) { event ->
            showSnack(getString(event), requireView())
        }
    }

   private fun SwitchMaterial.checkPassengerAge(): FlightTicket.PassengerAge {
        return if (isChecked) FlightTicket.PassengerAge.CHILD else FlightTicket.PassengerAge.ADULT
    }

    private fun checkHistory() {
        binding.buttonToShowFlightsHistory.setOnClickListener {
            requireActivity().openFragment(
                idFrameFragment = R.id.frameFragment,
                fragment = FragmentFlightHistory.newInstance(),
                tag = FragmentFlightHistory.TAG
            )
        }
    }

}


