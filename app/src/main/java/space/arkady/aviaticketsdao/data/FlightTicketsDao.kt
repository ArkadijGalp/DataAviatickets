package space.arkady.aviaticketsdao.data

import androidx.room.*
import space.arkady.aviaticketsdao.data.entity.FlightTicketEntity


@Dao
interface FlightTicketsDao {

@Insert
suspend fun saveTicketsDao(flightTicket: FlightTicketEntity)

@Delete
suspend fun deleteTicketsDao(flightTicket: FlightTicketEntity)

@Query("SELECT * FROM flighttickets")
suspend fun getAllFlightTickets(): List<FlightTicketEntity>
}