package space.arkady.aviaticketsdao.domain.repository

import space.arkady.aviaticketsdao.domain.models.FlightTicket

interface FlightTicketRepository {

    suspend fun getSavedFlightTicket(): List<FlightTicket>

    suspend fun saveFlightTicket(ticket: FlightTicket)

    suspend fun deleteFlightTicket(ticket: FlightTicket)
}