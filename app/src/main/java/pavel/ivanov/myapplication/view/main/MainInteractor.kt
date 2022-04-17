package pavel.ivanov.myapplication.view.main

import pavel.ivanov.core.viewmodel.Interactor
import pavel.ivanov.model.data.AppState
import pavel.ivanov.model.data.DataModel
import pavel.ivanov.myapplication.utils.mapSearchResultToResult
import pavel.ivanov.repository.Repository
import pavel.ivanov.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}