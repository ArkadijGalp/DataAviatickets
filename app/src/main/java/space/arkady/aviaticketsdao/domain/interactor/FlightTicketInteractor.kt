package space.arkady.aviaticketsdao.domain.interactor

import space.arkady.aviaticketsdao.domain.models.FlightTicket

interface FlightTicketInteractor {
    suspend fun getFlightTickets(): List<FlightTicket>

    suspend fun deleteFlightTickets(flightTicket: FlightTicket)

    suspend fun createFlightTickets(
        departure: String,
        destination: String,
        departureDate: String,
        returningDate: String,
        passengerPassportNumber: String,
        passengerName: String,
        passengerAge: FlightTicket.PassengerAge
    )
}