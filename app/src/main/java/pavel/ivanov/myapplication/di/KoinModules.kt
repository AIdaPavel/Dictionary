package pavel.ivanov.myapplication.di

import androidx.room.Room
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pavel.ivanov.model.data.DataModel
import pavel.ivanov.repository.RetrofitImplementation
import pavel.ivanov.repository.RoomDataBaseImplementation
import pavel.ivanov.repository.Repository
import pavel.ivanov.repository.RepositoryImplementation
import pavel.ivanov.repository.RepositoryImplementationLocal
import pavel.ivanov.repository.RepositoryLocal
import pavel.ivanov.repository.room.HistoryDataBase
import pavel.ivanov.myapplication.view.history.HistoryInteractor
import pavel.ivanov.myapplication.view.history.HistoryViewModel
import pavel.ivanov.myapplication.view.main.MainInteractor
import pavel.ivanov.myapplication.view.main.MainViewModel


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
