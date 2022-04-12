package pavel.ivanov.myapplication.di

import androidx.room.Room
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
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(
        RoomDataBaseImplementation(get())
    )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
