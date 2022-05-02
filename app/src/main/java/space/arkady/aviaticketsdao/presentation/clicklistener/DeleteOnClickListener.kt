package space.arkady.aviaticketsdao.presentation.clicklistener

import space.arkady.aviaticketsdao.domain.models.FlightTicket

interface DeleteOnClickListener {
    fun deleteTicket(flightTicket: FlightTicket)
}