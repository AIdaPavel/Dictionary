package pavel.ivanov.myapplication.view.history

import pavel.ivanov.core.viewmodel.Interactor
import pavel.ivanov.model.data.AppState
import pavel.ivanov.model.data.DataModel
import pavel.ivanov.repository.Repository
import pavel.ivanov.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

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