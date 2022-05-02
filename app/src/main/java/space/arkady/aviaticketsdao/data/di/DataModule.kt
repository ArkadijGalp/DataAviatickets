package space.arkady.aviaticketsdao.data.di

import org.koin.dsl.module
import space.arkady.aviaticketsdao.data.repository.FlightTicketEntitiesRepositoryImplement
import space.arkady.aviaticketsdao.domain.repository.FlightTicketRepository

val dataModule = module {
    single<FlightTicketRepository> {
        FlightTicketEntitiesRepositoryImplement(get())
    }

}