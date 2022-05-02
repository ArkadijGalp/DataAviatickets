package space.arkady.aviaticketsdao.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.arkady.aviaticketsdao.R
import space.arkady.aviaticketsdao.domain.interactor.FlightTicketInteractor
import space.arkady.aviaticketsdao.domain.models.FlightTicket

class HistoryFragmentViewModel(private val interactor: FlightTicketInteractor) : ViewModel() {

    private val _flightTicket = MutableLiveData<List<FlightTicket>>()
    val flightTicket: LiveData<List<FlightTicket>> get() = _flightTicket

    private val _snack = MutableLiveData<Int>()
    val snack: LiveData<Int> get() = _snack

    fun getFlightTickets() {
        viewModelScope.launch {
            _flightTicket.postValue(interactor.getFlightTickets())
        }
    }

    fun deleteFlightTicket(flightTicket: FlightTicket) {
        viewModelScope.launch {
            interactor.deleteFlightTickets(flightTicket)
        }.invokeOnCompletion {
            getFlightTickets()
            _snack.value = R.string.RemoteSuccesfully
        }
    }

    fun removeItem(position: Int): FlightTicket? {
        return flightTicket.value?.toMutableList()?.removeAt(position)
    }
}