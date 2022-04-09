package pavel.ivanov.myapplication.model.repository

import pavel.ivanov.myapplication.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}