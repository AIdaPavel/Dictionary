package pavel.ivanov.repository

import pavel.ivanov.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}