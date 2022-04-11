package pavel.ivanov.myapplication.model.datasource

import pavel.ivanov.myapplication.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}