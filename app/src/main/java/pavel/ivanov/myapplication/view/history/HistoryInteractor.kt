package pavel.ivanov.myapplication.view.history

import pavel.ivanov.myapplication.model.data.AppState
import pavel.ivanov.myapplication.model.data.DataModel
import pavel.ivanov.myapplication.model.data.dto.SearchResultDto
import pavel.ivanov.myapplication.model.data.mapSearchResultToResult
import pavel.ivanov.myapplication.model.repository.Repository
import pavel.ivanov.myapplication.model.repository.RepositoryLocal
import pavel.ivanov.myapplication.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean):
            AppState {
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