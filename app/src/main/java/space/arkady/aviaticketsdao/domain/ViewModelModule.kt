package space.arkady.aviaticketsdao.domain

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import space.arkady.aviaticketsdao.presentation.viewmodels.FlightFragmentViewModel
import space.arkady.aviaticketsdao.presentation.viewmodels.HistoryFragmentViewModel

val viewModelModule = module {
    viewModel<FlightFragmentViewModel> {
        FlightFragmentViewModel(
            get()
        )
    }
    viewModel<HistoryFragmentViewModel>() {
        HistoryFragmentViewModel(
            get()
        )
    }
}