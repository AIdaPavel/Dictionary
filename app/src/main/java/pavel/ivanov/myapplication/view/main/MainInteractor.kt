package pavel.ivanov.myapplication.view.main

import pavel.ivanov.myapplication.model.data.AppState
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.model.repository.RepositoryLocal
import pavel.ivanov.myapplication.utils.mapSearchResultToResult
import pavel.ivanov.myapplication.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean):
            AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState =
                AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState =
                AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }

}