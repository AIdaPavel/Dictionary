package pavel.ivanov.model.data

import pavel.ivanov.model.data.userdata.DataModel

// Состояние приложения
sealed class AppState {

    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
