package space.arkady.aviaticketsdao.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import space.arkady.aviaticketsdao.data.FlightTicketsDao
import space.arkady.aviaticketsdao.domain.models.FlightTicket
import space.arkady.aviaticketsdao.domain.repository.FlightTicketRepository
import space.arkady.aviaticketsdao.utils.toFlightTicket
import space.arkady.aviaticketsdao.utils.toFlightTicketEntity

class FlightTicketEntitiesRepositoryImplement(private val flightTicketsDao: FlightTicketsDao)
    : FlightTicketRepository {
    override suspend fun getSavedFlightTicket(): List<FlightTicket> {
        return withContext(Dispatchers.IO) {
            flightTicketsDao.getAllFlightTickets().map { FlightTicketEntity ->
                FlightTicketEntity.toFlightTicket()
            }
        }
    }

    override suspend fun saveFlightTicket(ticket: FlightTicket) {
        return withContext(Dispatchers.IO) {
            flightTicketsDao.saveTicketsDao(ticket.toFlightTicketEntity())
        }
    }

    override suspend fun deleteFlightTicket(ticket: FlightTicket) {
        return withContext(Dispatchers.IO) {
            flightTicketsDao.deleteTicketsDao(ticket.toFlightTicketEntity())
        }
    }
}