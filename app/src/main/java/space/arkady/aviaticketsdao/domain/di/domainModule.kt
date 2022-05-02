package space.arkady.aviaticketsdao.domain.di

import org.koin.dsl.module
import space.arkady.aviaticketsdao.domain.interactor.FlightTicketInteractor
import space.arkady.aviaticketsdao.domain.repository.FlightTicketRepositoryImplement

val domainModule = module {
    single<FlightTicketInteractor> {
        FlightTicketRepositoryImplement(get())
    }
}