package pavel.ivanov.myapplication.view.history

import pavel.ivanov.core.viewmodel.Interactor
import pavel.ivanov.model.data.AppState
import pavel.ivanov.model.data.DataModel
import pavel.ivanov.myapplication.utils.mapSearchResultToResult
import pavel.ivanov.repository.Repository
import pavel.ivanov.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
