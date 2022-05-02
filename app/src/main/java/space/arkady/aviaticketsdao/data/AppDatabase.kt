package space.arkady.aviaticketsdao.data

import androidx.room.Database
import androidx.room.RoomDatabase
import space.arkady.aviaticketsdao.data.entity.FlightTicketEntity


@Database(entities = [FlightTicketEntity::class], version = AppDatabase.VERSION_DB)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        const val VERSION_DB = 1

    }

    abstract fun getFlightTickets(): FlightTicketsDao
}