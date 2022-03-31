package pavel.ivanov.myapplication.view.main

import pavel.ivanov.myapplication.model.data.AppState
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    // Интерактор лишь запрашивает у репозитория данные, детали имплементации интерактору неизвестны
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}