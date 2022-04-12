package pavel.ivanov.repository

import pavel.ivanov.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}