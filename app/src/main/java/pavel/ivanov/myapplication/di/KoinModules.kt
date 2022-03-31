package pavel.ivanov.myapplication.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.datasource.RetrofitImplementation
import pavel.ivanov.myapplication.model.datasource.RoomDataBaseImplementation
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.model.repository.RepositoryImplementation
import pavel.ivanov.myapplication.view.main.MainInteractor
import pavel.ivanov.myapplication.view.main.MainViewModel


val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
