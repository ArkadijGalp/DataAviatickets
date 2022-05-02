package space.arkady.aviaticketsdao.domain.repository

import space.arkady.aviaticketsdao.domain.models.FlightTicket
import space.arkady.aviaticketsdao.domain.interactor.FlightTicketInteractor

class FlightTicketRepositoryImplement(val repository: FlightTicketRepository) :
    FlightTicketInteractor {
    override suspend fun getFlightTickets(): List<FlightTicket> {
        return repository.getSavedFlightTicket()
    }

    override suspend fun deleteFlightTickets(flightTicket: FlightTicket) {
        return repository.deleteFlightTicket(ticket = flightTicket)
    }

    override suspend fun createFlightTickets(
        departure: String,
        destination: String,
        departureDate: String,
        returningDate: String,
        passengerPassportNumber: String,
        passengerName: String,
        passengerAge: FlightTicket.PassengerAge
    ) {
        repository.saveFlightTicket(
            ticket = FlightTicket(
                passengerAge = passengerAge,
                namePassenger = passengerName,
                departDate = departureDate,
                departure = departure,
                destination = destination,
                returnDate = returningDate,
                numberPassportOfPassenger = passengerPassportNumber
            )
        )
    }


}