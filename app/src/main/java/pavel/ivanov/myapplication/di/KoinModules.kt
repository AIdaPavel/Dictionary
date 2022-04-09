package pavel.ivanov.myapplication.di

import androidx.room.Room
import org.koin.dsl.module
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.datasource.RetrofitImplementation
import pavel.ivanov.myapplication.model.datasource.RoomDataBaseImplementation
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.model.repository.RepositoryImplementation
import pavel.ivanov.myapplication.model.repository.RepositoryImplementationLocal
import pavel.ivanov.myapplication.model.repository.RepositoryLocal
import pavel.ivanov.myapplication.room.HistoryDataBase
import pavel.ivanov.myapplication.view.history.HistoryInteractor
import pavel.ivanov.myapplication.view.history.HistoryViewModel
import pavel.ivanov.myapplication.view.main.MainInteractor
import pavel.ivanov.myapplication.view.main.MainViewModel


val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
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
