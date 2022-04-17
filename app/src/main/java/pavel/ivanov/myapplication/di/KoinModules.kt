package pavel.ivanov.myapplication.di

import androidx.room.Room
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pavel.ivanov.historyscreen.history.HistoryActivity
import pavel.ivanov.historyscreen.history.HistoryInteractor
import pavel.ivanov.historyscreen.history.HistoryViewModel
import pavel.ivanov.model.data.dto.SearchResultDto
import pavel.ivanov.myapplication.view.main.MainActivity
import pavel.ivanov.myapplication.view.main.MainInteractor
import pavel.ivanov.myapplication.view.main.MainViewModel
import pavel.ivanov.repository.*
import pavel.ivanov.repository.room.HistoryDataBase


val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
