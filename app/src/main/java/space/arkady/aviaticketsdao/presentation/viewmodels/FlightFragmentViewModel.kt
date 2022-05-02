package space.arkady.aviaticketsdao.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.arkady.aviaticketsdao.R
import space.arkady.aviaticketsdao.domain.interactor.FlightTicketInteractor
import space.arkady.aviaticketsdao.domain.models.FlightTicket
import space.arkady.aviaticketsdao.utils.checkValidPassport

class FlightFragmentViewModel(private val interactor: FlightTicketInteractor) : ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    private val _snack = MutableLiveData<Int>()
    val snack: LiveData<Int> get() = _snack

    init {
        getFlightTickets()
    }

    fun createFlightTicket(
        departure: String,
        destination: String,
        departDate: String,
        returnDate: String,
        numberPassportPassenger: String,
        passengerAge: FlightTicket.PassengerAge,
        namePassenger: String
    ) {
        viewModelScope.launch {
            if (isValid(
                    destination,
                    departDate,
                    departure,
                    returnDate,
                    numberPassportPassenger,
                    namePassenger
                )
            ) {
                interactor.createFlightTickets(
                    destination = destination,
                    passengerName = namePassenger,
                    passengerAge = passengerAge,
                    departureDate = departDate,
                    returningDate = returnDate,
                    passengerPassportNumber = numberPassportPassenger,
                    departure = departure
                )
                _snack.value = R.string.FlightRes
            } else {
                _snack.value = R.string.FillEveryField
            }
        }
    }

    private fun getFlightTickets() {
        viewModelScope.launch {
            _flightTicket.postValue(interactor.getFlightTickets())
        }
    }

    private fun isValid(
        destination: String,
        departDate: String,
        departure: String,
        returnDate: String,
        numberPassportPassenger: String,
        namePassenger: String
    ): Boolean {
        return (departure.isNotEmpty() &&
                departDate.isNotEmpty() &&
                destination.isNotEmpty() &&
                returnDate.isNotEmpty() &&
                numberPassportPassenger.checkValidPassport() &&
                namePassenger.isNotEmpty())
    }
}