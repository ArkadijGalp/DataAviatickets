package space.arkady.aviaticketsdao.data.di

import androidx.room.Room
import org.koin.dsl.module
import space.arkady.aviaticketsdao.data.AppDatabase
import space.arkady.aviaticketsdao.data.FlightTicketsDao

val roomModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(), AppDatabase::class.java, "flighttickets"
        ).build()
    }

    single<FlightTicketsDao> {
        get<AppDatabase>().getFlightTickets()
    }
}