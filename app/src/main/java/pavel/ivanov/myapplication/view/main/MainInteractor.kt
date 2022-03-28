package pavel.ivanov.myapplication.view.main

import io.reactivex.Observable
import pavel.ivanov.myapplication.di.NAME_LOCAL
import pavel.ivanov.myapplication.di.NAME_REMOTE
import pavel.ivanov.myapplication.model.data.AppState
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.viewmodel.Interactor
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(

    // Снабжаем интерактор репозиторием для получения локальных или внешних данных
    @Named(NAME_REMOTE) val remoteRepository: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    // Интерактор лишь запрашивает у репозитория данные, детали имплементации интерактору неизвестны
    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }


}